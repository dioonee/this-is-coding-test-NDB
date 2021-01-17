import java.util.Arrays;
import java.util.Scanner;

public class MakeDduk {
    public static void main(String[] args) {
        int number, length;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        length = sc.nextInt();
        sc.nextLine();
        int[] dduks;
        String line = sc.nextLine();
        dduks = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int height = 0, sum = 0, start = 0;
        int end = Arrays.stream(dduks).max().getAsInt() -1;
        while( start <= end) {
            height = (start + end) / 2;
            sum = getLength(height, dduks);
            if (sum < length) { end = height - 1; }
            else {
                start = height + 1;
            }
        }
        System.out.println(height);
    }

    public static int getLength(int height, int[] dduk) {
        int result = 0;
        for (int one : dduk) {
            if (one > height) {
                result += (one - height);
            }
        }
        return result;
    }
}
