package com.github.affandes.kuliah.st;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {

    public List<WordInfo> wordCount = new ArrayList<>();

    public void wordCount(String text) {
        wordCount.clear();
        if (text == null || text.trim().isEmpty()) {
            return;
        }
        String[] words = text.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            System.out.println("Processing word: " + word);
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println("Adding WordInfo: " + entry.getKey() + " with count " + entry.getValue());
            wordCount.add(new WordInfo(entry.getKey(), entry.getValue()));
        }
    }
//    public void addWord(String word) {
//        if (wordCount.isEmpty()) {
//            wordCount.add(new WordInfo(word, 1));
//        } else {
//            WordInfo found = wordCount.stream().filter(w -> w.word.equals(word)).findFirst().orElse(null);
//            if (found == null) {
//                wordCount.add(new WordInfo(word, 1));
//            } else {
//                found.word += 1;
//            }
//        }
//    }

}
