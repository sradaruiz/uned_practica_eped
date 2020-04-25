package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.ListIF;

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
        while (word.length() != 0) {
            // TODO: corregir recursion
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
        }
    }

    private int getChildPosition(ListIF<GTreeIF<Node>> children, GTreeIF<Node> child) {
        if (children.contains(child)) {
            for (int i = 1; i <= children.size(); i++) {
                if (children.get(i).equals(child)) {
                    return i;
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
    private void searchInTree(String sequence, String word, GTreeIF<Node> node, WordList salida) {

    }

    /* Método público de búsqueda de todas las palabras de tamaño size a partir de una secuencia */
    public WordListN search(String sequence, int size) {
        WordListN salida = new WordListN(size);           /* Variable donde construiremos la salida */
        searchInTreeN(sequence, "", this.dict, salida, size); /* Construimos la salida recursivamente */
        return salida;
    }

    /* Método privado llamado por el anterior */
    private void searchInTreeN(String sequence, String word, GTreeIF<Node> node, WordListN salida, int size) {

    }

}
