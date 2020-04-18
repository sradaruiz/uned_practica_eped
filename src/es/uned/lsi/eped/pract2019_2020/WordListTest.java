package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordListTest {
    public static void main(String[] args) {
        System.out.println("Pruebas sobre las WordList \n");

        WordList wordList = new WordList();
        wordList.add("casa");
        wordList.add("mano");
        wordList.add("cabaña");
        wordList.add("al");

        System.out.println(wordList.toString());
    }
}

class WordListNTest {
    public static void main(String[] args) {
        System.out.println("Pruebas sobre las WordListN\n");
        WordListN wordListN = new WordListN(4);
        wordListN.add("baca");
        wordListN.add("casa");
        wordListN.add("alta");
        wordListN.add("zapa");
        wordListN.add("cama");
        wordListN.add("dami");
        wordListN.add("alta");
        wordListN.add("al");

        System.out.println(wordListN.toString());
    }
}