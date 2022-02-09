//Connected Components in a Graph

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    private static void dfs(int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> graph){
        visited[vertex] = true;
        for(int child : graph.get(vertex)){
            if(visited[child] == true) continue;
            dfs(child, visited, graph); 
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            graph.add(list);
        }
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<e; i++){
            String[] s2 = in.readLine().trim().split(" ");
            int v1 = Integer.parseInt(s2[0]);
            int v2 = Integer.parseInt(s2[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        in.close();
        int count = 0;
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;
            dfs(i, visited, graph);
            count++;
        }
        System.out.println(count);
    }
}