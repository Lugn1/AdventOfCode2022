package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MainDay4 {
    public static void main(String[] args){

        File file = new File("src/day4/day4data.txt");

        Scanner scanner;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        scanner.useDelimiter("[,\n\\-]");


        int overlapCount = 0;


        while (scanner.hasNext()) {
            int firstPairStart = Integer.parseInt(scanner.next());
            int firstPairEnd = Integer.parseInt(scanner.next().trim());
            int secondPairStart = Integer.parseInt(scanner.next());
            int secondPairEnd = Integer.parseInt(scanner.next().trim());

            /* Part 1

             if (firstPairStart <= secondPairStart && firstPairEnd >= secondPairEnd) {
                // First pair fully contains second pair
                overlapCount++;
            } else if (firstPairStart >= secondPairStart && firstPairEnd <= secondPairEnd) {
                // Second pair fully contains first pair
                overlapCount++;
            }
             System.out.println(overlapCount);
             */


        // Part 2
            if (firstPairStart <= secondPairStart && firstPairEnd >= secondPairStart) {
                // First pair overlaps second pair
                overlapCount++;
            } else if (secondPairStart <= firstPairEnd && secondPairEnd >= firstPairStart) {
                // Second pair overlaps first pair
                overlapCount++;
            }
        }
        System.out.println(overlapCount);
    }
}
