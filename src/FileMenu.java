import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FileMenu implements Menu {
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem openOption = new JMenuItem("Open");
    private SideComponents sideComponents = new SideComponents();


    @Override
    public void createsMenu() {
        openOption = new JMenuItem("Open");
        JMenuItem saveAsOption = new JMenuItem("Save as");
        JMenuItem saveOption = new JMenuItem("Save");

        fileMenu.add(openOption);
        fileMenu.add(saveAsOption);
        fileMenu.add(saveOption);

        listenActions();

    }


    @Override
    public JMenu getsMenu() {
        createsMenu();
        return fileMenu;
    }

    public void listenActions(){
        openOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Test");

            }
        });
    }


}
