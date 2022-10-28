package com.casra;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawText = scanner.nextLine();

/** Hardcode Test Input  */
        rawText = "i11s;e6x1t1ra 2a1 n5u2mbe3r1.se3cr4et,w5o5rd6s; 1r3eo5rd2er4;88b3y;1n4u78mb2er3 f2r1o9m.1w3o5rd4s, Th1is, 1a4n9d; Remo9ve- w3o6r6ds6 +v1er12y ,t2h25e1i9r2,t3ex5t" ;
        //out put:  This is a very secret text Remove number from words and reorder words by their number
/** End of test Part */
        rawText = rawText.replaceAll("([^a-zA-Z_0-9])", " "); // Replace all splitter with " "

        String[] rawSentence = rawText.split(" ");
        ArrayList<WordExtractor> wo = new ArrayList<WordExtractor>();

        for (int n=0; n< rawSentence.length; n++) {
            int p = 0;
            char c;
            for (int i = 0; i < rawSentence[n].length(); i++) {
                c = rawSentence[n].charAt(i);
                if (Character.isDigit(c)) {
                    int v = Character.getNumericValue(c);
                    p += v;
                }
            }
            WordExtractor word = new WordExtractor(rawSentence[n].replaceAll("([^a-zA-Z])",""),p);

            System.out.println(n + ". rawWord : " + rawSentence[n] + "   word: " + word + "   wordOrder: " + p);
            wo.add(word);
        }

        wo.sort((a,b) -> {                          //Sorting words
            if (a.order > b.order) return 1;
            if (a.order < b.order) return -1;
            if (a.order == b.order) {
                b.word = "";
            }
            return 0;
        });

        StringBuilder builder = new StringBuilder();
        wo.forEach(w -> builder.append(w.word + (w.word.isEmpty() ? "" : " ")));

        System.out.println("final sentence -> " + builder);
        };
    }

 class  WordExtractor {
    String word;
    Integer order;

    public void setWord(String word) {
        this.word = word;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
    public WordExtractor(String word,
                         Integer order) {
       this.word = word;
       this.order = order;

    }
    @Override
    public String toString() {
        return  word;
    }
}


