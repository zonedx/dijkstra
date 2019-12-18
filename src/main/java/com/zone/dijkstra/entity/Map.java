package com.zone.dijkstra.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zone
 * @description 地图主体的实体
 */
@Entity
@Table(name = "t_map")
@Data
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mapId;
    @Column(columnDefinition = " varchar(255) COMMENT '地图名称'")
    private String mapName;
    @Column(columnDefinition = " Integer COMMENT '地图是否启用,0为未启用，1为已启用'")
    private Integer enable;
    @Column(columnDefinition = " varchar(255) COMMENT '版本号'")
    private String version;
    @Column(columnDefinition = " varchar(255) COMMENT '所属代码、产品Id等'")
    private String productCode;
    @Column(columnDefinition = " varchar(255) COMMENT '产品名称'")
    private String productName;
    @Column(name = "mid",columnDefinition = " varchar(255) COMMENT '页面需要的id'")
    private String mid;
    @Column(columnDefinition = " mediumtext COMMENT '缩略图地址'")
    private String imageUrl;
    @Column(columnDefinition = " varchar(255) COMMENT '地图的状态'")
    private String mapStatus;

}
