package com.zone.dijkstra.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * description 地图点的集合
 * @author zone
 */

@Entity
@Table(name = "t_point")
@Data
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = " varchar(255) COMMENT '点的名称'")
    private String name;

    @Column(columnDefinition = " varchar(255) COMMENT '点序列号'")
    private String pointSn;

    @Column(columnDefinition = " Double COMMENT '横坐标'")
    private Double xPosition;

    @Column(columnDefinition = " Double COMMENT '纵坐标'")
    private Double yPosition;

    @Column(columnDefinition = " Double COMMENT 'z轴坐标或高度，便于后续坡度使用'")
    private Double zPosition;

    @Column(columnDefinition = " varchar(255) COMMENT 'X偏移量'")
    private String xOffset="";

    @Column(columnDefinition = " varchar(255) COMMENT 'Y偏移量'")
    private String yOffset="";

    @Column(columnDefinition = " varchar(255) COMMENT '类型'")
    private String type="";

    @Column(columnDefinition = " varchar(255) COMMENT '上下料点的类型'")
    private String pointType="";

    @Column(columnDefinition = " varchar(255) COMMENT '上下料点的图标的位置'")
    private String pointTypePosition;

    @Column(columnDefinition = " bit(1) default false COMMENT '是否减速'",nullable=false)
    private Boolean slow = false;

    @Column(columnDefinition = " varchar(255) COMMENT '预设动作指令集'")
    private String actions;

    @Column(columnDefinition = " varchar(255) COMMENT '关联设备(为功能节点时可设定)'")
    private String equip;

    @Column(columnDefinition = " varchar(255) COMMENT '任务类型(为功能节点时可设定)'")
    private String taskType;

    @Column(columnDefinition = " varchar(255) COMMENT '任务优先级(为功能节点时可设定)'")
    private String priority;

    @Column(columnDefinition = " bigint(20) COMMENT '地图Id'")
    private Long mapId;

    @Column(name = "mid",columnDefinition = " varchar(255) COMMENT '页面需要的id'")
    private String mid;
    @Column(columnDefinition = " varchar(255) COMMENT '用于储存背景颜色、字体大小、尺寸等页面属性信息'")
    private String options;

    @Column(columnDefinition = " bit(1) default false COMMENT '是否停车点'",nullable=false)
    private Boolean isParkPoint = false;

    @Column(columnDefinition = " bit(1) default false COMMENT '是否作业点'",nullable=false)
    private Boolean isWorkPoint = false;

    @Column(columnDefinition = " varchar(255) COMMENT '入站角度'")
    private String inboundAngle;


}
