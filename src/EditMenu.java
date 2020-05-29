import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenu implements Menu, ActionListener {

    private JMenu editMenu = new JMenu("Edit");
    private SideComponents sideComponents;
    private boolean isCaseSensitiveSearch;
    private boolean isCaseSensitiveReplace = false;
    private Object lastHL;
    private Highlighter hl;
    private int findIndex;
    private Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);


    public EditMenu(SideComponents sideComponents, Highlighter hl) {
        this.sideComponents = sideComponents;
        this.hl = hl;
    }

    @Override
    public void createsMenu() {
        JMenuItem menuSearch = new JMenuItem("Search");
        JMenuItem menuReplace = new JMenuItem("Replace");
        JMenuItem menuCopy = new JMenuItem("Copy");
        JMenuItem menuPaste = new JMenuItem("Paste");
        JMenuItem menuCut = new JMenuItem("Cut");

        menuSearch.addActionListener(this);
        menuReplace.addActionListener(this);
        menuCopy.addActionListener(this);
        menuPaste.addActionListener(this);
        menuCut.addActionListener(this);

        editMenu.add(menuSearch);
        editMenu.add(menuReplace);
        editMenu.add(menuCopy);
        editMenu.add(menuPaste);
        editMenu.add(menuCut);

    }

    @Override
    public JMenu getsMenu() {
        createsMenu();
        return editMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();

        if (s.equals("Search")) {
            search();
        } else if (s.equals("Replace")) {
            replace();
        } else if (s.equals("Copy")) {
            copy();
        } else if (s.equals("Paste")) {
            paste();
        } else if (s.equals("Cut")) {
            cut();
        }
    }

    public void setHighlight(int idx, String findStr) {
        sideComponents.getTxtArea().setCaretPosition(idx);
        findIndex = idx;
        int startHL = sideComponents
                .getTxtArea()
                .getCaretPosition();

        int endHL = startHL + findStr.length();

        try {
            lastHL = hl.addHighlight(startHL, endHL, painter);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void search() {
        JDialog jd = new JDialog();
        jd.setTitle("Search");
        jd.setSize(340, 150);
        jd.getContentPane().setLayout(new BorderLayout());
        jd.setLocationRelativeTo(sideComponents.getFrame());

        JButton closeButton = new JButton("Close");
        JButton findButton = new JButton("Search");
        JButton findNextButton = new JButton("Search Next");
        JCheckBox mCheckBox = new JCheckBox("Case Sensitive");
        JTextField findField = new JTextField(15);

        JPanel findPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        findPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new GridLayout(1, 3));

        findPanel.add(new JLabel("Find: "));
        findPanel.add(findField);
        findPanel.add(mCheckBox);
        jd.getContentPane().add(findPanel, BorderLayout.CENTER);

        buttonPanel.add(findButton);
        buttonPanel.add(findNextButton);
        buttonPanel.add(closeButton);
        jd.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        System.out.println("test");

        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                isCaseSensitiveSearch = false;
                jd.setVisible(false);
            }
        });

        mCheckBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (mCheckBox.isSelected())
                    isCaseSensitiveSearch = true;
                else
                    isCaseSensitiveSearch = false;
            }
        });

        findNextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                String str = sideComponents
                        .getTxtArea()
                        .getText()
                        .toLowerCase();

                String findStr = findField
                        .getText()
                        .toLowerCase();

                if (isCaseSensitiveSearch) {
                    str = sideComponents
                            .getTxtArea()
                            .getText();

                    findStr = findField.getText();
                }
                if (!str.equals("")) {
                    if (lastHL != null)
                        hl.removeHighlight(lastHL);
                    int idx = str.indexOf(findStr, findIndex + 1);
                    if (idx > -1) {
                        setHighlight(idx, findStr);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not Found");
                    }
                }
            }
        });

        findButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String str = sideComponents.getTxtArea()
                        .getText()
                        .toLowerCase();
                String findStr = findField.getText().toLowerCase();

                if (isCaseSensitiveSearch) {
                    str = sideComponents.getTxtArea().getText();
                    findStr = findField.getText();
                }
                if (!str.equals("")) {
                    if (lastHL != null)
                        hl.removeHighlight(lastHL);
                    int idx = str.indexOf(findStr, 0);
                    if (idx > -1) {
                        setHighlight(idx, findStr);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not Found");
                    }
                }
            }
        });

        jd.setVisible(true);
    }

    public void replace() {
        JDialog jd = new JDialog();
        jd.setTitle("Replace");
        jd.setSize(350, 150);
        jd.getContentPane().setLayout(new BorderLayout());
        jd.setLocationRelativeTo(sideComponents.getFrame());

        JCheckBox mCheckBox = new JCheckBox("Case Sensitive");
        JTextField wordOneField = new JTextField(10);
        JTextField wordTwoField = new JTextField(10);
        JButton replaceBtn = new JButton("Replace");
        JButton closeBtn = new JButton("Close");

        JPanel panelTwo = new JPanel();

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(1, 3));

        panelTwo.add(new JLabel("Old: "));
        panelTwo.add(wordOneField);


        panelTwo.add(new JLabel("New: "));
        panelTwo.add(wordTwoField);
        jd.getContentPane().add(panelTwo, FlowLayout.LEFT);


        buttonPanel.add(replaceBtn);
        buttonPanel.add(closeBtn);
        buttonPanel.add(mCheckBox);
        jd.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        mCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mCheckBox.isSelected()) {
                    isCaseSensitiveReplace = true;
                } else {
                    isCaseSensitiveReplace = false;
                }
            }

        });

        replaceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String textAreaString;
                String findString;
                String replaceString = wordTwoField.getText();
                ;

                if (isCaseSensitiveReplace) {
                    textAreaString = sideComponents.getTxtArea().getText();
                    findString = wordOneField.getText();
                } else {

                    textAreaString = sideComponents.getTxtArea().getText().toLowerCase();
                    findString = wordOneField.getText().toLowerCase();
                }

                String replacedText = textAreaString.replaceAll(findString, replaceString);

                sideComponents.getTxtArea().setText(replacedText);

                if (textAreaString.equals("")) {
                    if (textAreaString.contains(findString)) {
                        String newStr = textAreaString.replaceAll(findString, replaceString);
                        sideComponents.getTxtArea().setText(newStr);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not found!");
                    }
                }
            }
        });

        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jd.setVisible(false);
            }
        });

        jd.setVisible(true);
    }

    public void copy() {
        sideComponents.getTxtArea().copy();
    }

    public void paste() {
        sideComponents.getTxtArea().paste();
    }

    public void cut() {
        sideComponents.getTxtArea().cut();
    }
}
