package com.clv.dao.tool;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clv.mapper.MessageMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.user.Code;
import com.mysubmail.config.AppConfig;
import com.mysubmail.lib.MESSAGEXsend;
import com.mysubmail.utils.ConfigLoader;
//阿里大于短信服务调用包
//import com.taobao.api.ApiException;
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
@Component
public class MessageDaoImpl implements MessageDao{
	  @Autowired
	private MessageMapper messageMapper;
	//赛邮短信服务调用接口
		public String getCode(String phone) throws JSONException {
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<6;i++){
				int code = (int)(Math.random()*8+1);
				sb.append(Integer.valueOf(code).toString());
			}
			sb.delete(0, 1);
			String strcode = sb.toString();
			
			AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
			MESSAGEXsend submail = new MESSAGEXsend(config);
			submail.addTo(phone);
			submail.setProject("7Ns8O3");
			submail.addVar("code", strcode);
			submail.addVar("time", "10分钟");
			if(submail.xsend()){
				String time = Long.valueOf(System.currentTimeMillis()).toString();
				if(messageMapper.selectCode(phone) !=null){
					messageMapper.modifyCode(phone, strcode, time);
					return new JsonFormat("success").toString();
				}
				messageMapper.addCode(phone, strcode,time);
				return new JsonFormat("success").toString();
			}
			return new JsonFormat("101","fail").toString();
		}
		/**
		 * 阿里大于短信服务调用接口
		@Override
		public String getCode(String phone) throws ApiException, JSONException {
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<6;i++){
				int code = (int)(Math.random()*8+1);
				sb.append(Integer.valueOf(code).toString());
			}
			sb.delete(0, 1);
			
			String strcode = sb.toString();
			
			System.out.println("code:"+strcode);
			String url = "http://gw.api.taobao.com/router/rest";
			String appkey = " 23561829";
			String secret = "370a9c1e0532706b4857be11cd64f6f7";
			TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend(phone);
			req.setSmsType("normal");
			req.setSmsFreeSignName("蠢驴工作室");
			req.setSmsParam("{\"code\":\""+strcode+"\"}");
			req.setRecNum(phone);
			req.setSmsTemplateCode("SMS_33605394");
			AlibabaAliqinFcSmsNumSendResponse response = client.execute(req);
			String str = response.getBody();
			
			int a = str.indexOf("error_response");
			if(a==-1){
				String time = Long.valueOf(System.currentTimeMillis()).toString();
				if(messageMapper.selectCode(phone) !=null){
					messageMapper.modifyCode(phone, strcode, time);
					return new JsonFormat("success").toString();
				}
				messageMapper.addCode(phone, strcode,time);
				return new JsonFormat("success").toString();
			}else{
				return new JsonFormat("101","fail").toString();
			}
		}
		*/
		public String checkCode(String phone,String code) throws JSONException{
			 Code Code = messageMapper.selectCode(phone);
			 if(Code == null){
				 System.out.println("验证码不存在");
				 return new JsonFormat("103","fail").toString();
			 }
			 long time = System.currentTimeMillis();
			 long codeTime = Long.parseLong(Code.getTime());
			
			 if(Code.getCode().equals(code)){
				  if(Math.abs(codeTime-time)>60000){
					 System.out.println("验证码过期");
					 return new JsonFormat("102","fail").toString();
				  }
				  System.out.println("验证码正确");
				 return new JsonFormat("success").toString();
			 }
			 System.out.println("验证码错误");
			 return new JsonFormat("101","fail").toString();
		 }
}
