package com.zone.dijkstra.dao;

import com.zone.dijkstra.entity.Point;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zone
 */
@Repository
public interface PointDao extends PagingAndSortingRepository<Point,Long>, JpaSpecificationExecutor<Point> {

    /**
     * 根据mapId获取顶点总数
     * @param mapId
     * @return
     */
    List<Point> findByMapId(Long mapId);
}
