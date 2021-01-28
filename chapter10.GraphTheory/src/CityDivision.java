import java.util.*;

public class CityDivision {
    public static int v, e;
    public static List<Edge> edges = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        sc.nextLine();

        int[] parent = new int[v+1];
        for (int i = 1; i<v+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i< e; i++) {
            int a, b, cost;
            a = sc.nextInt();
            b = sc.nextInt();
            cost = sc.nextInt();
            edges.add(new Edge(a, b, cost));
            sc.nextLine();
        }

        Collections.sort(edges);

        int result = 0;
        int last = 0;
        for (Edge edge : edges) {
            if (find_parent(parent, edge.a) != find_parent(parent, edge.b)) {
                union_parent(parent, edge.a, edge.b);
                result += edge.cost;
                last = edge.cost;
            }
        }
        System.out.println(result - last);

    }

    public static int find_parent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);
        if (a < b) { parent[b] = a; }
        else { parent[a] = b; }
    }
}

