package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MainDay2 {

    static List<String> guideList = new ArrayList<>();

    public static void main(String[] args) {

        int rock = 1;
        int paper = 2;
        int scissor = 3;
        int win = 6;
        int draw = 3;
        int totalPoints = 0;
        int partTwoTotalPoints = 0;

        addOptionsToArrayList();

        // Part one
        for (String result : guideList){
            switch (result) {
                case "A X" -> totalPoints += (rock + draw);
                case "A Y" -> totalPoints += (paper + win);
                case "A Z" -> totalPoints += scissor;
                case "B X" -> totalPoints += rock;
                case "B Y" -> totalPoints += (paper + draw);
                case "B Z" -> totalPoints += (scissor + win);
                case "C X" -> totalPoints += (rock + win);
                case "C Y" -> totalPoints += paper;
                case "C Z" -> totalPoints += (scissor + draw);
            }
    }
        System.out.println("My first total score would be: " + totalPoints);

        // Part two
        for (String result : guideList){
            switch (result) {
                case "A X" -> partTwoTotalPoints += scissor;
                case "A Y" -> partTwoTotalPoints += (rock + draw);
                case "A Z" -> partTwoTotalPoints += (paper + win);
                case "B X" -> partTwoTotalPoints += rock;
                case "B Y" -> partTwoTotalPoints += (paper + draw);
                case "B Z" -> partTwoTotalPoints += (scissor + win);
                case "C X" -> partTwoTotalPoints += paper;
                case "C Y" -> partTwoTotalPoints += (scissor + draw);
                case "C Z" -> partTwoTotalPoints += (rock + win);
            }
        }

        System.out.println("My second total score would be: " + partTwoTotalPoints);
    }


    private static void addOptionsToArrayList() {

        try{
            List<String> allLines = Files.readAllLines(Path.of("src/day2/day2Data.txt"));
            guideList.addAll(allLines);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
