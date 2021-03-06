package com.swuorange.util;

import java.util.Random;

public class TraceKey {
	
	/*public static void main(String[] args) {
        //随机生成纯数字
        //for(int i=0;i<15;i++)
        String key = getTraceCode(20);
        System.out.println(key);
      
    }*/
	//随机生成20位数字字母混合的溯源码
    public static String getTraceCode(int length) {  
          
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }
    

}

