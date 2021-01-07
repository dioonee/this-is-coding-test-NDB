import java.util.*;

public class TopToBottom {
    public static void main(String[] args) {
        int dataNum;
        Scanner sc = new Scanner(System.in);
        dataNum = sc.nextInt();

        List<Integer> dataList = new ArrayList<>();
        for (int i = 0; i<dataNum; i++) {
            int num = sc.nextInt();
            dataList.add(num);
        }

        dataList.sort(Collections.reverseOrder());

        for (int data : dataList) {
            System.out.print(data + " ");
        }

    }


}
