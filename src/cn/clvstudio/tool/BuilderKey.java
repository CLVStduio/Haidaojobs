package cn.clvstudio.tool;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 制造安全匙
 * @author Evanglist
 * @time 2016.12.31
 */
public class BuilderKey {
	/**
	 * 制造安全匙
	 * @param phone
	 * 		:手机号
	 * @return
	 */
		public String builderSecurityKey(String phone){
			StringBuilder sb = new StringBuilder(getMD5(phone));
			sb.delete(0,16);
			for(int i = 0 ;i<13;i++){
				char letter = (char)(Math.random()*26+65);
				sb.append(letter);
			}
			String security_key = sb.toString();
			return security_key;
		}
		
		public String builderComplementKey(String phone){
			StringBuilder sb = new StringBuilder(getMD5(phone));
			sb.delete(16,32);
			long time = System.currentTimeMillis();
			sb.append(Long.valueOf(time).toString());
			String complemen_key = sb.toString();
			return complemen_key;
		}
		
		public String getMD5(String str) {
		    try {
		        // 生成一个MD5加密计算摘要
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        // 计算md5函数
		        md.update(str.getBytes());
		        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
		        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
		        return new BigInteger(1, md.digest()).toString(16);
		    } catch (Exception e) {
		        System.out.println("MD5加密出错");
		    }
			return null;
		}
}
