package readability;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        AutomatedReadabilityIndex automatedReadabilityIndex = new AutomatedReadabilityIndex();
        FleschKincaid fleschKincaid = new FleschKincaid();
        MeasureGobbledygook measureGobbledygook = new MeasureGobbledygook();
        Coleman coleman = new Coleman();
        boolean b = true;
        int word = 1; //слова
        int characters = 0; //символи, кроме пробелов
        int sentences = 0; //предложения
        int syllables = 0; // слогов
        int polysyllables = 0;
        String a = null;
     //   String pathToFile = "C:\\dataset_91069.txt";     //удаляем строку
        File file = new File(args[0]);               //args[0]
        try (Scanner scanner = new Scanner(file)) {
            while (b == true) {
                a = scanner.nextLine();

                String temp = "[.!?]";

                String tempArr[] = a.replaceFirst("[1-9]", "").split(temp);
                sentences = tempArr.length;

                char[] chArr = a.toCharArray();

                for (int i = 0; i < chArr.length; i++) {
                    if (chArr[i] == ' ') word += 1;
                    if (chArr[i] != ' ') characters += 1;
                }
            }
        } catch (Exception e) {
            b = false;
        }

        int[] arrSyllables1 = Main.countSyllables(a);

        syllables = arrSyllables1[0];
        polysyllables = arrSyllables1[1];

        System.out.println("Words: " + word);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner sc = new Scanner(System.in);
        String switcH = sc.next();
        switch (switcH) {
            case "ARI":
                automatedReadabilityIndex.automatedReadabilityIndex(characters, word, sentences);break;
            case "FK":
                fleschKincaid.fleschKincaid(word, sentences, syllables);break;
            case "SMOG":
                measureGobbledygook.measureGobbledygook(polysyllables, sentences);break;
            case "CL":
                coleman.coleman(characters, sentences, word);break;
            case "all":  automatedReadabilityIndex.automatedReadabilityIndex(characters, word, sentences);
                fleschKincaid.fleschKincaid(word, sentences, syllables);
                measureGobbledygook.measureGobbledygook(polysyllables, sentences);
                coleman.coleman(characters, sentences, word);break;
        }



    }


    private static int[] countSyllables(String a) {
        int count = 1; //было 0
        int polyCount = 0; //было 0
        for (String word : a.split("\\W+")) {
            // System.out.println(word);
            int wordSyllables = countWordSyllables(word);
            if (wordSyllables > 2) polyCount += 1;
            //System.out.printf("%20s: %d%n", word, wordSyllables);
            count += wordSyllables;
        }
        int[] arrSyllables = new int[]{count, polyCount};

        return arrSyllables;
    }

    private static int countWordSyllables(String a) {
        if (!a.matches("[A-Za-z]+"))
            return 0;

        Pattern vowelsPattern = Pattern.compile("[aieouy]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = vowelsPattern.matcher(a.replaceFirst("e$", ""));
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return Math.max(count, 1);
    }


}