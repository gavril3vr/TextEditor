import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Display {
    private JFrame frame;
    private JTextArea txtArea;
    private JMenuBar menuBar = new JMenuBar();
    private FileMenu fileMenu = new FileMenu();
    private EditMenu editMenu = new EditMenu();

    public void createWindow(){
        setsDefaultSettings();
        txtArea = new JTextArea(10, 10);
        frame.add(txtArea);
        createsMenuBar();
    }

    public void setsDefaultSettings(){
        frame = new JFrame("Text Editor");
        frame.pack();
        frame.setSize(100, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
    }

    public void createsMenuBar(){
        menuBar.add(fileMenu.getsMenu());
        menuBar.add(editMenu.getsMenu());
        frame.setJMenuBar(menuBar);
    }


}
