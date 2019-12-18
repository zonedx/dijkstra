package com.zone.dijkstra.service.impl;

import com.zone.dijkstra.dao.MapDao;
import com.zone.dijkstra.dao.PathDao;
import com.zone.dijkstra.dto.MapDto;
import com.zone.dijkstra.dto.PathDto;
import com.zone.dijkstra.entity.Map;
import com.zone.dijkstra.service.IMapService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author duanxin
 * @className: MapServiceImpl
 * @date 2019-12-18 17:25
 **/
@Service
public class MapServiceImpl implements IMapService {

    @Resource
    MapDao mapDao;

    @Resource
    PathServiceImpl pathService;

    @Override
    public MapDto getMapInfoByMapId(Long mapId) {
        Map map = mapDao.findMapByMapId(mapId);
        MapDto mapDto = new MapDto();
        if (map != null){
            BeanUtils.copyProperties(map,mapDto);
            List<PathDto> pathDtos = pathService.getPathsByMapId(mapId);
            mapDto.setPathDtos(pathDtos);
        }
        return mapDto;
    }
}
