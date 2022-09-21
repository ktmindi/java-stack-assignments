package javaFundamentals.puzzling;

import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomTen = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 1; i <=10; i++) {
            randomTen.add(rand.nextInt(20) + 1);
        }
        return randomTen;
    }


    public String getRandomLetter() {
        Random rand = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char randomChar = alphabet.charAt(rand.nextInt(26));

        return String.valueOf(randomChar);
    }

    public String generatePassword() {
        String password = "";
        for(int i = 0; i <8; i++) {
            password = password + getRandomLetter();
        }
        return password;
    }


    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<String>();
        for(int i = 0; i < length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }
}
