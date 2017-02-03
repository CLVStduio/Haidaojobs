package cn.clvstudio.tool;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
    public String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
            System.out.print("Key值为空");
            return null;
        }
        if (sKey.length() != 16) {
            System.out.print("Key不是16的倍数");
            return null;
        }
		try {
			byte[] raw = sKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
    }
    public String encryptMessage(String message,String phone,String securityKey){
    	String encrypt = encrypt(message,builderMessage(phone,securityKey));
    	if(encrypt != null ){
    		return encrypt;
    	}
    	return "fail";
    }
    /**
     * AES解密
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public String decrypt(String sSrc, String sKey) {
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
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original,"utf-8");
            return originalString;
    	} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			return null;
		} catch (BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * 解密经过AES"时间钥匙"加密的信息
     * @param enId
     * @return
     */
    public String decryptTime(String message){
    	long time = System.currentTimeMillis();
		StringBuilder IdKeysb = new StringBuilder(getMD5(getMD5(Long.valueOf(time/100000*100000).toString())));
		
		String IdKey = IdKeysb.substring(0, 16);
    	try {
    		return decrypt(message,IdKey);
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
    public String decrypMessage(String message,String phone,String securityKey){
		String decrypt =  decrypt(message,builderMessage(phone,securityKey));
		if(decrypt != null){
			return decrypt;
		}
    	return "fail";
    }
    /**
     * 生成信息匙
     * @param enMessage
     * @param phone
     * @param securityKey
     * @return
     */
    public String builderMessage(String phone,String securityKey){
    	StringBuilder sb = new StringBuilder(securityKey);
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
		return sb.toString();
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
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
        // 计算md5函数
        md.update(str.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        return new BigInteger(1, md.digest()).toString(16);
	}
}
