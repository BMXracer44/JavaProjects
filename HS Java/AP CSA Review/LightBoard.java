public class LightBoard {
    
    private boolean[][] lights;
    /** Constructs a LightBoard object having numRows rows and numCols columns.
    * Precondition: numRows > 0, numCols > 0
    * Postcondition: each light has a 40% probability of being set to on.
    */
    public LightBoard(int numRows, int numCols)
    { 
    
        lights = new boolean[numRows][numCols];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(Math.random() * 10 + 1 < 5){
                    lights[i][j] = true;
                }
                else{
                    lights[i][j] = false;
                }
            }
        }
        
    
    }
    /** Evaluates a light in row index row and column index col and returns a status
    * as described in part (b).
    * Precondition: row and col are valid indexes in lights.
    */
    public boolean evaluateLight(int row, int col)
    { 
        int counter = 0;
        for(int i = 0; i < lights.length; i++){
            for(int j = 0; j < lights[0].length; j++){
                if(lights[i][j] == true){
                    for(int k = 0; k < lights[0].length; k++){
                        if(lights[i][k] == true){
                            counter++;
                        }
                    }
                    if(counter % 2 == 0){
                        return false;
                    }
                }
                else if(lights[i][j] == false){
                    for(int k = 0; k < lights[0].length; k++){
                        if(lights[i][k] == true){
                            counter++;
                        }
                        if(counter % 3 == 0){
                            return true;
                        }
                }

    }
    else{
        return lights[i][j];
    }
    // There may be additional instance variables, constructors, and methods not shown.
   }
        }
}
}

