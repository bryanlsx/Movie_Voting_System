/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import entity.*;
import adt.*;
import static client.AdminPage.adminPage;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MovieVotingSystem {

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        Voter user= new Voter();
        Voter newUser= new Voter();
        Voting timeToVote = new Voting();

        int option;
        int MovieNo;
        Boolean loginSuccess=false;
        Boolean returnMenu=false;
        
        //Demo Database to show//
        //Add Movies into list
        Movie.addMovie(new Movie("Titanic","Ship Sinks", "Romance"));
        Movie.addMovie(new Movie("Mr Bean","The silent guy that is funny", "Comedy"));
        Movie.addMovie(new Movie("Hello Kitty","Cute walking cat", "Cartoon"));
        Movie.addMovie(new Movie("James Bond","Secret Agent", "Thriller"));
        
        //Add vote count to movies
        for (int i = 1; i <= Movie.movieList.getNumberOfEntries(); i++) {
            timeToVote.demoAddVote(Movie.movieList.getEntry(i).getTitle(), i);
        }
        
        //Add Users 
        String name[] = {"user1", "user2", "user3", "user4", "user5"};
        String username[] = {"Mary","JohnnyLegend","Bryan","Enoch","PeiYee"};
        String password[] = {"123","12","123","12","123"};
        String age[] = {"15", "20", "22", "22", "21"};
        String contact[] = {"0123456543", "0191238177", "0138749299", "01783901092", "01234772882"};
        
        for(int i = 0;i<name.length;i++){
            newUser.setFullName(name[i]);
            newUser.setUsername(username[i]);
            newUser.setPassword(password[i]);
            newUser.setAge(age[i]);
            newUser.setContact(contact[i]);
            Voter.register(newUser); 
        }
        
  
        
        //Program Starts Here
        do{
            System.out.println("\n\n===============================================");
            System.out.println("      WELCOME TO OUR MOVIE VOTING SYSTEM       ");
            System.out.println("===============================================");
            System.out.println("                                               ");
            System.out.println("***********************************************");
            System.out.println("*                   MENU                      *");
            System.out.println("***********************************************");
            System.out.println("*                                             *");
            System.out.println("*           1.Login                           *");
            System.out.println("*           2.Register                        *");
            System.out.println("*           3.View Movies                     *");
            System.out.println("*           4.Favourite Movie Ranking         *");
            System.out.println("*           5.Exit                            *");
            System.out.println("*                                             *");
            System.out.println("***********************************************");
            System.out.println("                                               ");
            System.out.print("          Please select an option: ");

            option=sc.nextInt();
            System.out.println("");
            switch (option) {
                //@Done By LEE PEI YEE
                case 1:
                {
                    int loginLimit=1;
                    do{
                        System.out.println("                                                             ");
                        System.out.println("                                                             ");
                        System.out.println("*************************************************************");
                        System.out.println("*                          LOGIN                            *");
                        System.out.println("*************************************************************");
                        System.out.println("*  !Kindly remind that you can only try login 3 times!      *");
                        System.out.println("*                     Login times:"+loginLimit+"                         *");
                        System.out.println("*************************************************************");
                        System.out.print("* Username: ");
                        user.setUsername(sc.next());
                        System.out.println("*                                                           *");
                        System.out.print("* Password: ");
                        user.setPassword(sc.next());
                        System.out.println("*                                                           *");
                        System.out.println("*************************************************************");
                        System.out.println("                                                             ");
                        
                        //Done by: Enoch Hii Chen Sheng
                        //login to admin page
                        if(user.getUsername().equals("admin123") && user.getPassword().equals("@dmin321")){
                            adminPage();
                            returnMenu=false;
                            break;
                        }else {loginSuccess=Voter.login(user);                       
                        loginLimit++;
                        }
                    
                    }while(loginSuccess!=true&&loginLimit<4);
                    
                    //voter login
                    if(loginSuccess==true){
                        System.out.println("                                                                                        ");
                        System.out.println("                                                                                        ");
                        System.out.println("************************** Welcome! "+user.getUsername()+" *****************************");
                        System.out.println("                                                                                        ");
                    do{
                        System.out.println("\n\n***********************************************");
                        System.out.println("*                USER PANEL                   *");
                        System.out.println("***********************************************");
                        System.out.println("**1*********************************************");
                        System.out.println("*                                             *");
                        System.out.println("*           1.View Your Profile               *");
                        System.out.println("*           2.Edit Profile                    *");
                        System.out.println("*           3.Vote Movie                      *");
                        System.out.println("*           4.Log Out                         *");
                        System.out.println("*                                             *");
                        System.out.println("***********************************************");
                        System.out.println("                                               ");
 
                        System.out.print("Please select an option: ");
                        option=sc.nextInt();
                        switch(option){
                            //View Profile Done By LEE PEI YEE
                            case 1:
                            {
                                Voter.viewProfile(user);
                                returnMenu=true;
                                break;
                            }
                            //Edit Profile Done By LEE PEI YEE
                            case 2:
                            {
                                do{
                                    System.out.println("\n\n***********************************************");
                                    System.out.println("*            CHANGE YOUR PROFILE              *");
                                    System.out.println("***********************************************");
                                    System.out.println("***********************************************");
                                    System.out.println("*                                             *");
                                    System.out.println("*           1.Change Username                 *");
                                    System.out.println("*           2.Change Password                 *");
                                    System.out.println("*           3.Change Full Name                *");
                                    System.out.println("*           4.Change Age                      *");
                                    System.out.println("*           5.Change Contact Number           *");
                                    System.out.println("*           6.Return to User Panel            *");
                                    System.out.println("*                                             *");
                                    System.out.println("***********************************************");
                                    System.out.println("                                               ");
                                    System.out.print("Please select an option: ");
                                    
                                    option = sc.nextInt();
                                    returnMenu=Voter.modifyProfile(user,option);
                                }while(option>6||option<1||returnMenu==true);
                                returnMenu=true;
                                break;
                            }
                            //Done by: Loo Seng Xian
                            //Le Voting Part
                            case 3:
                            {
                                System.out.println("\n\n***********************************************");
                                System.out.println("*                VOTING PAGE                  *");
                                if (!(timeToVote.votedUsers.contains(user.getUsername()))) {
                                    Movie.displayAllMovieTitles();
                                    System.out.print("    Please Enter Your Choice of Selection: ");
                                    int choice = sc.nextInt();
                                    timeToVote.Vote(choice, user.getUsername());
                                }else{
                                    System.out.println("        You have already voted for " + timeToVote.showVotedMovie.get(user.getUsername()));
                                }
                                break;
                            }
                            //Log Out
                            case 4:
                            {
                                System.out.println("See you again!");
                                returnMenu=false;
                                break;
                            }
                            default:
                            {
                                returnMenu=true;
                            }
                        }

                    }while(returnMenu==true);
                    }else{
                    returnMenu=true;
                }
                    returnMenu=true;
                    break;
                }
                //Register Done By LEE PEI YEE
                case 2:
                {
                    System.out.println("\n\n*************************************************************");
                    System.out.println("*                        REGISTER                           *");
                    System.out.println("*************************************************************");
                    System.out.print("                    Full Name: ");
                    newUser.setFullName(sc.next());
                    System.out.print("                         Age : ");
                    newUser.setAge(sc.next());
                    System.out.print("                      Contact: ");
                    newUser.setContact(sc.next());
                    System.out.print("                     Username: ");
                    newUser.setUsername(sc.next());
                    System.out.print("                     Password: ");
                    newUser.setPassword(sc.next());
                    System.out.println("*************************************************************");

                    Voter.register(newUser);
                    returnMenu=true;
                    break;
                }  
                //Done by: Enoch Hii Chen Sheng
                //View Movies
                case 3:
                    System.out.println("\n\n");
                    Movie.displayAllMovieTitles();
                    System.out.print("        Please select a movie to view: ");
                    MovieNo = 0;
                    
                    //validation integer input
                    try {
                        MovieNo = sc.nextInt(); // read an integer value
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Please enter a valid integer value.\n\n");
                        sc.nextLine(); // consume the invalid input
                    }
                    
                    Movie.displayMovieInfo(MovieNo);      
                    System.out.println("***********************************************\n");
                    System.out.print("     Press 1 to return back to main menu: ");
                    int optionBack = sc.nextInt();
                    if(optionBack == 1){
                    returnMenu=true;
                    }
                    break;
                    
                //Done by: Loo Seng Xian
                //View Favourite Movie Ranking
                case 4:
                    timeToVote.displayMovieRank();
                    returnMenu=true;
                    break;
                    
                //Exit
                case 5:
                {
                    returnMenu=false;
                    break;
                }
                default:
                {
                    System.out.println("***********************************************");
                    System.out.println("*           Enter a Valid Number              *");
                    System.out.println("*            To Use The System                *");
                    System.out.println("***********************************************");
                    returnMenu=true;
                    break;
                }
            }
            
    }while(returnMenu==true);
        System.out.println("\n\n***********************************************");
        System.out.println("*       Thank you for participating in        *");
        System.out.println("*          our movie voting system!           *");
        System.out.println("*              Have a Nice Day!!              *");
        System.out.println("***********************************************");
 }
    
}
