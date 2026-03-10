import java.io.Serializable;

/**
 * class that represents a message
 */

public class Message implements Serializable {

    private String text;

    /**
     * constructor that gets as parameter the text
     * @param text the text
     */

    public Message(String text){
        this.text=text;
    }

    /**
     * method that sets the text of the message
     * @param text the text
     */

    public void setText(String text){
        this.text=text;
    }

    /**
     * method that returns the text of the message
     * @return text
     */

    public String getText(){
        return text;
    }
}
