import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMenu implements Menu, ActionListener {
    private JMenu viewMenu = new JMenu("View");
    private SideComponents sideComponents;
    private JPanel labelPanel;

    public ViewMenu(SideComponents sideComponents){
        this.sideComponents = sideComponents;
    }

    public JPanel getLabelPanel() {
        return labelPanel;
    }

    public void setLabelPanel(JPanel labelPanel) {
        this.labelPanel = labelPanel;
    }

    @Override
    public void createsMenu() {
        JMenuItem menuCount = new JMenuItem("Count");
        menuCount.addActionListener(this);
        viewMenu.add(menuCount);
    }

    @Override
    public JMenu getsMenu() {
        createsMenu();
        return viewMenu;
    }

    @Override
    public void listenActions() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Count")) {
            JLabel labelWords = new JLabel("Word count: ");
            JLabel labelLines = new JLabel("Line count: ");
            JLabel labelChar = new JLabel("Character count: ");
            JPanel btnPanel = new JPanel();
            labelPanel = new JPanel();
            JButton btnClose = new JButton("Close");
            JDialog jd = new JDialog();


            jd.setTitle("Count");
            jd.setSize(350, 150);
            jd.getContentPane().setLayout(new BorderLayout());
            jd.setLocationRelativeTo(sideComponents.getFrame());

            btnPanel.add(btnClose);
            jd.getContentPane().add(btnPanel, BorderLayout.SOUTH);
            labelPanel.add(labelWords);
            labelPanel.add(labelLines);
            labelPanel.add(labelChar);
            jd.getContentPane().add(labelPanel, BorderLayout.NORTH);

            jd.setVisible(true);

            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    jd.setVisible(false);
                }
            });
            sideComponents.getTxtArea().addCaretListener(new CaretListener() {
                @Override
                public void caretUpdate(CaretEvent caretEvent) {
                    labelLines.setText("Line count: " + sideComponents.getTxtArea().getLineCount());
                    labelWords.setText("Word count: " + countWords(sideComponents.getTxtArea().getText()));
                    labelChar.setText("Character count: " + sideComponents.getTxtArea().getText().length());
                }
            });
        }



    }

    private int countWords(String str){
        final int OUT = 0;
        final int IN = 1;
        int state = OUT;
        int wc = 0;
        int i = 0;

        while (i < str.length())
        {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n'
                    || str.charAt(i) == '\t')
                state = OUT;
            else if (state == OUT)
            {
                state = IN;
                ++wc;
            }
            ++i;
        }
        return wc;
    }
}
