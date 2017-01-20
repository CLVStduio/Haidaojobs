package cn.clvstudio.tool;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apaches.commons.codec.binary.Base64;

/**
 * 加密解密类
 * @author Evagnlist
 * @time 2016.12.31
 *
 */
public class Crypto {
	/**
	 * AES加密
	 * @param sSrc
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
    public String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key值为空");
            return null;
        }
        if (sKey.length() != 16) {
            System.out.print("Key不是16的倍数");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);
    }

    /**
     * AES解密
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public String Decrypt(String sSrc, String sKey) throws Exception {
//    	System.out.println("AES...: "+sSrc);
    	try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    /**
     * 解密经过AES"时间钥匙"加密的信息
     * @param enId
     * @return
     */
    public String DecryptTime(String message){
    	long time = System.currentTimeMillis();
		StringBuilder IdKeysb = new StringBuilder(getMD5(getMD5(Long.valueOf(time/100000*100000).toString())));
		
		String IdKey = IdKeysb.substring(0, 16);
    	try {
    		return Decrypt(message,IdKey);
		} catch (Exception e) {
			System.out.println("解密身份号失败");
			e.printStackTrace();
		}
    	System.out.println("解密身份号失败");
    	return "fail";
    }
    /**
     * 解密经过AES加密的信息
     * @param enMessage
     * @return
     */
    public String DecrypMessage(String enMessage,String phone,String security_key){
    	StringBuilder sb = new StringBuilder(security_key);
		sb.delete(0, 16);
		
		String str = sb.toString();
		char[] ch = str.toCharArray();
		int sum = 0;
		for(char c: ch){
			sum += (int) c;
		}
		sb.append(Integer.valueOf(sum%9).toString());
		
		long Num = Long.parseLong(phone);
		sb.append(Integer.valueOf((int)sum(Num)%7).toString());
		
		int count = 0;
		while(Num>10){
			count += Num%10%2==0?1:0;
			Num /= 10;
		}
		sb.append(Integer.valueOf(count).toString());
		String messageKey = sb.toString();
//		System.out.println(messageKey);
    	try {
			return Decrypt(enMessage,messageKey);
		} catch (Exception e) {
			System.out.println("解密信息失败");
			e.printStackTrace();
		}
    	return "fail";
    }
	public static long sum(long num){
		return num<10?num:num%10+sum(num/10);
	}
    /**
     * MD5加密
     * @param str
     * @return
     */
    public static String getMD5(String str) {
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
