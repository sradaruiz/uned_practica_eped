package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.ListIF;

public class DictionaryTest {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.insert("sara");
        dictionary.insert("sapo");
        dictionary.insert("mapa");
        dictionary.insert("pam");
        dictionary.insert("ma");
        dictionary.insert("a");
        dictionary.insert("pama");
        WordList wordList = dictionary.search("ampa");
        WordListN wordListN = dictionary.search("ampa", 4);
        System.out.println(wordList.toString());
        System.out.println("----------------------------------------------------------");
        System.out.println(wordListN.toString());
    }
}

class GTreeTest {
    public static void main(String[] args) {
        GTree<Node> dict = new GTree<Node>();
        dict.setRoot(new RootNode());

        System.out.println(dict.isEmpty());
        GTree<Node> letterNode = new GTree<>();
        letterNode.setRoot(new LetterNode('a'));

        GTree<Node> otherLetterNode = new GTree<>();
        otherLetterNode.setRoot(new LetterNode('b'));

        dict.addChild(1, letterNode);
        dict.addChild(1, otherLetterNode);
        GTreeIF<Node> child = dict.getChild(2);

        GTree<Node> containsNode = new GTree<>();
        containsNode.setRoot(new LetterNode('b'));
        System.out.println(dict.getChildren().contains(containsNode));
    }
}
