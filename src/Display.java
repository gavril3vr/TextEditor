import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;

public class Display {
    private SideComponents sideComponents = new SideComponents();
    private JMenuBar menuBar = new JMenuBar();
    private FileMenu fileMenu;
    private EditMenu editMenu;
    private FormatMenu formatMenu;
    private ViewMenu viewMenu;

    private Highlighter hl = sideComponents
            .getTxtArea()
            .getHighlighter();

    public void createWindow() {
        fileMenu = new FileMenu(sideComponents);
        editMenu = new EditMenu(sideComponents, hl);
        formatMenu = new FormatMenu(sideComponents);
        viewMenu = new ViewMenu(sideComponents);

        setsDefaultSettings();
        sideComponents.getFrame().add(sideComponents.getScrollPane());
        createsMenuBar();
    }

    public void setsDefaultSettings() {
        sideComponents.getTxtArea().setLineWrap(true);
        sideComponents.getFrame().setLayout(new BorderLayout());
        sideComponents.getFrame().setSize(1024, 768);
        sideComponents.getFrame().setVisible(true);
        sideComponents.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createsMenuBar() {
        menuBar.add(fileMenu.getsMenu());
        menuBar.add(editMenu.getsMenu());
        menuBar.add(formatMenu.getsMenu());
        menuBar.add(viewMenu.getsMenu());
        sideComponents.getFrame().setJMenuBar(menuBar);


    }





}