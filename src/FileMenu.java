import javax.swing.*;

public class FileMenu implements Menu {

    private JMenu fileMenu = new JMenu("File");

    @Override
    public void createsMenu(){
        JMenuItem openOption = new JMenuItem("Open");
        JMenuItem saveAsOption = new JMenuItem("Save as");
        JMenuItem saveOption = new JMenuItem("Save");

        fileMenu.add(openOption);
        fileMenu.add(saveAsOption);
        fileMenu.add(saveOption);
    }


    @Override
    public JMenu getsMenu() {
        createsMenu();
        return fileMenu;
    }
}
