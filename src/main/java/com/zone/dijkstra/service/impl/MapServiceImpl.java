package com.zone.dijkstra.service.impl;

import com.zone.dijkstra.core.Graph;
import com.zone.dijkstra.dao.MapDao;
import com.zone.dijkstra.dao.PathDao;
import com.zone.dijkstra.dto.MapDto;
import com.zone.dijkstra.dto.PathDto;
import com.zone.dijkstra.entity.Map;
import com.zone.dijkstra.service.IMapService;
import com.zone.dijkstra.service.IPathService;
import com.zone.dijkstra.service.IPointService;
import com.zone.dijkstra.utils.GraphModelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    IPathService pathService;

    @Resource
    IPointService pointService;

    @Override
    public MapDto getMapInfoByMapId(Long mapId) {
        Map map = mapDao.findMapByMapId(mapId);
        MapDto mapDto = new MapDto();
        if (map != null) {
            BeanUtils.copyProperties(map, mapDto);
            List<PathDto> pathDtos = pathService.getPathsByMapId(mapId);
            mapDto.setPoints(pointService.getPoint(mapId));
            mapDto.setPathDtos(pathDtos);
        }
        return mapDto;
    }

    @Override
    public String[] getPath(Long mapId) {
        List<PathDto> mapDto = this.getMapInfoByMapId(mapId).getPathDtos();
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(mapDto)){
            throw new IllegalArgumentException("Please input right mapId!");
        }
        sb.append(this.getMapInfoByMapId(mapId).getPoints())
                .append("-")
                .append(mapDto.size())
                .append(",");
        mapDto.forEach(m -> sb.append(m.getPathSn()).append("-").append(m.getLength()).append(","));

        return sb.toString().split(",");

    }

    @Override
    public Graph calculate(Long mapId) {
        String[] g = this.genGraph(mapId);
        return new Graph(g);
    }


    /**
     * 将原始path转换为方便用于计算的点
     * @param mapId
     * @return
     */
    private String[] genGraph(Long mapId){
        String[] res = this.getPath(mapId);
        GraphModelUtil.pointNameMap2Integer(pointService.getPoints(mapId), res);
        return res;
    }
}
