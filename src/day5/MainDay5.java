package day5;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MainDay5 {
    public static void main(String[] args) throws Exception {

        List<String> input = Files.readAllLines(Path.of("src/day5/day5Data.txt"));

        List<List<Character>> stacks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            stacks.add(new ArrayList<>());
        }
        List<String> stacksInput = input.subList(0,8);

        for (String s : stacksInput){
            int index = 0;
            int stringIndex = 0;
            while (stringIndex < s.length()) {

                if (s.charAt(stringIndex) != ' ')
                        stacks.get(index).add(0, s.charAt(stringIndex + 1));

                index++;
                stringIndex += 4;
            }
        }

        List<List<Character>> partTwoList = new ArrayList<>();

        for (int i = 0; i < 9; i++)
            partTwoList.add(new ArrayList<>(stacks.get(i)));


        List<String> instructionsInput = input.subList(10, input.size());

        for (String i : instructionsInput) {

            String[] instructionPart = i.split(" ");

            // Part 1
            int numberOfCrates = Integer.parseInt(instructionPart[1]);
            int from = Integer.parseInt(instructionPart[3]) - 1;
            int to = Integer.parseInt(instructionPart[5]) - 1;

            List<Character> fromStack = stacks.get(from);
            List<Character> toStack = stacks.get(to);
            List<Character> movingStack = new ArrayList<>();

            for (int j = 0; j < numberOfCrates; j++)
                movingStack.add(fromStack.remove(fromStack.size() - 1));
            toStack.addAll(movingStack);

          // Part 2

            fromStack = partTwoList.get(from);
            toStack = partTwoList.get(to);
            movingStack = new ArrayList<>();

            for (int j = 0; j < numberOfCrates; j++)
                movingStack.add(0, fromStack.remove(fromStack.size() - 1));
            toStack.addAll(movingStack);

        }

        // Part 1
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Character> stack : stacks) {
            stringBuilder.append(stack.get(stack.size() - 1));
        }
        // Part 2
        stringBuilder = new StringBuilder();
        for (List<Character> stack : partTwoList)
            stringBuilder.append(stack.get(stack.size() - 1));


        System.out.println(stringBuilder);

    }
}
