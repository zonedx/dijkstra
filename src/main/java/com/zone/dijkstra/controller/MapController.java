package com.zone.dijkstra.controller;

import com.zone.dijkstra.core.Dijkstra;
import com.zone.dijkstra.core.Graph;
import com.zone.dijkstra.service.IMapService;
import com.zone.dijkstra.vo.ServerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author duanxin
 * @className: MapController
 * @date 2019-12-19 16:02
 **/

@Controller
public class MapController {

    @Resource
    IMapService mapService;

    @RequestMapping("/getMap/{mapId}")
    @ResponseBody
    public ResponseEntity graph(@PathVariable Long mapId){
        Graph graph = mapService.calculate(mapId);
        System.out.println(graph.adj("P012"));
        return ResponseEntity.ok(ServerResponse.success(graph.toString()));
    }

    @RequestMapping("/calculate/{mapId}/{start}/{end}")
    public ResponseEntity path(@PathVariable Long mapId,
                               @PathVariable int start,
                               @PathVariable String end){
        Graph graph = mapService.calculate(mapId);
        Dijkstra dijkstra = new Dijkstra(graph,start);

        return ResponseEntity.ok(ServerResponse.success(dijkstra.path(end)));
    }
}
