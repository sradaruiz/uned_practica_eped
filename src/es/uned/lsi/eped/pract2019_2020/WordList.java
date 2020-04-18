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
            int wordListNPosition = getPosition(wordList, wordLength);

            if (wordListNPosition > wordList.size()) {
                WordListN newWordListN = new WordListN(wordLength);
                newWordListN.add(word);
                wordList.insert(wordList.size() + 1, newWordListN);
            } else if (wordList.get(wordListNPosition).getWordSize() == wordLength) {
                wordList.get(wordListNPosition).add(word);
            } else {
                moveElements(wordListNPosition, wordList.size() - 1);
                WordListN newWordListN = new WordListN(wordLength);
                newWordListN.add(word);
                wordList.set(wordListNPosition, newWordListN);
            }
        }
    }

    private void moveElements(int index, int current) {
        if (current >= index) {
            wordList.insert(current + 1, wordList.get(current));
            moveElements(index, current - 1);
        }
    }

    private int getPosition(ListIF<WordListN> wordList, int wordLength) {
        int wordListNPosition = 1;
        for (int pos = 1; pos <= wordList.size(); pos++) {
            if (wordLength <= wordList.get(pos).getWordSize()) {
                return pos;
            }
            wordListNPosition++;
        }
        return wordListNPosition;
    }

    public String toString() {
        StringBuilder salida = new StringBuilder();
        for (int pos = 1; pos <= this.wordList.size(); pos++) {
            salida.append(this.wordList.get(pos).toString());
        }
        return salida.toString();
    }
}
