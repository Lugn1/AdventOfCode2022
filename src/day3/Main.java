package day3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {


        String firstCompartment = getFirstCompartment("vJrwpWtwJgWrhcsFMMfFFhFp");
        String secondCompartment = getSecondCompartment("vJrwpWtwJgWrhcsFMMfFFhFp");

        System.out.println(firstCompartment);
        System.out.println(secondCompartment);


        System.out.println(findTheCommonCharacter("abcd", "aWER"));

        String test = new String(findTheCommonCharacter("abcd", "awer"));
        System.out.println(test);






        if (test.equals("[a]"))
            System.out.println("FUNGERAR");


    }

    private static String getFirstCompartment(String firstHalf) {


        return firstHalf.substring(0, firstHalf.length()/2);
    }

    private static String getSecondCompartment(String secondHalf) {

        return secondHalf.substring(secondHalf.length()/2);
    }


    private static String findTheCommonCharacter(String firstCompartment, String secondCompartment){

        HashSet<Character> firstHashSet = new HashSet<>();
        HashSet<Character> secondHashSet = new HashSet<>();

        for (int i = 0; i < firstCompartment.length(); i++) {
            firstHashSet.add(firstCompartment.charAt(i));
        }
        for (int i = 0; i < secondCompartment.length(); i++){
            secondHashSet.add(secondCompartment.charAt(i));
        }

        firstHashSet.retainAll(secondHashSet);
        Character[] res = firstHashSet.toArray(new Character[0]);
        return String.valueOf(res);
    }
}