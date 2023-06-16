/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.LinkedList;
import java.util.Scanner;

/*add the adt into entity*/
/**
 *
 * @author enoch
 */

//Done by: Enoch Hii Chen Sheng
public class Movie{
    private String title;
    private String description;
    private String genre;
    
    public Movie(){}
    public static LinkedList<Movie> movieList = new LinkedList<>();
    
    public Movie(String title, String description, String genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    

    
    public static void addMovie(Movie newMovie){ 
        if (movieList.isEmpty()){
            movieList.add(newMovie);
        }else {
            movieList.add(1,newMovie);
        }            
    }
    
    //Remove Movie
    public static void removeMovie(int MovieNo){        
        if(MovieNo > movieList.getNumberOfEntries()){
            System.out.println("Movie could not be found. \n\n");
        }else{
            Voting.voteCount.remove(movieList.getEntry(MovieNo).getTitle());
            movieList.remove(MovieNo);
            System.out.println("Deleting movie....");
                    try {
                            Thread.sleep(2000); // wait for 2 seconds (2000 milliseconds)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
            System.out.println("Movie deleted successfully!");
        }      
           
    }
        
    //Replace Movie
    public static void replaceMovie(int MovieNo, Movie newMovie){        
        if (MovieNo > movieList.getNumberOfEntries()){
            System.out.println("Movie could not be found.");
        }else{
            movieList.replace(MovieNo, newMovie);
            System.out.println("Replacing movie....");
                    try {
                            Thread.sleep(2000); // wait for 2 seconds (2000 milliseconds)
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
            System.out.println("Movie replaced successfully!");
        }
    }
    
        
    public static LinkedList<String> getAllMovieTitle() {
        LinkedList<String> titles = new LinkedList<>();
        for (int i = 1; i <= movieList.getNumberOfEntries(); i++) {
            titles.add(movieList.getEntry(i).getTitle());
        }
        return titles;
    }
    
    public static void displayAllMovieTitles(){
        System.out.println("***********************************************");
        System.out.println("*               List of Movies                *");
        System.out.println("***********************************************");
        LinkedList<String> titles = getAllMovieTitle(); 
        for (int i = 1; i <= titles.getNumberOfEntries(); i++) {
            System.out.println("                  " + i + ". " + titles.getEntry(i));
        }
        System.out.println("***********************************************");
    }
     
    
    public static void displayMovieInfo(int position){       
        
        if (position > movieList.getNumberOfEntries()) {
            System.out.println("\n***********************************************");
            System.out.println("*             Movie is not found              *");
        } else {          
            for (int i = 1; i <= movieList.getNumberOfEntries(); i++) {
                if (position == i) {
                    System.out.println("\n\n***********************************************");
                    System.out.println("*                Movie Info                   *");
                    System.out.println("***********************************************");
                    System.out.println("         Title       : " + movieList.getEntry(position).getTitle());
                    System.out.println("         Description : " + movieList.getEntry(position).getDescription());
                    System.out.println("         Genre       : " + movieList.getEntry(position).getGenre());
                }
            }
        }
    }
    
    public static boolean checkMovieTitle(String title){
        LinkedList<String> titles = getAllMovieTitle();
        return titles.contains(title);        
    }
    
    public static boolean isStringEmpty(String str) {
    return str == null || str.trim().isEmpty();
    }    
}

