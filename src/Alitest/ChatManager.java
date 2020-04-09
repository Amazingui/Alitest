package Alitest;

import java.util.Vector;

public class ChatManager {
    private ChatManager(){};
    private static final ChatManager cm = new ChatManager();
    public static ChatManager getCm(){
        return cm;
    }
    Vector<Chat> vector = new Vector<Chat>();
    public void add(Chat cs){
        vector.add(cs);
    }
    public void pub(Chat cs,String str){
        for (int i = 0; i <vector.size() ; i++) {
            Chat Cs = vector.get(i);
            if (!(cs.equals(Cs))){
                Cs.out(str+'\n');
            }
        }
    }
}
