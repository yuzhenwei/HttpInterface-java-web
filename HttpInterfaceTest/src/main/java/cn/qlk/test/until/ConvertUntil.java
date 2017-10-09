package cn.qlk.test.until;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ConvertUntil {
	
	/**
	 * 把字符串转换成jsonArr
	 * @param paramater
	 * @return
	 */
	public static JSONArray parameterConvertJsArr(String paramater){
		
		
		return JSONArray.fromObject(paramater);
	}
	
	/**
	 * 把字符串转换成Json
	 * @param paramater
	 * @return
	 */
	public static JSONObject parameterConvertJs(String paramater){
			
		JSONObject jsonObject = new JSONObject();	
		String[] par = paramater.split("\\&");
		
		for (String s : par) {
			
			String[] s2 = s.split("\\=");
			jsonObject.put(s2[0], s2[1]);
		}
		
			return jsonObject;
		}

	
	public static Object parameterConvert(String paramater){
		
		if(paramater.substring(0, 1).equals("[")){
			
			return parameterConvertJs(paramater);
		}
		
		return parameterConvertJsArr(paramater);
	}
	
	
	public static Map<String, String> headerConvert(String paramater){
		
		Map<String, String> map = new HashMap<>();	
		String[] par = paramater.split("\\;");
		
		for (String s : par) {
			
			String[] s2 = s.split("\\=");
			map.put(s2[0], s2[1]);
		}
		
			return map;
		}
	
	
	public static  Map<String, String> getDependId(String depend){
		
		Map<String, String> map = new HashMap<>();
		String[] dependIds = depend.split("\\;");
		for(String id : dependIds){
			
			String[] split = id.split("\\=");
			map.put(split[0], split[1]);
			
		}
		
		return map;
	}
}
