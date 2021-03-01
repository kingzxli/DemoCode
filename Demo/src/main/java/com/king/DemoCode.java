package com.king;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DemoCode {
	/**
	 * Numbers from 0 to 99 convert to letters
	 * @param digits
	 * @return List<String>
	 */
	public List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<String>();
		if (!StringUtils.hasLength(digits)) {
			return combinations;
		}else if(!isInteger(digits)) {
			throw new RuntimeException("您的输入不正确,请输入整数数字");
		}
		
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        	 put('0', " ");
        	 put('1', " ");
        	 put('2', "abc");
             put('3', "def");
             put('4', "ghi");
             put('5', "jkl");
             put('6', "mno");
             put('7', "pqrs");
             put('8', "tuv");
             put('9', "wxyz");
        }};       
        
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
	
	private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
		 if (index == digits.length()) {
	            combinations.add(combination.toString().replace(" ", ""));
	        } else {
	            char digit = digits.charAt(index);
	            String letters = phoneMap.get(digit);
	            for (int i = 0; i < letters.length(); i++) {
	                combination.append(letters.charAt(i));
	                backtrack(combinations, phoneMap, digits, index + 1, combination);
	                combination.deleteCharAt(index);
	            }
	        }
	}
	
	/**
	 * Verify that it is a combination of numbers 2-9
	 * @param str
	 * @return boolean
	 */
	public static boolean isInteger(String str) {		
		Pattern pattern = Pattern.compile("^\\d+$");
		return pattern.matcher(str).matches();
	}

}
