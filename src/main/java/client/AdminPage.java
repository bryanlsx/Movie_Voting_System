/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import adt.*;
import java.util.Scanner;
import entity.*;
import java.util.InputMismatchException; 

/**
 *
 * @author enoch
 */
//Done by: Enoch Hii Chen Sheng
public class AdminPage {
    public static void adminPage(){
    Scanner sc = new Scanner(System.in);
    String title;
    String description;
    String genre;
    int MovieNo;
    int choice;
    LinkedList<String> movieTitles = Movie.getAllMovieTitle();
    Voter voter = new Voter();

    do {
        System.out.println("\n\n***********************************************");
        System.out.println("*                  ADMIN                      *");
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*             1.Add new movie                 *");
        System.out.println("*             2.Delete movie                  *");
        System.out.println("*             3.Edit movie                    *");
        System.out.println("*             4.Logout                        *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");
        System.out.print("           Please select an option: ");
        
        choice = 0;//validation integer input
                try {
                        choice = sc.nextInt(); // read an integer value
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Enter INTEGER value.\n");
                        sc.nextLine(); // consume the invalid input
                    }  

        switch (choice) {
                
            case 1:
                // add new movie functionality
                System.out.println("\n\n***********************************************");
                System.out.println("*               ADD NEW MOVIE                 *");
                System.out.println("***********************************************");
                System.out.print("  1. Please enter Movie Title       : ");
                sc.nextLine();
                title = sc.nextLine();                
                System.out.print("  2. Please enter Movie Description : ");
                description = sc.nextLine();
                System.out.print("  3. Please enter Movie Genre       : ");
                genre = sc.nextLine();
                
                //check movie title
                if(Movie.isStringEmpty(title)){
                    System.out.println("Movie Title is empty. \n");
                }
                else if(Movie.isStringEmpty(description)){
                    System.out.println("Movie Description is empty. \n");
                }
                else if(Movie.isStringEmpty(genre)){
                    System.out.println("Movie Genre is empty. \n");
                }
                else if(Movie.checkMovieTitle(title)){
                    System.out.println("Movie Has Already Been Added. \n");
                }else{
                    System.out.println("\n\n***********************************************");
                    System.out.println("*               ADDING MOVIE                  *");
                    System.out.println("***********************************************");
                    try {
                            Thread.sleep(800); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.print("*************");
                    try {
                            Thread.sleep(800); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.print("*******************");
                    try {
                            Thread.sleep(800); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.print("***************");
                    try {
                            Thread.sleep(1250); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.println("\n       Movie has been successfully added!");
                    Movie.addMovie(new Movie(title, description, genre));
                }
                
                break;
                
                
            case 2:
                // delete movie functionality
                System.out.println("\n\n***********************************************");
                System.out.println("*              DELETING MOVIE                 *");
                System.out.println("***********************************************");
                Movie.displayAllMovieTitles();
                System.out.print("Please select a movie to delete or enter 0 to exit: ");
                MovieNo = 0;
                try {
                        MovieNo = sc.nextInt(); // read an integer value
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Enter a valid integer value.\n\n");
                        sc.nextLine(); // consume the invalid input
                    }               
                Movie.removeMovie(MovieNo);
                break;
                
          
            case 3:
                // edit movie functionality
                System.out.println("\n\n***********************************************");
                System.out.println("*               EDITING MOVIE                 *");
                System.out.println("***********************************************");
                Movie.displayAllMovieTitles();
                System.out.print("Please select a movie to edit: ");
                MovieNo = 0;
                System.out.println("\n");
                //validation integer input
                try {
                        MovieNo = sc.nextInt(); // read an integer value
                        if (MovieNo == 0){
                        break;
                        }else{}
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Enter a valid integer value.");
                        sc.nextLine();
                        break;// consume the invalid input
                    }               
                System.out.print("1. Please enter Movie Title       : ");
                sc.nextLine();
                title = sc.nextLine();                
                System.out.print("2. Please enter Movie Description : ");
                description = sc.nextLine();
                System.out.print("3. Please enter Movie Genre       : ");
                genre = sc.nextLine(); 
                if(Movie.checkMovieTitle(title)){
                    System.out.println("\nMovie Title has been taken!");
                }else{
                    Movie.replaceMovie(MovieNo, new Movie(title, description, genre));
                }
                break;
                
            case 4:
                System.out.println("Logging out... \n\n");
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n\n");
                break;
        }
    } while (choice != 4);
    }
}
