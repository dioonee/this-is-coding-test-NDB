import java.util.Arrays;
import java.util.Scanner;

public class FindParts {
    public static void main(String[] args) {
        int storeNum;
        Scanner sc = new Scanner(System.in);
        storeNum = sc.nextInt();
        sc.nextLine();
        String storeList = sc.nextLine();
        String[] storeArray = storeList.split(" ");
        int requestNum;
        requestNum = sc.nextInt();
        sc.nextLine();
        String requestList = sc.nextLine();
        String[] requestArray = requestList.split(" ");

        for (String s : requestArray) {
            if (Arrays.stream(storeArray).anyMatch(s::equals)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }

    }
}
