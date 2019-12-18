package com.zone.dijkstra.dao;

import com.zone.dijkstra.entity.Map;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * @author zone
 */
@Repository
public interface MapDao extends PagingAndSortingRepository<Map,Long>, JpaSpecificationExecutor<Map> {

    /**
     * 根据mapId查询map信息
     * @param id
     * @return
     */
     Map findMapByMapId(Long id);
}
