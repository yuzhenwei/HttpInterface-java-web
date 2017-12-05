package cn.qlk.test.until;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.Consts;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class ClientHttp{

	private static final Logger logger = LoggerFactory.getLogger(ClientHttp.class);
	
	public CloseableHttpClient getHttpClient(){
		return HttpClients.createDefault();
	}

 
	public void closeHttpClient(CloseableHttpClient client){
	    try{
			client.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * 发送post请求
	 * @param url 	  接口绝对地址
	 * @param param
	 * @return		  返回json串
	 */
	public String postRequest(String url,List<BasicNameValuePair> param){
		CloseableHttpClient httpClient = getHttpClient();
		int status = 0;
		String returnJson = "";
		try{
			HttpPost httpPost = new HttpPost(url);
	        //设置请求和传输超时时间
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).setConnectionRequestTimeout(20000).build();
	        httpPost.setConfig(requestConfig); 

			 //调整连接池的参数：
	        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	        cm.setMaxTotal(200);
	        httpClient = HttpClients.custom().setConnectionManager(cm).build();
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(param,Consts.UTF_8);
			httpPost.setEntity(entity);
			CloseableHttpResponse httpResponse = null;			
			try {
				httpResponse=httpClient.execute(httpPost);
				status=httpResponse.getStatusLine().getStatusCode();
				returnJson=EntityUtils.toString(httpResponse.getEntity());			
			}catch(Exception e){
				logger.error("可能是由于服务器重启导致连接失败！");
				logger.error("请求错误", e);
				return returnJson;
			}finally{
				httpResponse.close();
			}	
		}catch(Exception e){
			logger.error("参数错误", e);
			return returnJson;
		}finally{
			closeHttpClient(httpClient);
		}		
		/*Map<String, String> jsonStr = new HashMap<String, String>();
		jsonStr.put("status", status+"");
		jsonStr.put("returnJson", returnJson);*/
		return returnJson;
	}
	/**
	 * 发送get请求
	 * @param url		接口绝对地址
	 * @param param
	 * @return			返回json字符串
	 */
	public String  getRequest(String url,List<BasicNameValuePair> param){
		CloseableHttpClient httpClient = getHttpClient();
		int status = 0;
		String returnJson =null;
		
		try{
			HttpGet httpGet = new HttpGet(url);
	
		
	        //设置请求和传输超时时间
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).setConnectionRequestTimeout(20000).build();
	        httpGet.setConfig(requestConfig); 

	        String str = EntityUtils.toString(new UrlEncodedFormEntity(param));  
			httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str)); 
			CloseableHttpResponse httpResponse = null;
			try{
				httpResponse=httpClient.execute(httpGet);
				status=httpResponse.getStatusLine().getStatusCode();
				returnJson=EntityUtils.toString(httpResponse.getEntity());			
			}catch(Exception e){
				logger.error("发送请求错误", e);
			}finally{
				httpResponse.close();
			}
		} catch (Exception e) {
			logger.error("连接请求超时", e);
		}finally{
			closeHttpClient(httpClient);
		}	
		/*Map<String, String> jsonStr = new HashMap<String, String>();
		jsonStr.put("status", status+"");
		jsonStr.put("returnJson", returnJson);*/
		return returnJson;
	}
  
	/**
	 * post请求
	 * @param url
	 * @param parmater
	 * @param header
	 * @param type
	 * @return
	 */
	  public String sendPost(String url ,String parmater,String header,String type ){
		  
		  CloseableHttpClient httpClient = getHttpClient();
			int status = 0;
			String returnJson = null;
			StringEntity entity =null;
			try{
				HttpPost httpPost = new HttpPost(url);
		        //设置请求和传输超时时间
		        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).setConnectionRequestTimeout(20000).build();
		        httpPost.setConfig(requestConfig); 

				 //调整连接池的参数：
		        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		        cm.setMaxTotal(200);
		        httpClient = HttpClients.custom().setConnectionManager(cm).build();
		        if(type !=null){
		        	if(type.equals("json")){
			        	
			        	entity = new StringEntity(JSONObject.fromObject(parmater).toString(),"utf-8");
			        	
			        	httpPost.setHeader("Content-Type","application/json");
			        }else if (type.equals("arr")) {
			        	
			        	entity = new StringEntity(ConvertUntil.parameterConvertJsArr(parmater).toString(),"utf-8");
					}else {
						
			        	entity = new UrlEncodedFormEntity(ExpectResultUntil.getParam(parmater),Consts.UTF_8);

					}
			       		        	
		        }
		        
				httpPost.setEntity(entity);
				//设置请求头
				if(header !=null){
					Map<String, String> map = ConvertUntil.headerConvert(header);
					Set<String> maps = map.keySet();
					for (String key : maps) {
						String val = map.get(key);
						httpPost.setHeader(key,val);
					}
					
					
				}
				CloseableHttpResponse httpResponse = null;			
				try {
					httpResponse=httpClient.execute(httpPost);
					status=httpResponse.getStatusLine().getStatusCode();//获取请求的code
					if(status ==200){
						returnJson=EntityUtils.toString(httpResponse.getEntity());			
					}else{
						return returnJson;
					}
				}catch(Exception e){
					logger.error("可能是由于服务器重启导致连接失败！");
					logger.error("请求错误", e);
				}finally{
					httpResponse.close();
				}	
			}catch(Exception e){
				logger.error("参数错误", e);
			}finally{
				closeHttpClient(httpClient);
			}		

			return returnJson;
		   
		  
	  }
	  
	  public  String  sendRequest(String url, String param,String header,String mothed,String Type){
	    	String result="";
	    	if(mothed.toLowerCase().equals("post") ){
	    		
	    		result = sendPost(url, param,header,Type);
	    		return result;
	    	}
	    	else if(mothed.toLowerCase().equals("get")){
	    		;
	    		result = getRequest(url, ExpectResultUntil.getParam(param));
	    		return result;
			}
			return result;

	    }
	  
	
}
