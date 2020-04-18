package es.uned.lsi.eped.pract2019_2020;

public class WordListTest {
    public static void main(String[] args) {
        System.out.println("Pruebas sobre las WordList \n");
        WordList wordList = new WordList();
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
