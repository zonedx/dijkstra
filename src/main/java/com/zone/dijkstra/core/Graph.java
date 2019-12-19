package com.zone.dijkstra.core;


import com.zone.dijkstra.utils.GraphModelUtil;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author duanxin
 * @className: Graph
 * @date 2019-12-18 19:34
 **/
public class Graph {


    private int v;
    private int e;
    private TreeMap<Integer, Double>[] adj;
    private boolean directed;

//    private MapServiceImpl mapService = ApplicationContextUtil.getBean(MapServiceImpl.class);



    public Graph(boolean directed,String[] g) {

        this.directed = directed;

        String[] ve = g[0].split("-");
        /** 顶点数 */
        v = Integer.parseInt(ve[0]);
        /** 边数 */
        e = Integer.parseInt(ve[1]);
        if (v < 1 || e < 1) {
            throw new IllegalArgumentException("Please input right mapId");
        }
        adj = new TreeMap[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new TreeMap<>();
        }

        for (int i = 1; i < e ; i++) {
            String[] path = g[i].split("-");

            int a = Integer.parseInt(path[0]);
            int b = Integer.parseInt(path[1]);
            double weight = Double.parseDouble(path[2]);

            if (a == b) {
                throw new IllegalArgumentException("Self Loop is Detected!");
            }

            adj[a].put(b,weight);
            if (!directed) {
                adj[b].put(a, weight);
            }
        }

    }

    public Graph(String[] g){
        this(true,g);
    }


    public boolean isDirected() {
        return directed;
    }

    public int getV(){
        return v;
    }

    public int getE(){
        return e;
    }

    public boolean hasEdge(String source,String target){
        validateVertex(source);
        validateVertex(target);

        return adj[GraphModelUtil.pointName2Integer(source)].containsKey(GraphModelUtil.pointName2Integer(target));
    }

    public Iterable<Integer> adj(String point) {

        validateVertex(point);
        return adj[GraphModelUtil.pointName2Integer(point)].keySet();
    }

    public double getWeight(String source,String target){
        if (hasEdge(source,target)) {
            return adj[GraphModelUtil.pointName2Integer(source)].get(GraphModelUtil.pointName2Integer(target));
        }
        throw new IllegalArgumentException("Please input right point");
    }

    private void validateVertex(String point){
        if (!GraphModelUtil.hasPoint(point)) {
            throw new IllegalArgumentException("Please input right point");
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d , E = %d , directed = %b\n", v, e, directed));

        for (int i = 0 ; i < adj.length; i++){
            sb.append(String.format("%s：", GraphModelUtil.getMapKey().get(i)));

            for (Map.Entry<Integer,Double> entry : adj[i].entrySet()){
                sb.append(String.format("(%s, %.2f)",GraphModelUtil.integer2PointName(entry.getKey()),entry.getValue()));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
