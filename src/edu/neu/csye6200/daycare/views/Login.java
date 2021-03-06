/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.objects.Student;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jaidevmane
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    private static DayCareController controller = null;
    private static boolean loggedIn;
    public DriverFrame df;
    //public LoginPage lp = new LoginPage(rightPanel);
    public static JPanel rightPanel;
   
    
    public static DayCareController getController() {
		return controller;
	}

	public static void setController(DayCareController controller) {
		Login.controller = controller;
	}
  
    
    
    public Login(JPanel rightPanel, DriverFrame df,DayCareController controller) throws Exception {
        initComponents();
        System.out.println("Init components complete");
        this.rightPanel = rightPanel;
        this.df=df;
        setController(controller);
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
        AdminLoginButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UserNameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        AdminLoginButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        AdminLoginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminLoginButton.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/login title.png")); // NOI18N
        AdminLoginButton.setText(" Login");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");

        UserNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        UserNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserNameFieldFocusGained(evt);
            }
        });
        UserNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserNameFieldKeyPressed(evt);
            }
        });

        PasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/exit main.png")); // NOI18N
        jButton1.setText("Exit");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton1.setBorderPainted(false);
        jButton1.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/reset.png")); // NOI18N
        jButton2.setText("Reset");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/login.png")); // NOI18N
        jButton3.setText("Login");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(AdminLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(PasswordField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(AdminLoginButton)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void UserNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserNameFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||(!Character.isWhitespace(c))||Character.isISOControl(c)||Character.isDigit(c))
        {
            UserNameField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            UserNameField.setEditable(false);
        }
    }//GEN-LAST:event_UserNameFieldKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PasswordField.setText(null);
        UserNameField.setText(null);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String username = UserNameField.getText();
        String password = PasswordField.getText();
        boolean there=false;

        if (password.equals("admin")&&username.equals("admin"))
        {

            //MainPage form = new MainPage(controller);
            //form.setVisible(true);
            UserNameField.setText("");
            PasswordField.setText("");
            loggedIn = true;
            df.setBtns(loggedIn,"admin");
            df.setLbl("Welcome "+"\n"+" Admin");
            successPage();
            try {
                df.startDeadCheckAdmin();
            } catch (InterruptedException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            there=true;
        }
        else
        {
            File file = new File(controller.getStudentfilename());
            String line="";
                
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable mode
                while((line=br.readLine())!=null){
              
                String[] stu = line.split(",");
                int studentId = Integer.parseInt(stu[0]);
                String fname = stu[1];
                String lname= stu[2];
              
                String uName = stu[10];
                String pass = stu[11];
             
                if(username.equals(uName) && password.equals(pass)){
                    UserNameField.setText("");
                    PasswordField.setText("");
                    loggedIn = true;
                    df.setBtns(loggedIn,"student");
                    df.setLbl("Welcome "+ fname+ " \n "+ lname);
                    try {
                df.startDeadCheckStu(fname, lname, stu[0]);
                } catch (InterruptedException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                    successPage();
                    there=true;
                }
                
                /************************Teacher Login*************************************/
                File file1 = new File(controller.getTeacherFileName());
                BufferedReader brt = new BufferedReader(new FileReader(file1));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable mode
                while((line=brt.readLine())!=null){
              
                String[] teacher = line.split(",");
                int teacherId = Integer.parseInt(teacher[0]);
                String teacherfname = teacher[1];
                String teacherlname= teacher[2];
              
                String teacheruName = teacher[6];
                String teacherpass = teacher[7];
             
                if(username.equals(teacheruName) && password.equals(teacherpass)){
                    UserNameField.setText("");
                    PasswordField.setText("");
                    loggedIn = true;
                    df.setBtns(loggedIn,"teacher");
                    df.setLbl("Welcome "+ teacherfname+ " \n "+ teacherlname);
                    successPage();
                    there=true;
                }
            
             
             if(there){
                 break;
             }
//             String dob = targetFormat.format(dob_uf); 
//             Date dob_uf = originalFormat.parse(stu[9]);
              //LocalDate dob = LocalDate.parse(stu[9], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            
                }} 
        }catch(IOException e){
            System.out.println(e);
        }
        
        
    }       
            if(!there){
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Please Enter Valid Details" );
            }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void successPage(){
        SuccessScreen ss = new SuccessScreen();
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        rightPanel.add(ss);
        layout.next(rightPanel);
    }
    
    private void UserNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserNameFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameFieldFocusGained

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminLoginButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
