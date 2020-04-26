package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

import javax.management.NotificationEmitter;

public class Dictionary {

    private GTree<Node> dict; /* El diccionario es un árbol general de nodos */

    /* Constructor de la clase */
    public Dictionary() {
        dict = new GTree<Node>();
        dict.setRoot(new RootNode());
    }

    /* Método de inserción de una nueva palabra en el diccionario */
    public void insert(String word) {
        /* Insertamos la palabra a partir del nodo raíz del árbol */
        insertInTree(word, this.dict);

    }

    /* Método privado llamado por el anterior */
    private void insertInTree(String word, GTreeIF<Node> node) {
        if (dict.isEmpty()) {
            dict = new GTree<Node>();
            dict.setRoot(new RootNode());
        }
        if (word.length() != 0) {
            char letter = word.charAt(0);
            word = word.substring(1);

            GTreeIF<Node> newNode = new GTree<>();
            newNode.setRoot(new LetterNode(letter));
            int position = getChildPosition(node.getChildren(), newNode);
            if (position == -1) {
                node.addChild(1, newNode);
                insertInTree(word, newNode);
            } else {
                GTreeIF<Node> retrievedNode = node.getChild(position);
                insertInTree(word, retrievedNode);
            }
        } else {
            GTreeIF<Node> finalNode = new GTree<>();
            finalNode.setRoot(new WordNode());
            node.addChild(1, finalNode);
        }
    }

    private int getChildPosition(ListIF<GTreeIF<Node>> children, GTreeIF<Node> child) {
        if (child.getRoot().getNodeType() == Node.NodeType.LETTERNODE) {
            for (int i = 1; i <= children.size(); i++) {
                GTreeIF<Node> retrievedChildren = children.get(i);
                if (retrievedChildren.getRoot().getNodeType() == Node.NodeType.LETTERNODE) {
                    LetterNode retrievedLetter = (LetterNode) retrievedChildren.getRoot();
                    LetterNode childLetter = (LetterNode) child.getRoot();
                    if (retrievedLetter.getLetter() == childLetter.getLetter()) {
                        return i;
                    }
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    /* Método público de búsqueda de todas las palabras a partir de una secuencia */
    public WordList search(String sequence) {
        WordList salida = new WordList();           /* Variable donde construiremos la salida */
        searchInTree(sequence, "", this.dict, salida); /* Construimos la salida recursivamente */
        return salida;
    }

    /* Método privado llamado por el anterior */
//    private void searchInTree(String sequence, String word, GTreeIF<Node> node, WordList salida) {
//        if (node.getRoot().getNodeType() != Node.NodeType.WORDNODE) {
//            char letter = sequence.charAt(0);
//
//            ListIF<GTreeIF<Node>> children = node.getChildren();
//            for (int i = 1; i <= node.getNumChildren(); i++) {
//                GTreeIF<Node> newNode = children.get(i);
//                if (newNode.getRoot().getNodeType() == Node.NodeType.LETTERNODE) {
//                    LetterNode retrievedLetter = (LetterNode) newNode.getRoot();
//                    if (retrievedLetter.getLetter() == letter) {
//                        searchInTree(sequence, word + letter, newNode, salida);
//                    }
//                } else if (newNode.getRoot().getNodeType() == Node.NodeType.WORDNODE) {
//                    salida.add(word);
//                    searchInTree(sequence.substring(1), word + letter, newNode, salida);
//                }
//            }
//        } else {
//            salida.add(word);
//        }
//    }
    private void searchInTree(String sequence, String word, GTreeIF<Node> node, WordList salida) {
        sequence = getUniqueString(sequence);
        for (int pos = 0; pos < sequence.length(); pos++) {
            if (node.getRoot().getNodeType() != Node.NodeType.WORDNODE) {
                char letter = sequence.charAt(pos);

                ListIF<GTreeIF<Node>> children = node.getChildren();
                for (int i = 1; i <= node.getNumChildren(); i++) {
                    GTreeIF<Node> childNode = children.get(i);
                    if (childNode.getRoot().getNodeType() == Node.NodeType.LETTERNODE) {
                        LetterNode retrievedLetter = (LetterNode) childNode.getRoot();
                        if (retrievedLetter.getLetter() == letter) {
                            searchInTree(sequence, word + letter, childNode, salida);
                        }
                    } else if (childNode.getRoot().getNodeType() == Node.NodeType.WORDNODE) {
                        salida.add(word);
                    }
                }
                searchInTree(sequence.substring(1), word, node, salida);
            } else if (node.getRoot().getNodeType() == Node.NodeType.WORDNODE) {
                salida.add(word);
            }
        }
    }


    /* Método público de búsqueda de todas las palabras de tamaño size a partir de una secuencia */
    public WordListN search(String sequence, int size) {
        WordListN salida = new WordListN(size);           /* Variable donde construiremos la salida */
        searchInTreeN(sequence, "", this.dict, salida, size); /* Construimos la salida recursivamente */
        return salida;
    }

    /* Método privado llamado por el anterior */
    private void searchInTreeN(String sequence, String word, GTreeIF<Node> node, WordListN salida, int size) {
        sequence = getUniqueString(sequence);
        for (int pos = 0; pos < sequence.length(); pos++) {
            if (node.getRoot().getNodeType() != Node.NodeType.WORDNODE) {
                char letter = sequence.charAt(pos);

                ListIF<GTreeIF<Node>> children = node.getChildren();
                for (int i = 1; i <= node.getNumChildren(); i++) {
                    GTreeIF<Node> childNode = children.get(i);
                    if (childNode.getRoot().getNodeType() == Node.NodeType.LETTERNODE) {
                        LetterNode retrievedLetter = (LetterNode) childNode.getRoot();
                        if (retrievedLetter.getLetter() == letter) {
                            searchInTreeN(sequence, word + letter, childNode, salida, size);
                        }
                    } else if (childNode.getRoot().getNodeType() == Node.NodeType.WORDNODE) {
                        if (word.length() == size) {
                            salida.add(word);
                        }
                    }
                }
                searchInTreeN(sequence.substring(1), word, node, salida, size);
            } else if (node.getRoot().getNodeType() == Node.NodeType.WORDNODE) {
                if (word.length() == size) {
                    salida.add(word);
                }
            }
        }
    }

    private static String getUniqueString(String sequence) {
        ListIF<Character> characters = new List<Character>();
        String uniqueString = "";
        for (int i = 0; i < sequence.length(); i++) {
            char sequenceChar = sequence.charAt(i);
            if (!characters.contains(sequenceChar)) {
                characters.insert(1, sequenceChar);
                uniqueString += sequenceChar;
            }
        }
        return uniqueString;
    }
}
