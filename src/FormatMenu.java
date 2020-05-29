import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormatMenu implements Menu, ActionListener {

    private JMenu formatMenu = new JMenu("Format");
    private JMenuItem font = new JMenuItem("Font");
    private SideComponents sideComponents;
    private JTextField txtFieldFont = new JTextField(2);

    public FormatMenu(SideComponents sideComponents) {
        this.sideComponents = sideComponents;
    }

    @Override
    public void createsMenu() {
        formatMenu.add(font);
        font.addActionListener(this);

    }

    @Override
    public JMenu getsMenu() {
        createsMenu();
        return formatMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();

        if (s.equals("Font")) {
            setFontSize();
        }
    }

    public void setFontSize() {
        JDialog jd = new JDialog();
        JButton btnSetSize = new JButton("Set size");
        JButton closeBtn = new JButton("Exit");

        jd.setTitle("Font size");
        jd.setSize(350, 100);
        jd.getContentPane().setLayout(new BorderLayout());
        jd.setLocationRelativeTo(sideComponents.getFrame());

        JPanel panel = new JPanel();

        panel.add(txtFieldFont);
        panel.add(btnSetSize);
        panel.add(closeBtn);

        jd.getContentPane().add(panel, BorderLayout.CENTER);

        jd.setVisible(true);

        btnSetSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int textFieldValue = Integer.parseInt(txtFieldFont.getText());
                Font f = sideComponents.getTxtArea().getFont();
                Font f2 = new Font(f.getFontName(), f.getStyle(), textFieldValue);
                sideComponents.getTxtArea().setFont(f2);
            }
        });

        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jd.setVisible(false);
            }
        });
    }
}
