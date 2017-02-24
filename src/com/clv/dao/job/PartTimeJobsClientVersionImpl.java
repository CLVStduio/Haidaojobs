package com.clv.dao.job;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
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
			JSONArray partTimeArray = factory.getJson().listToJsonArray(partTimeList);
			return new JsonFormat("success",partTimeArray).toString();
		}
		List<PartTimeSummary> partTimeListAll = partTimeMapper.getPartTimeListAll(lastTime);
		if(partTimeListAll != null){
			JSONArray partTimeArray = factory.getJson().listToJsonArray(partTimeListAll);
			return new JsonFormat("success",partTimeArray).toString();
		}
		//没有新的兼职
		return new JsonFormat("101","fail").toString();
	}

	@Override
	public String getPartTimeInformation(int partTimeId) throws JSONException {
			PartTimeInformation information = partTimeMapper.getPartTimeInformation(partTimeId);
			List<PartTimeDescription> description = partTimeMapper.getPartTimeDescription(partTimeId);
			List<PartTimeProblem> problem = partTimeMapper.getPartTimeProblem(partTimeId);
			PartTimeShow partTimeShow = new PartTimeShow(information,description,problem);
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(partTimeShow))).toString();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, timeout = 60)
	public String partTimeRegistration(int userId, String enparttimeId, String enAnswer) throws JSONException {
		if(userId>0){
			User user = userMapper.selectUserById(userId);
			String parttimeId = factory.getCrypto().decrypMessage(enparttimeId, user.getUserPhoneNo(), user.getSecurityKey());
			String answer = factory.getCrypto().decrypMessage(enAnswer, user.getUserPhoneNo(), user.getSecurityKey());
			if(!"fail".equals(parttimeId) && !"fail".equals(answer)){
				
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(userId),"fail").toString();
	}

	@Override
	public String cancelTheRegistration(int userId, String enJobId) throws JSONException {
		if(userId>0){
			
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
