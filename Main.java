package com.company;

public class Main {

    public static void main(String[] args) {

    }
}

//---------------------------------------------------------------
abstract class User {
    private String fulName;
    private long phoneNumber;

    public User(String fulName, long phoneNumber) {
        this.fulName = fulName;
        this.phoneNumber = phoneNumber;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFulName() {
        return fulName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    abstract String getBasicInformation();
}
//------------------------------------------------------------------------
abstract class Employee extends User {
    private String dateOfEmployeement;

    public Employee(String fulName, long phoneNumber, String dateOfEmployeement) {
        super(fulName, phoneNumber);
        this.dateOfEmployeement = dateOfEmployeement;
    }

    public void setDateOfEmployeement(String dateOfEmployeement) {
        this.dateOfEmployeement = dateOfEmployeement;
    }

    public String getDateOfEmployeement() {
        return dateOfEmployeement;
    }

    @Override
    final String getBasicInformation() {
        return ("ful name: " + String.valueOf(getFulName()) + '\n' + "phone number: " + String.valueOf(getPhoneNumber()) + '\n' + "date of employeement: " + dateOfEmployeement);
    }

    abstract void work(int w);

    abstract double getSalary();
}
//--------------------------------------------------------------------
final class FullTimeEmployee extends Employee {
    private int uncountedDays;
    final private double monthlySalaryRate;

    FullTimeEmployee(String fulName, long phoneNumber, String dateOfEmployeement, double monthlySalary) {
        super(fulName, phoneNumber, dateOfEmployeement);
        this.monthlySalaryRate = monthlySalary;
    }

    public void setUncountedDays(int uncountedDays) {
        this.uncountedDays = uncountedDays;
    }

    public int getUncountedDays() {
        return uncountedDays;
    }

    public double getMonthlySalaryRate() {
        return monthlySalaryRate;
    }

    @Override
    double getSalary() {
        int temp = uncountedDays / 30;
        uncountedDays = uncountedDays % 30;
        return ((temp) * 30 * monthlySalaryRate);
    }

    @Override
    void work(int newUncountedDays) {
        uncountedDays += newUncountedDays;
    }
}
//----------------------------------------------------------------------------------
final class PartTimeEmployee extends Employee {
    private int uncountedHour;
    final private double hourlySalaryRate;

    public PartTimeEmployee(String fulName, long phoneNumber, String dateOfEmployeement, double hourlySalaryRate) {
        super(fulName, phoneNumber, dateOfEmployeement);
        this.hourlySalaryRate = hourlySalaryRate;
    }

    public void setUncountedHour(int uncountedHour) {
        this.uncountedHour = uncountedHour;
    }

    public int getUncountedHour() {
        return uncountedHour;
    }

    public double getHourlySalaryRate() {
        return hourlySalaryRate;
    }

    @Override
    double getSalary() {
        int temp = uncountedHour;
        uncountedHour = 0;
        return ((temp) * hourlySalaryRate);
    }

    @Override
    void work(int newUncountedDays) {
        uncountedHour += newUncountedDays;
    }
}
//-----------------------------------------------------------------------------
final class ProjectEmployee extends Employee {
    private int uncountedProjects;
    final private double wage;

    public ProjectEmployee(String fulName, long phoneNumber, String dateOfEmployeement, double wage) {
        super(fulName, phoneNumber, dateOfEmployeement);
        this.wage = wage;
    }

    public void setUncountedProjects(int uncountedProjects) {
        this.uncountedProjects = uncountedProjects;
    }

    public int getUncountedProjects() {
        return uncountedProjects;
    }

    public double getWage() {
        return wage;
    }

    @Override
    double getSalary() {
        int temp = uncountedProjects;
        uncountedProjects = 0;
        return ((temp) * wage);
    }

    @Override
    void work(int newUncountedProject) {
        uncountedProjects += newUncountedProject;
    }
}
//--------------------------------------------------------------------
class Admin extends User {
    Admin admin;

    public Admin getAdmin(String nane, long number) {
        if (admin == null) {
            admin = new Admin(nane, number);
        }
        return admin;
    }

    static ArrayList<Employee> employees;

    private Admin(String fulName, long phoneNumber) {
        super(fulName, phoneNumber);
    }

    @Override
    final String getBasicInformation() {
        return ("ful name: " + String.valueOf(getFulName()) + '\n' + "phone number: " + String.valueOf(getPhoneNumber()));
    }

    public static void setEmployees(Employee employee) {
        employees.add(employee);
    }
}
