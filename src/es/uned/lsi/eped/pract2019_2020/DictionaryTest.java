package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;

public class DictionaryTest {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.insert("sara");
        dictionary.insert("sapo");
        dictionary.insert("mapa");
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
