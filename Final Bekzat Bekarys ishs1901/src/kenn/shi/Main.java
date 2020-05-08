package kenn.shi;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;
    public static You[] staffs;
    public static int size;

    public static void connect(PackageData pd) {
        try{ Socket socket = new Socket("127.0.0.1", 8888);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD")){
                outputStream.writeObject(pd);/// ADD, Student
            }
            else if(pd.getOperationType().equals("LIST")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<You> arrayListFromServer = infoFromServer.getYous();
                String s = "";

                for(int i=0;i<arrayListFromServer.size();i++){
                    s+=arrayListFromServer.get(i)+"\n";
                }

                Results.area.append(s);
            }
            inputStream.close();
            outputStream.close();
            socket.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        frame = new MainFrame();
        frame.setVisible(true);
        staffs = new You[50];
        size = 0;
    }

    public static void addStaff(You staff){
        staffs[size] = staff;
        size++;
    }


    public static String showResult(){
        String temp="";
        for (int i=0;i<size;i++){
            temp = temp + "\n" + staffs[i].toString();
        }
        return temp;
    }



}

