package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordList {
    private ListIF<WordListN> wordList;
    // TODO: la inserción tiene que ser ordenada

    public WordList() {
        this.wordList = new List<WordListN>();
    }

    public void add(String word) {
        int wordLength = word.length();
        if (wordList.isEmpty()) {
            WordListN firstWordListN = new WordListN(wordLength);
            firstWordListN.add(word);
            wordList.insert(1, firstWordListN);
        } else {
            int wordListNPosition = 0;
            for (int pos = 1; pos <= wordList.size(); pos++) {
                if (wordLength == wordList.get(pos).getWordSize()) {
                    wordListNPosition = pos;
                }
            }
            if (wordListNPosition == 0) {
                WordListN newWordListN = new WordListN(wordLength);
                newWordListN.add(word);
                wordList.insert(wordList.size() + 1, newWordListN);
            } else {
                WordListN wordListN = wordList.get(wordListNPosition);
                wordListN.add(word);
                wordList.set(wordListNPosition, wordListN);
            }
        }
    }

    public String toString() {
        StringBuilder salida = new StringBuilder();
        for (int pos = 1; pos <= this.wordList.size(); pos++) {
            salida.append(this.wordList.get(pos).toString());
        }
        return salida.toString();
    }
}
