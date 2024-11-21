package it.unibo.mvc;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/**
 * Application controller. Performs the I/O.
 */
public class SimpleController {
    /**
 * Application controller. Performs the I/O.
 */
    public static final String SEP = System.getProperty("file.separator"); 
    private final String p = System.getProperty("user.home") + SEP + "output.txt";
    private final List<String> history;
    private String next;
    /**
 * controller constructor.
 */
public SimpleController() {
    this.history = new ArrayList<>(0); 
}
/**
 * setta la prossima stringa da stampare.
 * @param s stringa da settare come prossima da stampare.
 * @exception IllegalStateException se la prossima stringa è null
 * 
 */
        public void setNextString(final String s) {
                if (s == null) {
                    throw new IllegalArgumentException("The input string cannot be null.");
                }
                next = s;
            }

/**
 * 
 * @return ritorna la prossima stringa da stampare.
 */
        public String getNextString() {
        return next;
        }
/**
 * @return ritorna in forma di lista tutte le stringhe stampate
 */
        public List<String> getHistory() {
            return new ArrayList<>(this.history);
        }
/**
 * stampa la stringa corrente.
 * @param n stringa da stampare
 * @throw IllegalStateException se la stringa corrente non è settata
 */
public void printString(final String n) {
    try (PrintStream output = new PrintStream(p, StandardCharsets.UTF_8)) {
        output.write(n.getBytes(StandardCharsets.UTF_8));
        history.add(n);
    } catch (IOException e) {
        e.printStackTrace(); //NOPMD
    }
}
}

