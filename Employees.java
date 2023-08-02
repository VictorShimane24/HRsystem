public class Employees{
    private int employeeId;
    private String fname;
    private String lname;
    private String dob;
    private String gender;
    private String address;
    private String titleOfEmp;
    private String dateHired;
    private String department;
    private double hoursWorked;
    private double rateOfPay;
    private int leaveDays;
    private double carAllowance;
    private double monthlyGratuity; 
    private double taxRate=5.6;

    public Employees(){
        carAllowance=0.00;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId=employeeId;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public void setFname(String fname){
        this.fname=fname;
    }
    public String getFname(){
        return fname;
    }
    public void setLname(String lname){
        this.lname=lname;
    }
    public String getLname(){
        return lname;
    }
    public void setDob(String dob){
        this.dob=dob;
    }
    public String getDob(){
        return dob;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }public void setTitleOfEmp(String titleOfEmp){
        this.titleOfEmp=titleOfEmp;
    }
    public String getTitleOfEmp(){
        return titleOfEmp;
    }
    public void setDateHired(String dateHired){
        this.dateHired=dateHired;
    }
    public String getDateHired(){
        return dateHired;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String getDepartment(){
        return department;
    }
    public void setHoursWorked(double hoursWorked){
        this.hoursWorked=hoursWorked;
    }
    public double getHoursWorked(){
        return hoursWorked;
    }
    public void setRateOfPay(double rateOfPay){
        this.rateOfPay=rateOfPay;
    }
    public double getRateOfPay(){
        return rateOfPay;
    }
    public void setLeaveDays(int leaveDays){
        this.leaveDays=leaveDays;
    }
    public int getLeaveDays(){
        return leaveDays;
    }
    public void setCarAllowance(double carAllowance){
        this.carAllowance=carAllowance;
    }
    public double getCarAllowance(){
        return carAllowance;
    }
    public void setMonthlyGratuity(double monthlyGratuity){
        this.monthlyGratuity=monthlyGratuity;
    }
    public double getMonthlyGratuity(){
        return rateOfPay;
    }
    public void setTaxRate(double taxRate){
        this.rateOfPay=rateOfPay;
    }
    public double getTaxRate(){
        return taxRate;
    }
    public double calcSalary(){
        double grossSalary;
        grossSalary=(hoursWorked*rateOfPay)+(hoursWorked*rateOfPay+(carAllowance/100))+monthlyGratuity;
        return grossSalary;
    }
}