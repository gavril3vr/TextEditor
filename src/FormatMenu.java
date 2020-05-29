import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormatMenu implements Menu, ActionListener {

    private JMenu formatMenu = new JMenu("Format");
    private JMenuItem font = new JMenuItem("Font");
    private SideComponents sideComponents;
    private JTextField txtFieldFont = new JTextField(2);
    private JButton btnSetSize = new JButton("Set size");

    public FormatMenu(SideComponents sideComponents){
        this.sideComponents = sideComponents;
    }

    public JMenuItem getFont() {
        return font;
    }

    public JTextField getTxtFieldFont() {
        return txtFieldFont;
    }

    public JButton getBtnSetSize() {
        return btnSetSize;
    }

    @Override
    public void createsMenu() {
        formatMenu.add(font);
        font.addActionListener(this);
        listenActions();
    }

    @Override
    public JMenu getsMenu() {
        createsMenu();
        return formatMenu;
    }

    @Override
    public void listenActions() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        String s = e.getActionCommand();

        if (s.equals("Font")) {
            JFrame frame = new JFrame("Font size");

            frame.pack();
            frame.setSize(100, 100);
            frame.setVisible(true);

            JPanel panel = new JPanel();


            frame.add(panel);
            panel.add(txtFieldFont);
            panel.add(btnSetSize);
        }

        btnSetSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int textFieldValue = Integer.parseInt(txtFieldFont.getText());
                System.out.println(textFieldValue);
                Font f = sideComponents.getTxtArea().getFont();
                //System.out.println(f.getSize());
                Font f2 = new Font(f.getFontName(), f.getStyle(), textFieldValue);
                //System.out.println(f2.getSize());
                sideComponents.getTxtArea().setFont(f2);
                System.out.println(sideComponents.getTxtArea().getFont());


            }
        });


    }
}
