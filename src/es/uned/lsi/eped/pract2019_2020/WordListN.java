package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;

public class WordListN {
    /* Atributos de la clase con la estructura adecuada */
    private int wordSize;
    private List<String> wordList;
    /* Atributos de la clase con la estructura adecuada */

    public WordListN(int size) {
        wordSize = size;
        wordList = new List<String>();
    }

    public void add(String word) {
        wordList.insert(wordList.size() + 1, word);
    }

    public int getWordSize() {
        return wordSize;
    }

    public String toString() {
        StringBuilder salida = new StringBuilder();
        int numPalabras = this.wordList.size();/* Longitud de la secuencia de palabras */
        salida.append("-Palabras de ");
        salida.append(this.getWordSize());
        salida.append(" letra");
        if (this.getWordSize() > 1) {
            salida.append('s');
        }
        salida.append(": ");
        for (int pos = 1; pos <= numPalabras; pos++) {
            /* Estas líneas dependen de la estructura escogida */
            String word = this.wordList.get(pos);/* Obtener la siguiente palabra */
            /* Avanzar a la siguiente sin destruir la estructura */
            //TODO: Las listas conservan su estructura, tener cuidado si se cambia porque
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
