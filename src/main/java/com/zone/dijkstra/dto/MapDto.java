package com.zone.dijkstra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author duanxin
 * @className: MapDto
 * @date 2019-12-18 17:24
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapDto implements Serializable {
    /**主键ID*/
    private Long mapId;
    /**地图名称*/
    private String mapName;
    /**地图可启用，0为未启用，1为已启用*/
    private Integer enable;
    /**地图版本号*/
    private String version;
    /**所属代码、产品Id等*/
    private String productCode;

    private String productName;

    private String mapStatus;

    private String mid;

    private String imageUrl;

    private List<PathDto> pathDtos;
    /** 顶点数 */
    private int points;

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

}
