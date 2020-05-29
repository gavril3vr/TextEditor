import javax.swing.*;

public class Display {
    private SideComponents sideComponents = new SideComponents();
    private JMenuBar menuBar = new JMenuBar();
    private FileMenu fileMenu;
    private EditMenu editMenu;
    private FormatMenu formatMenu;

    public void createWindow() {
        fileMenu = new FileMenu(sideComponents);
        editMenu = new EditMenu(sideComponents);
        formatMenu = new FormatMenu(sideComponents);
        setsDefaultSettings();
        sideComponents.getFrame().add(sideComponents.getScrollPane());
        createsMenuBar();
    }

    public void setsDefaultSettings() {
        sideComponents.getFrame().setSize(100, 100);
        sideComponents.getFrame().pack();
        sideComponents.getFrame().setVisible(true);
        sideComponents.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createsMenuBar() {
        menuBar.add(fileMenu.getsMenu());
        menuBar.add(editMenu.getsMenu());
        menuBar.add(formatMenu.getsMenu());

        sideComponents.getFrame().setJMenuBar(menuBar);
    }

}