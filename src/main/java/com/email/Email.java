package com.email;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private Integer mailBoxCapacity = 500;
    private Integer defaultPasswordLength = 10;
    private String alternateMail;
    private String companySuffix = "company.com";

    // Constructor to receive the first name and last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method which will ask for the department - return the department
        this.department = setDepartment();

        // Call a method to return random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your passowrd is: " + password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New team member: " + firstName +". " + "Department Codes:\n1 for Sales\n2 for Development \n3 for Accounting\n0 for none\n Enter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "info";
        }
    }

    // Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Set the mailbox capacity
    public void setMailBoxCapacity(Integer capacity){
        this.mailBoxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateMail(String altmail) {
        this.alternateMail = altmail;
    }
    // Change the password
    public void changePassword(String password){
        this.password = password;
    }
    public Integer getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateMail() {
        return alternateMail;
    }
    public String getPassword(){
        return password;
    }
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
