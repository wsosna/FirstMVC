package wsosnowska_12c;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatView extends JFrame implements Cloneable{

    private final ChatController chatController;
    private JPanel mainPanel;
    private JPanel textPanel;
    private JScrollPane jsp;
    private JTextField textField;
    private JButton addButton;
    private BorderLayout borderLayout;

    public ChatView (ChatController chatController){
        super("Chat window - SAY HELLO!");
        this.chatController = chatController;
        borderLayout = new BorderLayout(1, 1);
        mainPanel = new JPanel();
        jsp = new JScrollPane(mainPanel);
        addButton = new JButton("ADD");
        textPanel = new JPanel();
        textField = new JTextField();
        init();
        setVisible(true);
    }

    public void init() {
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chatController.buttonADDaction(textField.getText());
            }
        });

        textPanel.add(textField);
        textPanel.add(addButton);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));

        setLayout(borderLayout);
        addComponent(textPanel, BorderLayout.SOUTH);
        addComponent(jsp, BorderLayout.CENTER);
        setMinimumSize(new Dimension(300,400));
        pack();

        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                chatController.getChatModel().getViewList().remove(this);
            }
        });
    }

    public void addComponent(JComponent component, Object constrains) {
        add(component);
        borderLayout.addLayoutComponent(component, constrains);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
