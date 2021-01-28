import java.util.Scanner;

public class TeamUnion {
    public static void main(String[] args) {
        int N, M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        int[] parent = new int[N+1];
        for (int i = 1; i<N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i< M; i++) {
            int oper, a, b;
            oper = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            if (oper == 0) {
                union_parent(parent, a, b);
            }
            else {
                if (find_parent(parent, a) == find_parent(parent, b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }

        }

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

