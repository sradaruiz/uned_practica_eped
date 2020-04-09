package es.uned.lsi.eped.pract2019_2020;

public class LetterNode extends Node {
    private char letter;
    private LetterNode nextLetter;

    @Override
    public NodeType getNodeType() {
        return NodeType.LETTERNODE;
    }

    public char getLetter() {
        return letter;
    }

    public void addNewLetter(){

    }
}
