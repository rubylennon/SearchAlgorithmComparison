/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabasearchcomparison;

//imports
import java.util.Collections;

/*
 * TABA Data Structures and Algorithms
 * 6th May 2021
 * @author Ruby Lennon
 * Student ID: x19128355
 * SearchComparisonApp.java
 */

public class SearchComparisonApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        
        //variables
        int pos;
        
        //comparison counters
        int unorderedSeqSearchCount;
        int binarySearchNonRecursionCount;
        int binarySearchRecursionCount;
        int linearSearchCount;
        
        //Time variables to store nano seconds
        long t1,t2,t3,t4,t5,t6,t7,t8;
      
        ///*
        //TEST DATASET 1 - START - Test using dataset size 10 (N)
        //Set dataset size - N input 
        int n = 10;
        //print dataset size
        System.out.println("Dataset size: " +n);       
        //Create array of numbers using N input
        for(int i =0; i<n; i++){
           //creates list of integers from 0 - 9
           list.add(i);
        }
        //Key for searching
        Integer key1 = new Integer(10);// key 10 does not exist in arraylist
        //print search key
        System.out.println("Search key: " +key1);
        //TEST DATASET 1 - END
        //*/
        
        /*
        //TEST DATASET 2 - START - Test using dataset size 20 (N)
        //Set dataset size - N input
        int n = 20;
        //print dataset size
        System.out.println("Dataset size: " +n);      
        //Create array of numbers using N input
        for(int i =0; i<n; i++){
            //creates list of integers from 0 - 19
           list.add(i);
        }        
        //Key for searching
        Integer key1 = new Integer(20);// key 20 does not exist in arraylist
        //print search key
        System.out.println("Search key: " +key1);
        //TEST DATASET 2 - END
        */
        
        /*
        //TEST DATASET 3 - START - Test using dataset size 30 (N)
        //Set dataset size - N input
        int n = 30;
        //print dataset size
        System.out.println("Dataset size: " +n);   
        //Create array of numbers using N input
        for(int i =0; i<n; i++){
            //creates list of integers from 0 - 29
           list.add(i);
        }       
        //Key for searching
        Integer key1 = new Integer(30);// key 30 does not exist in arraylist
        //print search key
        System.out.println("Search key: " +key1);
        //TEST DATASET 3 - END
        */
                
        //Shuffle the list
        Collections.shuffle(list);
                
        //print the array list
        System.out.println("\nList unordered:");
        for(int i =0; i<n; i++){
            System.out.println(list.get(i));
        }        
              
        //Unordered Linear Search
        System.out.println("\nUnordered Linear Search:");
        //Capture run start time in nano seconds
        t1 = System.nanoTime();
        //Initiate unordered linear search and assign result to pos variable
        pos = list.unorderedLinearSearch(key1);
        //Capture run end time in nano seconds
        t2 = System.nanoTime();
        //Subtract run end time from run start time and print to screen
        System.out.println("Total time taken for Unordered Linear Search: "+ (t2-t1) +" nanoseconds.");
        //Print the search results
        //if the position returned from the search is -1 the key has not been found
        if(pos == -1){
            System.out.println("Search result: key value '" +key1+ "' does not exist in ArrayList.");
        }else {
            //else print the location of the key in the ArrayList
            System.out.println("Search result: key value '" +key1+ "' located at ArrayList index " +pos+ ".");
        }
        //Get comparison count from arraylist class
        unorderedSeqSearchCount = list.getUnorderedSeqSearchCount();
        //print number of comparisons
        System.out.println("Unordered Sequel Comparisons: " + unorderedSeqSearchCount +"\n");
        
        //Sort the list
        Collections.sort(list);
        
        //print the array list
        System.out.println("List ordered:");
        for(int i =0; i<n; i++){
            System.out.println(list.get(i));
        }
        
        //Linear Sequential Search
        System.out.println("\nSequential Linear Search:");
        //Capture run start time in nano seconds
        t3 = System.nanoTime();
        //Initiate linear sequential search and assign result to pos variable
        pos = list.linearSearchSequential(key1);
        //Capture run end time in nano seconds
        t4 = System.nanoTime();
        //Subtract run end time from run start time and print to screen
        System.out.println("Total time taken for Linear Sequential Search: "+ (t4-t3) +" nanoseconds.");
        //Print the search results
        //if the position returned from the search is -1 the key has not been found
        if(pos == -1){
            System.out.println("Search result: key value '" +key1+ "' does not exist in ArrayList.");
        }else {
            //else print the location of the key in the ArrayList
            System.out.println("Search result: key value '" +key1+ "' located at position " +pos+ ".");
        }       
        //Get comparison count from arraylist class
        linearSearchCount = list.getLinearSearchCount();
        //print number of comparisons
        System.out.println("Ordered Sequentials Search Comparisons: " + linearSearchCount +"\n");   
        
        //Binary Search - Non-Recursive
        System.out.println("Non Recursive Binary Search:");
        //Capture run start time in nano seconds
        t5 = System.nanoTime();
        //Initiate non recursive binary search and assign result to pos variable
        pos = list.binarySearch_nonRecursive(key1, 0, list.size()-1);
        //Capture run end time in nano seconds
        t6 = System.nanoTime();
        //Subtract run end time from run start time and print to screen
        System.out.println("Total time taken for Non Recursive Binary Search: "+ (t6-t5) +" nanoseconds.");
        //Print the search results
        //if the position returned from the search is -1 the key has not been found
        if(pos == -1){
            System.out.println("Search result: key value '" +key1+ "' does not exist in ArrayList.");
        }else {
            //else print the location of the key in the ArrayList
            System.out.println("Search result: key value '" +key1+ "' located at ArrayList position " +pos+ ".");
        }      
        //Get comparison count from arraylist class
        binarySearchNonRecursionCount = list.getBinarySearchNonRecursionCount();
        //print number of comparisons
        System.out.println("Binary Search Non Recursive Count: " + binarySearchNonRecursionCount +"\n");
        
        //Binary Search Recursive
        System.out.println("Recursive Binary Search:");
        //Capture run start time in nano seconds
        t7 = System.nanoTime();
        //Initiate recursive binary search and assign result to pos variable
        pos = list.binarySearch_recursive(key1, 0, list.size()-1);
        //Capture run end time in nano seconds
        t8 = System.nanoTime();
        //Subtract run end time from run start time and print to screen
        System.out.println("Total time taken for Recursive Binary Search: "+ (t8-t7) +" nanoseconds.");
        //Print the search results
        //if the position returned from the search is -1 the key has not been found
        if(pos == -1){
            System.out.println("Search result: key value '" +key1+ "' does not exist in ArrayList.");
        }else {
            //else print the location of the key in the ArrayList
            System.out.println("Search result: key value '" +key1+ "' located at position " +pos+ ".");
        }       
        //Get comparison count from arraylist class
        binarySearchRecursionCount = list.getBinarySearchRecursionCount();
        //Print number of comparisons
        System.out.println("Binary Search Recursive Count: " + binarySearchRecursionCount +"\n");      
    }    
}