package cn.edu.zua.drools.one.model.rules;

/**
 * Created by ascend on 2017/2/6 16:40.
 */
public class Message {
    public static final int HELLO = 0;
    public static final int GOODBYE = 1;
    private String message;
    private int status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
