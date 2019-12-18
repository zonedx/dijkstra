package com.zone.dijkstra.service.impl;

import com.zone.dijkstra.dao.PathDao;
import com.zone.dijkstra.dto.PathDto;
import com.zone.dijkstra.entity.Path;
import com.zone.dijkstra.service.IPathService;
import com.zone.dijkstra.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxin
 * @className: PathServiceImpl
 * @date 2019-12-18 17:40
 **/
@Service
public class PathServiceImpl implements IPathService {

    @Resource
    PathDao pathDao;

    @Override
    public List<PathDto> getPathsByMapId(Long mapId) {
        List<Path> paths = pathDao.findByMapId(mapId);
        if (paths.size() > 0){
            return BeanUtil.copyListProperties(paths,PathDto.class);
        }
        return null;
    }
}
