package cn.qlk.test.until;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.standard.MediaName;

import org.apache.http.message.BasicNameValuePair;

public class ExpectResultUntil {
	
	/**
	 * 
	 * @param ExceptResult
	 * @return 预期的key的值
	 */
	public static String getExpectKey(String ExceptResult){
		
		 String key=null;
		 
		 String[] strs = ExceptResult.split("\\=");
		 Map<String, String> m = new HashMap<String, String>();
		 m.put(strs[0], strs[1]);

		 Set<String> keySet = m.keySet();
		 for (String keys : keySet) {
			
			 key = keys;
			return key;
		}
		 return key;
	}
	
	/**
	 * 
	 * @param ExceptResult
	 * @return 预期的values的值
	 */
	public static String getExpectValues(String ExceptResult){
		
		 String values=null;
		 
		 String[] strs = ExceptResult.split("\\=");
		 Map<String, String> m = new HashMap<String, String>();
		 m.put(strs[0], strs[1]);

		 Set<String> keySet = m.keySet();
		 for (String keys : keySet) {
			
			 values = m.get(keys);
			return values;
		}
		 return values;
	}
	
	public static List<BasicNameValuePair> getParam(String param){
		
		String[] split = param.split("\\&");
		List<BasicNameValuePair> basicNameValuePairs = new ArrayList<BasicNameValuePair>();
		for (String s : split) {
			
			System.out.println(s.toString());
			
			String[] s2 = s.split("\\=");
			basicNameValuePairs.add(new BasicNameValuePair(s2[0], s2[1]));
			
		}

		return basicNameValuePairs;
	}
	
}

