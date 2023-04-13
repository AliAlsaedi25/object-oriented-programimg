import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Cells extends Thread {
    char status;
    int rows = 20;
    int collums = 20;
    int cellX;
    int cellY;
    char array [][] = new char[rows][collums];
    int neighbor = 0;
    public Thread thread;

    public Cells(int cellX, int cellY, char[][] gameArray) {
        this.cellX = cellX;
        this.cellY = cellY;
        this.status = array[cellX][cellY];

        for (int rowiterator = 0; rowiterator < rows; rowiterator++) {
            for (int colliterator = 0; colliterator < collums; colliterator++){
                array[rowiterator][colliterator] = gameArray[rowiterator][colliterator];
            }
        }
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        neighbor = checkNeighbors(cellX,cellY);
        rules(cellY,cellY);
    }

    /*
    this method will check the neighboring cells and act accordingly depending on the value via the rules
    of the game
     */
    public int checkNeighbors(int cellX, int cellY){
        for (int rowChecker = 0; rowChecker <= 1; rowChecker++){
            for (int collChecker = 0; collChecker <= 1; collChecker++){
                if ((cellX + rowChecker>=0 && cellX + rowChecker<rows)
                        && (cellY+collChecker>=0 && cellY + collChecker<collums)
                        && (array[cellX+rowChecker][cellY+collChecker] == 'X'))
                    neighbor++;
            }
        }
        if (array[cellX][cellY] == 'X'){
            neighbor--;
        }
        return neighbor;
    }

    /*
    these are the rules of the game of life
     */
    public void rules( int cellX, int cellY){
        if ((status == 'X') && (neighbor < 2 || neighbor > 3)){
            status = '.';
        }
        else if ((status == '.') && (neighbor == 3)){
            status = 'X';
        }
    }

}
//done
