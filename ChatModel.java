package wsosnowska_12c;

import java.util.ArrayList;
import java.util.List;

public class ChatModel implements Cloneable{

    private final ChatController chatController;
    private List<String> data;
    private List<ChatView> viewList;

    public ChatModel (ChatController chatController) {
        this.chatController = chatController;
        data = new ArrayList();
        viewList = new ArrayList<>();
    }

    public List<ChatView> getViewList() {
        return viewList;
    }

    public List<String> getData() {
        return data;
    }
}
