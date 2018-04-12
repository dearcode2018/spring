/**
 * 描述: 
 * RandomCodeStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import java.util.Random;

import org.junit.Test;

/**
 * 描述: 签名密钥 - 启动器
 * @author  qye.zheng
 * 
 * RandomCodeStarter
 */
public final class SignSecretGenerator
{

	//static final String CODE = "~!@#$%^&*?=+_0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static final String CODE = "!@$%^&?+_0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	static final String CODE_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	
	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		/** ===== end of 驱动参数设置 ===== */
		// 启动驱动
		/* 3 + 29 = 32 位长 */
		final int length = 29;
		String apiSecret = "api";
		String androidAppKey = "and";
		String iosAppKey = "ios";
		String randomCode = null;
		
		randomCode = getRandomCode(length);
		apiSecret += randomCode;
		System.out.println("apiSecret = " + apiSecret);
		
		randomCode = getRandomCode(length);
		androidAppKey += randomCode;
		System.out.println("androidAppKey = " + androidAppKey);
		
		randomCode = getRandomCode(length);
		iosAppKey += randomCode;
		System.out.println("iosAppKey = " + iosAppKey);
		
		// O2O_APP_AZFEZJPWOUQHDIPMAPCRPPEAICMQKHBF
		//randomCode = getRandomLetter(length);
		//System.out.println("randomCode = " + randomCode);
		
	}
	
	 /**
     * Generates a string of random chars from the CODE set.
     *
     * @param num
     *            Number of chars to generate.
     */
    public static String getRandomCode(final int num) {
        final StringBuilder saltString = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            saltString.append(CODE.charAt(new Random().nextInt(CODE.length())));
        }
        return saltString.toString();
    }
    
	
	 /**
    * Generates a string of random chars from the CODE set.
    *
    * @param num
    *            Number of chars to generate.
    */
   public static String getRandomLetter(final int num) {
       final StringBuilder saltString = new StringBuilder();
       for (int i = 1; i <= num; i++) {
           saltString.append(CODE_LETTER.charAt(new Random().nextInt(CODE_LETTER.length())));
       }
       return saltString.toString();
   }  
		  
}
