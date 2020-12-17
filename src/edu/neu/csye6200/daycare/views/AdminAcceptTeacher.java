/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import au.com.bytecode.opencsv.CSVReader;
import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.objects.Group;
import edu.neu.csye6200.daycare.objects.Student;
import edu.neu.csye6200.daycare.objects.Teacher;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aayus
 */
public class AdminAcceptTeacher extends javax.swing.JPanel {

    /**
     * Creates new form AdminAcceptStud
     */
     private static DayCareController controller = null;
     private static Group group = null;
     private static List<Teacher> tableLines ;
     private static List<String> immuLines ;
     private FileWriter writer;
     private File file;
     private JPanel RightPanel;
        //SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        //DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
    
     private final String FILE_PATH = "teacher.csv";
     private final String FILE_PATH_temp = "teacherTemp.csv";
     private final String LINE_BREAK = "\n";
    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
     
    public AdminAcceptTeacher(DayCareController controller,JPanel RightPanel) throws IOException {
        initComponents();
        this.controller=controller;
        tableLines = new ArrayList<Teacher>();
        //immuLines= new ArrayList<String>();
        DefaultTableModel dtm = (DefaultTableModel) teacherApprovalTab.getModel();
        dtm.setRowCount(0);
        tableLines = csvToList();
       // immuLines = csvToListImmu();
        displayTable();
        this.RightPanel=RightPanel;
    }
    
    private List<Teacher> csvToList(){
        File file = new File(controller.getTempteacherFileName());
        String line="";
                
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable mode
          while((line=br.readLine())!=null){
              
              String[] teach = line.split(",");
              
             int teacherId = Integer.parseInt(teach[0]);
              String fname = teach[1];
              String lname= teach[2];
              boolean avail = Boolean.parseBoolean(teach[3]);
              String add = teach[4];
              String ph=teach[5];
              String uname= teach[6];
              String pass=teach[7];
//              String fatName = stu[5];
//              String motName = stu[6];
//              String phno = stu[7];
//             Date doj =new SimpleDateFormat("MM/dd/yyyy").parse(stu[8]);
//             Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(stu[9]);
//             String uName = stu[10];
//             String pass = stu[11];
//             String dob = targetFormat.format(dob_uf); 
//             Date dob_uf = originalFormat.parse(stu[9]);
              //LocalDate dob = LocalDate.parse(stu[9], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
             // Student s = new Student(fname,lname,age,add,fatName,motName,phno,doj,studentId,dob,uName,pass);
             Teacher t= new Teacher(fname, lname, teacherId, avail, add, ph, uname, pass);
              tableLines.add(t);
              
          }
            System.out.println(tableLines);
           
            
        }catch(IOException e){
            System.out.println(e);
        }
        return tableLines;
        
    } 
    
    
//    private List<String> csvToListImmu(){
//        File file = new File(controller.getTempImmunizationFileName());
//        String line="";
//                
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            // get the first line
//            // get the columns name from the first line
//            // set columns name to the jtable mode
//          while((line=br.readLine())!=null){
//              
//              String[] stu = line.split(",");
//              int studentId = Integer.parseInt(stu[0]);
//              int hib = Integer.parseInt(stu[1]);
//              int dtab= Integer.parseInt(stu[2]);
//              int mmr = Integer.parseInt(stu[3]);
//              int hepb = Integer.parseInt(stu[4]);
//              int polio = Integer.parseInt(stu[5]);
//              int vari = Integer.parseInt(stu[6]);
//              
//              String val = studentId+","+hib+","+dtab+","+mmr+","+hepb+","+polio+","+vari;
//
//              
//              immuLines.add(val);
//              
//          }
//            System.out.println(immuLines);
//           
//            
//        }catch(IOException e){
//            System.out.println(e);
//        }
//        return immuLines;
//        
//    } 
    
    public void writeTest() throws IOException, ParseException{
         try {
            file = new File(FILE_PATH_temp);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New File Created");
            writer = new FileWriter(file);
        
            actualWrite(); 
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        
        
    }
    
    
//    public void writeTestImmu() throws IOException, ParseException{
//         try {
//            file = new File(FILE_PATH_IMMU);
//            if(file.exists()){
//                file.delete();
//            }
//            file.createNewFile();
//            System.out.println("New File Created");
//            writer = new FileWriter(file);
//        
//            actualWriteImmu(); 
//            
//        }finally{
//            try {
//                writer.flush();
//                writer.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//        }
//        
//        
//    }
    
    
    public void actualWriteImmu() throws IOException{
        if(!immuLines.isEmpty()){
        for(String immu:immuLines){
            
            
             writer.append(immu);
             writer.append(LINE_BREAK);
                   
        }
        }
        displayTable();
    }
    
    
    
    
    public void actualWrite() throws IOException{
        if(!tableLines.isEmpty()){
        for(Teacher teach:tableLines){
            int teachID = teach.getTeacherID();
            String fname= teach.getFirstName();
            String lname= teach.getLastName();
            boolean avail= teach.getisAvailable();
            String addr= teach.getAddress();
            int ph= Integer.parseInt(teach.getPhoneNumber());
          String uName = teach.getuName();
            String pass = teach.getPassword();
            
            
            String lineoutput = teachID + ","+ fname + "," + lname+ ","+ avail + ","+ addr + ","  + ph+","+uName+","+pass ;
            
            
            
             writer.append(lineoutput);
             writer.append(LINE_BREAK);
                   
        }
        }
        displayTable();
    }
    
    public void displayTable() throws IOException{
         //File file = new File(controller.getStudentfilename());
         
         CSVReader reader; 
            try {
//                reader = new CSVReader(new FileReader(controller.getStudentfilename()+".csv"));
//                List myEntries = reader.readAll();
                
                   
            DefaultTableModel dtm = (DefaultTableModel) teacherApprovalTab.getModel();
            dtm.setRowCount(0);
            for (Teacher teach: tableLines)
            {
                Object row[] = new Object[9];
                row[0] =teach ;
                row[1] = teach.getFirstName();
                row[2]= teach.getLastName();
                row[3]=teach.getAddress();
                row[4]=teach.getPhoneNumber();
                
                
                dtm.addRow(row);
            }
                //JTable table = new JTable(myEntries.toArray());
            } catch (Exception ex) {
                Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
            }
        

    }
    
    public void reload(){
         DefaultTableModel model = (DefaultTableModel)teacherApprovalTab.getModel();
         for(int i = 0; i < tableLines.size(); i++)
            {
                String line = tableLines.get(i).toString().trim();
//                String[] dataRow = line.split(",");
//                model.addRow(dataRow);
            }
            
    }
    
    public void delElement(List<Object> tableLines, Object object){
        this.tableLines.remove(object);
          
    }
    
    public void DeleteRow(){
        
        System.out.println("Delete()");
        int selectedRow = teacherApprovalTab.getSelectedRow();
      
        System.out.println(selectedRow);
        if (selectedRow < 0 )
        JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult=JOptionPane.showConfirmDialog(null, "Please Confirm to Delete the selected Student", "Warning", dialogBtn);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Teacher object = (Teacher)teacherApprovalTab.getValueAt(selectedRow,0);

                System.out.println(object);
              
                int studId = object.getTeacherID();
        
                
                tableLines.remove(object);
                
                
                try {
                    writeTest();
                    //writeTestImmu();
                    displayTable();
                } catch (IOException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                }
                       }

                System.out.println(tableLines);

                JOptionPane.showMessageDialog(null, "Selected Student deleted successfully");
                //reload();
            }
        }
    
    
     public void AddRow(){
        
         boolean addTeacherStatus=false;
         
        System.out.println("Delete()");
        int selectedRow = teacherApprovalTab.getSelectedRow();
      
        System.out.println(selectedRow);
        if (selectedRow < 0 )
        JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult=JOptionPane.showConfirmDialog(null, "Please Confirm to Add the selected Student", "Warning", dialogBtn);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Teacher object = (Teacher)teacherApprovalTab.getValueAt(selectedRow,0);

                System.out.println(object);
              
                
                int id = object.getTeacherID();
                
                
                
                
//               
String teacherList = object.getFirstName()+","+object.getLastName()+","+object.getAddress()+","+object.getisAvailable()+","+object.getPhoneNumber()+","+object.getuName()+","+object.getPassword();
       
            try {
                addTeacherStatus = controller.getDayCareObj().enrollTeacherPerm(controller.getTeacherFactoryObj(), teacherList);
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
                
                try {
                    tableLines.remove(object);
                    writeTest();
                    //writeTestImmu();
                    displayTable();
                } catch (IOException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                }
                       }

                System.out.println(tableLines);

                JOptionPane.showMessageDialog(null, "Selected Teacher Accepted successfully");
                //reload();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        teacherApprovalTab = new javax.swing.JTable();
        acceptBtn = new javax.swing.JButton();
        declineBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 237, 246));

        teacherApprovalTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher ID", "First Name", "Last Name", "Address", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(teacherApprovalTab);

        acceptBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/neu/csye6200/daycare/icons/accept.png"))); // NOI18N
        acceptBtn.setText("Accept");
        acceptBtn.setBorderPainted(false);
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        declineBtn.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/decline.png")); // NOI18N
        declineBtn.setText("Decline");
        declineBtn.setBorderPainted(false);
        declineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pending Approval: Teachers");

        backButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        backButton1.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/back.png")); // NOI18N
        backButton1.setText("Back");
        backButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        backButton1.setBorderPainted(false);
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205)
                        .addComponent(acceptBtn)
                        .addGap(231, 231, 231)
                        .addComponent(declineBtn)))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn)
                    .addComponent(declineBtn)
                    .addComponent(backButton1))
                .addContainerGap(247, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        // TODO add your handling code here:
        AddRow();
        reload();
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void declineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineBtnActionPerformed
        // TODO add your handling code here:
        DeleteRow();
        reload();
    }//GEN-LAST:event_declineBtnActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        RightPanel.remove(this);
        CardLayout cardLayout = (CardLayout) RightPanel.getLayout();
        cardLayout.previous(RightPanel);
    }//GEN-LAST:event_backButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton declineBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable teacherApprovalTab;
    // End of variables declaration//GEN-END:variables
}

