/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import edu.neu.csye6200.daycare.controller.DayCareController;
import static edu.neu.csye6200.daycare.views.ChatHere.s;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author jaidevmane
 */
public class ChatAndroid extends javax.swing.JPanel {
    private JPanel RightPanel;
    private DayCareController controller = null;
     static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    static ServerSocket ss;
    static InputStreamReader isr;
    static BufferedReader br;
    static String msgIn="";

    
    public ChatAndroid(DayCareController controller, JPanel RightPanel) {
        initComponents();
        doThis();
    }
    
        
     public void doThis(){
        SwingWorker<Void,String> worker = new SwingWorker<Void, String>() {

            @Override
            protected Void doInBackground() throws Exception {
                
                 try {
            ss = new ServerSocket(6000);
            
            while(true){
            s = ss.accept();
            isr = new InputStreamReader(s.getInputStream());
            br = new BufferedReader(isr);
            msgIn= br.readLine();
            
            System.out.println(msgIn);
            
            if(chatWindow.getText().equals("") || chatWindow.getText().isEmpty() ){
                chatWindow.setText("Android: "+ msgIn +"\n");
            }
            else{
                chatWindow.append("Android: "+ msgIn +"\n");
            }
            
            //chatWindow.setText("Android: "+ msgIn +"\n");
            }
            
            
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                
//            try{
////                s= new Socket("172.20.10.9",1201);//
//                Socket s = new Socket("10.0.0.106",7801);
////                s= new Socket("10.0.0.153",1201);//
//               //s= new Socket("127.0.0.1",1201);//running server and client on same system
//               din = new DataInputStream(s.getInputStream());
//               dout = new DataOutputStream(s.getOutputStream());
//               String msgIn ="";
//            
//            
//                while(!msgIn.equals("exit")){
//                    msgIn = din.readUTF();
//                    publish(msgIn);
//                    //ClientView.setText(ClientView.getText().trim()+"\nServer-> "+msgIn);
//                }
//
//            }catch(Exception e){
//                System.out.println("Error connecting local ip add"+e);
//            }
          return null;
        }

            @Override
            protected void process(List<String> chunks) {
                String msgIn = chunks.get(chunks.size()-1);
               chatWindow.setText(chatWindow.getText().trim()+"\nServer-> "+msgIn); 
            }
            
            
        };
        
        worker.execute();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        chatWindow = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        sendWindowField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(246, 237, 246));

        chatWindow.setEditable(false);
        chatWindow.setColumns(20);
        chatWindow.setRows(5);
        jScrollPane3.setViewportView(chatWindow);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PC Client Chat Window");

        sendButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sendButton.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/send.png")); // NOI18N
        sendButton.setText("Send");
        sendButton.setBorderPainted(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        sendWindowField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendWindowFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sendWindowField, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendButton))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendWindowField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {
            // TODO add your handling code here:
            Socket s = new Socket("10.0.0.106",7801);
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            pw.write(sendWindowField.getText());
            if(chatWindow.getText().equals("") || chatWindow.getText().isEmpty() ){
                chatWindow.setText("PC: "+ sendWindowField.getText() +"\n");
            }
            else{
                chatWindow.append("PC: "+ sendWindowField.getText() +"\n");
            }
            sendWindowField.setText("");

            pw.flush();
            pw.close();
            s.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
//        try{
//            String msgOut ="";
//            msgOut=sendWindowField.getText().trim();
//            dout.writeUTF(msgOut);
//            chatWindow.setText(chatWindow.getText().trim()+"\nClient->" +msgOut);
//            sendWindowField.setText("");
//        }catch(Exception e){
//               e.printStackTrace();
//        }

    }//GEN-LAST:event_sendButtonActionPerformed

    private void sendWindowFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendWindowFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendWindowFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea chatWindow;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton sendButton;
    private static javax.swing.JTextField sendWindowField;
    // End of variables declaration//GEN-END:variables
}
