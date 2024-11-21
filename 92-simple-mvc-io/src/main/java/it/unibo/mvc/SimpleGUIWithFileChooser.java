package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "simple GUI With file chooser";
    private final JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 5;
    private final Controller contr = new Controller();
/**
 *  Creates a new  SimpleGUIWithFileChooser.
*/
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        final JPanel browser = new JPanel();
        browser.setLayout(new BorderLayout());
        canvas.setLayout(new BorderLayout());
        final JButton save = new JButton("save");
        final JButton cerca = new JButton("Browser");
        final JTextArea read = new JTextArea();
        final JTextField file = new JTextField(contr.getPath());
        browser.add(cerca, BorderLayout.LINE_END);
        browser.add(file, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(read, BorderLayout.CENTER);
        canvas.add(browser, BorderLayout.NORTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
             final String s = read.getText();
             try {
                 contr.writeString(s);
             } catch (IOException ex) {
                 ex.printStackTrace(); // NOPMD
             }
        }
    });
    cerca.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            final JFileChooser folder = new JFileChooser();
                if (folder.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    contr.setFile(folder.getSelectedFile());
                } else if (folder.showSaveDialog(frame) != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(file, e, TITLE, PROPORTION);
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
       new SimpleGUIWithFileChooser().display();
    }
}
