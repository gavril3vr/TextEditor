import javax.swing.*;

public class EditMenu implements Menu {

    private JMenu editMenu = new JMenu("Edit");

    @Override
    public void createsMenu(){
        JMenuItem search = new JMenuItem("Search");
        JMenuItem replace = new JMenuItem("Replace");
        JMenuItem count = new JMenuItem("Count");
        JMenuItem font = new JMenuItem("Font");

        editMenu.add(search);
        editMenu.add(replace);
        editMenu.add(count);
        editMenu.add(font);
    }


    @Override
    public JMenu getsMenu() {
        createsMenu();
        return editMenu;
    }


}
