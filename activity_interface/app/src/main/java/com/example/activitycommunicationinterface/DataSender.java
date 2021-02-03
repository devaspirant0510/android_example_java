package com.example.activitycommunicationinterface;

public class DataSender {
    public interface MySender{
        void sendMessage(String str1);
    }
    MySender mySender;
    MainActivity mainActivity;
    public DataSender(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

    }
    public void sendData(){
        mainActivity.callbackMethod("안녕","친구");

    }
    public void sendMessageMethod(){
        sendMessage("hhhhi");
    }
    public void setMySender(MySender mySender){
        this.mySender = mySender;

    }
    public void sendMessage(String str1){
        mySender.sendMessage(str1);
    }

}
