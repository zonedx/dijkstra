package com.zone.dijkstra.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxin
 * @className: BeanUtil
 * @date 2019-12-18 17:42
 **/
public class BeanUtil {

    public static<T> List<T> copyListProperties(List<?> source, Class target){
        Assert.notNull(source,"Source must not be null!");
        Assert.notNull(target,"Target must not be null!");
        List<T> result = new ArrayList<>();
        if (source != null){
            for (Object object : source){
                try {
                    T targetObject = (T) target.newInstance();
                    copyProperties(object,targetObject);
                    result.add(targetObject);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void copyProperties(Object source,Object target){
        BeanUtils.copyProperties(source,target);
    }
}
