import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
                JFileChooser j = new JFileChooser("f:");

                // Invoke the showsOpenDialog function to show the save dialog
                int r = j.showOpenDialog(null);

                // If the user selects a file
                if (r == JFileChooser.APPROVE_OPTION) {
                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        // String
                        String s1 = "", sl = "";

                        // File reader
                        FileReader fr = new FileReader(fi);

                        // Buffered reader
                        BufferedReader br = new BufferedReader(fr);

                        // Initilize sl
                        sl = br.readLine();

                        // Take the input from the file
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }

                        // Set the text
                        txtArea.setText(sl);
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(sideComponents.getFrame(), evt.getMessage());
                    }
                }
                // If the user cancelled the operation
                else
                    JOptionPane.showMessageDialog(sideComponents.getFrame(), "the user cancelled the operation");
            }
        });
    }


}
