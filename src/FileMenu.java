import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileMenu implements Menu, ActionListener {
    private JMenu fileMenu = new JMenu("File");
    private SideComponents sideComponents;

    public FileMenu(SideComponents sideComponents) {
        this.sideComponents = sideComponents;
    }

    @Override
    public void createsMenu() {
        JMenuItem menuNew = new JMenuItem("New");
        JMenuItem menuOpen = new JMenuItem("Open");
        JMenuItem menuSave = new JMenuItem("Save");
        JMenuItem menuSaveAs = new JMenuItem("SaveAs");
        JMenuItem menuPrint = new JMenuItem("Print");
        JMenuItem menuExit = new JMenuItem("Exit");

        // Add action listener
        menuNew.addActionListener(this);
        menuOpen.addActionListener(this);
        menuSaveAs.addActionListener(this);
        menuSave.addActionListener(this);
        menuPrint.addActionListener(this);
        menuExit.addActionListener(this);

        fileMenu.add(menuNew);
        fileMenu.add(menuOpen);
        fileMenu.add(menuSaveAs);
        fileMenu.add(menuSave);
        fileMenu.add(menuPrint);
        fileMenu.add(menuExit);

    }


    @Override
    public JMenu getsMenu() {
        createsMenu();
        return fileMenu;
    }

    @Override
    public void listenActions() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String line = e.getActionCommand();

        if (line.equals("Open")) {
            open();
        } else if (line.equals("SaveAs")) {
            saveAs();
        } else if (line.equals("New")) {
            clearsTextArea();
        }


    }



    public void open() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt", "html", "xml", "css", "doc", "docx");
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Desktop");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int openDialog = chooser.showOpenDialog(null);
        if (openDialog == JFileChooser.APPROVE_OPTION) {
            File fi = new File(chooser.getSelectedFile().getAbsolutePath());
            try {
                String s1 = "", sl = "";

                FileReader fr = new FileReader(fi);
                BufferedReader br = new BufferedReader(fr);

                sl = br.readLine();
                while ((s1 = br.readLine()) != null) {
                    sl = sl + "\n" + s1;
                }
                sideComponents.getTxtArea().setText(sl);
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(sideComponents.getFrame(), evt.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(sideComponents.getFrame(), "Operation cancelled");
        }
    }

    public void saveAs() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Desktop");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt", "html", "xml", "css", "doc", "docx");
        chooser.setFileFilter(filter);


        int r = chooser.showSaveDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {


            File file = new File(chooser.getSelectedFile().getAbsolutePath());

            try {

                FileWriter wr = new FileWriter(file, false);


                BufferedWriter w = new BufferedWriter(wr);


                w.write(sideComponents.getTxtArea().getText());

                w.flush();
                w.close();
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(sideComponents.getFrame(), evt.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(sideComponents.getFrame(), "Operation cancelled");
        }

    }

    public void clearsTextArea(){
        sideComponents.getTxtArea().setText("");
    }

}


