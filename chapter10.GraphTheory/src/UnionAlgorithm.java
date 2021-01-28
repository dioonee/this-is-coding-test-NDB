import java.util.Scanner;

public class UnionAlgorithm {
    public static void main(String[] args) {
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        sc.nextLine();

        int[] parent = new int[v+1];
        for (int i = 1; i<v+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i< e; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            union_parent(parent, a, b);
            sc.nextLine();
        }

        System.out.print("각 원소가 속한 집합 : ");
        for (int i = 1; i< v+1; i++) {
            System.out.print(find_parent(parent, i) + " ");
        }
        System.out.println();
        System.out.print("부모 테이블 : ");
        for (int i = 1; i< v+1; i++) {
            System.out.print(parent[i] + " ");
        }


    }

    static int find_parent(int[] parent, int x) {
        if (parent[x] != x) {                           //자기 자신이 루트 노드가 아니라면,
            parent[x] = find_parent(parent, parent[x]);      //루트 노드 찾을 때까지 재귀 호출
        }
        return parent[x];                               //그냥 x 를 return -> 바로 위 부모노드만 저장
                                            //parent[x]를 return 하면 루트노드를 부모노드로 저장 가능
    }

    static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);
        if (a < b) { parent[b] = a; }
        else { parent[a] = b; }
    }

}
