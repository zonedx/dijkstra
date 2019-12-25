package com.zone.dijkstra.utils;

import com.zone.dijkstra.entity.Point;

import java.util.*;

/**
 * @author duanxin
 * @className: GraphModel
 * @date 2019-12-19 08:58
 **/
public class GraphModelUtil {

    /**
     * key为点名称
     * value为映射到图中的id
     */
    private static TreeMap<String, Integer> map;

    public static List<String> getMapKey() {
        List<String> list = new ArrayList<>();
        if (map.size() != 0) {
            for (Map.Entry entry : map.entrySet()) {
                list.add((String) entry.getKey());
            }
        }
        return list;
    }

    public static void pointNameMap2Integer(List<Point> points, String[] str) {

        if (points.size() == 0) {
            throw new IllegalArgumentException("Please input right mapId!");
        }

        map = new TreeMap<>();

        for (int i = 0; i < points.size(); i++) {
            map.put(points.get(i).getName(), i);
        }

        for (int i = 0; i < str.length - 1; i++) {
            String[] path = str[i + 1].split("-");
            StringBuilder sb = new StringBuilder();

            sb.append(map.get(path[0])).append("-").append(map.get(path[1])).append("-").append(path[2]);
            str[i + 1] = sb.toString();
        }
    }

    public static String integer2PointName(Integer integer) {


        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == integer) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    public static Integer[] pointName2Integer(String source, String target) {
        if (!map.containsKey(source) || !map.containsKey(target)) {
            throw new IllegalArgumentException("Please input right point!");
        }

        Integer[] integers = new Integer[2];
        integers[0] = map.get(source);
        integers[1] = map.get(target);

        return integers;
    }

    public static Integer pointName2Integer(String source) {
        if (!map.containsKey(source)) {
            throw new IllegalArgumentException("Please input right point!");
        }

        return map.get(source);
    }

    public static void dijkstraResultToString(List<Integer> source, List<String> target) {
        for (int i = 0 ; i < source.size(); i ++){
            target.add(integer2PointName(source.get(i)));
        }
    }

    public static boolean hasPoint(String point) {
        if (map.containsKey(point)) {
            return true;
        }
        return false;
    }
}
