package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordListTest {
    public static void main(String[] args) {
        System.out.println("Pruebas sobre las WordList \n");

        WordList wordList = new WordList();
        wordList.add("a");
        wordList.add("c");
        wordList.add("o");

        wordList.add("as");
        wordList.add("ca");
        wordList.add("oc");
        wordList.add("os");
        wordList.add("so");

        wordList.add("aca");
        wordList.add("asa");
        wordList.add("cao");
        wordList.add("cas");
        wordList.add("coa");
        wordList.add("oca");
        wordList.add("osa");
        wordList.add("oso");
        wordList.add("sao");
        wordList.add("sos");

        wordList.add("asca");
        wordList.add("asco");
        wordList.add("caca");
        wordList.add("caco");
        wordList.add("caos");
        wordList.add("casa");
        wordList.add("caso");
        wordList.add("coca");
        wordList.add("coco");
        wordList.add("cosa");
        wordList.add("coso");
        wordList.add("osco");
        wordList.add("saca");
        wordList.add("saco");
        wordList.add("soca");
        wordList.add("sosa");
        wordList.add("soso");

        wordList.add("acaso");
        wordList.add("acoso");
        wordList.add("cacao");
        wordList.add("casca");
        wordList.add("casco");
        wordList.add("ocaso");
        wordList.add("ososo");

        wordList.add("ascoso");
        wordList.add("casaca");
        wordList.add("cascas");
        wordList.add("cocoso");
        wordList.add("cosaco");
        wordList.add("coscas");

        System.out.println(wordList.toString());
    }
}

class WordListNTest {
    public static void main(String[] args) {
        System.out.println("Pruebas sobre las WordListN\n");
        WordListN wordListN = new WordListN(4);
        wordListN.add("a");
        wordListN.add("c");
        wordListN.add("o");

        wordListN.add("as");
        wordListN.add("ca");
        wordListN.add("oc");
        wordListN.add("os");
        wordListN.add("so");

        wordListN.add("aca");
        wordListN.add("asa");
        wordListN.add("cao");
        wordListN.add("cas");
        wordListN.add("coa");
        wordListN.add("oca");
        wordListN.add("osa");
        wordListN.add("oso");
        wordListN.add("sao");
        wordListN.add("sos");

        wordListN.add("asca");
        wordListN.add("asco");
        wordListN.add("caca");
        wordListN.add("caco");
        wordListN.add("caos");
        wordListN.add("casa");
        wordListN.add("caso");
        wordListN.add("coca");
        wordListN.add("coco");
        wordListN.add("cosa");
        wordListN.add("coso");
        wordListN.add("osco");
        wordListN.add("saca");
        wordListN.add("saco");
        wordListN.add("soca");
        wordListN.add("sosa");
        wordListN.add("soso");

        wordListN.add("acaso");
        wordListN.add("acoso");
        wordListN.add("cacao");
        wordListN.add("casca");
        wordListN.add("casco");
        wordListN.add("ocaso");
        wordListN.add("ososo");

        wordListN.add("ascoso");
        wordListN.add("casaca");
        wordListN.add("cascas");
        wordListN.add("cocoso");
        wordListN.add("cosaco");
        wordListN.add("coscas");

        System.out.println(wordListN.toString());
    }
}