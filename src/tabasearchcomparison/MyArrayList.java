/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabasearchcomparison;

//imports
import java.util.ArrayList;

/*
 * TABA Data Structures and Algorithms
 * 6th May 2021
 * @author Ruby Lennon
 * Student ID: x19128355
 * MyArrayList.java
 */

public class MyArrayList<E>  extends ArrayList<E> {
    
    //variables - comparison counters
    int orderedSeqSearchCount;
    int unorderedSeqSearchCount;
    int binarySearchNonRecursionCount;
    int binarySearchRecursionCount;
    int linearSearchCount;
    
    //Unordered Linear Search
    public int unorderedLinearSearch(E key){
        int k;
        //pass over the number of elements in the collection
        for(k = 0; k<size(); k++){
            //using Comparable interface and compareTo()
            if(((Comparable)get(k)).compareTo((Comparable)key) == 0){
                return k; //return the position
            }
            //add 1 to the comparison counter
            unorderedSeqSearchCount ++;
        }
        return -1; //return -1 to indicate not in the list
    }
    
    //Sequential Linear Search
    public int linearSearchSequential(E key) {
        int k = 0;
        //run while element at k is less than the key and k is less than the number of items in the list
        while (k < this.size() && ((Comparable) get(k)).compareTo(key) < 0) {
        k++;
        //add 1 to the comparison counter
        linearSearchCount ++;
        }

        return k < this.size() && (((Comparable) get(k)).compareTo(key) == 0) ? k : -1;
    }
    
    //Ordered Sequential Search
    public int orderedSequentialSearch(E key){
        int k=0;
        //run while element at k is less than the key and k is less than the number of items in the list
	while (((Comparable)get(k)).compareTo((Comparable)key) < 0  &&  k < size()){
            k = k+1;
            //add 1 to the comparison counter
            orderedSeqSearchCount ++;
        }
        if(((Comparable)get(k)).compareTo((Comparable)key)==0)
            return k;
	else
            return -1;
    }
    
    //Binary Search - Non Recursive
    int binarySearch_nonRecursive (E key, int start, int end){
        //boolean found flag
        boolean found;
        //middle
        int middle = 0;
        //search begins with false found value
        found = false;
        //while the start is less than the end and the flag is false
        while ((start <= end) && ( found==false)){
            //add 1 to the comparison counter
            binarySearchNonRecursionCount ++;
            //chop the array
            middle = (start+end)/2;
            //if the item in the middle equals the key
            if (((Comparable)get(middle)).compareTo((Comparable)key)== 0)
                //found flag equal true
                found = true;
            //else go back to the start
            else if (((Comparable)get(middle)).compareTo((Comparable)key)< 0)
                //start equals middle plus 1
                start = middle +1;
            else
                //else the end equals the middle minus 1
                end=middle-1;
        }
        //if the key has been found
        if (found == true){
            //return the middle position
            return middle;   
        } else{
            //else return minus 1
            return -1;
        }
    }

    //Binary Search - Recursive
    int binarySearch_recursive (E key, int start, int end){
        //middle equals zero
        int middle = 0;
        //result is the middle
        int result;
        //chop the array
        middle = (start+end)/2;
        if (((Comparable)get(middle)).compareTo((Comparable)key)== 0){//base case
            result = middle;
        }
        else if (start == end){//base case
            result = -1;//item has not been found
        }//recursive case
        else {        
            if (((Comparable)get(middle)).compareTo((Comparable)key)>0)
                result = binarySearch_recursive(key, start,middle-1);//left side - start to middle
            else
                result = binarySearch_recursive(key, middle+1, end);//right side - middle to end
        }
        //add 1 to the comparison counter
        binarySearchRecursionCount ++;
        return result;
    } 

    //getters for main class

    public int getUnorderedSeqSearchCount() {
        return unorderedSeqSearchCount;
    }

    public int getBinarySearchNonRecursionCount() {
        return binarySearchNonRecursionCount;
    }

    public int getBinarySearchRecursionCount() {
        return binarySearchRecursionCount;
    }

    public int getLinearSearchCount() {
        return linearSearchCount;
    }
       
}