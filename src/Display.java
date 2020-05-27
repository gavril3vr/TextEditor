import javax.swing.*;

public class Display {
    private SideComponents sideComponents = new SideComponents();
    private JMenuBar menuBar = new JMenuBar();
    private FileMenu fileMenu = new FileMenu();
    private EditMenu editMenu = new EditMenu();

    public void createWindow() {
        setsDefaultSettings();
        sideComponents.setTxtArea(new JTextArea(10, 10));
        sideComponents.getFrame().add(sideComponents.getTxtArea());
        //sideComponents.getTxtArea().setText("sdasdasdasfsdgdfhgdfh");
        createsMenuBar();
    }

    public void setsDefaultSettings() {
        sideComponents.setFrame(new JFrame("Text Editor"));
        sideComponents.getFrame().pack();
        sideComponents.getFrame().setSize(100, 100);
        sideComponents.getFrame().setVisible(true);
        sideComponents.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createsMenuBar() {
        menuBar.add(fileMenu.getsMenu());
        menuBar.add(editMenu.getsMenu());
        sideComponents.getFrame().setJMenuBar(menuBar);
    }


}
