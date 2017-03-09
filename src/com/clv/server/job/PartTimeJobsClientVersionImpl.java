package com.clv.server.job;

import java.sql.Timestamp;
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
import net.sf.json.JSONObject;
@Service
public class PartTimeJobsClientVersionImpl implements PartTimeJobsClientVersionDao{
	@Autowired 
	private PartTimeMapper partTimeMapper;
	
	private Factory factory = new Factory();
	@Override
	public String getPartTimeList(Timestamp lastTime) throws JSONException {
		List<PartTimeSummary> partTimeList = partTimeMapper.getPartTimeList(lastTime);
		if(partTimeList != null){
			for(PartTimeSummary summary: partTimeList){
				summary.setLocation();
			}
			JSONArray partTimeArray = factory.getJson().listToJsonArray(partTimeList,"locationProvince","locationCity","locationDistrict","locationDetailed");
			return new JsonFormat("success",partTimeArray).toString();
		}
		List<PartTimeSummary> partTimeListAll = partTimeMapper.getPartTimeListAll(lastTime);
		if(partTimeListAll != null){
			for(PartTimeSummary summary: partTimeListAll){
				summary.setLocation();
			}
			JSONArray partTimeArray = factory.getJson().listToJsonArray(partTimeListAll,"locationProvince","locationCity","locationDistrict","locationDetailed");
			return new JsonFormat("success",partTimeArray).toString();
		}
		//没有新的兼职
		return new JsonFormat("101","fail").toString();
	}

	@Override
	public String getPartTimeInformation(int partTimeId) throws JSONException {
			PartTimeInformation information = partTimeMapper.getPartTimeInformation(partTimeId);
			List<PartTimeDescription> description = partTimeMapper.getPartTimeDescription(partTimeId);
			PartTimeShow partTimeShow = new PartTimeShow(information,description);
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(partTimeShow))).toString();
	}
	@Override
	public String getPartTimeInformation(String enpartTimeId,Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enpartTimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(!"fail".equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				PartTimeInformation information = partTimeMapper.getPartTimeInformation(partTimeId);
				List<PartTimeDescription> description = partTimeMapper.getPartTimeDescription(partTimeId);
				PartTimeShow partTimeShow = new PartTimeShow(information,description);
				Integer registration = partTimeMapper.selectUserRegistration(userId,partTimeId);
				JSONObject showJson = factory.getJson().toJson(partTimeShow);
				showJson.put("registrationType", registration!=null?registration:0);
				return new JsonFormat("success",new JSONArray().put(showJson)).toString();
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, timeout = 60)
	public String partTimeRegistration(Map<String,String> userMap, String enparttimeId) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if("fail".equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				List<PartTimeProblem> problem = partTimeMapper.getPartTimeProblem(partTimeId);
				if(problem!=null){
					return new JsonFormat("success",factory.getJson().listToJsonArray(problem)).toString();
				}
				int type = partTimeMapper.selectUserRegistration(userId,partTimeId);
				if(type == 0 || type == 2){
					partTimeMapper.registration(userId, partTimeId);
					return new JsonFormat("success").toString();
				}
				//已处于报名或被录取或被拒绝的状态
				return new JsonFormat("101","fail").toString();
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, timeout = 60)
	public String partTimeRegistration(Map<String,String> userMap, String enparttimeId, String enAnswer) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			String answer = factory.getCrypto().decrypMessage(enAnswer, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(!"fail".equals(partTimeIdStr) && !"fail".equals(answer) ){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				int type = partTimeMapper.selectUserRegistration(userId,partTimeId);
				if(type == 0 || type == 2){
					partTimeMapper.registration(userId, partTimeId);
					List<PartTimeAnswer> list = factory.getJson().jsonArrayToList(answer, PartTimeAnswer.class);
					partTimeMapper.addAnswer(list);
					return new JsonFormat("success").toString();
				}
				//已处于报名或被录取或被拒绝的状态
				return new JsonFormat("101","fail").toString();
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}
	@Override
	public String cancelTheRegistration(Map<String,String> userMap, String enparttimeId) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(!"fail".equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				partTimeMapper.cancelTheRegistration(userId, partTimeId);
				return new JsonFormat("success").toString();
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

	@Override
	public String getPendingList(Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

	@Override
	public String getEnrollmentResults(Map<String,String> userMap, String enparttimeId) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

	@Override
	public String getPartTimeAdmission(Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

}
