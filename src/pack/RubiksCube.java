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
    	rotateFace(0, true);
    	
    	char temp0 = cube[1][0];
    	char temp3 = cube[1][3];
    	char temp6 = cube[1][6];
    	
    	cube[1][0] = cube[4][0];
    	cube[1][3] = cube[4][3];
    	cube[1][6] = cube[4][6];
    	
    	cube[4][0] = cube[3][8];
    	cube[4][3] = cube[3][5];
    	cube[4][6] = cube[3][2];
    	
    	cube[3][8] = cube[5][0];
    	cube[3][5] = cube[5][3];
    	cube[3][2] = cube[5][6];
    	
    	cube[5][0] = temp0;
    	cube[5][3] = temp3;
    	cube[5][6] = temp6;
    	
    }
    
    //index 1
    public void move_F() {
    	rotateFace(1, true);
    	
    	char temp8 = cube[0][8];
    	char temp5 = cube[0][5];
    	char temp2 = cube[0][2];
    	
    	cube[0][8] = cube[5][2];
    	cube[0][5] = cube[5][1];
    	cube[0][2] = cube[5][0];
    	
    	cube[5][2] = cube[2][0];
    	cube[5][1] = cube[2][3];
    	cube[5][0] = cube[2][6];
    	
    	cube[2][0] = cube[4][6];
    	cube[2][3] = cube[4][7];
    	cube[2][6] = cube[4][8];
    	
    	cube[4][6] = temp8;
    	cube[4][7] = temp5;
    	cube[4][8] = temp2;
    	
    }
    
    //index 2
    public void move_R() {
    	rotateFace(2, true);
    	
    	char temp8 = cube[5][8];
    	char temp5 = cube[5][5];
    	char temp2 = cube[5][2];
    	
    	cube[5][8] = cube[3][0];
    	cube[5][5] = cube[3][3];
    	cube[5][2] = cube[3][6];
    	
    	cube[3][0] = cube[4][8];
    	cube[3][3] = cube[4][5];
    	cube[3][6] = cube[4][2];
    	
    	cube[4][8] = cube[1][8];
    	cube[4][5] = cube[1][5];
    	cube[4][2] = cube[1][2];
    	
    	cube[1][8] = temp8;
    	cube[1][5] = temp5;
    	cube[1][2] = temp2;
    }
    
    //index 3
    public void move_B() {
    	rotateFace(3, true);
    	
    	char temp2 = cube[2][2];
    	char temp5 = cube[2][5];
    	char temp8 = cube[2][8];
    	
    	cube[2][2] = cube[5][8];
    	cube[2][5] = cube[5][7];
    	cube[2][8] = cube[5][6];
    	
    	cube[5][8] = cube[0][6];
    	cube[5][7] = cube[0][3];
    	cube[5][6] = cube[0][0];
    	
    	cube[0][6] = cube[4][0];
    	cube[0][3] = cube[4][1];
    	cube[0][0] = cube[4][2];
    	
    	cube[4][0] = temp2;
    	cube[4][1] = temp5;
    	cube[4][2] = temp8;
    }
    
    //index 4
    public void move_U() {
    	rotateFace(4, false);
    	
    	char temp2 = cube[2][2];
    	char temp1 = cube[2][1];
    	char temp0 = cube[2][0];
    	
    	cube[2][2] = cube[3][2];
    	cube[2][1] = cube[3][1];
    	cube[2][0] = cube[3][0];
    	
    	cube[3][2] = cube[0][2];
    	cube[3][1] = cube[0][1];
    	cube[3][0] = cube[0][0];
    	
    	cube[0][2] = cube[1][2];
    	cube[0][1] = cube[1][1];
    	cube[0][0] = cube[1][0];
    	
    	cube[1][2] = temp2;
    	cube[1][1] = temp1;
    	cube[1][0] = temp0;
    }
    
    //index 5
    public void move_D() {
    	
    }

    //Inverse moves, p stands for prime
    
    //index 0
    public void move_Lp() {
    	rotateFace(0, false);
    	
    	char temp0 = cube[4][0];
    	char temp3 = cube[4][3];
    	char temp6 = cube[4][6];
    	
    	cube[4][0] = cube[1][0];
    	cube[4][3] = cube[1][3];
    	cube[4][6] = cube[1][6];
    	
    	cube[1][0] = cube[5][0];
    	cube[1][3] = cube[5][3];
    	cube[1][6] = cube[5][6];
    	
    	cube[5][0] = cube[3][8];
    	cube[5][3] = cube[3][5];
    	cube[5][6] = cube[3][2];
    	
    	cube[3][8] = temp6;
    	cube[3][5] = temp3;
    	cube[3][2] = temp0;
    }
    
    //index 1
    //4 -> 0 -> 5 -> 2
    public void move_Fp() {
    	rotateFace(1, false);
    	
    	char temp6 = cube[4][6];
    	char temp7 = cube[4][7];
    	char temp8 = cube[4][8];
    	
    	cube[4][6] = cube[2][0];
    	cube[4][7] = cube[2][3];
    	cube[4][8] = cube[2][6];
    	
    	cube[2][0] = cube[5][2];
    	cube[2][3] = cube[5][1];
    	cube[2][6] = cube[5][0];
    	
    	cube[5][2] = cube[0][8];
    	cube[5][1] = cube[0][5];
    	cube[5][0] = cube[0][2];
    	
    	cube[0][8] = temp6;
    	cube[0][5] = temp7;
    	cube[0][2] = temp8;
    }
    
    //index 2
    public void move_Rp() {
    	rotateFace(2, false);
    	
    	char temp1 = cube[4][8];
    	char temp2 = cube[4][5];
    	char temp3 = cube[4][2];
    	
    	cube[4][8] = cube[3][0];
    	cube[4][5] = cube[3][3];
    	cube[4][2] = cube[3][6];
    	
    	cube[3][0] = cube[5][8];
    	cube[3][3] = cube[5][5];
    	cube[3][6] = cube[5][2];
    	
    	cube[5][8] = cube[1][8];
    	cube[5][5] = cube[1][5];
    	cube[5][2] = cube[1][2];
    	
    	cube[1][8] = temp1;
    	cube[1][5] = temp2;
    	cube[1][2] = temp3;
    }
    
    //index 3
    public void move_Bp() {
    	rotateFace(3, false);
    	
    	char temp1 = cube[4][0];
    	char temp2 = cube[4][1];
    	char temp3 = cube[4][2];
    	
    	cube[4][0] = cube[0][6];
    	cube[4][1] = cube[0][3];
    	cube[4][2] = cube[0][0];
    	
    	cube[0][6] = cube[5][8];
    	cube[0][3] = cube[5][7];
    	cube[0][0] = cube[5][6];
    	
    	cube[5][8] = cube[2][2];
    	cube[5][7] = cube[2][5];
    	cube[5][6] = cube[2][8];
    	
    	cube[2][2] = temp1;
    	cube[2][5] = temp2;
    	cube[2][8] = temp3;
    }
    
    //index 4
    public void move_Up() {
    	rotateFace(4, false);
    	
    	char temp1 = cube[3][0];
    	char temp2 = cube[3][1];
    	char temp3 = cube[3][2];
    	
    	cube[3][0] = cube[2][0];
    	cube[3][1] = cube[2][1];
    	cube[3][2] = cube[2][2];
    	
    	cube[2][0] = cube[1][0];
    	cube[2][1] = cube[1][1];
    	cube[2][2] = cube[1][2];
    	
    	cube[1][0] = cube[0][0];
    	cube[1][1] = cube[0][1];
    	cube[1][2] = cube[0][2];
    	
    	cube[0][0] = temp1;
    	cube[0][1] = temp2;
    	cube[0][2] = temp3;
    	
    }
    
    //index 5
    public void move_Dp() {
    	rotateFace(5, false);
    	
    	char temp1 = cube[1][6];
    	char temp2 = cube[1][7];
    	char temp3 = cube[1][8];
    	
    	cube[1][6] = cube[2][6];
    	cube[1][7] = cube[2][7];
    	cube[1][8] = cube[2][8];
    	
    	cube[2][6] = cube[3][6];
    	cube[2][7] = cube[3][7];
    	cube[2][8] = cube[3][8];
    	
    	cube[3][6] = cube[0][6];
    	cube[3][7] = cube[0][7];
    	cube[3][8] = cube[0][8];
    	
    	cube[0][6] = temp1;
    	cube[0][7] = temp2;
    	cube[0][8] = temp3;
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
