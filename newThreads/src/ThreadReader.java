import java.util.ArrayList;

public class ThreadReader
{
    GridReader reader = new GridReader(); // instance of grid reader to use the method
    int generations = reader.generations; //generations from text file
    int rows = 20;
    int collums = 20;
    ArrayList<Cells> checkers = new ArrayList<>(); //the checker or "tossers" to work simotaniously
    char grid [][] = new char[rows][collums];
    /*
        this method essential runs the game and uses the other methods in the class
    */
    public ThreadReader (char gameArray[][]) throws InterruptedException {
        System.out.println("the number of genrations is " + generations + "\n"); //display generations
        duplicate(gameArray,grid);
        for (int genIterator = 0; genIterator < generations; genIterator++){
            threadBuilder(gameArray);
            gridBuilder();
            duplicate(grid,gameArray);
            checkers.clear();
        }
        display();

    }

    public void threadBuilder (char array [][]) throws InterruptedException{
        int totalCells = rows * collums; // total number of threads to have
        for (int rowIterator = 0; rowIterator < rows; rowIterator++){
            for (int collIterator = 0; collIterator < collums; collIterator++){
                checkers.add(new Cells(rowIterator,collIterator,array));
            }
        }
        for (int i = 0; i < totalCells; i++){
            checkers.get(i).start();
        }
        for (int i = 0; i < totalCells; i++){
            checkers.get(i).thread.join();
        }
    }

    public void gridBuilder (){
        int counter = 0;
        for (int rowIterator = 0; rowIterator < rows; rowIterator++){
            for (int collIterator = 0; collIterator < collums; collIterator++){
                grid[rowIterator][collIterator] = checkers.get(counter).status;
                counter++;
            }
        }
    }

    public void duplicate(char copy[][], char done [][]){
        for (int rowiterator = 0; rowiterator < rows; rowiterator++){
            for (int colliterator = 0; colliterator < collums; colliterator++){
                done[rowiterator][colliterator] = copy[rowiterator][colliterator];
            }
        }
    }


    public void display(){
        for (int rowiterator = 0; rowiterator < rows; rowiterator++){
            for (int colliterator = 0; colliterator < collums; colliterator++){
                System.out.print(grid[rowiterator][colliterator]);
            }
            System.out.print("\n");
        }
    }
}
//done