package task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class task2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String pathCircle = sc.nextLine();
        String pathCoordPoint = sc.nextLine();

        sc.close();

        List<String> circleData = Files.readAllLines(Paths.get(pathCircle));
        String[] centerCoordinates = circleData.get(0).split(" ");

        double centerX = Double.parseDouble(centerCoordinates[0]);
        double centerY = Double.parseDouble(centerCoordinates[1]);
        double radius = Double.parseDouble(circleData.get(1));

        List<String> pointsData = Files.readAllLines(Paths.get(pathCoordPoint));
        List<Integer> results = new ArrayList<>();

        for (String point : pointsData) {
            String[] pointCoordinates = point.split(" ");

            double pointX = Double.parseDouble(pointCoordinates[0]);
            double pointY = Double.parseDouble(pointCoordinates[1]);
            int result = getPointPosition(centerX, centerY, radius, pointX, pointY);
            results.add(result);
        }

        for (int result : results) {
            System.out.println(result);
        }

    }

    public static int getPointPosition(double centerX, double centerY, double radius, double pointX, double pointY) {

        double distanceSquared = Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2);
        double radiusSquared = Math.pow(radius, 2);

        if (distanceSquared < radiusSquared) {
            return 1;
        } else if (distanceSquared == radiusSquared) {
            return 0;
        } else {
            return 2;
        }

    }


}
