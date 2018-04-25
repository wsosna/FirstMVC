package wsosnowska_12c;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatController {
    private ChatView chatView;
    private ChatModel chatModel;
    private ParentWindow parentWindow;


    private Pattern pattern;
    private Matcher matcher;

    public ChatController() {
        parentWindow = new ParentWindow(this);
        chatModel = new ChatModel(this);
        chatView = null;
        pattern = Pattern.compile("^\\s+$");
        matcher = null;
    }

    public ChatView createChatView (){
        chatView = new ChatView(this);
        chatView.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                chatModel.getViewList().remove(chatView);
            }
        });
        chatModel.getViewList().add(chatView);
        addAllData(chatView);
        return chatView;
    }
    public void addAllData (ChatView view) {
        for (String string: chatModel.getData()) {
            view.getMainPanel().add(new JLabel(string));
        }
        view.getMainPanel().setLayout(new BoxLayout(view.getMainPanel(), BoxLayout.Y_AXIS));
        view.pack();
        view.setSize(300, 400);
    }

    public void buttonADDaction(String string){
        matcher = pattern.matcher(string);
        if(!matcher.find()) {
            addToList(string);
            addToMainPanel(string);
        } else chatView.getTextField().setText("");

    }

    public void addToMainPanel (String string){
        for (ChatView c : chatModel.getViewList()) {
            Dimension dimension = c.getSize();
            c.getMainPanel().add(new JLabel(string));
            c.getMainPanel().setLayout(new BoxLayout(c.getMainPanel(), BoxLayout.Y_AXIS));
            c.setPreferredSize(dimension);
            c.pack();
            c.getTextField().setText("");
        }
    }

    public void addToList (String string){
        chatModel.getData().add(string);
    }

    public ChatModel getChatModel() {
        return chatModel;
    }
}

