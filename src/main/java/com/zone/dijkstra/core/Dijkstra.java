package com.zone.dijkstra.core;

import com.zone.dijkstra.utils.GraphModelUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 单源最短路径 时间复杂度 e * log(e)
 * 任意点对最短路径即对每一个点执行一次单源最短路径算法  时间复杂度 v * e * log(e)
 * 远低于floyd算法的log(v^3)复杂度
 *
 * @author duanxin
 * @className: Dijkstra
 * @date 2019-12-20 16:32
 **/
public class Dijkstra {

    private Graph graph;
    private int s;
    private double[] dis;
    private int[] pre;

    private boolean[] isMin;

    private class Node implements Comparable<Node> {

        int v;
        double dis;

        Node(int v, double dis) {
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node another) {
            return (int) (dis - another.dis);
        }
    }


    /**
     * 每轮循环
     * 1、找到当前还未确定的节点的dis，即最短路径的节点
     *      2、确定这个节点的最短路径就是当前大小dis[cur]
     *          3、从这个节点遍历与之相连的其他节点，更新其他节点的路径长度
     *
     * ⓪①②③④⑤表示节点，路径上的数字表示距离
     * 初始化dis[]数组赋值为MAX
     * 第一次确定传入的源点s，当前dis[s]确定为最小值 即0，更新与⓪相连的其他节点路径长度
     *     dis[MAX,MAX...]-->dis[0,1,MAX,MAX,5,6]
     * 第二次找到最小值为dis[1] = 1，更新与①相连的其他节点路径长度
     *     dis[0,1,MAX,MAX,5,6]-->dis[0,1,9,MAX,3,6]
     * 第三次找到最小值为dis[4] = 3，更新与④相连的其他节点路径长度
     *     dis[0,1,9,MAX,3,6]-->dis[0,1,5,MAX,3,5]
     *          ........
     *
     *    此时时间复杂度为v轮循环，每次循环中遍历找最节点需要遍历v次 即： v * v
     *    若使用优先队列找最小节点，时间复杂度降至log级别
     *
     *            ①
     *         / |   \
     *      1/   |   8\
     *     /    2|     \
     *   /       |      \
     * ⓪  --5-- ④ --2-- ②
     *  \     /         /
     *  6\  2/        3/
     *    \ /         /
     *    ⑤----4----③
     *
     */

    /**
     * @param graph
     * @param s
     */
    public Dijkstra(Graph graph, int s) {
        this.graph = graph;

        graph.validateVertex(GraphModelUtil.integer2PointName(s));
        this.s = s;

        dis = new double[graph.getV()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s] = 0;

        pre = new int[graph.getV()];
        Arrays.fill(pre, -1);
        pre[s] = 0;

        isMin = new boolean[graph.getV()];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {

            int cur = pq.remove().v;
            if (isMin[cur]) {
                continue;
            }

            isMin[cur] = true;
            String curStr = GraphModelUtil.integer2PointName(cur);
            for (int w : graph.adj(curStr)) {
                String wStr = GraphModelUtil.integer2PointName(w);
                if (!isMin[w]) {
                    if (dis[cur] + graph.getWeight(curStr, wStr) < dis[w]) {
                        dis[w] = dis[cur] + graph.getWeight(curStr, wStr);
                        pq.add(new Node(w, dis[w]));
                        pre[w] = cur;
                    }
                }
            }
        }
    }

    public boolean isConnectedTo(int v){
        graph.validateVertex(GraphModelUtil.integer2PointName(v));
        return isMin[v];
    }

    public Iterable<Integer> path(int t){
        ArrayList<Integer> res = new ArrayList<>();

        if (!isConnectedTo(t)){
            return res;
        }

        int cur = t;
        while (cur != s){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);

        return res;
    }
}
