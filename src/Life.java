

public class Life
{

    /**
     * The static applyRule method takes the current board and
     * board based on the standard rules of Conway's Life:
     * 1. existing cell dies if fewer than 2 neighbors (underpopulation)
     * 2. existing cell lives if 2-3 neighbors ("these neighbors are JUST RIGHT!")
     * 3. existing cell dies if greater than 3 neighbors (overpopulation)
     * 4. empty cell becomes alive if exactly 3 neighbors (because...?)
     */
        public static void applyRules(int[][] array) {
        int[][] newArray = new int[array.length][array.length];
        for(int y = 1; y < array.length - 1; y++) {
            for(int x = 1; x < array.length - 1; x++) {
                int neighbors = neighborsCounter(array, x, y);
                if(array[x][y] == 1) {
                    if((neighbors < 2) || (neighbors > 3)) {
                        newArray[x][y] = 0;
                    }
                    if((neighbors == 2) || (neighbors == 3)) {
                        newArray[x][y] = 1;
                    }
                }
                else if(array[x][y] == 0){
                    if(neighbors == 3) {
                        newArray[x][y] = 1;
                    }
                    else {
                        newArray[x][y] = 0;
                    }
                }
            }
        }

        for(int i = 1; i < array.length - 1; i++){
            for(int j = 1; j < array.length - 1; j++) {
                array[i][j] = newArray[i][j];
            }
        }

    }
    /**
    * * The static method neighborsCounter counts the eight cells around a given
    * cell, making sure not to count outside of the bounds of the array and
    * not to count the current cell itself!
    */
        public static int neighborsCounter(int[][] array, int x, int y) {
            int neighbors = 0;
            for(int i = x - 1; i <= x + 1; i++) {
                for(int j = y - 1; j <= y + 1; j++) {
                    if(array[i][j] == 1) {
                        neighbors = neighbors + 1;
                    }
                }
            }

            if(array[x][y] == 1) {
                neighbors = neighbors - 1;
            }
            return neighbors;
        }

//Black cell grid on the GUI
        public static void grid(int[][] array){
            array[9][5]=1;
            array[9][6]=1;
            array[9][7]=1;
            array[8][7]=1;
            array[7][6]=1;
            array[10][4]=1;
            array[10][7]=1;
            array[10][8]=1;
            array[10][9]=1;
            array[10][10]=1;
            array[13][7]=1;
            array[13][8]=1;
            array[13][9]=1;
        }



    public static void main(String[] args) throws InterruptedException
    {
        GameOfLifeGui gui = new GameOfLifeGui();
        int [][] array = new int [71][72];
        grid(array);
        GameOfLifeGui.printingOut(array);
    }
}
