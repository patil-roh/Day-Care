/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.daycare.views;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import edu.neu.csye6200.daycare.controller.DayCareController;
import edu.neu.csye6200.daycare.objects.DayCare;
import edu.neu.csye6200.daycare.objects.Student;
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
public class UpdateStudPan extends javax.swing.JPanel {

    /**
     * Creates new form AddStudPan
     */
    private static DayCareController controller = null;
    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private Student st;
    private JPanel jp;
    private boolean upfirst;
    private final String FILE_PATH = "student.csv";
    private static List<Student> tableLines ;
    private static List<String> immuLines ;
    private final String FILE_PATH_IMMU = "Student_Immunization_Record.csv";
    private FileWriter writer;
    private File file;
    private final String LINE_BREAK = "\n";
    AdminPan ap ;

    public static DateFormat getDateFormat() {
        return dateFormat;
    }

    public static void setDateFormat(DateFormat dateFormat) {
        UpdateStudPan.dateFormat = dateFormat;
    }
	
    

    
    public UpdateStudPan(DayCareController controller,Student st,JPanel jp,AdminPan ap,boolean upfirst) {
        initComponents();
        System.out.println("Add student init components complete");
        this.controller = controller;
        tableLines = new ArrayList<Student>();
        tableLines = csvToList();
        immuLines= new ArrayList<String>();
        immuLines = csvToListImmu();
        this.st=st;
        this.jp=jp;
        setForm();
        this.ap=ap;
        this.upfirst=upfirst;
    }
    
    private void setForm(){
        FirstNameField.setText(st.getFirstName());
        LastNameField.setText(st.getLastName());
        DateofBirth.setDate(st.getDateOfBirth());
        MothersNameField.setText(st.getMotherName());
        passTxtField.setText(st.getPass());
        FathersNameField.setText(st.getFatherName());
        AddressField.setText(st.getAddress());
        PhoneField.setText(st.getPhoneNumber());
    }
    
    private List<String> csvToListImmu(){
        File file = new File(FILE_PATH_IMMU);
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
              String motName = stu[5];
              String fatName = stu[6];
              String phno = stu[7];
             Date doj =new SimpleDateFormat("MM/dd/yyyy").parse(stu[8]);
             Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(stu[9]);
             String uName = stu[10];
             String pass = stu[11];
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
           
            String doj = new SimpleDateFormat("MM/dd/yyyy").format(student.getDateOfJoining());
            String dob = new SimpleDateFormat("MM/dd/yyyy").format(student.getDateOfBirth());       
            String uName = student.getuName();
            String pass = student.getPass();
            
            
            String lineoutput = studentId + ","+ fname + "," + lName+ ","+ age + ","+ add + "," + mothername + ","+ fathername + "," + tel + ","
				+ doj + "," + dob+","+ uName +","+ pass;
            
             writer.append(lineoutput);
             writer.append(LINE_BREAK);
                   
        }
       
    }
    
    public int getStudCount(){
        int count =0;
        boolean first = true;
        
        for(Student s:tableLines){
        if(first){
            count= s.getStudentID();
            //JOptionPane.showMessageDialog(HepBComboBox, count);
            first=false;
        }
        count++;
    }
        return count-1;
    }
    
    public void updateCSV(String fileToUpdate) throws IOException {
        boolean addStudentStatus = false;
        boolean fStud = true;
        int firstStud=0;
        String fname = st.getFirstName();
        String lname = st.getLastName();
        Date dob = st.getDateOfBirth();
        String id = String.valueOf(st.getStudentID());
        
        for(Student s: tableLines){
           
            if((s.getFirstName().equalsIgnoreCase(fname))
                && (s.getLastName().equalsIgnoreCase(lname))
                && (s.getDateOfBirth().equals(dob))  
                    ){
                
                tableLines.remove(s);
                firstStud = getStudCount();
                //JOptionPane.showMessageDialog(HepBComboBox, firstStud);
                try {
                    writeTest();
                } catch (IOException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                for(String immu:immuLines){
                    String[] stu = immu.split(",");
                    if(stu[0].equals(id)){
                        immuLines.remove(immu);
                        break;
                    }
                }
                
                try {
                    writeTestImmu();
                } catch (IOException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AdminPan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            String dob2 = dateFormat.format(DateofBirth.getDate());
            String studentList = FirstNameField.getText()+","+LastNameField.getText()+","+dob2+","+AddressField.getText()+","+
            MothersNameField.getText()+","+FathersNameField.getText()+","+PhoneField.getText()
                    +","+st.getuName()+","+passTxtField.getText();
            try {
                
                addStudentStatus = controller.getDayCareObj().enrollStudentPermUp(controller.getStudentFactoryObj(), studentList,(firstStud));
                
            } catch (Exception ex) {
                Logger.getLogger(AddStudPan.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (addStudentStatus == true) {
                //popup successfull
                System.out.println("Updated student successful");
                JOptionPane.showMessageDialog(null, "Student Successfully Added","Success",JOptionPane.INFORMATION_MESSAGE);
                ap.displayTable();
            }
            else{
                //failure pop up
                System.out.println("Update of student failed, try again");
                JOptionPane.showMessageDialog(null, "Student Update Failed","Failed",JOptionPane.INFORMATION_MESSAGE);
            }
            String immunizationRecord = HibComboBox.getSelectedItem().toString()+","+DTAPComboBox.getSelectedItem().toString()+","+HepBComboBox.getSelectedItem().toString()+
            ","+MMRComboBox.getSelectedItem().toString()+","+PolioComboBox.getSelectedItem().toString()+","+jComboBox6.getSelectedItem().toString();

            try {
                controller.getDayCareObj().mapStudentIDToImmunizationDataFromUIPerm(Integer.toString(controller.getStudentFactoryObj().getStudentCount())+","+immunizationRecord);
            } catch (ParseException ex) {
                Logger.getLogger(AddStudPan.class.getName()).log(Level.SEVERE, null, ex);
            }

            FirstNameField.setText("");
            LastNameField.setText("");
            MothersNameField.setText("");
            FathersNameField.setText("");
            AddressField.setText("");
            PhoneField.setText("");
            FirstNameField.setText("");
            LastNameField.setText("");
            MothersNameField.setText("");
            FathersNameField.setText("");
            AddressField.setText("");
            PhoneField.setText("");
                
                
                break;
            }
        }
        
        ap.displayTable();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        MothersNameField = new javax.swing.JTextField();
        FathersNameField = new javax.swing.JTextField();
        AddressField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        DateofBirth = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        passTxtField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        HibCheckBox = new javax.swing.JCheckBox();
        DTAPCheckBox = new javax.swing.JCheckBox();
        MMRCheckBox = new javax.swing.JCheckBox();
        HepBCheckBox = new javax.swing.JCheckBox();
        PolioCheckBox = new javax.swing.JCheckBox();
        VariollaCheckBox = new javax.swing.JCheckBox();
        HibComboBox = new javax.swing.JComboBox<>();
        DTAPComboBox = new javax.swing.JComboBox<>();
        MMRComboBox = new javax.swing.JComboBox<>();
        HepBComboBox = new javax.swing.JComboBox<>();
        PolioComboBox = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1250, 1000));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setBackground(java.awt.SystemColor.activeCaption);
        jLabel1.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("First Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 25));

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mother's Name");

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Father's Name");

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Phone Number");

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Personal Info");

        FirstNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FirstNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        FirstNameField.setPreferredSize(new java.awt.Dimension(80, 25));
        FirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameFieldActionPerformed(evt);
            }
        });
        FirstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FirstNameFieldKeyPressed(evt);
            }
        });

        LastNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        LastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LastNameFieldKeyPressed(evt);
            }
        });

        MothersNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        MothersNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MothersNameFieldActionPerformed(evt);
            }
        });
        MothersNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MothersNameFieldKeyPressed(evt);
            }
        });

        FathersNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FathersNameField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        FathersNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FathersNameFieldKeyPressed(evt);
            }
        });

        AddressField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AddressField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        PhoneField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PhoneField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        PhoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PhoneFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PhoneFieldKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Date of Birth");

        DateofBirth.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        DateofBirth.setName("DateofBirth"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Password");

        passTxtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        passTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTxtFieldActionPerformed(evt);
            }
        });
        passTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passTxtFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passTxtFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(26, 26, 26)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FirstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DateofBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LastNameField)
                                        .addComponent(FathersNameField)
                                        .addComponent(AddressField)
                                        .addComponent(PhoneField)
                                        .addComponent(MothersNameField))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(passTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateofBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MothersNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FathersNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jPanel2.setBackground(new java.awt.Color(246, 237, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(417, 417));

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Immunisation");

        HibCheckBox.setBackground(java.awt.SystemColor.activeCaption);
        HibCheckBox.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        HibCheckBox.setText("Hib");
        HibCheckBox.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0))));
        HibCheckBox.setContentAreaFilled(false);
        HibCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HibCheckBoxActionPerformed(evt);
            }
        });

        DTAPCheckBox.setBackground(java.awt.SystemColor.activeCaption);
        DTAPCheckBox.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        DTAPCheckBox.setText("DTAP");

        MMRCheckBox.setBackground(java.awt.SystemColor.activeCaption);
        MMRCheckBox.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        MMRCheckBox.setText("MMR");
        MMRCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMRCheckBoxActionPerformed(evt);
            }
        });

        HepBCheckBox.setBackground(java.awt.SystemColor.activeCaption);
        HepBCheckBox.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        HepBCheckBox.setText("Hep B");

        PolioCheckBox.setBackground(java.awt.SystemColor.activeCaption);
        PolioCheckBox.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        PolioCheckBox.setText("Polio");
        PolioCheckBox.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        VariollaCheckBox.setBackground(java.awt.SystemColor.activeCaption);
        VariollaCheckBox.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        VariollaCheckBox.setText("Varicella");

        HibComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        HibComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HibComboBoxActionPerformed(evt);
            }
        });

        DTAPComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        MMRComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        HepBComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        PolioComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jLabel9.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Vaccine");

        jLabel10.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Dosage");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DTAPCheckBox)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(HibCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(122, 122, 122)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(VariollaCheckBox))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(MMRCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(279, 279, 279)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PolioCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addGap(366, 366, 366))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(HepBCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HibComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PolioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DTAPComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MMRComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HepBComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HibCheckBox)
                    .addComponent(HibComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DTAPCheckBox)
                    .addComponent(DTAPComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MMRCheckBox)
                    .addComponent(MMRComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HepBCheckBox)
                    .addComponent(HepBComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PolioCheckBox)
                    .addComponent(PolioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VariollaCheckBox)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        backButton.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/back.png")); // NOI18N
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        backButton.setBorderPainted(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("/Users/jaidevmane/NetBeansProjects/DayCare Version Control/aayush new/15 Apr 2020/15 Apr 2020/DayCare/src/edu/neu/csye6200/daycare/icons/update.png")); // NOI18N
        jButton2.setText("Update");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void FirstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFieldActionPerformed

    private void FirstNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstNameFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            FirstNameField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            FirstNameField.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFieldKeyPressed

    private void LastNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LastNameFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            LastNameField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            LastNameField.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldKeyPressed

    private void MothersNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MothersNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MothersNameFieldActionPerformed

    private void MothersNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MothersNameFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            MothersNameField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            MothersNameField.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_MothersNameFieldKeyPressed

    private void FathersNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FathersNameFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            FathersNameField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            FathersNameField.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_FathersNameFieldKeyPressed

    private void PhoneFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneFieldKeyPressed
        char c = evt.getKeyChar();
        if(Character.isDigit(c)||Character.isWhitespace(c)||Character.isISOControl(c))
        {
            PhoneField.setEditable(true);
        }// TODO add your handling code here:
        else
        {
            getToolkit().beep();
            PhoneField.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneFieldKeyPressed

    private void PhoneFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneFieldKeyReleased

    private void HibCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HibCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HibCheckBoxActionPerformed

    private void MMRCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MMRCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MMRCheckBoxActionPerformed

    private void HibComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HibComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HibComboBoxActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
//        MainPage form = new MainPage(controller);
//        form.setVisible(true);
//        close();        // TODO add your handling code here:
        jp.remove(this);
        CardLayout cardLayout = (CardLayout) jp.getLayout();
        cardLayout.previous(jp);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
               

        try {
            updateCSV("student.csv");
            jp.remove(this);
            CardLayout cardLayout = (CardLayout) jp.getLayout();
            cardLayout.previous(jp);
            ap.displayTable();
        } catch (IOException ex) {
            Logger.getLogger(UpdateStudPan.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void passTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTxtFieldActionPerformed

    private void passTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passTxtFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTxtFieldKeyPressed

    private void passTxtFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passTxtFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_passTxtFieldKeyReleased

    private static int StuID = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JCheckBox DTAPCheckBox;
    private javax.swing.JComboBox<String> DTAPComboBox;
    private com.toedter.calendar.JDateChooser DateofBirth;
    private javax.swing.JTextField FathersNameField;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JCheckBox HepBCheckBox;
    private javax.swing.JComboBox<String> HepBComboBox;
    private javax.swing.JCheckBox HibCheckBox;
    private javax.swing.JComboBox<String> HibComboBox;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JCheckBox MMRCheckBox;
    private javax.swing.JComboBox<String> MMRComboBox;
    private javax.swing.JTextField MothersNameField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JCheckBox PolioCheckBox;
    private javax.swing.JComboBox<String> PolioComboBox;
    private javax.swing.JCheckBox VariollaCheckBox;
    private javax.swing.JButton backButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField passTxtField;
    // End of variables declaration//GEN-END:variables
}
