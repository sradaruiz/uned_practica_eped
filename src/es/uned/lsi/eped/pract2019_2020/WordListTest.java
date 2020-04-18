package es.uned.lsi.eped.pract2019_2020;

public class WordListTest {
    public static void main(String[] args) {
        System.out.println("Pruebas sobre las WordList \n");
    }
}

class WordListNTest {
    public static void main(String[] args) {
        System.out.println("Pruebas sobre las WordListN\n");
        WordListN list = new WordListN(4);
        list.add("baca");
        list.add("casa");
        list.add("alta");
        list.add("zapa");
        list.add("cama");
        list.add("dami");
        list.add("alta");
        list.add("al");

        System.out.println(list.toString());
    }
}
