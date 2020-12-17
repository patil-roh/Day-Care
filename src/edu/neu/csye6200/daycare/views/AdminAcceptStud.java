/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import au.com.bytecode.opencsv.CSVReader;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.objects.Group;
import edu.neu.csye6200.daycare.objects.Student;
import edu.neu.csye6200.daycare.util.FileUtil;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
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
public class AdminAcceptStud extends javax.swing.JPanel {

    /**
     * Creates new form AdminAcceptStud
     */
     private static DayCareController controller = null;
     private static Group group = null;
     private static List<Student> tableLines ;
     private static List<String> immuLines ;
     private static List<String> deadList ;
     private FileWriter writer;
     private static FileUtil fileutil = new FileUtil();
     private File file;
     private JPanel RightPanel;
        //SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        //DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
    
     private final String FILE_PATH = "studentTemp.csv";
     private final String FILE_PATH_DEADLINE = "deadline.csv";
     private final String FILE_PATH_IMMU = "Student_Immunization_Record_temp.csv";
     private final String LINE_BREAK = "\n";
    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
     
    public AdminAcceptStud(DayCareController controller,JPanel RightPanel) throws IOException {
        initComponents();
        this.controller=controller;
        tableLines = new ArrayList<Student>();
        immuLines= new ArrayList<String>();
        deadList = new ArrayList<String>();
        DefaultTableModel dtm = (DefaultTableModel) studentsApprovalTab.getModel();
        dtm.setRowCount(0);
        tableLines = csvToList();
        immuLines = csvToListImmu();
        deadList=createDeadList();
        displayTable();
        this.RightPanel=RightPanel;
        writeToDeadline();
    }
    
    public void writeToDeadline() throws IOException{
        writeDeadlineToFile(deadList);
    }
    
    public List<String> createDeadList(){
        List<String> studentdataList = new ArrayList<String>();
        
        for (Student student : tableLines) {
					String studentData = "";
					int daysPending =0;
					LocalDateTime enrollmentDueDate =(((fileutil.convertToLocalDateTimeViaInstant(student.getDateOfJoining()).plusYears(1))));
					Calendar c = Calendar.getInstance();
					c.setTime(Date.from((enrollmentDueDate).atZone(ZoneId.systemDefault()).toInstant()));
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					int date = c.get(Calendar.DATE);
					LocalDate l1 = LocalDate.of(year, month, date);
					Period age = Period.between(LocalDate.now(), l1);
							if(age.getYears()!=0) {
								daysPending = daysPending + (age.getYears()*365);
							}
							if(age.getMonths()!=0) {
								daysPending = daysPending + age.getMonths()*30;
							}
							daysPending +=age.getDays();
							System.out.println("period age is "+daysPending);
					
					
					studentData = student.getStudentID()+","+student.getFirstName()+","+student.getLastName()+","+dateFormat.format(student.getDateOfJoining())+","+
							dateFormat.format(Date.from((enrollmentDueDate).atZone(ZoneId.systemDefault()).toInstant()))+","+daysPending;
					System.out.println("studentData is "+studentData);
					studentdataList.add(studentData);
				}
        return studentdataList;
			
    }
    
    private List<Student> csvToList(){
        File file = new File(controller.getTempStudentFileName());
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
              int age = Integer.parseInt(stu[3]);
              String add = stu[4];
              String fatName = stu[5];
              String motName = stu[6];
              String phno = stu[7];
             Date doj =new SimpleDateFormat("MM/dd/yyyy").parse(stu[8]);
             Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(stu[9]);
             String uName = stu[10];
             String pass = stu[11];
//             String dob = targetFormat.format(dob_uf); 
//             Date dob_uf = originalFormat.parse(stu[9]);
              //LocalDate dob = LocalDate.parse(stu[9], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
              Student s = new Student(fname,lname,age,add,fatName,motName,phno,doj,studentId,dob,uName,pass);
              tableLines.add(s);
              
          }
            System.out.println(tableLines);
           
            
        }catch(IOException e){
            System.out.println(e);
        }catch(ParseException s){
            System.out.println(s);
        }
        return tableLines;
        
    } 
    
    
    private List<String> csvToListImmu(){
        File file = new File(controller.getTempImmunizationFileName());
        String line="";
                
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable mode
          while((line=br.readLine())!=null){
              
              String[] stu = line.split(",");
              int studentId = Integer.parseInt(stu[0]);
              int hib = Integer.parseInt(stu[1]);
              int dtab= Integer.parseInt(stu[2]);
              int mmr = Integer.parseInt(stu[3]);
              int hepb = Integer.parseInt(stu[4]);
              int polio = Integer.parseInt(stu[5]);
              int vari = Integer.parseInt(stu[6]);
              
              String val = studentId+","+hib+","+dtab+","+mmr+","+hepb+","+polio+","+vari;

              
              immuLines.add(val);
              
          }
            System.out.println(immuLines);
           
            
        }catch(IOException e){
            System.out.println(e);
        }
        return immuLines;
        
    } 
    
    public void writeTest() throws IOException, ParseException{
         try {
            file = new File(FILE_PATH);
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
    
    
    public void writeTestImmu() throws IOException, ParseException{
         try {
            file = new File(FILE_PATH_IMMU);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New File Created");
            writer = new FileWriter(file);
        
            actualWriteImmu(); 
            
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
        for(Student student:tableLines){
            int studentId = student.getStudentID();
            String fname = student.getFirstName();
            String lName = student.getLastName();
            int age = student.getAge();
            String add = student.getAddress();
            String fathername = student.getFatherName();
            String mothername = student.getMotherName();
            String tel = student.getPhoneNumber();
           
            String doj = new SimpleDateFormat("MM/dd/yyyy").format(student.getDateOfJoining());
            String dob = new SimpleDateFormat("MM/dd/yyyy").format(student.getDateOfBirth());
            
            String uName = student.getuName();
            String pass = student.getPass();
            
            
            String lineoutput = studentId + ","+ fname + "," + lName+ ","+ age + ","+ add + "," + fathername + ","+ mothername + "," + tel + ","
				+ doj + "," + dob+","+ uName +","+ pass;
            
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
                
                   
            DefaultTableModel dtm = (DefaultTableModel) studentsApprovalTab.getModel();
            dtm.setRowCount(0);
            for (Student student: tableLines)
            {
                Object row[] = new Object[9];
                row[0] =student ;
                row[1] = student.getFirstName();
                row[2]=student.getLastName();
                row[3]=student.getAddress();
                row[4]=student.getFatherName();
                row[5]=student.getMotherName();
                row[6]=student.getPhoneNumber();
                row[7]=student.getDateOfJoining();
                row[8] = student.getDateOfBirth();
                
                dtm.addRow(row);
            }
                //JTable table = new JTable(myEntries.toArray());
            } catch (Exception ex) {
                Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
            }
        

    }
    
    public void reload(){
         DefaultTableModel model = (DefaultTableModel)studentsApprovalTab.getModel();
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
        int selectedRow = studentsApprovalTab.getSelectedRow();
      
        System.out.println(selectedRow);
        if (selectedRow < 0 )
        JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult=JOptionPane.showConfirmDialog(null, "Please Confirm to Delete the selected Student", "Warning", dialogBtn);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Student object = (Student)studentsApprovalTab.getValueAt(selectedRow,0);

                System.out.println(object);
              
                int studId = object.getStudentID();
                
                for(String lines:immuLines){
                    String[] sp = lines.split(",");
                    if(Integer.parseInt(sp[0])== studId){
                        immuLines.remove(lines);
                        break;
                    }
                }
                System.out.println(immuLines);
                tableLines.remove(object);
                
                
                try {
                    writeTest();
                    writeTestImmu();
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
        
         boolean addStudentStatus=false;
         
        System.out.println("Delete()");
        int selectedRow = studentsApprovalTab.getSelectedRow();
      
        System.out.println(selectedRow);
        if (selectedRow < 0 )
        JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult=JOptionPane.showConfirmDialog(null, "Please Confirm to Add the selected Student", "Warning", dialogBtn);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Student object = (Student)studentsApprovalTab.getValueAt(selectedRow,0);

                System.out.println(object);
              
                
                int id = object.getStudentID();
                
                
                
                
                String studentList = object.getFirstName()+","+object.getLastName()+","+dateFormat.format(object.getDateOfBirth())+","+object.getAddress()+","+
            object.getFatherName()+","+object.getMotherName()+","+object.getPhoneNumber()
                    +","+object.getuName()+","+object.getPass();
            try {
                addStudentStatus = controller.getDayCareObj().enrollStudentPerm(controller.getStudentFactoryObj(), studentList);
            } catch (Exception ex) {
                Logger.getLogger(AddStudPan.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (addStudentStatus) {
                //popup successfull
                System.out.println("Add student successful");
                JOptionPane.showMessageDialog(null, "Student Successfully Added","Success",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                //failure pop up
                System.out.println("Add student failed, try again");
                JOptionPane.showMessageDialog(null, "Student Addition Failed","Failed",JOptionPane.INFORMATION_MESSAGE);
            }
            
            String immunizationRecord="";
            
            for(String lines:immuLines){
                    String[] sp = lines.split(",");
                    if(Integer.parseInt(sp[0])== id){
                     
                        immunizationRecord = sp[1]
                                +","+sp[2]
                                +","+sp[3]
                                +","+sp[4]
                                +","+sp[5]
                                +","+sp[6];
                        
                        break;
                    }
            }
            try {
                controller.getDayCareObj().mapStudentIDToImmunizationDataFromUIPerm
                (Integer.toString(controller.getStudentFactoryObj().getStudentCount())+","+immunizationRecord);
                
            } catch (ParseException ex) {
                Logger.getLogger(AddStudPan.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                 for(String lines:immuLines){
                    String[] sp = lines.split(",");
                    if(Integer.parseInt(sp[0])== id){
                        immuLines.remove(lines);
                        break;
                    }
                }
                System.out.println(immuLines);
                tableLines.remove(object);
                
                try {
                    writeTest();
                    writeTestImmu();
                    displayTable();
                } catch (IOException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                }
                       }

                System.out.println(tableLines);

                JOptionPane.showMessageDialog(null, "Selected Student Accepted successfully");
                //reload();
            }
        }
     
     public void writeDeadlineToFile(List<String> studentData) throws IOException{
          try {
            file = new File(FILE_PATH_DEADLINE);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New File Created");
            writer = new FileWriter(file);
        
            actualWriteDeadline(studentData); 
            
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
     
     public void actualWriteDeadline(List<String> studentData) throws IOException{
         if(!studentData.isEmpty()){
        for(String dead:studentData){
            
            
             writer.append(dead);
             writer.append(LINE_BREAK);
                   
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

        jScrollPane1 = new javax.swing.JScrollPane();
        studentsApprovalTab = new javax.swing.JTable();
        acceptBtn = new javax.swing.JButton();
        declineBtn = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 237, 246));

        studentsApprovalTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Address", "Father's Name", "Mother's Name", "Telephone", "DOJ", "DOB"
            }
        ));
        jScrollPane1.setViewportView(studentsApprovalTab);

        acceptBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/neu/csye6200/daycare/icons/accept.png"))); // NOI18N
        acceptBtn.setText("Accept");
        acceptBtn.setBorderPainted(false);
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        declineBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/neu/csye6200/daycare/icons/decline.png"))); // NOI18N
        declineBtn.setText("Decline");
        declineBtn.setBorderPainted(false);
        declineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineBtnActionPerformed(evt);
            }
        });

        backButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        backButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/neu/csye6200/daycare/icons/back.png"))); // NOI18N
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
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addComponent(acceptBtn)
                .addGap(281, 281, 281)
                .addComponent(declineBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn)
                    .addComponent(declineBtn)
                    .addComponent(backButton1))
                .addContainerGap(164, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        // TODO add your handling code here:
        AddRow();
        reload();
        List<String> studentData = new ArrayList<String>();
        studentData = createDeadList();
         try {
             writeDeadlineToFile(studentData);
         } catch (IOException ex) {
             Logger.getLogger(AdminAcceptStud.class.getName()).log(Level.SEVERE, null, ex);
         }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentsApprovalTab;
    // End of variables declaration//GEN-END:variables
}

