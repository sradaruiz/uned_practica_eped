package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;

public class LetterNode extends Node {
    private final char letter;
    private List<Node> nextNodes;

    public LetterNode(char character) {
        letter = character;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.LETTERNODE;
    }
}
