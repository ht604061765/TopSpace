/**
 * @author Hunter
 * TopSpaceMaven
 * 2017-12-23 下午11:26:13
 * TODO //
 */
package com.topspace.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CollectionUtil {
	
	private CollectionUtil() {
	}

	/**
	 * 判断是否为空
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty( Collection collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * 获取两个List的交集
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static List intersection(List first, List second) {
		List result = new ArrayList();
		if (isEmpty(first) || isEmpty(second)) {
			return result;
		} else {
			for (int i = 0; i < first.size(); i++) {
				Object firstObj = first.get(i);
				if (second.contains(firstObj)) {
					result.add(firstObj);
				}
			}
		}
		return result;
	}

	/**
	 * 两个list的合并
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static List merge(List one, List two) {
		if (isEmpty(one)) {
			return two;
		}
		if (isEmpty(two)) {
			return one;
		}
		List result = new ArrayList();
		// 开始合并操作
		Set set = new HashSet();
		for (int i = 0; i < one.size(); i++) {
			Object obj = one.get(i);
			if (set.add(obj)) {
				result.add(obj);
			}
		}
		for (int i = 0; i < two.size(); i++) {
			Object obj = two.get(i);
			if (set.add(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	/**
	 * 判断两个List的对象中的内容是否相等
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean isEquals(List first, List second) {

		if (first == null && second == null) {
			return true;
		}
		int firstSize = 0;
		if (!isEmpty(first)) {
			firstSize = first.size();
		}
		int secondSize = 0;
		if (!isEmpty(second)) {
			secondSize = second.size();
		}
		if (secondSize != firstSize) {
			return false;
		}

		for (int i = 0; i < firstSize; i++) {
			Object firstObj = first.get(i);
			Object secondObj = second.get(i);
			if (firstObj == null) {
				if (secondObj == null) {
					continue;
				} else {
					return false;
				}
			} else {
				if (firstObj.equals(secondObj)) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;

	}

	/**
	 * 功能：集合差集 第一个减去第二个 说明：从第一个集合中提取第二个集合中没有的元素
	 * 
	 * @param first
	 *            第一个集合
	 * @param second
	 *            第二个集合
	 * @return
	 */
	public static List subtract(List first, List second) {
		List resultList = new ArrayList();
		if (isEmpty(first)) {
			return resultList;
		}
		if (isEmpty(second)) {
			return first;
		}

		boolean inboth = false;// 某个元素在两个集合中都有
		for (int findex = 0; findex < first.size(); findex++) {
			Object fobj = first.get(findex);
			inboth = false;
			for (int sindex = 0; sindex < second.size(); sindex++) {
				Object sobj = second.get(sindex);
				if (null != fobj && fobj.equals(sobj)) {
					inboth = true;
					break;
				}
			}
			if (!inboth) {
				resultList.add(fobj);
				inboth = false;
			}
		}
		return resultList;
	}

}


