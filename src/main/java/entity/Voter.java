/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import adt.HashSet;
import adt.hashmap;
import adt.LinkedList;
import java.util.Scanner;
/**
 *
 * @Done By LEE PEI YEE 
 */
public class Voter {
    private static String username;
    private static String password;
    private static String fullName;
    private static String age;
    private static String contact;
    private static hashmap<String, String[]> userInfo = new hashmap<>();

    public Voter(String username, String password, String fullName, String age, String contact) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.contact = contact;
    }

    public Voter() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String age() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public static void register(Object userReg){
        if(userInfo.containsKey(username)){
            System.out.println("You have registered before."); 
        }else{
            userInfo.put(username,new String[]{password,fullName,age,contact});
            System.out.println("You have registered successfully!");
        } 
    }
    public static Boolean login(Object member){
         if (userInfo.containsKey(username)) {
             String[] savedPassword = userInfo.get(username);
            if (savedPassword[0].equals(password)) {
                return true;
            }
        }
        return false;
 }   

    public static void viewProfile(Object userProfile){
        String[] personalInfo = userInfo.get(username);
        System.out.println("\n\n*************************************************************");
        System.out.println("*                    USER PROFILE                           *");
        System.out.println("*************************************************************");
        System.out.println("*                                                           *");
        System.out.println("*      ***********                                          *");
        System.out.println("*      *  |  |   *     Username      : " + username           );
        System.out.println("*      *         *     Password      : " + personalInfo[0]    );
        System.out.println("*      * ------- *     Full Name     : " + personalInfo[1]    );
        System.out.println("*      *         *     Age           : " + personalInfo[2]    );
        System.out.println("*      ***********     Contact Number: " + personalInfo[3]    );
        System.out.println("*                                                           *");
        System.out.println("*************************************************************");
        System.out.println("                                                             ");
    }
    
    public static Boolean modifyProfile(Object userProfile, int choice){
        Scanner sc=new Scanner(System.in);
        String[] personalInfo;
        if(choice==1){
            String oldUsername=username;
            personalInfo = userInfo.get(username);
            userInfo.remove(username);
            System.out.println("\n\n***********************************************");
            System.out.println("*            CHANGE USERNAME                  *");
            System.out.println("***********************************************");
            System.out.print("  Enter new username: ");
            String newUsername=sc.next();
            username=newUsername;
            userInfo.put(username, personalInfo);
            System.out.println("                                                                  ");
            System.out.println("  You have changed the username from "+oldUsername+" to "+newUsername);
            return true;
        }else if(choice==2){
            String oldPassword=password;
            personalInfo = userInfo.get(username);
            System.out.println("\n\n***********************************************");
            System.out.println("*            CHANGE PASSWORD                  *");
            System.out.println("***********************************************");
            System.out.print("  Enter new password: ");
            personalInfo[0] = sc.next();
            userInfo.replace(username, personalInfo);
            System.out.println("                                                                      ");
            System.out.println("  You have changed the password from "+oldPassword+" to "+personalInfo[0]);
            return true;
        }else if(choice==3){
            String oldFullName=fullName;
            personalInfo = userInfo.get(username);
            System.out.println("\n\n***********************************************");
            System.out.println("*            CHANGE FULL NAME                 *");
            System.out.println("***********************************************");
            System.out.print("  Enter new full name: ");
            personalInfo[1] = sc.next();
            userInfo.replace(username, personalInfo);
            System.out.println("                                                            ");
            System.out.println("  You have changed the name from "+oldFullName+" to "+personalInfo[1]);
            return true;
        }else if(choice==4){
            String oldAge=age;
            personalInfo = userInfo.get(username);
            System.out.println("\n\n***********************************************");
            System.out.println("*               CHANGE AGE                    *");
            System.out.println("***********************************************");
            System.out.print("  Enter new age: ");
            personalInfo[2] = sc.next();
            userInfo.replace(username, personalInfo);
            System.out.println("                                                            ");
            System.out.println("  You have changed the age from "+oldAge+" to "+personalInfo[2]);
            return true;

        }else if (choice == 5) {
            String oldContact = contact;
            personalInfo = userInfo.get(username);
            System.out.println("\n\n***********************************************");
            System.out.println("*            CHANGE CONTACT                   *");
            System.out.println("***********************************************");
            System.out.print("  Enter new contact number: ");
            personalInfo[3] = sc.next();
            userInfo.replace(username, personalInfo);
            System.out.println("                                                                                 ");
            System.out.println("  You have changed the contact number from " + oldContact + " to " + personalInfo[3]);
            return true;
        }else if(choice==6){
            return false;
        }else{
            return true;
        }
        
    }


}

