package com.mtty.igood.util;


import java.util.Arrays;

/**
 * @Desp
 * @Date 2018/4/24
 * @Author mtty
 */
public final class SortUtil {
    //字典排序
    public static String dirtSort(String ...strs){
        Arrays.sort(strs);
        StringBuilder dirtStr = new StringBuilder();
        for (String str: strs){
            dirtStr.append(str);
        }
        return dirtStr.toString();
    }
}
