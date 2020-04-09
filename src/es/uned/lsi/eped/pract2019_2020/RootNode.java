package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.List;

public class RootNode extends Node {
    private List<WordNode> wordNodes;

    public RootNode() {
        this.wordNodes = new List<WordNode>();
    }

    public void addWordNode(WordNode elem) {
        this.wordNodes.insert(this.wordNodes.size() + 1, elem);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.ROOTNODE;
    }
}
