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
        return ("ful name: " + String.valueOf(fulName) + '\n' + "phone number: " + String.valueOf(phoneNumber));
    }

    abstract void work(int w);

    abstract long getSalary();
}
