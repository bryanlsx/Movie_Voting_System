/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.*;
import java.util.Scanner;

/**
 *
 * @author Bryan
 */

//Done by: Loo Seng Xian
public class Voting {

    public HashSet<String> votedUsers = new HashSet<>();
    public hashmap<String, String> showVotedMovie = new hashmap<>();
    public static hashmap<String, Integer> voteCount = new hashmap<>();
    private static Voter voter = new Voter();
    private static Movie movie = new Movie();
    
    
    public Voting() {
        this.votedUsers = votedUsers;
        this.voteCount = voteCount;
    }

    //Pass in option and username
    public void Vote(int opt, String username) {
        //Validation: make sure user don't exceed the list of available movies
        if (!votedUsers.contains(voter.getUsername()) && opt > 0 && opt <= movie.movieList.getNumberOfEntries()) {
            votedUsers.add(voter.getUsername());
            //Check if username exist in set, if not then add uesrname -> set
            //If username exists in the set, proceed to else statement

            //Getting title of movie by passing in user's option
            String selectedMovie = movie.movieList.getEntry(opt).getTitle();

            //If hashmap already contains the key (title) then proceed to add vote
            //If title has not been mapped, proceed to else statement
            if (voteCount.containsKey(selectedMovie)) {

                //Get the existing vote count
                int count = voteCount.get(selectedMovie);

                //update vote count
                voteCount.put(selectedMovie, count + 1);
                showVotedMovie.put(voter.getUsername(), selectedMovie);

            } else {
                //Map unmapped title in the hashset and update value to 1
                voteCount.put(selectedMovie, 1);
                showVotedMovie.put(voter.getUsername(), selectedMovie);

            }
            
            //Ask if user wanna change vote
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n*************************************************************");
            System.out.println("*                   Thanks for Voting                       *");
            System.out.println("*          Would you like to change your vote?              *");
            System.out.println("*************************************************************");
            System.out.println("*************************************************************");
            System.out.println("*          Enter 1 to Change Vote or Press Any              *");
            System.out.println("*                Number to Confirm Vote                     *");
            System.out.println("*************************************************************\n");
            System.out.print("                    Enter here: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    changeVote(movie.movieList.getEntry(opt).getTitle(), voter.getUsername());
                    break;
                case 2:
                    System.out.println("\n*************************************************************");
                    System.out.println("*              Your Vote Has Been Received!                 *");
                    System.out.println("*************************************************************");
                    System.out.println("               Current Vote Count for " + selectedMovie);
                    System.out.println("                       Votes : " + voteCount.get(selectedMovie));
                    System.out.println("*************************************************************");
                    break;
            }
        } else {
            System.out.println("\n*************************************************************");
            System.out.println("                Invalid movie title selection               ");
            System.out.println("             please only enter between 1 and " + movie.movieList.getNumberOfEntries());
            System.out.println("*************************************************************");
            return;

        }
    }
    
    public void demoAddVote(String currentSelectedMovie, int count){
        voteCount.put(currentSelectedMovie, count);
    }

    public void changeVote(String currentSelectedMovie, String username) {
        int changeVoteCount = voteCount.get(currentSelectedMovie);
        voteCount.put(currentSelectedMovie, changeVoteCount - 1);
        votedUsers.remove(username);
        return;
    }
    
    public String[] showVotedMovie() {
        HashSet<String> votedMovie = voteCount.getKeys();
        return votedMovie.toArray();
    }
    
    public void displayMovieRank(){
        SortedArray<Integer> sortedArray = new SortedArray<>(voteCount.size());
        hashmap<Integer, HashSet<String>> ranking = new hashmap<>();

            for (String movie : showVotedMovie()) {
                int voteCounts = voteCount.get(movie);
                if (ranking.containsKey(voteCounts)) {
                    HashSet<String> listOfMovies = ranking.get(voteCounts);
                    listOfMovies.add(movie);
                    sortedArray.add(voteCounts);
                } else {
                    HashSet<String> listOfMovies = new HashSet<>();
                    listOfMovies.add(movie);
                    ranking.put(voteCounts, listOfMovies);
                    sortedArray.add(voteCounts);
                }
            }

        Integer[] sortedMovie = sortedArray.getSortedArr();
        int prevVoteCount = Integer.MAX_VALUE;
        System.out.println("\n***********************************************");
        System.out.println("*           Current Movie Ranking             *");
        System.out.println("* (Movies that are not voted will not appear) *");
        System.out.println("***********************************************");
        System.out.println("          Ranking Highest to Lowest");
        System.out.println("          *************************\n");
            for (int i : sortedMovie) {
                HashSet<String> movies = ranking.get(i);
                if (i != prevVoteCount) {
                    System.out.println("            " + movies + " : " + i);
                }
                prevVoteCount = i;
            }
        
    }
   }

   



