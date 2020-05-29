import javax.swing.*;

public class EditMenu implements Menu {

    private JMenu editMenu = new JMenu("Edit");
    private SideComponents sideComponents;

    public EditMenu(SideComponents sideComponents){
        this.sideComponents = sideComponents;
    }

    @Override
    public void createsMenu() {
        JMenuItem search = new JMenuItem("Search");
        JMenuItem replace = new JMenuItem("Replace");
        JMenuItem count = new JMenuItem("Count");

        editMenu.add(search);
        editMenu.add(replace);
        editMenu.add(count);

        listenActions();
    }

    @Override
    public JMenu getsMenu() {
        createsMenu();
        return editMenu;
    }

    @Override
    public void listenActions() {

    }


}
