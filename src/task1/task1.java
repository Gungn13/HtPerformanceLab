package task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(circleArray(m, n));

        sc.close();
    }


    public static int circleArray(int n, int m) {

        int response = 0;
        int[] nums = new int[n];
        int curIndex = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        while (true) {
            response = (response * 10) + nums[curIndex];
            curIndex = (curIndex + m - 1) % nums.length;

            if (curIndex == 0) {
                break;
            }

        }
        return response;
    }
}
