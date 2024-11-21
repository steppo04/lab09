package it.unibo.mvc;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
/**
 * Application controller. Performs the I/O.
 */
public class Controller {
/**
 * Application controller. Performs the I/O.
 */
    public static final String SEP = System.getProperty("file.separator"); 
    private File current;
    private final String p = System.getProperty("user.home") + SEP + "output.txt";
/**
 * controller constructor.
 */
        public Controller() {
            this.current = new File(p);
        }
/**
 * setta un nuovo file.
 * @param c file da settare come current.
 * 
 */
        public void setFile(final File c) {
            this.current = c;
        }
/**
 * 
 * @return ritorna il file corrente.
 */
        public File getFile() {
            return current;
        }
/**
 * @return ritorna il percorso del file corrente.
 */
        public String getPath() {
            return current.getAbsolutePath();
        }
/**
 * scrive una nuova riga.
 * @param text testo da inserire.
  * @throws IOException 
  */
     public void writeString(final String text) throws IOException {
        try (PrintStream output = new PrintStream(p, StandardCharsets.UTF_8)) {
            output.println(text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace(); // NOPMD
        }
    }
}
