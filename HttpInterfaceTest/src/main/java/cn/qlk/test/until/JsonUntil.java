package cn.qlk.test.until;

import java.util.Iterator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUntil {
private static final Logger logger = LoggerFactory.getLogger(JsonUntil.class);
	
	private String  kb;
	private String values;
	private String val;
	public JsonUntil(String kb,String values){
		this.kb =kb;
		this.values = values;
		
	}
	public JsonUntil(String kb){
		this.kb =kb;
	
	}

	/**
	 * 查看返回的json是否包含指定的键，如果包含返回键对应的值
	 * @param fileName   	被调用接口的excel文件名
	 * @param outData    实际返回的json串
	 * @param param			接口中需要的另外一个接口的参数
	 * @return
	 */
	public String getParamValue(String outData){
		if(outData.contains(kb)){
			String val = getJsonValue(outData);
			return val;
		}else{
			logger.error("调用的用例返回值中不存在字段"+kb+"!!!");
			System.out.println("调用的用例返回值中不存在字段"+kb+"!!!");
			return "没有找到"+kb+"的值";
		}
	}
	
	/**
	 * 
	 * @param returnJson 返回的接口结果,可能存在数组
	 * @param param      返回接口结果中的某一个键
	 * @return
	 */
	public String getJsonValue(String returnJson){
		String paramValue="";
		if(returnJson.substring(0, 1).equals("[")){
			JSONArray jsonArray = JSONArray.fromObject(returnJson);
			int size = jsonArray.size();
			if(size>0){
				for(int i=0;i<size;i++){
					JSONObject jsonObj = JSONObject.fromObject(jsonArray.get(i));
					paramValue=getJson(jsonObj);
				}
			}else{
				logger.error("返回json的data没有数据");
				System.out.println("返回json的data没有数据");
			}
		}else{
			JSONObject jsonObj = JSONObject.fromObject(returnJson);
			paramValue=getJson(jsonObj);			
		}
		return val;
	}
	
	public String getJson(JSONObject jsonObj){
		String paramValue="";
		for(Iterator ite=jsonObj.keys();ite.hasNext();){
			String key = (String) ite.next();
			String jsonStr = jsonObj.getString(key);
			
			//System.out.println(key+"--"+jsonStr);
			if(kb.toLowerCase().equals(key.toLowerCase())){
				if(values != null){
					
					if(values.toLowerCase().equals(jsonStr.toLowerCase())){
						
						val=key+"="+jsonStr;
						return val;
					}
				}
				
				val=key+"="+jsonStr+";"+val;
				return val;
			}else{
				try{
					paramValue=getJsonValue(jsonStr);
				}catch(Exception e){
					continue;
				}
			}
		}
		return val;
	}
	

}