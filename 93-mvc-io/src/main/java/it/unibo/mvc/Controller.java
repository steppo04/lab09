package it.unibo.mvc;
import java.util.List;
/**
 * semplice interfaccia controller.
 */
public interface Controller {
    /**
     * setta la prossima stringa da stampare.
     * @param s stringa da settare come prossima da stampare.
     * @exception IllegalStateException se la prossima stringa è null
     * 
     */
    void setNextString(String s);
    /**
     * 
     * @return ritorna la prossima stringa da stampare.
     */
    String getNextString();
    /**
     * @return ritorna in forma di lista tutte le stringhe stampate.
     */
     List<String> getHistory();
    /**
     * stampa la stringa corrente.
     * @throw IllegalStateException se la stringa corrente non è settata
     */
    void printString();
}



