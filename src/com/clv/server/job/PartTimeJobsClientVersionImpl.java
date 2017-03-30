package com.clv.server.job;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.clv.mapper.PartTimeMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.parttime.PartTimeAnswer;
import com.clv.model.parttime.PartTimeDescription;
import com.clv.model.parttime.PartTimeInformation;
import com.clv.model.parttime.PartTimeProblem;
import com.clv.model.parttime.PartTimeShow;
import com.clv.model.parttime.PartTimeSummary;

import cn.clvstudio.tool.Factory;
import cn.clvstudio.tool.Json;
import net.sf.json.JSONObject;
@Service
public class PartTimeJobsClientVersionImpl implements PartTimeJobsClientVersionDao{
	@Autowired 
	private PartTimeMapper partTimeMapper;
	
	private Factory factory = new Factory();
	@Override
	public String getPartTimeList(Timestamp lastTime) throws JSONException {
		List<PartTimeSummary> partTimeList;
		try {
			partTimeList = partTimeMapper.getPartTimeList(lastTime);
			if(partTimeList != null){
				for(PartTimeSummary summary: partTimeList){
					summary.setLocation();
				}
				JSONArray partTimeArray = Json.listToJsonArray(partTimeList,"locationProvince","locationCity","locationDistrict","locationDetailed");
				return new JsonFormat(SUCCESS,partTimeArray).toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new JsonFormat("102",FAIL).toString();
		}
		List<PartTimeSummary> partTimeListAll;
		try {
			partTimeListAll = partTimeMapper.getPartTimeListAll(lastTime);
			if(partTimeListAll != null){
				for(PartTimeSummary summary: partTimeListAll){
					summary.setLocation();
				}
				JSONArray partTimeArray = Json.listToJsonArray(partTimeListAll,"locationProvince","locationCity","locationDistrict","locationDetailed");
				return new JsonFormat(SUCCESS,partTimeArray).toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new JsonFormat("102",FAIL).toString();
		}
		//没有新的兼职
		return new JsonFormat("101",FAIL).toString();
	}

	@Override
	public String getPartTimeInformation(int partTimeId) throws JSONException {
			PartTimeInformation information;
			List<PartTimeDescription> description;
			try {
				description = partTimeMapper.getPartTimeDescription(partTimeId);
				information = partTimeMapper.getPartTimeInformation(partTimeId);
				PartTimeShow partTimeShow = new PartTimeShow(information,description);
				return new JsonFormat(SUCCESS,new JSONArray().put(Json.toJson(partTimeShow))).toString();
			} catch (SQLException e) {
				e.printStackTrace();
				return new JsonFormat("101",FAIL).toString();
			}
	}
	@Override
	public String getPartTimeInformation(String enpartTimeId,Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enpartTimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(!FAIL.equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				try{
					PartTimeInformation information = partTimeMapper.getPartTimeInformation(partTimeId);
					List<PartTimeDescription> description = partTimeMapper.getPartTimeDescription(partTimeId);
					PartTimeShow partTimeShow = new PartTimeShow(information,description);
					JSONObject showJson = Json.toJson(partTimeShow);
					HashMap<String, Integer> map = new HashMap<String, Integer>();
					map = partTimeMapper.selectUserIsRegistration(userId,partTimeId);
					System.out.println(map.toString());
					System.out.println("partTimeStatus ： "+map.get("partTimeStatus"));
					System.out.println("registrationType : "+map.get("registrationType"));
					showJson.put("registrationType", map.get("registrationType")!=null?map.get("registrationType"):0);
					return new JsonFormat(SUCCESS,new JSONArray().put(showJson)).toString();
				}catch(SQLException e){
					e.printStackTrace();
					return new JsonFormat("101",FAIL).toString();
				}
			}
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}
	@Transactional(rollbackFor=Exception.class,readOnly = false, propagation = Propagation.REQUIRES_NEW, timeout = 60)
	public String partTimeRegistration(Map<String,String> userMap, String enparttimeId) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(!FAIL.equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				try{
					HashMap<String, Integer> map = new HashMap<String, Integer>();
					map =  partTimeMapper.selectUserIsRegistration(userId,partTimeId);
					System.out.println(map.toString());
					System.out.println("partTimeStatus ： "+map.get("partTimeStatus"));
					System.out.println("registrationType : "+map.get("registrationType"));
					if(map.get("partTimeStatus") == 201 &&(map.get("registrationType") == null || map.get("registrationType") == 2)){
						List<PartTimeProblem> problem = partTimeMapper.getPartTimeProblem(partTimeId);
						if(problem!=null){
							return new JsonFormat(SUCCESS,Json.listToJsonArray(problem)).toString();
						}
						partTimeMapper.registration(userId, partTimeId);
						partTimeMapper.registrationOfInformation(partTimeId);
						return new JsonFormat(SUCCESS).toString();
					}
					//已处于报名或被录取或被拒绝的状态
					return new JsonFormat("101",FAIL).toString();
				}catch(SQLException e){
					e.printStackTrace();
					return new JsonFormat("102",FAIL).toString();
				}
			}
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}
	@Transactional(rollbackFor=Exception.class,readOnly = false, propagation = Propagation.REQUIRES_NEW, timeout = 60)
	public String partTimeRegistration(Map<String,String> userMap, String enparttimeId, String enAnswer) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			String answer = factory.getCrypto().decrypMessage(enAnswer, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(!FAIL.equals(partTimeIdStr) && !FAIL.equals(answer) ){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				try{
					HashMap<String, Integer> map  = new HashMap<String, Integer>();
					map =  partTimeMapper.selectUserIsRegistration(userId,partTimeId);
					if(map.get("partTimeStatus") == 201 &&(map.get("registrationType") == null || map.get("registrationType") == 2)){
						List<PartTimeAnswer> list = Json.convertToList(answer, PartTimeAnswer.class);
						partTimeMapper.addAnswer(list);
						partTimeMapper.registration(userId, partTimeId);
						partTimeMapper.registrationOfInformation(partTimeId);
						return new JsonFormat(SUCCESS).toString();
					}
					//已处于报名或被录取或被拒绝的状态
					return new JsonFormat("101",FAIL).toString();
				}catch(SQLException e){
					e.printStackTrace();
					return new JsonFormat("102",FAIL).toString();
				}
			}
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}
	@Transactional(rollbackFor=Exception.class,readOnly = false, propagation = Propagation.REQUIRES_NEW, timeout = 60)
	public String cancelTheRegistration(Map<String,String> userMap, String enparttimeId) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(!FAIL.equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				try{
					partTimeMapper.cancelTheRegistration(userId, partTimeId);
					partTimeMapper.cancelTheRegistrationOfInformation(partTimeId);
					return new JsonFormat(SUCCESS).toString();
				}catch(SQLException e){
					e.printStackTrace();
					return new JsonFormat("101",FAIL).toString();
				}
			}
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String getPendingList(Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String getEnrollmentResults(Map<String,String> userMap, String enparttimeId) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String getPartTimeAdmission(Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

}
