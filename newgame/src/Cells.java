public class Cells
{
    GridReader reader = new GridReader();
    int rows = reader.rows;
    int collums = reader.collums;
    int generations = reader.generations;

    char Currentgrid[][] = new char[rows][collums];
    char Futuregrid[][] = new char[rows][collums];
    /*
    the two grids are used to hold the state of each cell after they have been evalualted to the rules of the
    game the future girid becomes the current and so on until the number of generations
     */

    /*
    this funtion will make sure that the curent grid is the smae as the grid that has been
    read in from the file in the grid reader class
     */
    public Cells (){
        for (int rowiterator = 0; rowiterator < rows; rowiterator++) {
            for (int colliterator = 0; colliterator < collums; colliterator++) {
                Currentgrid[rowiterator][colliterator] = reader.grid[rowiterator][colliterator];
            }
        }

    }

    /*
    this funtion is simply going through every cell and making the  future grid the current grid
     */

    public void run (){
        for (int geniterator = 0; geniterator < generations; geniterator++){
            AdjustCells();
            for (int rowiterator = 0; rowiterator < rows; rowiterator++) {
                for (int colliterator = 0; colliterator < collums; colliterator++) {
                    Currentgrid[rowiterator][colliterator] = Futuregrid[rowiterator][colliterator];
                }
            }
        }
        display();
    }

    /*
    this funtion is determining the rules of teh game and evaluating each cell to see
    how to evaluate each cell
     */

    public void rules (int cellX, int cellY, int neighbor){
        if ((Currentgrid[cellX][cellY] == 'X') && (neighbor<2)){
            Futuregrid[cellX][cellY] = '.';
        }
        else if ((Currentgrid[cellX][cellY] == 'X') && (neighbor>3)){
            Futuregrid[cellX][cellY] = '.';
        }
        else if ((Currentgrid[cellX][cellY] == '.') && (neighbor==3)){
            Futuregrid[cellX][cellY] = 'X';
        }
        else {
            Futuregrid[cellX][cellY] = Currentgrid[cellX][cellY];
        }
    }



    public void AdjustCells(){
        for (int cellX = 0; cellX < rows; cellX++){
            for (int cellY = 0; cellY < collums; cellY++){
                int neighbor = checkNeighbor(cellX,cellY);
                rules(cellX,cellY,neighbor);
            }
        }
    }

    /*
    this method is evaluating each cell and neihbor to determin if it is cell good or not
     */

    public int checkNeighbor(int cellX, int cellY){
        int neighbor = 0;
        for (int rowiterator = -1; rowiterator <= 1; rowiterator++){
            for (int colliterator = -1; colliterator <=1; colliterator++) {
                if ((cellX + rowiterator >=0 && cellX + rowiterator < rows ) &&
                        (cellY + colliterator >=0 && cellY + colliterator < collums) &&
                        (Currentgrid[cellX+rowiterator][cellY+colliterator] == 'X'))
                    neighbor++;
            }
        }
        if (Currentgrid[cellX][cellX] == 'X'){
            neighbor--;
        }
        return neighbor;
    }



    public void display() {
        for (int rowiterator = 0; rowiterator < rows; rowiterator++) {
            for (int colliterator = 0; colliterator < collums; colliterator++) {
                System.out.print(Currentgrid[rowiterator][colliterator]);
            }
            System.out.print("\n");
        }
    }

}
//apple
