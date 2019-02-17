/**
 * Copyright 2015-2025 FLY的狐狸(email:jflyfox@sina.com qq:369191470).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.example.websocketdemo.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberUtils {

	private NumberUtils() {
	}

	public static int parseInt(Object obj) {
		int value = 0;
		if (obj != null) {
			try {
				value = Integer.parseInt(obj.toString());
			} catch (Exception e) {
				value = 0;
			}
		}
		return value;
	}

	public static BigDecimal parseBigDecimal(Object obj) {
		BigDecimal value = BigDecimal.ZERO;
		if (obj != null) {
			try {
				value = new BigDecimal(obj.toString());
			} catch (Exception e) {
				value = BigDecimal.ZERO;
			}
		}
		return value;
	}

	public static int parseInt(String str){
		return parseInt(str ,0);
	}

	public static int parseInt(String str ,int defaultValue){
		try{
			defaultValue = Integer.parseInt(str);
		} catch(Exception e){}
		return defaultValue ;
	}

	public static double parseDbl(String str){
		return parseDbl(str ,0);
	}

	public static double parseDbl(String str ,double defaultValue){
		try{
			defaultValue = Double.parseDouble(str);
		} catch(Exception e){}
		return defaultValue ;
	}
	
	public static float parseFloat(String str) {
		return parseFloat(str, 0);
	}
	
	public static float parseFloat(String str ,float b) {
		try{
			return Float.parseFloat(str);
		}catch(Exception e){
			return b;
		}
	}

	public static long parseLong(String str) {
		return parseLong(str, 0l);
	}

	public static long parseLong(String str ,long defaultValue){
		try{
			defaultValue = Long.parseLong(str);
		} catch(Exception e){}
		return defaultValue ;
	}








	public static void main(String[] args)
	{

		int count = 1000000;
		List<String> listString = new ArrayList<>();
		int lenght = 5;
		for(int i =0; i < count; i++){
			listString.add(RandomStringUtils.randomAlphabetic(lenght).toUpperCase());
			lenght++;
			if(lenght > 10){
				lenght = 5;
			}
		}

		int size = listString.size();
		for(int i =0; i < size; i++){
			String outputString = sortString(listString.get(i));
			listString.set( i, outputString);
		}

		java.util.Collections.sort(listString);
		System.out.println(listString.size());
	}

	public static String sortString(String inputString)
	{
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}
}
