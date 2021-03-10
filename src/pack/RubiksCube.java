package pack;

public class RubiksCube {    
	
	private char[][] cube;
	
    public RubiksCube() {
    	cube = new char[6][9];
    	
    	//Order: left, front, right, back, top, bottom
    	char[] colors = new char[] {'G', 'R', 'B', 'O', 'W', 'Y'};
    	
    	for (int i = 0; i < cube.length; i++) {
    		for (int j = 0; j < cube[0].length; j++) {
    			cube[i][j] = colors[i];
    		}
    	}
    }

    //Moves for a Rubiks Cube

    public void move_U() {

    }

    public void move_D() {

    }

    public void move_R() {

    }

    public void move_L() {

    }

    public void move_F() {

    }

    public void move_B() {

    }

    //Inverse moves, p stands for prime

    public void move_Up() {

    }

    public void move_Dp() {

    }

    public void move_Rp() {

    }

    public void move_Lp() {

    }

    public void move_Fp() {

    }

    public void move_Bp() {
        
    }
    
    @Override
    public String toString() {
		
    	String toReturn = "";
    	
    	for (int i = 0; i < cube.length; i++) {
    		for (int j = 0; j < cube[0].length; j++) {
    			toReturn = toReturn + cube[i][j];
    		}
    	}
    	
    	return toReturn;
    	
    }
    
    //0 -> 2 -> 8 -> 6
    //1 -> 5 -> 7 -> 4
    private void rotateSide(int side, boolean clockwise) {
    	
    	char temp1 = cube[side][0];
    	char temp2 = cube[side][1];
    	
    	if (clockwise) {
        	cube[side][0] = cube[side][2];
        	cube[side][2] = cube[side][8];
        	cube[side][8] = cube[side][6];
        	cube[side][6] = temp1;
        	
        	cube[side][1] = cube[side][5];
        	cube[side][5] = cube[side][7];
        	cube[side][7] = cube[side][4];
        	cube[side][4] = temp2;
    	} else {
        	cube[side][0] = cube[side][6];
        	cube[side][6] = cube[side][8];
        	cube[side][8] = cube[side][2];
        	cube[side][2] = temp1;
        	
        	cube[side][1] = cube[side][4];
        	cube[side][4] = cube[side][7];
        	cube[side][7] = cube[side][5];
        	cube[side][5] = temp2;
    	}
    	
    }

}
