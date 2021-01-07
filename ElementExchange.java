import java.util.*;

public class ElementExchange {
    public static void main(String[] args) {
        int length;
        int exchangeNum;
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        exchangeNum = sc.nextInt();
        //add
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int j = 0; j<length; j++) {
            listA.add(sc.nextInt());
        }
        for (int j = 0; j<length; j++) {
            listB.add(sc.nextInt());
        }
        //sort
        Collections.sort(listA);
        Collections.sort(listB, Collections.reverseOrder());
        //exchange
        for (int i = 0; i<exchangeNum; i++) {
            if (listA.get(i) < listB.get(i)) {
                int temp = listA.get(i);
                listA.set(i, listB.get(i));
                listB.set(i, temp);
            }
        }
        //print
        int sum = 0;
        for (int num : listA) {
            sum += num;
        }
        System.out.println(sum);
    }
}
