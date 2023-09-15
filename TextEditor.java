import java.awt.BorderLayout;
/**import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class TextEditor extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int fileToOpen;
    int fileToSave;
    JFileChooser fileOpen;
    JFileChooser fileSave;

    TextEditor() {
        JMenuBar menuBar = new JMenuBar();
        final JTextArea textArea = new JTextArea();
        setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        menuBar.add(file);
        JMenuItem newOption = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem close = new JMenuItem("Exit");
        file.add(newOption);
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(close);
        getContentPane().add(textArea);

        JLabel status = new JLabel("Notepad", JLabel.CENTER);
        status.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        add(status, BorderLayout.SOUTH);

        newOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        open.addActionListener(new ActionListener() {
            private Scanner scan;

            public void actionPerformed(ActionEvent e) {
                openFile();
                if (fileToOpen == JFileChooser.APPROVE_OPTION) {
                    textArea.setText("");
                    try {
                        scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
                        while (scan.hasNext())
                            textArea.append(scan.nextLine());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
                if (fileToSave == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
                        out.write(textArea.getText());
                        out.close();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void openFile() {
        JFileChooser open = new JFileChooser();
        int option = open.showOpenDialog(this);
        fileToOpen = option;
        fileOpen = open;
    }

    public void saveFile() {
        JFileChooser save = new JFileChooser();
        int option = save.showOpenDialog(this);
        fileToSave = option;
        fileSave = save;
    }
}