package com.zone.dijkstra.controller;

import com.zone.dijkstra.core.Dijkstra;
import com.zone.dijkstra.core.Graph;
import com.zone.dijkstra.service.IMapService;
import com.zone.dijkstra.vo.ServerResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author duanxin
 * @className: MapController
 * @date 2019-12-19 16:02
 **/

@Api(value = "地图 api",tags = {"map"})
@RestController
@RequestMapping("/v1/map")
public class MapController {

    @Resource
    IMapService mapService;

    @ApiOperation(value = "获取地图")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mapId" ,value = "地图id",required = true,paramType = "path",dataType = "Long"),
    })
    @GetMapping("/getMap/{mapId}")
    public ResponseEntity graph(@PathVariable Long mapId){
        Graph graph = mapService.calculate(mapId);
        System.out.println(graph.adj("P012"));
        return ResponseEntity.ok(ServerResponse.success(graph.toString()));
    }

    @ApiOperation(value = "获取最短路径")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mapId" ,value = "地图id",required = true,paramType = "path",dataType = "Long"),
            @ApiImplicitParam(name = "start" ,value = "开始点，暂时为点的编号",required = true,paramType = "path",dataType = "int"),
            @ApiImplicitParam(name = "end" ,value = "结束点，点名称",required = true,paramType = "path",dataType = "string"),

    })
    @PostMapping("/calculate/{mapId}/{start}/{end}")
    public ResponseEntity path(@PathVariable Long mapId,
                               @PathVariable int start,
                               @PathVariable String end){
        Graph graph = mapService.calculate(mapId);
        Dijkstra dijkstra = new Dijkstra(graph,start);

        return ResponseEntity.ok(ServerResponse.success(dijkstra.path(end)));
    }

    @ApiOperation(value = "test")
    @GetMapping("/test")
    public String hello(){
        return "hello world!";
    }
}
