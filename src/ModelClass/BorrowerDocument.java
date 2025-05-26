/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import javafx.scene.image.Image;

/**
 *
 * @author Admin
 */
public class BorrowerDocument {
    private String senderID;
    private String receiverID;
    private Image imageDoc;

    public BorrowerDocument() {
    }

    public BorrowerDocument(String senderID, String receiverID, Image imageDoc) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.imageDoc = imageDoc;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public Image getImageDoc() {
        return imageDoc;
    }

    public void setImageDoc(Image imageDoc) {
        this.imageDoc = imageDoc;
    }

    @Override
    public String toString() {
        return "BorrowerDocument{" + "senderID=" + senderID + ", receiverID=" + receiverID + ", imageDoc=" + imageDoc + '}';
    }   
}
