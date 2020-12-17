/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import edu.neu.csye6200.daycare.controller.DayCareController;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author jaidevmane
 */
public class ChatOption extends javax.swing.JPanel {
    private JPanel RightPanel;
    private DayCareController controller = null;
    
    

    /**
     * Creates new form ChatOption
     */
    public ChatOption(DayCareController controller,JPanel RightPanel) {
        initComponents();
        this.controller = controller; 
        this.RightPanel = RightPanel;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnChatLocally = new javax.swing.JButton();
        btnChatRemotely = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnChatLocally.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChatLocally.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/local.png")); // NOI18N
        btnChatLocally.setText("Chat Locally");
        btnChatLocally.setBorderPainted(false);
        btnChatLocally.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLocallyActionPerformed(evt);
            }
        });

        btnChatRemotely.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChatRemotely.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/remote.png")); // NOI18N
        btnChatRemotely.setText("Chat Remotely");
        btnChatRemotely.setBorderPainted(false);
        btnChatRemotely.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatRemotelyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnChatLocally)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnChatRemotely)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChatLocally)
                    .addComponent(btnChatRemotely))
                .addContainerGap(179, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChatLocallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLocallyActionPerformed
        // TODO add your handling code here:
        ChatHere ch = new ChatHere(controller, RightPanel);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        RightPanel.add(ch);
        layout.next(RightPanel);
        
    }//GEN-LAST:event_btnChatLocallyActionPerformed

    private void btnChatRemotelyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatRemotelyActionPerformed
        // TODO add your handling code here:
        ChatAndroid cha = new ChatAndroid(controller, RightPanel);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        RightPanel.add(cha);
        layout.next(RightPanel);
    }//GEN-LAST:event_btnChatRemotelyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChatLocally;
    private javax.swing.JButton btnChatRemotely;
    // End of variables declaration//GEN-END:variables
}
