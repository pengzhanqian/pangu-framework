package com.pangu.framework.utils;

import cn.hutool.core.collection.ListUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * list相关的工具类
 *
 * @author pengzhan.qian
 * @date 2022/5/26 16:53
 */
public class PanguListUtil extends ListUtil {

    /**
     * 取2个list的差集(基于API解法) 适用于小数据量
     *
     * @return java.util.List
     * @author qianpengzhan
     * @date 2022/5/26 17:00
     */
    public static <T> List<T> subListForSmallData(List<T> list1, List<T> list2) {
        list1.removeAll(list2);
        return list1;
    }

    /**
     * 取2个list的差集(基于常规解法）优化解法1 适用于中等数据量
     * 求List1中有的但是List2中没有的元素
     * 空间换时间降低时间复杂度
     * 时间复杂度O(Max(list1.size(),list2.size()))
     *
     * @return java.util.List<T>
     * @author qianpengzhan
     * @date 2022/5/26 17:04
     */
    public static <T> List<T> subList1(List<T> list1, List<T> list2) {
        //空间换时间 降低时间复杂度
        Map<T, T> tempMap = new HashMap<>();
        for (T t : list2) {
            tempMap.put(t, t);
        }
        //LinkedList 频繁添加删除 也可以ArrayList容量初始化为List1.size(),防止数据量过大时频繁扩容以及数组复制
        List<T> resList = new LinkedList<>();
        for (T t : list1) {
            if (!tempMap.containsKey(t)) {
                resList.add(t);
            }
        }
        return resList;
    }


    /**
     * 取2个list的差集(基于java8新特性)优化解法2 适用于大数据量
     * 求List1中有的但是List2中没有的元素
     *
     * @return java.util.List<java.lang.String>
     * @author qianpengzhan
     * @date 2022/5/26 17:00
     */
    public static <T> List<T> subListForBigData(List<T> list1, List<T> list2) {
        Map<T, T> tempMap = list2.parallelStream().collect(Collectors.toMap(Function.identity(), Function.identity(), (oldData, newData) -> newData));
        return list1.parallelStream().filter(str -> !tempMap.containsKey(str)).collect(Collectors.toList());
    }
}
