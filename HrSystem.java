import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class  HrSystem extends JFrame implements ActionListener{//extending from the jframe class and implementing the ActionListener interface
    Container con = getContentPane();
    JButton b,b1,b2,b3;
    JTextField t1;
    JLabel l,heading;
    JScrollPane scrollPane;
    DefaultListModel listModel;
    Employees[] employees=new Employees[50];//creating a new employees array
    JComboBox cmbTitlesList,cmbCitiesList;
 


   public HrSystem() throws Exception{
      
       
      t1=new JTextField(20); 
      b = new JButton("Show all Employees");
      b1 = new JButton("Display females Only");
      b2 = new JButton("Search Employee");
      b3 = new JButton("Display Employees and Net Salaries");
      l= new JLabel("Result");
      heading= new JLabel("HUMAN RESOURCE SYSTEM");
      heading.setFont(new Font("Times New Roman", Font.BOLD, 95));//SETTING THE HEADING
      String[] titles={"marketing executives","Human Resources Officers & Accounts Officers","Temp Staff","Management Team","Support staff"};
      cmbTitlesList=new JComboBox(titles);
      String[] cities={"Gaborone","Kanye","Kasane","Maun","Mahalapye"};
      cmbCitiesList=new JComboBox(cities);

      
      
      try {
            Scanner inFile=new Scanner(new File("employees.txt"));
            String  line;
            int i=0;
            int employeeId;
            String fname;
            String lname;
            String dob;
            String gender;
            String address;
            String titleOfEmp;
            String dateHired;
            String department;
            double hoursWorked;
            double rateOfPay;
            int leaveDays;
            double carAllowance;
            double monthlyGratuity;
            double taxRate;
           
            
           
            while (inFile.hasNextLine() && i<employees.length) { //loop for going through  every line in file
                line = inFile.nextLine();
                employees[i]=new Employees();
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");// using , as a delimiter to read each individual item as a token
                while (stringTokenizer.hasMoreElements()) { //loop for getting each token
                    employeeId=Integer.parseInt(stringTokenizer.nextElement().toString());
                    fname=stringTokenizer.nextElement().toString();
                    lname=stringTokenizer.nextElement().toString();
                    dob=stringTokenizer.nextElement().toString();
                    gender=stringTokenizer.nextElement().toString();
                    address=stringTokenizer.nextElement().toString();
                    titleOfEmp=stringTokenizer.nextElement().toString();
                    dateHired=stringTokenizer.nextElement().toString();
                    department=stringTokenizer.nextElement().toString();
                    hoursWorked=Double.parseDouble(stringTokenizer.nextElement().toString());
                    rateOfPay=Double.parseDouble(stringTokenizer.nextElement().toString());
                    leaveDays=Integer.parseInt(stringTokenizer.nextElement().toString());
                    carAllowance=Double.parseDouble(stringTokenizer.nextElement().toString());
                    monthlyGratuity=Double.parseDouble(stringTokenizer.nextElement().toString());
                    taxRate=Double.parseDouble(stringTokenizer.nextElement().toString());
                    
                    //getting the data in the employees array
                    employees[i].setEmployeeId(employeeId);
                    employees[i].setFname(fname);
                    employees[i].setLname(lname);
                    employees[i].setDob(dob);
                    employees[i].setGender(gender);
                    employees[i].setAddress(address);
                    employees[i].setTitleOfEmp(titleOfEmp);
                    employees[i].setDateHired(dateHired);
                    employees[i].setDepartment(department);
                    employees[i].setHoursWorked(hoursWorked);
                    employees[i].setRateOfPay(rateOfPay);
                    employees[i].setLeaveDays(leaveDays);
                    employees[i].setCarAllowance(carAllowance);
                    employees[i].setMonthlyGratuity(monthlyGratuity);
                    employees[i].setTaxRate(taxRate);                                   
                }
                i++;
              }
                
              
               listModel = new DefaultListModel(); //new listModel created
               JList list=new JList(listModel);
               Font defaultListFont = list.getFont();
               list.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
               scrollPane = new JScrollPane(list);
               scrollPane.setPreferredSize(new Dimension(930, 500));
               
               
                   
               } catch (IOException e) {
                  e.printStackTrace();
        }
      //elements being added so that they can be displayed
       con.add(heading);
      con.add(b);
      con.add(b1); 
      con.add(cmbTitlesList);  
      con.add(cmbCitiesList); 
      con.add(t1);
      con.add(b2);
      con.add(b3);
      b.addActionListener(this);
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      cmbTitlesList.setSelectedIndex(1);
      cmbTitlesList.addActionListener(this);
      cmbCitiesList.setSelectedIndex(1);
      cmbCitiesList.addActionListener(this);
      add(scrollPane, BorderLayout.CENTER);

      
    //JFrame settings  
      con.setLayout(new FlowLayout()); 
      con.setBackground(Color.GREEN);//change background color 
      b.setBackground(Color.WHITE);//change button color
      b1.setBackground(Color.WHITE);
      b2.setBackground(Color.WHITE);
      b3.setBackground(Color.WHITE);
      cmbTitlesList.setBackground(Color.WHITE);
      cmbCitiesList.setBackground(Color.WHITE);
      setVisible(true);
      setSize(1000,800);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
   //method for doing program tasks
   public void actionPerformed(ActionEvent ae) {
       //printing all employee details        
      if(ae.getSource()==b){
         listModel.clear();
         listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-25s %-18s %-18s %-12s %-12s %-12s %-12s %-12s %-12s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate"));
         listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
         for(int j=0;j<employees.length;j++){
                  listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate()));
               }

      }
      //printing only female employees
      if(ae.getSource()==b1){
         listModel.clear();
         listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-25s %-18s %-18s %-12s %-12s %-12s %-12s %-12s %-12s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate"));
         listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
         for(int j=0;j<employees.length;j++){
               if((employees[j].getGender()).equalsIgnoreCase("Female")){
                  listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate()));
                  }
               }
      }
      //displaying  employees by title
      if(ae.getSource()==cmbTitlesList){
         JComboBox cb =(JComboBox)ae.getSource();
         String tls= (String)cb.getSelectedItem();
         
         switch(tls){
            case  "marketing executives":
               listModel.clear();
               listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-25s %-18s %-18s %-12s %-12s %-12s %-12s %-12s %-12s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate"));
               listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getTitleOfEmp()).equalsIgnoreCase("marketing executive") || (employees[j].getTitleOfEmp()).equalsIgnoreCase("Markerting") ){
                     listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate()));
                     }
                  }  
               break;
            case  "Human Resources Officers & Accounts Officers":
               listModel.clear();
               listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-25s %-18s %-18s %-12s %-12s %-12s %-12s %-12s %-12s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate"));
               listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getTitleOfEmp()).equalsIgnoreCase("Human Resources Officer") || (employees[j].getTitleOfEmp()).equalsIgnoreCase("Accounts Officer") ){
                     listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate()));
                     }
                  }  
               break;
            case  "Temp Staff":
               listModel.clear();
               listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-25s %-18s %-18s %-12s %-12s %-12s %-12s %-12s %-12s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate"));
               listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getDepartment()).equalsIgnoreCase("temp staff")){
                     listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate()));
                     }
                  }  
               break;
            case  "Management Team":
               listModel.clear();
               listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-25s %-18s %-18s %-12s %-12s %-12s %-12s %-12s %-12s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate"));
               listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getDepartment()).equalsIgnoreCase("Management")){
                     listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate()));
                     }
                  }  
               break;
             case  "Support staff":
               listModel.clear();
               listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-25s %-18s %-18s %-12s %-12s %-12s %-12s %-12s %-12s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate"));
               listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getDepartment()).equalsIgnoreCase("Support staff ")){
                     listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate()));
                     }
                  }  
               break;
            default: listModel.addElement("Something is wrong");
             break;

         }
      }
      //searching by employee last name
      if(ae.getSource()==b2){
               String key=t1.getText();
               listModel.clear();
               listModel.addElement(String.format("%-5s %-18s %-18s %-23s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s","id","fname","lname","DOB","gender","address","title of employment","Date of Hire","Department","Hours worked","Pay Rate","leave days","car allowance","monthly gratuity","tax rate","Salary"));
               listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getLname()).equalsIgnoreCase(key)){
                     listModel.addElement(String.format("%-5d %-20s %-20s %-20s %-20s %-20s %-30s %-20s %-20s %-10.1f %-10.1f %-10d %-10.2f %-10.2f %-10.1f %-10.2f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].getDob(),employees[j].getGender(),employees[j].getAddress(),employees[j].getTitleOfEmp(),employees[j].getDateHired(),employees[j].getDepartment(),employees[j].getHoursWorked(),employees[j].getRateOfPay(),employees[j].getLeaveDays(),employees[j].getCarAllowance(),employees[j].getMonthlyGratuity(),employees[j].getTaxRate(),employees[j].calcSalary()));
                  }            
              }  
      }
      //display  only id,first name,last name and the employee salary
      if(ae.getSource()==b3){
         listModel.clear();
         listModel.addElement(String.format("%-8s %-20s %-20s %-20s","id","fname","lname","Salary"));
         listModel.addElement("=========================================================================================================================================================================================================================================================================================================================================================================");
         for(int j=0;j<employees.length;j++){
                  listModel.addElement(String.format("%-5d %-20s %-20s %-20.2f",employees[j].getEmployeeId(),employees[j].getFname(),employees[j].getLname(),employees[j].calcSalary()));
               }
      }
      //displaying by cities
      if(ae.getSource()==cmbCitiesList){
         JComboBox cb1 =(JComboBox)ae.getSource();
         String cts= (String)cb1.getSelectedItem();
         int countCities=0;
         switch(cts){
            case  "Gaborone":
               listModel.clear();
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getAddress()).equalsIgnoreCase("Gaborone")){
                        countCities++;
                     }
                }
                listModel.addElement(countCities+" employees"); 
               break;
            case  "Maun":
               listModel.clear();
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getAddress()).equalsIgnoreCase("Maun")){
                        countCities++;
                     }
                }
                listModel.addElement(countCities+" employees");               
                break;
            case  "Kanye":
               listModel.clear();
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getAddress()).equalsIgnoreCase("Kanye")){
                        countCities++;
                     }
                }
                listModel.addElement(countCities+" employees");               
                break;
            case  "Mahalapye":
               listModel.clear();
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getAddress()).equalsIgnoreCase("Mahalapye")){
                        countCities++;
                     }
                }
                listModel.addElement(countCities+" employees");               
                break;
             case  "Kasane":
               listModel.clear();
               for(int j=0;j<employees.length;j++){
                  if((employees[j].getAddress()).equalsIgnoreCase("Kasane")){
                        countCities++;
                     }
                }
                listModel.addElement(countCities+" employees");                 
                break;
            default: listModel.addElement("Something is wrong");
             break;

         }
      }

   }
}
