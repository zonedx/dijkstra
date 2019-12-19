package com.zone.dijkstra.service;

import com.zone.dijkstra.entity.Point;

import java.util.List;

/**
 * @author duanxin
 * @className: IPointService
 * @date 2019-12-18 20:01
 **/
public interface IPointService {

    /**
     * 获取总顶点数
     * @param mapId
     * @return
     */
    int getPoint(Long mapId);

    /**
     * 获取顶点集合
     * @param mapId
     * @return
     */
    List<Point> getPoints(Long mapId);
}
