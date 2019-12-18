package com.zone.dijkstra.dao;

import com.zone.dijkstra.entity.Path;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zone
 */
@Repository
public interface PathDao extends PagingAndSortingRepository<Path,Long>, JpaSpecificationExecutor<Path> {

    /**
     * 根据mapId查询路线
     * @param id
     * @return
     */
    List<Path> findByMapId(Long id);
}
