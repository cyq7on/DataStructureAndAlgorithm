package com.cyq7on.practice.mt;


public class Graph {
    //建立一个标识数组，0表示未被发现的节点，1表示已被发现的节点，2表示邻接表检索完后的节点
    private static int[] color;
    //记录连通图的个数
    private static int count = 0;
    //遍历方法
    public static void DFS_visit(int[][] array,int n){
        //节点n已查找
        color[n]=1;
        //从n出发查找与n相连的节点
        for(int i = n;i<array.length;i++){
            for(int j = 0;j<array.length;j++){
                if(array[n][j]==1){
                    if(color[j]==0){
                        DFS_visit(array,j);
                    }
                }
            }
        }
        color[n]=2;
    }

    public static void Graph_DFS(int[][] graph){
        //初始化color数组，表示该无向图的所有节点都没有查找过
        for(int i = 0;i<graph.length;i++){
            color[i]=0;
        }
        //图的遍历
        for(int j = 0;j<graph.length;j++){
            if(color[j]==0){
                //每次执行以下2行代码，表示多出一个连通图
                count++;
                DFS_visit(graph,j);
            }
        }
    }
    /**
     * 主函数
     */
    public static void main(String[] args) {
        //创建一个1,2,3和4,5,6的环
        int[][] map1 = new int[][]{	{0,1,0},
                {1,0,0},
                {0,0,0},
        };
        int[][] map = new int[][]{
                {0,2,0,0,0},
                {0,0,2,0,0},
                {0,0,0,2,0},
                {0,0,0,0,2},
                {0,0,0,0,0}};
        //0表示未被发现的节点，1表示已被发现的节点，2表示邻接表检索完后的节点
        color = new int[map.length];
        Graph_DFS(map);
        System.out.println(count);
    }

}
