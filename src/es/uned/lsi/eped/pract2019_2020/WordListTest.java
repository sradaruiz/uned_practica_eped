package es.uned.lsi.eped.pract2019_2020;

public class WordListTest {
    public static void main(String[] args) {
        WordList wordList = new WordList();

        wordList.add("ey");
        wordList.add("adios");
        wordList.add("hola");
        wordList.add("okey");

        System.out.println(wordList.toString());
    }
}
