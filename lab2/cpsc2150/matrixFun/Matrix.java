/*Spalding Latham
  CPSC 2151
  2/1/19
  Lab 2
*/
package cpsc2150.matrixFun;
import java.util.*;

/**
 * @author Spalding Latham 1/31/19
 * Matrix class used to perform matrices operations on 2D arrays
 */
public class Matrix {
    //class member variables
    /**
     * @invariant rows is positive and less than 11
     */
    private int rows = 0;
    /**
     * @invariant columns is positive and less than 11
     */
    private int columns = 0;
    private int[][] values;
    private int listCounter = 0;
    private List<Integer> valueList;

    /**
     * Constructs a Matrix from a list of user input values
     * @pre rows and columns are between 1 and 10
     * @post creates a matrix with the user's row length, column length, and values
     * @param rows the number of rows the matrix has, must be between 1 and 10
     * @param columns the number of columns the matrix has, must be between 1 and 10
     * @param values the list of integer values the user inputs
     */
    Matrix(int rows, int columns, List<Integer> values){
           //initialize member variables
           this.rows = rows;
           this.columns = columns;
           this.valueList = values;
           this.values = new int[rows][columns];

           //initialize 2D array from the list of user-input values
           for(int i = 0; i < rows; i++){
               for(int j = 0; j < columns; j++){
                   this.values[i][j] = values.get(listCounter);
                   listCounter++;
               }
           }
    }

    /**
     * Getter method for the rows of a Matrix object
     * @return returns the number of rows
     */
    int getRows(){
        System.out.println(this.rows);
        return this.rows;
    }

    /**
     * Getter method for the columns of a Matrix object
     * @return returns the number of columns
     */
    int getColumns(){
        return this.columns;
    }

    /**
     * Adds two matrices together
     * @param m2 the second matrix to add to
     * @return returns a new matrix that is the current
     * matrix added to the second matrix that was passed in as a parameter.
     */
     Matrix add(Matrix m2){
        //declare new matrix to store the addition
        Matrix m3 = new Matrix(this.rows, this.columns, this.valueList);
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                m3.values[i][j] = this.values[i][j] + m2.values[i][j];
            }
        }
        return m3;
     }

    /**
     * Subtracts one matrix from another
     * @param m2 the second matrix in the subtraction
     * @return returns a new matrix that is the
     * second matrix that was passed in as a parameter subtracted from the first matrix
     */
     Matrix subtract(Matrix m2){
         //create new matrix to store the subtraction
         Matrix m3 = new Matrix(this.rows, this.columns, this.valueList);
         for(int i = 0; i < this.rows; i++){
             for(int j = 0; j < this.columns; j++){
                 m3.values[i][j] = this.values[i][j] - m2.values[i][j];
             }
         }
         return m3;
     }

    /**
     * Transposes a single matrix
     * @return returns a new matrix that is the transpose of the current
     * matrix
     */
     Matrix transpose(){
        //create new matrix of size [columns][rows] to store transpose
        Matrix values3 = new Matrix(this.columns, this.rows, this.valueList);
        int counter = 0;
        int counterTracker = 0;

        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                //set the spots in the new matrix to the where the counter is in the list of values
                values3.values[i][j] = this.valueList.get(counter);
                //increment counter by the number of columns to transpose
                counter += this.columns;
            }
            //increment the counterTracker by 1 when it gets to outer loop
            counterTracker++;
            //reset the counter to the counterTracker to move to the next column
            counter = counterTracker;
        }
        return(values3);
     }

    /**
     * Allows a matrix to be printed in a readable format
     * @return returns a string with the matrix values
     */
    public String toString() {
        String matrixPrint = "";
        for(int i = 0; i < rows; i++){
            matrixPrint += "| ";
            for(int j = 0; j < columns; j++){
                matrixPrint += this.values[i][j];
                matrixPrint += " | ";
            }
            matrixPrint += "\n";
        }
        return(matrixPrint);
    }

    }
