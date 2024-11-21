package it.unibo.mvc;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "simple GUI With file chooser";
    private final JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 5;
    private final SimpleController contr = new SimpleController();
/**
 *  Creates a new  SimpleGUIWithFileChooser.
*/
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        final JPanel south = new JPanel(new FlowLayout());
        canvas.setLayout(new BorderLayout());
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show History");
        final JTextArea tarea = new JTextArea();
        final JTextField tfield = new JTextField();
        canvas.add(tfield, BorderLayout.NORTH);
        canvas.add(tarea, BorderLayout.CENTER);
        canvas.add(south, BorderLayout.SOUTH);
        south.add(print);
        south.add(history);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
             final String s = tfield.getText();
                 contr.setNextString(s);
                 contr.printString(s);
                 System.out.println(s); //NOPMD
        }
    });
    history.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            for (final String riga: contr.getHistory()) {
                tarea.append(riga + "\n");
            }
        }
        });
     }
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
       new SimpleGUI().display();
    }
}

