package com.zone.dijkstra.service;

import com.zone.dijkstra.core.Graph;
import com.zone.dijkstra.dto.MapDto;

import java.util.List;

/**
 * @author duanxin
 * @className: MapService
 * @date 2019-12-18 17:20
 **/
public interface IMapService {

    /**
     * 根据mapId获取地图详情
     * @param mapId
     * @return
     */
    MapDto getMapInfoByMapId(Long mapId);

    /**
     * 根据mapInfo封装路线信息
     * @param mapId
     * @return
     */
    String[] getPath(Long mapId);

    /**
     * 建模图，用于计算-- 已重写toString()可直接print查看
     * @param mapId
     * @return
     */
    Graph calculate(Long mapId);
}
