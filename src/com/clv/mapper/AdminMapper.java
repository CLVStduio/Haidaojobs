package com.clv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clv.model.admin.Admin;
import com.clv.model.resume.Identity;

/**
 * 管理员数据库操作映射类
 * @author evanglist
 *
 */
public interface AdminMapper {
	
    /**
     * 添加管理员
     * @param adminName
     * 			管理员姓名
     * @param permissions
     * 			管理员权限
     * @param phone
     * 			管理员手机号
     * @param password
     * 			管理员密码
     * @param securityKey
     * 			管理员安全码
     * @param complementKey
     * 			管理员补充码
     */
    public void addAdmin(@Param("adminName")String adminName,@Param("permissions")String permissions,@Param("adminPhoneNo")String phone,@Param("adminPassword")String password,@Param("securityKey") String securityKey,@Param("complementKey") String complementKey);
    /**
	 * 根据用户ID查询管理员信息
	 * @param user_id
	 * @return
	 */
    public Admin selectAdminById(int adminId);  
   
    /**
     * 待实现
     * 查询指定密码
     * @param phone
     * @return
     */
   // public String signIn(@Param("phone") String phone);
    
    /**
     * 待实现
     * 更新安全码
     * @param phone
     * @param security_key
     * @param complement_key
     * @return
     */
  //  public String modifySecurity(@Param("phone") String phone,@Param("securityKey") String securityKey,@Param("complementKey") String complementKey);
	/**
	 * 修改用户认证状态
	 * @param userId
	 * 		用户id
	 * @param adminId
	 * 		管理员id
	 * @param auditType
	 * 		用户认证状态
	 */
	public void modifyAuditTypeOfIdentity(@Param("userId")int userId,@Param("adminId")int adminId,@Param("auditType")int auditType);
	
	/**
	 * 获取待审核名单
	 * @return
	 */
	public List<Identity> getAuditQueue();
}
