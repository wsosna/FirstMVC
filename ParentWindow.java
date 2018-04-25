package wsosnowska_12c;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParentWindow extends JFrame {

    private final ChatController chatController;

    public ParentWindow(ChatController chatController){
        this.chatController = chatController;

        setTitle("WopsiChat");
        setSize(300,100);
        setResizable(false);
        setLocation(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel helloPanel = new JPanel();
        JLabel helloLabel = new JLabel("Hello! Would you like talk with me?");

        JButton childWindowButton = new JButton("Go on!");
        childWindowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chatController.createChatView();
            }
        });
        helloPanel.add(helloLabel);
        helloPanel.add(childWindowButton);
        helloLabel.setLayout(new FlowLayout());
        getContentPane().add(helloPanel);

        setVisible(true);
    }
}
