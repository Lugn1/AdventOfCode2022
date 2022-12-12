package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainDay3 {

    static List<String> rucksacks = new ArrayList<>();
    public static void main(String[] args) {

        rucksacksToList();
        partOne();
        partTwo();

    }
    private static void partOne() {
        int prioritySum = 0;

            for (String result : rucksacks) {
                String firstCompartment = getFirstCompartment(result);
                String secondCompartment = getSecondCompartment(result);

                int add = findTheCommonCharacter(firstCompartment, secondCompartment).stream()
                        .mapToInt(MainDay3::convertToPriority).sum();

                prioritySum += add;

            }

            System.out.println("The sum of the priorities are: " + prioritySum);
        }


    private static void rucksacksToList() {

        try{
            List<String> allLines = Files.readAllLines(Path.of("src/day3/day3Data.txt"));
            rucksacks.addAll(allLines);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String getFirstCompartment(String firstHalf) {
        return firstHalf.substring(0, firstHalf.length()/2);
    }

    private static String getSecondCompartment(String secondHalf) {
        return secondHalf.substring(secondHalf.length()/2);
    }

    private static HashSet<Character> findTheCommonCharacter(String firstCompartment, String secondCompartment){

        HashSet<Character> firstHashSet = new HashSet<>();
        HashSet<Character> secondHashSet = new HashSet<>();

        for (int i = 0; i < firstCompartment.length(); i++) {
            firstHashSet.add(firstCompartment.charAt(i));
        }
        for (int i = 0; i < secondCompartment.length(); i++){
            secondHashSet.add(secondCompartment.charAt(i));
        }
        firstHashSet.retainAll(secondHashSet);

        return firstHashSet;
    }



    private static int convertToPriority(Character character) {
        if (Character.isUpperCase(character))
            return (int) character - (int) 'A' + 27;
        else
            return (int) character - (int) 'a' + 1;

    }


    private static void partTwo(){

        String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int prioritySum = 0;

        for(int i = 0; i < rucksacks.size(); i = i + 3) {

            String first = rucksacks.get(i);
            String second = rucksacks.get(i + 1);
            String third = rucksacks.get(i + 2);

            int counter = 0;
            for(int j = 0; j < first.length(); j++)
                for(int k = 0; k < second.length(); k++)
                    for(int o = 0; o < third.length(); o++)
                        if(first.charAt(j) == second.charAt(k) && first.charAt(j) == third.charAt(o)) {
                            counter++;
                            if(counter == 1)
                                prioritySum = prioritySum + alphabet.indexOf(first.charAt(j));
            }
        }
        System.out.println("The sum of the badge priority is: " + prioritySum);
    }
}