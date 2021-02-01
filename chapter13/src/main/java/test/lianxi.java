package test;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.Arrays;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;

import java.util.UUID;
public class lianxi {
	public static void main(String[] args) {
		long requestTime = System.currentTimeMillis();
// 原始请求参数定义
//key1=value1&key2=&key3=value3    key2 为空将不会被作为签名的字符串并被舍弃请求。 具体请参见接口文档。
// 此处会自动添加sign 参数，sign可以不填或者留空即可。
		String originalparametersString = "serviceVersion=1.0&requestTime="+requestTime+"&operatorName=CuiXiaoming";
		String[] parameters = originalparametersString.split("&");
		TreeMap SortedParametersWithoutSign = new TreeMap();
// 将参数按字母排序
		for(int i = 0 ; i < parameters.length ; i ++){
			String[] pandvalue  =  parameters[i].split("=");
			if(pandvalue.length>1){
				String[] values = Arrays.copyOfRange(pandvalue, 1, pandvalue.length);
				if(!values[0].equals(""))
					SortedParametersWithoutSign.put(pandvalue[0],values[0]);
			}
		}

// 根据排序后的参数，组装参数。
		String requestParameters = "";
		Set set = SortedParametersWithoutSign.entrySet();
		Iterator iterator = set.iterator();
		int iterationcount = 0;
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			if(iterationcount == 0)
				requestParameters += mentry.getKey()+"="+mentry.getValue();
			else requestParameters += "&"+mentry.getKey()+"="+mentry.getValue();
			iterationcount++;
		}

	}
}