package com.zone.dijkstra.service;

import com.zone.dijkstra.dto.MapDto;

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

}
