/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import edu.neu.csye6200.daycare.controller.DayCareController;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aayus
 */
public class AddTeaPan extends javax.swing.JPanel {

    /**
     * Creates new form AddTeaPan
     */
    private static DayCareController controller = null;
    private JPanel RightPanel;
    
    public AddTeaPan(DayCareController controller, JPanel RightPanel) {
        initComponents();
        this.controller=controller;
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

        jPanel1 = new javax.swing.JPanel();
        TeacherFirstName = new javax.swing.JLabel();
        TeacherLastName = new javax.swing.JLabel();
        availibility = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        Phone = new javax.swing.JLabel();
        TeacherFirstNameField = new javax.swing.JTextField();
        TeacherLastNameField = new javax.swing.JTextField();
        TeacherAddressField = new javax.swing.JTextField();
        TeacherPhoneField = new javax.swing.JTextField();
        AvailibilityComboBox = new javax.swing.JComboBox<>();
        Save = new javax.swing.JButton();
        Phone1 = new javax.swing.JLabel();
        uNameTextField = new javax.swing.JTextField();
        Phone2 = new javax.swing.JLabel();
        passwordTxtField = new javax.swing.JTextField();
        backButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 1000));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)), "Add Teacher", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 3, 20))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 1000));

        TeacherFirstName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TeacherFirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TeacherFirstName.setText("First Name");

        TeacherLastName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        TeacherLastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TeacherLastName.setText("Last Name");

        availibility.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        availibility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availibility.setText("Availibility");

        Address.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Address.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Address.setText("Address");

        Phone.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Phone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Phone.setText("Phone");

        TeacherFirstNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TeacherFirstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TeacherFirstNameFieldKeyPressed(evt);
            }
        });

        TeacherLastNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TeacherLastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TeacherLastNameFieldKeyPressed(evt);
            }
        });

        TeacherAddressField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TeacherPhoneField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TeacherPhoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TeacherPhoneFieldKeyPressed(evt);
            }
        });

        AvailibilityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        AvailibilityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailibilityComboBoxActionPerformed(evt);
            }
        });

        Save.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/neu/csye6200/daycare/icons/save.png"))); // NOI18N
        Save.setText("Save");
        Save.setBorderPainted(false);
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Phone1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Phone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Phone1.setText("User Name");

        uNameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        uNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uNameTextFieldKeyPressed(evt);
            }
        });

        Phone2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Phone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Phone2.setText("Password");

        passwordTxtField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTxtFieldKeyPressed(evt);
            }
        });

        backButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        backButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/neu/csye6200/daycare/icons/back.png"))); // NOI18N
        backButton1.setText("Back");
        backButton1.setBorderPainted(false);
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(availibility, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TeacherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TeacherFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TeacherFirstNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TeacherLastNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AvailibilityComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(TeacherAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Phone1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Phone2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TeacherPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(306, 306, 306))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281)
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TeacherFirstName)
                    .addComponent(TeacherFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TeacherLastName)
                    .addComponent(TeacherLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availibility)
                    .addComponent(AvailibilityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Address)
                    .addComponent(TeacherAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Phone)
                    .addComponent(TeacherPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Phone1)
                    .addComponent(uNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Phone2)
                    .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(backButton1))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TeacherFirstNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeacherFirstNameFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            TeacherFirstNameField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            TeacherFirstNameField.setEditable(false);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_TeacherFirstNameFieldKeyPressed

    private void TeacherLastNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeacherLastNameFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            TeacherLastNameField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            TeacherLastNameField.setEditable(false);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_TeacherLastNameFieldKeyPressed

    private void TeacherPhoneFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeacherPhoneFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isDigit(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            TeacherPhoneField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            TeacherPhoneField.setEditable(false);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_TeacherPhoneFieldKeyPressed

    private void AvailibilityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailibilityComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AvailibilityComboBoxActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        boolean addTeacherStatus = false;
        boolean availibility = false;
        if (TeacherFirstNameField.getText().equals("")||TeacherLastNameField.getText().equals("")||TeacherAddressField.getText().equals("")||TeacherPhoneField.getText().equals(""))
        {
            System.out.println("All Fields Are Compulsory");
        }//
        else
        {
            System.out.println("First Name:"+" "+TeacherFirstNameField.getText());
            System.out.println("Last Name:"+" "+TeacherLastNameField.getText());
            System.out.println("Address:"+" "+TeacherAddressField.getText());
            System.out.println("Availibility:"+" "+AvailibilityComboBox.getSelectedItem());
            System.out.println("Phone:"+" "+TeacherPhoneField.getText());
            if (AvailibilityComboBox.getSelectedItem() == "Yes") {
                availibility = true;
                System.out.println("Setting availibility true");
            }
            String teacherList = TeacherFirstNameField.getText()+","+TeacherLastNameField.getText()+","+TeacherAddressField.getText()+","+
            availibility+","+TeacherPhoneField.getText()+","+uNameTextField.getText()+","+passwordTxtField.getText();
            try {
                addTeacherStatus = controller.getDayCareObj().enrollTeacher(controller.getTeacherFactoryObj(), teacherList);
            } catch (Exception ex) {
                Logger.getLogger(AddTeaPan.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (addTeacherStatus == true) {
                //popup successfull
                System.out.println("Add teacher successful");
                JOptionPane.showMessageDialog(null, "Teacher Successfully Added","Success",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                //failure pop up
                System.out.println("Add teacher failed, try again");
                JOptionPane.showMessageDialog(null, "Teacher Addition failed","Failed",JOptionPane.INFORMATION_MESSAGE);
            }
            TeacherFirstNameField.setText("");
            TeacherLastNameField.setText("");
            TeacherAddressField.setText("");
            TeacherPhoneField.setText("");

        }

    }//GEN-LAST:event_SaveActionPerformed

    private void uNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uNameTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_uNameTextFieldKeyPressed

    private void passwordTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTxtFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtFieldKeyPressed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        RightPanel.remove(this);
        CardLayout cardLayout = (CardLayout) RightPanel.getLayout();
        cardLayout.previous(RightPanel);
    }//GEN-LAST:event_backButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JComboBox<String> AvailibilityComboBox;
    private javax.swing.JLabel Phone;
    private javax.swing.JLabel Phone1;
    private javax.swing.JLabel Phone2;
    private javax.swing.JButton Save;
    private javax.swing.JTextField TeacherAddressField;
    private javax.swing.JLabel TeacherFirstName;
    private javax.swing.JTextField TeacherFirstNameField;
    private javax.swing.JLabel TeacherLastName;
    private javax.swing.JTextField TeacherLastNameField;
    private javax.swing.JTextField TeacherPhoneField;
    private javax.swing.JLabel availibility;
    private javax.swing.JButton backButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passwordTxtField;
    private javax.swing.JTextField uNameTextField;
    // End of variables declaration//GEN-END:variables
}
