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
import edu.neu.csye6200.daycare.util.FileUtil;
import static edu.neu.csye6200.daycare.views.Login.rightPanel;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aayus
 */
public class AdminPan extends javax.swing.JPanel {

    /**
     * Creates new form AdminPan
     */
    private static DayCareController controller = null;
    private static DriverFrame df = null;
        private static Group group = null;
        private static List<Student> tableLines ;
        private FileWriter writer;
        private File file;
        private JPanel RightPanel;
        private boolean upFirst;
        private final String FILE_PATH_PERM = "student.csv";
        private final String FILE_PATH_DEADLINE = "deadline.csv";
        private static FileUtil fileutil = new FileUtil();
        private static List<String> deadList = new ArrayList<String>(); 
        private static List<Student> permTableLines = new ArrayList<Student>(); ;
        private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        //SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        //DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
    
        private final String FILE_PATH = "student.csv";
        private final String LINE_BREAK = "\n";
    public AdminPan(DayCareController controller,JPanel RightPanel,boolean upFirst,DriverFrame df) throws IOException {
        initComponents();
        this.controller=controller;
        tableLines = new ArrayList<Student>();
        DefaultTableModel dtm = (DefaultTableModel) studentsTable.getModel();
        dtm.setRowCount(0);
        permTableLines = csvToListDead();
        deadList=createDeadList();
        tableLines = csvToList();
        displayTable();
        this.RightPanel=RightPanel;
        this.upFirst=upFirst;
        writeToDeadline();
        this.df = df;
        
    }
    
    private List<Student> csvToListDead(){
        File file = new File(FILE_PATH_PERM);
        String line="";
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
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
              Student s = new Student(fname,lname,age,add,fatName,motName,phno,doj,studentId,dob,uName,pass);
              permTableLines.add(s);
              
          }
            System.out.println(permTableLines);
           
            
        }catch(IOException e){
            System.out.println(e);
        }catch(ParseException s){
            System.out.println(s);
        }
        return permTableLines;
        
    } 
    
     public void writeToDeadline() throws IOException{
        writeDeadlineToFile(deadList);
    }
    
    public List<String> createDeadList(){
        List<String> studentdataList = new ArrayList<String>();
        
        for (Student student : permTableLines) {
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
    
    
    private List<Student> csvToList(){
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
    
    public void actualWrite() throws IOException{
        
        for(Student student:tableLines){
            int studentId = student.getStudentID();
            String fname = student.getFirstName();
            String lName = student.getLastName();
            int age = student.getAge();
            String add = student.getAddress();
            String fathername = student.getFatherName();
            String mothername = student.getMotherName();
            String tel = student.getPhoneNumber();
            String uName = student.getuName();
            String pass = student.getPass();
           
            String doj = new SimpleDateFormat("MM/dd/yyyy").format(student.getDateOfJoining());
            String dob = new SimpleDateFormat("MM/dd/yyyy").format(student.getDateOfBirth());
            
//            System.out.println("*******"+format.parse(student.getDateOfJoining().toString()));
//            Date doj = format.parse(student.getDateOfJoining().toString());
//            Date dob = format.parse(student.getDateOfBirth().toString());
            
            String lineoutput = studentId + ","+ fname + "," + lName+ ","+ age + ","+ add + "," + fathername + ","+ mothername + "," + tel + ","
				+ doj + "," + dob+","+uName+","+pass ;
           
             writer.append(lineoutput);
             writer.append(LINE_BREAK);
                   
        }
        displayTable();
    }
    
    public void displayTable() throws IOException{
         //File file = new File(controller.getStudentfilename());
         
         CSVReader reader; 
            try {
//                reader = new CSVReader(new FileReader(controller.getStudentfilename()+".csv"));
//                List myEntries = reader.readAll();
                
                   
            DefaultTableModel dtm = (DefaultTableModel) studentsTable.getModel();
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
         DefaultTableModel model = (DefaultTableModel)studentsTable.getModel();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminPanJPanel = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        FastForwardBtn = new javax.swing.JButton();
        btnDeleteStudent = new javax.swing.JButton();
        btnUpdateStudents = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        acceptStudentBtn = new javax.swing.JButton();
        acceptTeachersBtn = new javax.swing.JButton();
        TrackAnnualRegistration1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1250, 1000));

        adminPanJPanel.setBackground(new java.awt.Color(255, 255, 255));
        adminPanJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)), "Administrator", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 25))); // NOI18N
        adminPanJPanel.setPreferredSize(new java.awt.Dimension(1200, 1000));

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/back.png")); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnBack.setBorderPainted(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        FastForwardBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        FastForwardBtn.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/fast-forward.png")); // NOI18N
        FastForwardBtn.setText("Fast Forward (6 Months)");
        FastForwardBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        FastForwardBtn.setBorderPainted(false);
        FastForwardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FastForwardBtnActionPerformed(evt);
            }
        });

        btnDeleteStudent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDeleteStudent.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/delete.png")); // NOI18N
        btnDeleteStudent.setText("Delete Student");
        btnDeleteStudent.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnDeleteStudent.setBorderPainted(false);
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });

        btnUpdateStudents.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdateStudents.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/update.png")); // NOI18N
        btnUpdateStudents.setText("Update Student");
        btnUpdateStudents.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnUpdateStudents.setBorderPainted(false);
        btnUpdateStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentsActionPerformed(evt);
            }
        });

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Address", "Father's Name", "Mother's Name", "Telephone", "DOJ", "DOB"
            }
        ));
        jScrollPane1.setViewportView(studentsTable);

        acceptStudentBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        acceptStudentBtn.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/student.png")); // NOI18N
        acceptStudentBtn.setText("Accept Students");
        acceptStudentBtn.setBorderPainted(false);
        acceptStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptStudentBtnActionPerformed(evt);
            }
        });

        acceptTeachersBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        acceptTeachersBtn.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/teacher.png")); // NOI18N
        acceptTeachersBtn.setText("Accept Teachers");
        acceptTeachersBtn.setBorderPainted(false);
        acceptTeachersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptTeachersBtnActionPerformed(evt);
            }
        });

        TrackAnnualRegistration1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TrackAnnualRegistration1.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/track.png")); // NOI18N
        TrackAnnualRegistration1.setText("Track Annual Registration");
        TrackAnnualRegistration1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        TrackAnnualRegistration1.setBorderPainted(false);
        TrackAnnualRegistration1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrackAnnualRegistration1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminPanJPanelLayout = new javax.swing.GroupLayout(adminPanJPanel);
        adminPanJPanel.setLayout(adminPanJPanelLayout);
        adminPanJPanelLayout.setHorizontalGroup(
            adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(adminPanJPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteStudent)
                    .addComponent(btnUpdateStudents))
                .addGap(88, 88, 88)
                .addGroup(adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptTeachersBtn)
                    .addComponent(acceptStudentBtn))
                .addGap(91, 91, 91)
                .addGroup(adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TrackAnnualRegistration1)
                    .addComponent(FastForwardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 191, Short.MAX_VALUE))
        );
        adminPanJPanelLayout.setVerticalGroup(
            adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanJPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanJPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBack))
                    .addGroup(adminPanJPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteStudent)
                            .addComponent(acceptTeachersBtn)
                            .addComponent(TrackAnnualRegistration1))))
                .addGap(18, 18, 18)
                .addGroup(adminPanJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptStudentBtn)
                    .addComponent(FastForwardBtn)
                    .addComponent(btnUpdateStudents))
                .addGap(200, 200, 200))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(adminPanJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminPanJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentsActionPerformed
        System.out.println("Update..()");     
        // TODO add your handling code here:
        int selectedRow = studentsTable.getSelectedRow();
        if (selectedRow < 0 )
        JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            Student student = (Student)studentsTable.getValueAt(selectedRow,0);
            UpdateStudPan upd = new UpdateStudPan(controller,student,RightPanel,this,upFirst);
            CardLayout layout = (CardLayout) rightPanel.getLayout();
            rightPanel.add(upd);
            layout.next(rightPanel);
           
        }
        
        
    }//GEN-LAST:event_btnUpdateStudentsActionPerformed

    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
        System.out.println("Delete()");
        int selectedRow = studentsTable.getSelectedRow();
        
        System.out.println(selectedRow);
        if (selectedRow < 0 )
        JOptionPane.showMessageDialog(null, "Please select a row");
        else
        {
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult=JOptionPane.showConfirmDialog(null, "Please Confirm to Delete the selected Student", "Warning", dialogBtn);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                Student object = (Student)studentsTable.getValueAt(selectedRow,0);

                System.out.println(object);
              
                tableLines.remove(object);
                
                try {
                    writeTest();
                    displayTable();
                } catch (IOException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                System.out.println(tableLines);

                

                JOptionPane.showMessageDialog(null, "Selected Student deleted successfully");
               
            }
        }

      
    }//GEN-LAST:event_btnDeleteStudentActionPerformed

    private void FastForwardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FastForwardBtnActionPerformed
         System.out.println("Increase BY 6 months");
        List<String> fastForList = new ArrayList<String>();
        File file = new File(FILE_PATH_DEADLINE);
        String line="";
                
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
          while((line=br.readLine())!=null){
              
              
              String[] stu = line.split(",");
              
              int updatedDead = Integer.parseInt(stu[5]);
              
              if(updatedDead-180 < 0){
                  updatedDead = 0;
              }else{
              updatedDead = updatedDead-180;
              }
              
              
              String fs = stu[0]+","+stu[1]+","+stu[2]+","+stu[3]+","+stu[4]+","+updatedDead;
              fastForList.add(fs);
              
          }
          }catch(IOException e){
            System.out.println(e);
        }
        try {
            writeDeadlineToFile(fastForList);
            JOptionPane.showMessageDialog(null, "All Students Fast Forwarded by 180 days");
        } catch (IOException ex) {
            Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                df.startDeadCheckAdmin();
            } catch (InterruptedException ex) {
                Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       // TODO add your handling code here:
    }//GEN-LAST:event_FastForwardBtnActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) studentsTable.getModel();
        dtm.setRowCount(0);
        
        RightPanel.remove(this);
        CardLayout cardLayout = (CardLayout) RightPanel.getLayout();
        cardLayout.previous(RightPanel);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void acceptStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptStudentBtnActionPerformed
        // TODO add your handling code here:
        AdminAcceptStud aas;
        try {
            aas = new AdminAcceptStud(controller,RightPanel);
            CardLayout layout = (CardLayout) RightPanel.getLayout();
            RightPanel.add(aas);
        layout.next(RightPanel);
        } catch (IOException ex) {
            Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_acceptStudentBtnActionPerformed

    private void acceptTeachersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptTeachersBtnActionPerformed
        // TODO add your handling code here:
        AdminAcceptTeacher aas;
        try {
            aas = new AdminAcceptTeacher(controller,RightPanel);
            CardLayout layout = (CardLayout) RightPanel.getLayout();
            RightPanel.add(aas);
        layout.next(RightPanel);
        } catch (IOException ex) {
            Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_acceptTeachersBtnActionPerformed

    private void TrackAnnualRegistration1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrackAnnualRegistration1ActionPerformed
        //        AnnualRegistration AR = new AnnualRegistration(controller);
        //        AR.setVisible(true);

        AnnualRegPanel arp;
        try {
            arp = new AnnualRegPanel(controller,RightPanel);
            CardLayout layout = (CardLayout) RightPanel.getLayout();
            RightPanel.add(arp);
            layout.next(RightPanel);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_TrackAnnualRegistration1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FastForwardBtn;
    private javax.swing.JButton TrackAnnualRegistration1;
    private javax.swing.JButton acceptStudentBtn;
    private javax.swing.JButton acceptTeachersBtn;
    private javax.swing.JPanel adminPanJPanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnUpdateStudents;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentsTable;
    // End of variables declaration//GEN-END:variables
}
