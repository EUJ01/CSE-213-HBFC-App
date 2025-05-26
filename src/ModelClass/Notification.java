/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

/**
 *
 * @author Fahim Shahriar
 */
public class Notification {
    
    private String senderID;
    private String recieverID;
    private String userType;
    private String Text;

    public Notification() {
    }

    public Notification(String senderID, String recieverID, String userType, String Text) {
        this.senderID = senderID;
        this.recieverID = recieverID;
        this.userType = userType;
        this.Text = Text;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getRecieverID() {
        return recieverID;
    }

    public void setRecieverID(String recieverID) {
        this.recieverID = recieverID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    @Override
    public String toString() {
        return "Notification{" + "senderID=" + senderID + ", recieverID=" + recieverID + ", userType=" + userType + ", Text=" + Text + '}';
    }

    
    
    
    
}
