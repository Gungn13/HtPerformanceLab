package task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String pathNumsArray = sc.nextLine();

        sc.close();

        List<String> results = Files.readAllLines(Paths.get(pathNumsArray));

        int[] nums = results.stream().mapToInt(i -> Integer.parseInt(i)).toArray();

        int minMoves = minStepsToEqualArray(nums);
        System.out.println(minMoves);
    }

    public static int minStepsToEqualArray(int[] nums){
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
