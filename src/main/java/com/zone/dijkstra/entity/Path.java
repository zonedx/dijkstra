package com.zone.dijkstra.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zone
 * @description 地图路径的实体
 */

@Entity
@Table(name = "t_path")
@Data
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = " varchar(255) COMMENT '名称'")
    private String name;

    @Column(columnDefinition = " varchar(255) COMMENT '起始节点'")
    private String sourcePointSn;

    @Column(columnDefinition = " varchar(255) COMMENT '目标节点'")
    private String destinationPointSn;

    @Column(columnDefinition = " double default 1.0 COMMENT '长度'",nullable=false)
    private Double length = 1.0;

    @Column(columnDefinition = " double default 1.0 COMMENT '路径代价'",nullable=false)
    private Double cost = 1.0;

    @Column(columnDefinition = " double COMMENT '最大前进速度'")
    private Double maxVelocity;

    @Column(columnDefinition = " double COMMENT '最大倒车速度'")
    private Double maxReverseVelocity;

    @Column(columnDefinition = " double COMMENT '路线通过宽度'")
    private Double roadWidth;

    @Column(columnDefinition = "bit(1) default false COMMENT '是否锁住'",nullable=false)
    private Boolean locked = false;

    @Column(columnDefinition = "bit(1) default true COMMENT '是否单向'",nullable=false)
    private Boolean isSingle = true;

    @Column(columnDefinition = " varchar(255) COMMENT '曲线控制点(x,y;x,y;x,y)'")
    private String controlPoints;

    @Column(columnDefinition = " varchar(255) COMMENT '路径起点朝向，与 x 轴正方向朝向，弧度单位'")
    private String startFace;

    @Column(columnDefinition = " varchar(255) COMMENT '路径终点朝向，与 x 轴正方向朝向，弧度单位'")
    private String endFace;

    @Column(columnDefinition = " varchar(20) COMMENT '路线类型：直线或者弧线'")
    private String roadType;

    @Column(columnDefinition = " integer COMMENT '路径坡度'")
    private Integer roadAngle;

    @Column(columnDefinition = " boolean COMMENT '是否倒退路基，如果是倒退路径，小车在路径上倒着运动'")
    private Boolean isBackPath;

    @Column(columnDefinition = " bigint(20) COMMENT '地图Id'")
    private Long mapId;

    @Column(name = "mid",columnDefinition = " varchar(255) COMMENT '页面需要的id'")
    private String mid;
    @Column(columnDefinition = " varchar(255) COMMENT '用于储存背景颜色、字体大小、尺寸等页面属性信息'")
    private String options;
    @Column(columnDefinition = " varchar(255) COMMENT '页面显示线需要的起点id'")
    private String startMid;
    @Column(columnDefinition = " varchar(255) COMMENT '页面显示线需要的终点id'")
    private String endMid;
    @Column(columnDefinition = " varchar(255) COMMENT '线路的行驶类型'")
    private String moveType;
    @Column(columnDefinition = " varchar(255) COMMENT '线路的Sn'")
    private String pathSn;
}
