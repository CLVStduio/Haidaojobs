package com.clv.mapper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
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
	public List<PartTimeSummary> getPartTimeList(Timestamp lastTime) throws SQLException;
	public List<PartTimeSummary> getPartTimeListAll(Timestamp lastTime) throws SQLException;
	public PartTimeInformation getPartTimeInformation(int partTimeId) throws SQLException;
	public List<PartTimeDescription> getPartTimeDescription(int partTimeId) throws SQLException;
	public List<PartTimeProblem> getPartTimeProblem(int partTimeId) throws SQLException;
	public HashMap<String,Integer> selectUserIsRegistration(@Param("userId")int userId,@Param("parttimeId")int parttimeId) throws SQLException;
	@Transactional(readOnly = false, timeout = 60)
	public void registration(@Param("userId")int userId,@Param("parttimeId")int parttimeId) throws DataAccessException,SQLException;
	public void registrationOfInformation(@Param("parttimeId")int parttimeId) throws DataAccessException,SQLException;
	@Transactional(readOnly = false, timeout = 60)
	public void addAnswer(List<PartTimeAnswer> item) throws DataAccessException,SQLException;
	public void cancelTheRegistration(@Param("userId")int userId,@Param("parttimeId")int parttimeId) throws DataAccessException,SQLException;
	public void cancelTheRegistrationOfInformation(@Param("parttimeId")int parttimeId) throws DataAccessException,SQLException;
}
