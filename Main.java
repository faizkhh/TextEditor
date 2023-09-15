import javax.swing.JFrame;

public class Main {
    public static void main(String args[]) {
        JFrame frame = new TextEditor();
        frame.setTitle("Notepad");
        frame.setVisible(true);
        frame.setSize(500, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
    }
}