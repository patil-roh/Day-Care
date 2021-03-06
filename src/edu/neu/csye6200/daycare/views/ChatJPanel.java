/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.views.ChatJPanel.MyThread;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JPanel;

/**
 *
 * @author jaidevmane
 */
public class ChatJPanel extends javax.swing.JPanel {
    
    private static DayCareController controller = null;
    private static JPanel RightPanel;
    
    static Socket s;
    static ServerSocket ss;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message;
    
    public ChatJPanel(JPanel RightPanel) {
        initComponents();
        //Thread myThread = new Thread(MyThread);
        this.RightPanel = RightPanel;
        
    }
    
    public class MyThread implements Runnable{


        @Override
        public void run() {
            
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
            
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        chatWindow = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        sendWindowField = new javax.swing.JTextField();

        chatWindow.setEditable(false);
        chatWindow.setColumns(20);
        chatWindow.setRows(5);
        jScrollPane3.setViewportView(chatWindow);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Chat Window");

        sendButton.setText("Send ->");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(sendWindowField)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sendButton))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendWindowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addContainerGap(75, Short.MAX_VALUE))
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

    }//GEN-LAST:event_sendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea chatWindow;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton sendButton;
    private static javax.swing.JTextField sendWindowField;
    // End of variables declaration//GEN-END:variables
}
