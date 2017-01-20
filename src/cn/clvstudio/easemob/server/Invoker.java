package cn.clvstudio.easemob.server;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
/**
 * 环信各种调用类
 * @author Administrator
 *
 */
public class Invoker {

	//apiURL就是访问第三方的URL
	private static String apiURL = "https://a1.easemob.com/1102161208178702/parttimejobs/token";
	//创建应用的时候会对应生成
	//private static String client_id = "YXA67agq4LzmEea4aivdoCd5Pg";
	
	//private static String client_secret = "YXA6rU4UICKJLN_M1ZqqhBLZ2KwNg7E";
	/**
	 * 访问环信
	 * @param json
	 */
	public JSONObject test1(JSONObject json){
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        
        HttpEntity<String> formEntity = new HttpEntity<String>(json.toString(), headers);

        JSONObject result = restTemplate.postForObject(apiURL, formEntity, JSONObject.class);
        return result;
	}
}
