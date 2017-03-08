package com.clv.server.job;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.clv.mapper.PartTimeMapper;
import com.clv.mapper.UserMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.parttime.PartTimeDescription;
import com.clv.model.parttime.PartTimeInformation;
import com.clv.model.parttime.PartTimeProblem;
import com.clv.model.parttime.PartTimeShow;
import com.clv.model.parttime.PartTimeSummary;
import com.clv.model.user.User;

import cn.clvstudio.tool.Factory;
@Service
public class PartTimeJobsClientVersionImpl implements PartTimeJobsClientVersionDao{
	@Autowired 
	private UserMapper userMapper;
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
	public String getPartTimeInformation(int partTimeId,int userId) throws JSONException {
		if(userId>0){
			PartTimeInformation information = partTimeMapper.getPartTimeInformation(partTimeId);
			List<PartTimeDescription> description = partTimeMapper.getPartTimeDescription(partTimeId);
			PartTimeShow partTimeShow = new PartTimeShow(information,description);
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(partTimeShow).put("registrationType", partTimeMapper.selectUserRegistration(userId)))).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, timeout = 60)
	public String partTimeRegistration(int userId, String enparttimeId) throws JSONException {
		if(userId>0){
			User user = userMapper.selectUserById(userId);
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, user.getUserPhoneNo(), user.getSecurityKey());
			if("fail".equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				List<PartTimeProblem> problem = partTimeMapper.getPartTimeProblem(partTimeId);
				if(problem!=null){
					return new JsonFormat("success",factory.getJson().listToJsonArray(problem)).toString();
				}
				int type = partTimeMapper.selectUserRegistration(userId);
				if(!(type==2||type==3||type==0)){
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

	@Override
	public String cancelTheRegistration(int userId, String enparttimeId) throws JSONException {
		if(userId>0){
			User user = userMapper.selectUserById(userId);
			String partTimeIdStr = factory.getCrypto().decrypMessage(enparttimeId, user.getUserPhoneNo(), user.getSecurityKey());
			if("fail".equals(partTimeIdStr)){
				int partTimeId = Integer.parseInt(partTimeIdStr);
				partTimeMapper.cancelTheRegistration(userId, partTimeId);
				return new JsonFormat("success").toString();
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

	@Override
	public String getPendingList(int userId) throws JSONException {
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

	@Override
	public String getEnrollmentResults(int userId, String enparttimeId) throws JSONException {
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

	@Override
	public String getPartTimeAdmission(int userId) throws JSONException {
		if(userId>0){
			
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

}
