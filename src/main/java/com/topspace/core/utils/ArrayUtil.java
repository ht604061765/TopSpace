/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-23 下午11:24:45
 * TODO //
 */
package com.topspace.core.utils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public final class ArrayUtil {


	private ArrayUtil() {
	}

	/**
	 * 数组转换成字符串,中间用逗号(,)连接
	 * <p>
	 * 比如: arrayToString={"one","two"}; toString(array) return "one,two"<br>
	 * 如果参数为空,则返回""
	 * <p>
	 *
	 * @param array
	 *            目标数组
	 * @return
	 */
	public static String arrayToString(Object[] array) {
		if (isEmpty(array)) {
			return "";
		}
		int len = array.length;
		StringBuffer buf = new StringBuffer(len * 12);
		for (int i = 0; i < len - 1; i++) {
			buf.append(array[i]).append(',');
		}
		return buf.append(array[len - 1]).toString();
	}

	/**
	 * 数组转换成字符串 中间用分隔符连接
	 * <p>
	 * 比如: arrayToString={"one","two"},delimiters=";"; toString(array) return
	 * "one;two"<br>
	 * 如果参数为空,则返回""
	 * <p> *
	 *
	 * @param array
	 *            目标数组
	 * @param delimiters
	 *            分隔符
	 * @return
	 */
	public static String arrayToString(Object[] array, String delimiters) {
		if (isEmpty(array)) {
			return "";
		}
		int len = array.length;
		StringBuffer buf = new StringBuffer(len * 12);
		for (int i = 0; i < len - 1; i++) {
			buf.append(array[i]).append(delimiters);
		}
		return buf.append(array[len - 1]).toString();
	}

	/**
	 * 数组转换成查询SQL中的in查询
	 * <p>
	 * 比如: array={"one","two"}; arrayToSqlInConditionString(array) return
	 * "'one','two'" <br>
	 * 如果参数为空,则返回"''"
	 * <p>
	 *
	 * @param array
	 * @return
	 */
	public static String arrayToSqlInConditionString(Object[] array) {
		if (isEmpty(array)) {
			return "''";
		}
		int len = array.length;
		StringBuffer buf = new StringBuffer(len * 12);
		for (int i = 0; i < len - 1; i++) {
			buf.append('\'').append(array[i]).append("',");
		}
		return buf.append('\'').append(array[len - 1]).append("'").toString();
	}

	/**
	 * 数组后面添加一个String
	 * <p>
	 * 在数组的后面添加一个元素
	 * </p>
	 *
	 * @param srcarray
	 *            目标数组
	 * @param descStr
	 *            需要添加的字符串
	 * @return
	 */
	public static String[] addStringToArray(String[] srcarray, String descStr) {
		String[] newArr = new String[srcarray.length + 1];
		System.arraycopy(srcarray, 0, newArr, 0, srcarray.length);
		newArr[srcarray.length] = descStr;
		return newArr;
	}

	/**
	 * 判断某数组是否是空数组
	 * <p>
	 * 如果数组等于null或者长度等于零返回true,否则返回false
	 * </p>
	 *
	 * @param array
	 *            目标数组
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		return (null == array) || (array.length == 0);
	}

	/**
	 * 将一个Object类型的数组转换成字符串数组
	 * <p>
	 * 注意:前提是数组里的对象在向上转型前是字符串
	 * </p>
	 *
	 * @param array
	 * @return
	 */
	public static String[] convert2StrArray(final Object[] array) {
		if (isEmpty(array)) {
			return new String[0];
		}
		int length = array.length;
		String[] strArray = new String[length];
		for (int i = 0; i < length; i++) {
			strArray[i] = (String) array[i];
		}

		return strArray;
	}

	/**
	 * 求Stirng数组的差集[集合]
	 * <p>
	 * 例子: first={"a","b","c"};second={"a","d"}<br>
	 * return {"b","c"}
	 * </p>
	 *
	 * @param firstArray
	 * @param secondArray
	 * @return
	 */
	public static String[] subArray(String[] first, String[] second) {
		List<String> firstList = toArrayList(first);
		List<String> secondList = toArrayList(second);
		List<String> subs = CollectionUtil.subtract(firstList, secondList);
		int length = subs.size();
		String[] results = new String[length];
		for (int i = 0; i < length; i++) {
			results[i] = (String) subs.get(i);
		}
		return results;
	}

	/**
	 * 将字数据转换成ArrayList
	 *
	 * @param strArray
	 * @return
	 */
	public static List<String> toArrayList(String[] array) {
		List<String> result = new ArrayList<String>();
		if (null == array || array.length == 0) {
			return result;
		}

		for (int i = 0; i < array.length; i++) {
			result.add(array[i]);
		}

		return result;
	}

}


