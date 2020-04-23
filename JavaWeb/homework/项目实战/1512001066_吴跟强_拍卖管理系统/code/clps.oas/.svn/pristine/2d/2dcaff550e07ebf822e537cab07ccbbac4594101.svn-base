package com.clps.oas.util.stringconversion;

/**
 * 
 * @Title:字符类型工具类
 * @Description: 字符类型的转换 字符的修改
 * @Author:henery.wu
 * @Since:2018年5月11日
 * @Version:1.1.0
 */

public class StringConversionUtil {
	/**
	 * 
	 * 去除整个字符串中所有空格
	 * 
	 * @param pwd
	 *            源字符串
	 * @return 替换所有空白字符 返回字符
	 */
	public static String removespaces(String pwd) {

		if (pwd == null || "".equals(pwd.trim())) {
			return "";
		}
		return pwd.replaceAll("\\s+", "");
	}

	/**
	 * 
	 * 去除字符串两端空格
	 * 
	 * @param pwd
	 *            源字符串
	 * @return 替换两端空白字符 返回字符
	 */
	public static String removespace(String pwd) {

		if (pwd == null) {
			return "";
		}
		String a = pwd.trim();
		return a;
	}

	/**
	 * string类型转换成int类型
	 * @param intstr
	 *            源字符串
	 * @return 返回 int类型
	 */
	public static int stringToint(String intstr) {

		Integer integer;
		integer = Integer.valueOf(intstr);
		return integer.intValue();
	}

	/**
	 * int类型转换成string类型
	 * @param strint
	 *            源字符串
	 * @return 返回string类型
	 */
	public static String intTostring(int strint) {

		Integer integer = new Integer(strint);
		return integer.toString();
	}
	
	/**
	 * string类型转换为boolean类型
	 * @param boolstr
	 *            源字符串
	 * @return 返回boolean类型
	 */
	public static boolean stringToboolean(String boolstr){
		boolean b = Boolean.valueOf(boolstr).booleanValue();
		return b;	
	}
	
	/**
	 * string类型转换为float类型
	 * @param flostr
	 *            源字符串
	 * @return 返回float类型
	 */
	public static float stringTofloat(String flostr){
		float b = Float.valueOf(flostr);
		return b;
	}
	/**
	 * 去除字符串中的数字
	 * @param str
	 *            源字符串
	 * @return 返回不带数字的字符串
	 */
	public static String removeNum(String str) {

		String s = str.replaceAll("\\d+", "");
		return s;
	}

}
