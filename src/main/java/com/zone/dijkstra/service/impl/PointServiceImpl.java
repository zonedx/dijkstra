package com.zone.dijkstra.service.impl;

import com.zone.dijkstra.dao.PointDao;
import com.zone.dijkstra.entity.Point;
import com.zone.dijkstra.service.IPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author duanxin
 * @className: PointServiceImpl
 * @date 2019-12-18 20:01
 **/
@Service
public class PointServiceImpl implements IPointService {

    @Resource
    PointDao pointDao;
    @Override
    public int getPoint(Long mapId) {
        List<Point> points = pointDao.findByMapId(mapId);
        return points.size();
    }

    @Override
    public List<Point> getPoints(Long mapId){
        return pointDao.findByMapId(mapId);
    }
}
