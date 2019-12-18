package com.zone.dijkstra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author duanxin
 * @className: PathDto
 * @date 2019-12-18 17:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathDto implements Serializable {
    /**名称*/
    private String name;
    /**起始节点*/
    private String sourcePointSn;
    /**目标节点*/
    private String destinationPointSn;
    /**长度*/
    private Double length = 1.0;
    /**最大前进速度*/
    private Double maxVelocity;
    /**最大倒车速度*/
    private Double maxReverseVelocity;
    /**路线通过宽度*/
    private Double roadWidth;
    /**是否锁住*/
    private Boolean locked = false;
    /**是否单向*/
    private Boolean isSingle = true;

    private String pathSn;
    /**是否垂直*/
//    private Boolean isVertical;
//    /**车辆探测范围*/
//    private String vehicleDetectionRange;
    /**路线类型：直线或者弧线*/
    private String roadType;
    /**路径坡度*/
    private Integer roadAngle = 0;
    /**地图Id*/
    private Long mapId;

    private Double cost = 1.0;

    private Long id;

    private String controlPoints;

    private String startFace;

    private String endFace;

    private Integer isBackPath;

    private String mid;
    private String options;
    private String startMid;
    private String endMid;
    private String moveType;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp updateTime;


    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PathDto that = (PathDto) o;
        return Objects.equals(sourcePointSn,that.sourcePointSn)  &&
                Objects.equals(destinationPointSn, that.destinationPointSn) &&
                Objects.equals(pathSn, that.pathSn);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sourcePointSn, destinationPointSn, pathSn);
    }
}
