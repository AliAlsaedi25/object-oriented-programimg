import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class GridReader
{
    String filepath = "C:\\Users\\alial\\Desktop\\OOP\\newThreads\\Grid.txt";
    int rows = 20;
    int collums = 20;
    //rows and collums of the grid

    int rowCounter = 0;
    int collCounter = 0;
    int generations; // represents the number of generations to be viewed

    char [][] currGrid = new char [rows][collums];
    char [][] futureGrid = new char[rows][collums];

    /*
    this method will scan the text file going thrrough every line and putting it into
    a char grid I made until it reaches a number when it sees a number it assigns that number to generations
     */

    public GridReader () {

        try{
            File fin = new File(filepath);//file path
            Scanner scan = new Scanner(fin);
            do {

                if (scan.hasNextInt()){
                    generations = scan.nextInt(); //viewing the integer in the file and putting it in generations
                }
                else {
                    String templine = scan.nextLine();
                    for (int iterator = 0; iterator < templine.length(); iterator++){
                        currGrid[rowCounter][iterator] = templine.charAt(iterator);
                        collCounter++;
                    }
                }
            }while ((scan.hasNext())); //while their is still data
            collCounter = collCounter/rowCounter;
            scan.close(); // exit reading the file

        }
        catch (Exception e){
            e.printStackTrace();
        }

        for (int rowiterator = 0; rowiterator < rows; rowiterator++){
            for (int colliterator = 0; colliterator < collums; colliterator++){
                futureGrid [rowiterator] [colliterator] = '.';
            }
        }

    }
}
//done
