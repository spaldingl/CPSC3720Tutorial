/*Spalding Latham
  CPSC 2151
  2/1/19
  Lab 2
*/
package cpsc2150.matrixFun;
import java.util.*;


public class MatrixApp {
    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        //flag that will terminate program when true
        boolean flag = false;

        while(flag == false) {
            System.out.println("1. Get the Transpose of a Matrix");
            System.out.println("2. Add two matrices");
            System.out.println("3. Find the difference of two matrices");
            System.out.println("4. Quit");

            int input = in.nextInt();
            int rows = 0;
            int columns = 0;
            int rowCounter = 1;
            int columnCounter = 1;
            boolean rowsValid = false;
            boolean columnsValid = false;
            List<Integer> values1 = new ArrayList<Integer>();
            List<Integer> values2 = new ArrayList<Integer>();


            //when user enters 4 program terminates
            if (input == 4) {
                flag = true;
            } else {
                //reprompts user until rows are between 1 and 10
                while (rowsValid == false) {
                    System.out.println("How many rows should the matrix have?");
                    rows = in.nextInt();
                    if ((rows > 10) || (rows < 1)) {
                        System.out.println("Number of rows must be between 1 and 10");
                    } else {
                        rowsValid = true;
                    }

                }
                //reprompts user until columns between 1 and 10
                while (columnsValid == false) {
                    System.out.println("How many columns should the matrix have?");
                    columns = in.nextInt();
                    if ((columns > 10) || (columns < 1)) {
                        System.out.println("Number of columns must be between 1 and 10");
                    } else {
                        columnsValid = true;
                    }

                }

                /*TRANSPOSE*/
                if (input == 1) {
                    //gets the user input values for matrix
                    while (rowCounter != rows + 1) {
                        while (columnCounter != columns + 1) {
                            System.out.println("Enter the value for row " + rowCounter + " column " + columnCounter);
                            values1.add(in.nextInt());
                            columnCounter++;
                        }
                        rowCounter++;
                        columnCounter = 1;
                    }
                    //create a matrix with the user input values, then transpose it
                    Matrix m1 = new Matrix(rows, columns, values1);
                    Matrix m2 = m1.transpose();
                    System.out.println(m2);


                }
                /*ADD*/
                if (input == 2) {
                    System.out.println("What values should be in the first matrix?");
                    //gets the user input values for matrix 1
                    while (rowCounter != rows + 1) {
                        while (columnCounter != columns + 1) {
                            System.out.println("Enter the value for row " + rowCounter + " column " + columnCounter);
                            values1.add(in.nextInt());
                            columnCounter++;
                        }
                        rowCounter++;
                        columnCounter = 1;
                    }
                    //reset counters to 1 not 0
                    rowCounter = 1;
                    columnCounter = 1;
                    System.out.println("What values should be in the second matrix?");
                    //gets the user input values for matrix
                    while (rowCounter != rows + 1) {
                        while (columnCounter != columns + 1) {
                            System.out.println("Enter the value for row " + rowCounter + " column " + columnCounter);
                            values2.add(in.nextInt());
                            columnCounter++;
                        }
                        rowCounter++;
                        columnCounter = 1;
                    }
                    //create the two matrices to add and a third to hold the addition
                    Matrix m1 = new Matrix(rows, columns, values1);
                    Matrix m2 = new Matrix(rows, columns, values2);
                    Matrix m3 = m1.add(m2);
                    System.out.print(m3);

                }
                /*SUBTRACT*/
                if (input == 3) {
                    System.out.println("What values should be in the first matrix? (the matrix to subtract FROM)");
                    //gets the user input values for matrix 1
                    while (rowCounter != rows + 1) {
                        while (columnCounter != columns + 1) {
                            System.out.println("Enter the value for row " + rowCounter + " column " + columnCounter);
                            values1.add(in.nextInt());
                            columnCounter++;
                        }
                        rowCounter++;
                        columnCounter = 1;
                    }
                    //reset to 1 not 0
                    rowCounter = 1;
                    columnCounter = 1;
                    System.out.println("What values should be in the second matrix? (The matrix to subtract)");
                    //gets the user input values for matrix 2
                    while (rowCounter != rows + 1) {
                        while (columnCounter != columns + 1) {
                            System.out.println("Enter the value for row " + rowCounter + " column " + columnCounter);
                            values2.add(in.nextInt());
                            columnCounter++;
                        }
                        rowCounter++;
                        columnCounter = 1;
                    }
                    //create the two matrices to subtract and a third to hold the subtraction
                    Matrix m1 = new Matrix(rows, columns, values1);
                    Matrix m2 = new Matrix(rows, columns, values2);
                    Matrix m3 = m1.subtract(m2);
                    System.out.print(m3);
                }
            }


        }

    }

}
