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

    //index 0
    public void move_L() {
    	
    }
    
    //index 1
    public void move_F() {
    	
    }
    
    //index 2
    public void move_R() {
    	
    }
    
    //index 3
    public void move_B() {
        
    }
    
    //index 4
    public void move_U() {
    	
    }
    
    //index 5
    public void move_D() {
    	
    }

    //Inverse moves, p stands for prime
    
    //index 0
    public void move_Lp() {
    	rotateFace(0, false);
    }
    
    //index 1
    //4 -> 0 -> 5 -> 2
    public void move_Fp() {
    	rotateFace(1, false);
    	
    	char temp1 = cube[4][6];
    	char temp2 = cube[4][7];
    	char temp3 = cube[4][8];
    	
    	cube[4][6] = cube[2][0];
    	cube[4][7] = cube[2][3];
    	cube[4][8] = cube[2][6];
    	
    	cube[2][0] = cube[5][2];
    	cube[2][3] = cube[5][1];
    	cube[2][6] = cube[5][0];
    	
    	cube[5][2] = cube[0][8];
    	cube[5][1] = cube[0][5];
    	cube[5][0] = cube[0][2];
    	
    	cube[0][8] = temp1;
    	cube[0][5] = temp2;
    	cube[0][2] = temp3;
    }
    
    //index 2
    public void move_Rp() {
    	rotateFace(2, false);
    }
    
    //index 3
    public void move_Bp() {
    	rotateFace(3, false);
    }
    
    //index 4
    public void move_Up() {
    	rotateFace(4, false);
    }
    
    //index 5
    public void move_Dp() {
    	rotateFace(5, false);
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
    private void rotateFace(int side, boolean clockwise) {
    	
    	char temp1 = cube[side][0];
    	char temp2 = cube[side][1];
    	
    	if (clockwise) {
    		
        	cube[side][0] = cube[side][6];
        	cube[side][6] = cube[side][8];
        	cube[side][8] = cube[side][2];
        	cube[side][2] = temp1;
        	
        	cube[side][1] = cube[side][3];
        	cube[side][3] = cube[side][7];
        	cube[side][7] = cube[side][5];
        	cube[side][5] = temp2;
        	
    	} else {

        	cube[side][0] = cube[side][2];
        	cube[side][2] = cube[side][8];
        	cube[side][8] = cube[side][6];
        	cube[side][6] = temp1;
        	
        	cube[side][1] = cube[side][5];
        	cube[side][5] = cube[side][7];
        	cube[side][7] = cube[side][3];
        	cube[side][3] = temp2;
    	}
    	
    }

}
