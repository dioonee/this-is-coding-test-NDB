import java.util.*;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int nodeNum, edgeNum;
        Scanner sc = new Scanner(System.in);
        nodeNum = sc.nextInt();
        edgeNum = sc.nextInt();
        sc.nextLine();

        int[] parent = new int[nodeNum + 1];
        for (int i = 1; i<nodeNum+1; i++) {
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i< edgeNum; i++) {
            int a, b, cost;
            a = sc.nextInt();
            b = sc.nextInt();
            cost = sc.nextInt();
            edges.add(new Edge(a, b, cost));
            sc.nextLine();
        }

        Collections.sort(edges);

        int result = 0;
        for (Edge edge : edges) {
            if (find_parent(parent, edge.a) != find_parent(parent, edge.b)) {
                union_parent(parent, edge.a, edge.b);
                result += edge.cost;
                System.out.println(edge.cost); //test
            }
        }
        System.out.println(result);

    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }

    static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);
        if (a < b) { parent[b] = a; }
        else { parent[a] = b; }
    }
}

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) {
            return -1;
        }
        return 1;
    }
}