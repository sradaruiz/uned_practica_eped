package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.ListIF;

public class DictionaryTest {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.insert("a");
        dictionary.insert("c");
        dictionary.insert("o");

        dictionary.insert("as");
        dictionary.insert("ca");
        dictionary.insert("oc");
        dictionary.insert("os");
        dictionary.insert("so");

        dictionary.insert("aca");
        dictionary.insert("asa");
        dictionary.insert("cao");
        dictionary.insert("cas");
        dictionary.insert("coa");
        dictionary.insert("oca");
        dictionary.insert("osa");
        dictionary.insert("oso");
        dictionary.insert("sao");
        dictionary.insert("sos");

        dictionary.insert("asca");
        dictionary.insert("asco");
        dictionary.insert("caca");
        dictionary.insert("caco");
        dictionary.insert("caos");
        dictionary.insert("casa");
        dictionary.insert("caso");
        dictionary.insert("coca");
        dictionary.insert("coco");
        dictionary.insert("cosa");
        dictionary.insert("coso");
        dictionary.insert("osco");
        dictionary.insert("saca");
        dictionary.insert("saco");
        dictionary.insert("soca");
        dictionary.insert("sosa");
        dictionary.insert("soso");

        dictionary.insert("acaso");
        dictionary.insert("acoso");
        dictionary.insert("cacao");
        dictionary.insert("casca");
        dictionary.insert("casco");
        dictionary.insert("ocaso");
        dictionary.insert("ososo");

        dictionary.insert("ascoso");
        dictionary.insert("casaca");
        dictionary.insert("cascas");
        dictionary.insert("cocoso");
        dictionary.insert("cosaco");
        dictionary.insert("coscas");
        WordList wordList = dictionary.search("aosc");
        System.out.println(wordList.toString());
        System.out.println("----------------------------------------------------------");
        WordListN wordListN = dictionary.search("aosc", 5);
        System.out.println(wordListN.toString());
        System.out.println("----------------------------------------------------------");
        WordListN wordListN7 = dictionary.search("aosc", 7);
        System.out.println(wordListN7.toString());
    }
}