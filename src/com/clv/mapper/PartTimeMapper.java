package com.clv.mapper;

import java.sql.Timestamp;
import java.util.List;

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
}
