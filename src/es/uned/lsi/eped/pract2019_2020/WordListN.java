package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.BTree;
import es.uned.lsi.eped.DataStructures.BTreeIF;

public class WordListN {
    /* Atributos de la clase con la estructura adecuada */
    int wordSize;
    BTreeIF<String> words;
    /* Atributos de la clase con la estructura adecuada */

    public WordListN(int size) {
        wordSize = size;
    }

    public int getWordSize() {
        return wordSize;
    }

    public void add(String word) {
        words = addChild(words, word);
    }

    private BTreeIF<String> addChild(BTreeIF<String> tree, String word) {
        if (word.length() != wordSize) {
            // No se insertan palabras que no cuadran con el tamaño indicado
            return tree;
        }
        if (tree == null) {
            // Si el árbol no está iniciado se inicia
            BTreeIF<String> newChild = new BTree<String>();
            newChild.setRoot(word);
            return newChild;
        }
        int wordCompare = word.compareToIgnoreCase(tree.getRoot());
        if (wordCompare < 0) {
            tree.setLeftChild(addChild(tree.getLeftChild(), word));
        } else if (wordCompare > 0) {
            tree.setRightChild(addChild(tree.getRightChild(), word));
        } else {
            return tree;
        }
        return tree;
    }

    public String toString() {
        StringBuilder salida = new StringBuilder();
        int numPalabras = words.size(); /*Longitud de la secuencia de palabras */
        salida.append("-Palabras de ");
        salida.append(this.getWordSize());
        salida.append(" letra");
        if (this.getWordSize() > 1) {
            salida.append('s');
        }
        salida.append(": ");
        salida.append(getWords());
        salida.append('\n');
        return salida.toString();
    }

    private StringBuilder getWordsFromTree(BTreeIF<String> tree, StringBuilder salida) {
        if (tree == null) {
            return new StringBuilder();
        }

        getWordsFromTree(tree.getLeftChild(), salida);
        salida.append(", ").append(tree.getRoot());
        getWordsFromTree(tree.getRightChild(), salida);

        return salida;
    }

    private String getWords() {
        StringBuilder wordsList = getWordsFromTree(words, new StringBuilder());
        return wordsList.substring(wordsList.indexOf(",") + 1, wordsList.length());
    }
}
