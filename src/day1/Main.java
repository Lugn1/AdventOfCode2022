package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static List<Integer> elvesCalories = new ArrayList<>();

    public static void main(String[] args) {

        getMaxElfCalorie(elvesCalories);
        System.out.println(Collections.max(elvesCalories));
        System.out.println(getTopThree());

    }

    private static int getTopThree() {
        int temp = 0;
        elvesCalories.sort(Comparator.reverseOrder());
        for (int i = 0; i < 3; i++) {
            temp = elvesCalories.get(i) + temp;

        }
        return temp;
    }

    private static void getMaxElfCalorie(List<Integer> elvesCalories) {
        int temp = 0;

        try {
            List<String> allLines = Files.readAllLines(Path.of("src/day1/day1Data.txt"));

            for (String line : allLines) {
                if (!line.equals("")) {
                    temp = Integer.parseInt(line) + temp;
                } else {
                    elvesCalories.add(temp);
                    temp = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// A, X: Rock - 1p
// B, Y: Paper - 2p
// C, Z: Scissors - 3p
// Win: 6p, Draw: 3p

// X = LOOSE
// Y = DRAW
// Z = WIN