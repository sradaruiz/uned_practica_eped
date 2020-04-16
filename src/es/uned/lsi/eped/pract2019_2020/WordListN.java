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

    public void add(String word) {
        words = addChild(words, word);
    }

    private BTreeIF<String> addChild(BTreeIF<String> child, String word) {
        if (child == null) {
            BTreeIF<String> newChild = new BTree<String>();
            newChild.setRoot(word);
            return newChild;
        }
        int wordCompare = word.compareToIgnoreCase(child.getRoot());
        if (wordCompare < 0) {
            child.setLeftChild(addChild(child.getLeftChild(), word));
        } else if (wordCompare > 0) {
            child.setRightChild(addChild(child.getRightChild(), word));
        } else {
            return child;
        }
        return child;
    }

    public int getWordSize() {
        return wordSize;
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
        for (int pos = 1; pos <= numPalabras; pos++) {
            /* Estas líneas dependen de la estructura escogida */
            String word = words/* Obtener la siguiente palabra */
            /* Avanzar a la siguiente sin destruir la estructura */
			...
            /* Estas líneas dependen de la estructura escogida */
            salida.append(word);
            if (pos < numPalabras) {
                salida.append(", ");
            }
        }
        salida.append('\n');
        return salida.toString();
    }
}
