package day6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainDay6 {
    public static void main(String[] args) throws IOException {


        String input = Files.readAllLines(Path.of("src/day6/day6Data.txt")).toString();

        input = input.replaceAll("\\p{P}","");

        // Part 1
        System.out.println("Part one: " + firstMarker(input, 4));
        // Part 2
        System.out.println("Part two: " + firstMarker(input, 14));


    }

    private static int firstMarker(String input, int markerLength) {

        for (int i = 0; i < input.chars().count(); i++) {
            if (input.substring(i, i + markerLength).chars().distinct().count() == markerLength){
                return markerLength + i;
            }

        }

        return -1;
    }

}