import javax.swing.*;

public class SideComponents {

    private JFrame frame = new JFrame("Notepad");
    private JTextArea txtArea = new JTextArea(50, 50);
    private JScrollPane scrollPane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }


}
