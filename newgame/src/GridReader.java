import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GridReader {
    int rows = 20;
    int collums = 20;
    int generations;
    String filepath = "C:\\Users\\alial\\Desktop\\OOP\\lifeThread2\\Grid.txt";

    char grid[][] = new char[rows][collums];

    public GridReader() {
        try {
            File fin = new File(filepath);
            Scanner scan = new Scanner(fin);

            int rowiterator = 0;
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    generations = scan.nextInt()
                    ;
                } else {
                    String temp = scan.nextLine();
                    for (int colliterator = 0; colliterator < temp.length(); colliterator++) {
                        grid[rowiterator][colliterator] = temp.charAt(colliterator);
                    }
                    rowiterator++;
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        for (int rowiterator = 0; rowiterator < rows; rowiterator++) {
            for (int colliterator = 0; colliterator < collums; colliterator++) {
                System.out.print(grid[rowiterator][colliterator]);
            }
            System.out.print("\n");
        }
    }
}

