package com.clv.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.clv.model.parttime.PartTimeAnswer;
import com.clv.model.parttime.PartTimeDescription;
import com.clv.model.parttime.PartTimeInformation;
import com.clv.model.parttime.PartTimeProblem;
import com.clv.model.parttime.PartTimeSummary;

/**
 * 兼职信息数据库操作
 * @author evanglist
 *
 */
public interface PartTimeMapper {
	public List<PartTimeSummary> getPartTimeList(Timestamp lastTime);
	public List<PartTimeSummary> getPartTimeListAll(Timestamp lastTime);
	public PartTimeInformation getPartTimeInformation(int partTimeId);
	public List<PartTimeDescription> getPartTimeDescription(int partTimeId);
	public List<PartTimeProblem> getPartTimeProblem(int partTimeId);
	public Integer selectUserRegistration(@Param("userId")int userId,@Param("parttimeId")int parttimeId);
	@Transactional(readOnly = false, timeout = 60)
	public void registration(@Param("userId")int userId,@Param("parttimeId")int parttimeId) throws DataAccessException;
	public void registrationOfInformation(@Param("parttimeId")int parttimeId) throws DataAccessException;
	@Transactional(readOnly = false, timeout = 60)
	public void addAnswer(List<PartTimeAnswer> item) throws DataAccessException;
	public void cancelTheRegistration(@Param("userId")int userId,@Param("parttimeId")int parttimeId) throws DataAccessException;
	public void cancelTheRegistrationOfInformation(@Param("parttimeId")int parttimeId) throws DataAccessException;
}
