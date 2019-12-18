package com.zone.dijkstra.service;

import com.zone.dijkstra.dto.PathDto;

import java.util.List;

/**
 * @author duanxin
 * @className: IPathService
 * @date 2019-12-18 17:39
 **/
public interface IPathService {

    /**
     * 根据mapId获取路线集合
     * @param mapId
     * @return
     */
    List<PathDto> getPathsByMapId(Long mapId);
}
