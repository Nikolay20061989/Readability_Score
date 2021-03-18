package readability;

import java.text.DecimalFormat;

public class AutomatedReadabilityIndex {
    void automatedReadabilityIndex(int characters, int word,int sentences){
        double score = 4.71 * (double) characters / word + 0.5 * (double) word / sentences - 21.43;
        double sc = (double) characters / word;
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.print("Automated Readability Index: " + df.format(score)+" ");
        DecimalFormat dfa = new DecimalFormat("##");

        int zzz = (int) Math.round(score);
        if(zzz<score)zzz+=1;
        switch (zzz) {
            case 1:
                System.out.println("This text should be understood by 5-6-year-olds.");
                break;
            case 2:
                System.out.println("(about 7-year-olds).");
                break;
            case 3:
                System.out.println("(about 8-year-olds).");
                break;
            case 4:
                System.out.println("(about 9-year-olds).");
                break;
            case 5:
                System.out.println("(about 10-year-olds).");
                break;
            case 6:
                System.out.println("(about 11-year-olds).");
                break;
            case 7:
                System.out.println("(about 12-year-olds).");
                break;
            case 8:
                System.out.println("(about 13-year-olds).");
                break;
            case 9:
                System.out.println("(about 14-year-olds).");
                break;
            case 10:
                System.out.println("(about 15-year-olds).");
                break;
            case 11:
                System.out.println("(about 16-year-olds).");
                break;
            case 12:
                System.out.println("(about 17-year-olds).");
                break;
            case 13:
                System.out.println("(about 18-24-year-olds).");
                break;
            case 14:
                System.out.println("(about 24+-year-olds).");
                break;
        }
    }
}
