package com.company;

public class Main {

    public static void main(String[] args) {

    }
}

abstract class User {
    String fulName;
    long phoneNumber;

    public User(String fulName, long phoneNumber) {
        this.fulName = fulName;
        this.phoneNumber = phoneNumber;
    }

    abstract String getBasicInformation();
}

abstract class Employee extends User {
    String dateOfEmployeement;

    public Employee(String fulName, long phoneNumber, String dateOfEmployeement) {
        super(fulName, phoneNumber);
        this.dateOfEmployeement = dateOfEmployeement;
    }

    @Override
    final String getBasicInformation() {
        return ("ful name: " + String.valueOf(fulName) + '\n' + "phone number: " + String.valueOf(phoneNumber)+ '\n'+ "date of employeement: "+ dateOfEmployeement);
    }

    abstract void work(int w);

    abstract double getSalary();
}
final class FullTimeEmployee extends Employee {
    int uncountedDays;
    final private double monthlySalaryRate;

    FullTimeEmployee(String fulName, long phoneNumber, String dateOfEmployeement, int uncountedDays, double monthlySalary) {
        super(fulName, phoneNumber, dateOfEmployeement);
        this.monthlySalaryRate = monthlySalary;
        this.uncountedDays = uncountedDays;
    }

    @Override
    double getSalary() {
        int temp = uncountedDays / 30;
        uncountedDays = uncountedDays % 30;
        return ((temp) * 30 * monthlySalaryRate);
    }
    @Override
    void work(int newUncountedDays){
        uncountedDays+=newUncountedDays;
    }
}
final class PartTimeEmployee extends Employee {
    int uncountedHour;
    final private double hourlySalaryRate;

    public PartTimeEmployee(String fulName, long phoneNumber, String dateOfEmployeement, double hourlySalaryRate, int uncountedHour) {
        super(fulName, phoneNumber, dateOfEmployeement);
        this.hourlySalaryRate = hourlySalaryRate;
        this.uncountedHour = uncountedHour;
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
