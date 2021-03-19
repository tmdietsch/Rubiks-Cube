package pack;

import java.util.Random;


public class RubiksCube {    
	
	public final static RubiksCube REFERENCE = new RubiksCube();
	private Cubelet[][] cube;
	
    public RubiksCube() {
    	cube = new Cubelet[6][9];
    	
    	//Order: left, front, right, back, top, bottom
    	char[] colors = new char[] {'G', 'R', 'B', 'O', 'W', 'Y'};
    	
    	for (int i = 0; i < cube.length; i++) {
    		for (int j = 0; j < cube[0].length; j++) {
    			cube[i][j] = new Cubelet(colors[i]);
    		}
    	}
    	
    	cubeletNeighborInit();
    }
    
    public RubiksCube(String cubeStr) {
    	cube = new Cubelet[6][9];
    	
    	for (int i = 0; i < cube.length; i++) {
    		for (int j = 0; j < cube[0].length; j++) {
    			cube[i][j] = new Cubelet(cubeStr.charAt(i * 9 + j));
    		}
    	}
    }
    
    private void cubeletNeighborInit() {
    	
    	cube[1][0].addNeighbor(cube[4][6]);
    	cube[1][0].addNeighbor(cube[0][2]);
    	
    	cube[1][2].addNeighbor(cube[2][0]);
    	cube[1][2].addNeighbor(cube[4][8]);
    	
    	cube[1][6].addNeighbor(cube[0][8]);
    	cube[1][6].addNeighbor(cube[5][0]);
    	
    	cube[1][8].addNeighbor(cube[2][6]);
    	cube[1][8].addNeighbor(cube[5][2]);
    	
    	
    	
    	cube[3][0].addNeighbor(cube[4][2]);
    	cube[3][0].addNeighbor(cube[2][2]);
    	
    	cube[3][2].addNeighbor(cube[0][0]);
    	cube[3][2].addNeighbor(cube[4][0]);
    	
    	cube[3][6].addNeighbor(cube[2][8]);
    	cube[3][6].addNeighbor(cube[5][8]);
    	
    	cube[3][8].addNeighbor(cube[5][6]);
    	cube[3][8].addNeighbor(cube[0][8]);
    	
    	
    	
    	cube[1][1].addNeighbor(cube[4][7]);
    	
    	cube[1][3].addNeighbor(cube[0][5]);
    	
    	cube[1][5].addNeighbor(cube[2][3]);
    	
    	cube[1][7].addNeighbor(cube[5][1]);
    	
    	
    	
    	cube[3][1].addNeighbor(cube[4][1]);
    	
    	cube[3][3].addNeighbor(cube[2][5]);
    	
    	cube[3][5].addNeighbor(cube[0][3]);
    	
    	cube[3][7].addNeighbor(cube[5][7]);
    	
    	
    	
    	cube[2][1].addNeighbor(cube[4][5]);
    	
    	cube[2][7].addNeighbor(cube[5][5]);
    	
    	cube[0][1].addNeighbor(cube[4][3]);
    	
    	cube[0][7].addNeighbor(cube[5][3]);
    	
    }

    //Moves for a Rubiks Cube

    //index 0
    public void move_L() {
    	rotateFace(0, true);
    	
    	Cubelet temp0 = cube[1][0];
    	Cubelet temp3 = cube[1][3];
    	Cubelet temp6 = cube[1][6];
    	
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
    	
    	Cubelet temp8 = cube[0][8];
    	Cubelet temp5 = cube[0][5];
    	Cubelet temp2 = cube[0][2];
    	
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
    	
    	Cubelet temp8 = cube[5][8];
    	Cubelet temp5 = cube[5][5];
    	Cubelet temp2 = cube[5][2];
    	
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
    	
    	Cubelet temp2 = cube[2][2];
    	Cubelet temp5 = cube[2][5];
    	Cubelet temp8 = cube[2][8];
    	
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
    	rotateFace(4, true);
    	
    	Cubelet temp2 = cube[2][2];
    	Cubelet temp1 = cube[2][1];
    	Cubelet temp0 = cube[2][0];
    	
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
    	rotateFace(5, true);
    	
    	Cubelet temp2 = cube[0][6];
    	Cubelet temp1 = cube[0][7];
    	Cubelet temp0 = cube[0][8];
    	
    	cube[0][6] = cube[3][6];
    	cube[0][7] = cube[3][7];
    	cube[0][8] = cube[3][8];
    	
    	cube[3][6] = cube[2][6];
    	cube[3][7] = cube[2][7];
    	cube[3][8] = cube[2][8];
    	
    	cube[2][6] = cube[1][6];
    	cube[2][7] = cube[1][7];
    	cube[2][8] = cube[1][8];
    	
    	cube[1][6] = temp2;
    	cube[1][7] = temp1;
    	cube[1][8] = temp0;
    }

    //Inverse moves, p stands for prime
    
    //index 0
    public void move_Lp() {
    	rotateFace(0, false);
    	
    	Cubelet temp0 = cube[4][0];
    	Cubelet temp3 = cube[4][3];
    	Cubelet temp6 = cube[4][6];
    	
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
    	
    	Cubelet temp6 = cube[4][6];
    	Cubelet temp7 = cube[4][7];
    	Cubelet temp8 = cube[4][8];
    	
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
    	
    	Cubelet temp1 = cube[4][8];
    	Cubelet temp2 = cube[4][5];
    	Cubelet temp3 = cube[4][2];
    	
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
    	
    	Cubelet temp1 = cube[4][0];
    	Cubelet temp2 = cube[4][1];
    	Cubelet temp3 = cube[4][2];
    	
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
    	
    	Cubelet temp1 = cube[3][0];
    	Cubelet temp2 = cube[3][1];
    	Cubelet temp3 = cube[3][2];
    	
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
    	
    	Cubelet temp1 = cube[1][6];
    	Cubelet temp2 = cube[1][7];
    	Cubelet temp3 = cube[1][8];
    	
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
    			toReturn = toReturn + cube[i][j].color;
    		}
    	}
    	
    	return toReturn;
    	
    }
    
    //0 -> 2 -> 8 -> 6
    //1 -> 5 -> 7 -> 4
    private void rotateFace(int side, boolean clockwise) {
    	
    	Cubelet temp1 = cube[side][0];
    	Cubelet temp2 = cube[side][1];
    	
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
    
    public void rotateCube(int direction) {
    	
    	int[] sides;
    	Cubelet[] holder;
    	
    	switch (direction) {
    	
    	case 0:
    		sides = new int[] {1, 4, 3, 5};
    		rotateFace(0, true);
    		rotateFace(2, false);
    		break;
    	case 1:
    		sides = new int[] {0, 4, 2, 5};
    		rotateFace(1, false);
    		rotateFace(3, true);
    		break;
    	case 2:
    		sides = new int[] {0, 1, 2, 3};
    		rotateFace(4, true);
    		rotateFace(5, false);
    		break;
    	case 3:
    		sides = new int[] {5, 3, 4, 1};
    		rotateFace(0, false);
    		rotateFace(2, true);
    		break;
    	case 4:
    		sides = new int[] {5, 2, 4, 0};
    		rotateFace(1, true);
    		rotateFace(3, false);
    		break;
    	case 5:
    		sides = new int[] {1, 4, 3, 5};
    		rotateFace(0, true);
    		rotateFace(2, false);
    		break;
    	default:
    		return;
    	}
    	
    	holder = cube[sides[0]];
    	
    	cube[sides[0]] = cube[sides[1]];
    	cube[sides[1]] = cube[sides[2]];
    	cube[sides[2]] = cube[sides[3]];
    	cube[sides[3]] = holder;
    	
    }

    public void printCube() {
    	System.out.println("      |" + cube[4][0].color + "|" + cube[4][1].color + "|" + cube[4][2].color + "|");
    	System.out.println("      |" + cube[4][3].color + "|" + cube[4][4].color + "|" + cube[4][5].color + "|");
    	System.out.println("      |" + cube[4][6].color + "|" + cube[4][7].color + "|" + cube[4][8].color + "|");
    	System.out.println("|"+ cube[0][0].color + "|" + cube[0][1].color + "|" + cube[0][2].color + "|" + 
    			cube[1][0].color + "|" + cube[1][1].color + "|" + cube[1][2].color + "|" +
    			cube[2][0].color + "|" + cube[2][1].color + "|" + cube[2][2].color + "|" +
    			cube[3][0].color + "|" + cube[3][1].color + "|" + cube[3][2].color + "|");
    	System.out.println("|"+ cube[0][3].color + "|" + cube[0][4].color + "|" + cube[0][5].color + "|" + 
    			cube[1][3].color + "|" + cube[1][4].color + "|" + cube[1][5].color + "|" +
    			cube[2][3].color + "|" + cube[2][4].color + "|" + cube[2][5].color + "|" +
    			cube[3][3].color + "|" + cube[3][4].color + "|" + cube[3][5].color + "|");
    	System.out.println("|"+ cube[0][6].color + "|" + cube[0][7].color + "|" + cube[0][8].color + "|" + 
    			cube[1][6].color + "|" + cube[1][7].color + "|" + cube[1][8].color + "|" +
    			cube[2][6].color + "|" + cube[2][7].color + "|" + cube[2][8].color + "|" +
    			cube[3][6].color + "|" + cube[3][7].color + "|" + cube[3][8].color + "|");
    	System.out.println("      |" + cube[5][0].color + "|" + cube[5][1].color + "|" + cube[5][2].color + "|");
    	System.out.println("      |" + cube[5][3].color + "|" + cube[5][4].color + "|" + cube[5][5].color + "|");
    	System.out.println("      |" + cube[5][6].color + "|" + cube[5][7].color + "|" + cube[5][8].color + "|");
    }
    
    public void randomize(int n) {
    	Random rand = new Random();
    	int r;
    	for(int i = 0; i < n; i++) {
    		r = rand.nextInt(12);
    		switch(r) {
    		
    		case 0:
    			this.move_F();
    			break;
    			
    		case 1:
    			this.move_Fp();
    			break;
    			
    		case 2:
    			this.move_B();
    			break;
    			
    		case 3:
    			this.move_Bp();
    			break;
    			
    		case 4:
    			this.move_D();
    			break;
    			
    		case 5:
    			this.move_Dp();
    			break;
    			
    		case 6:
    			this.move_L();
    			break;
    			
    		case 7:
    			this.move_Lp();
    			break;
    			
    		case 8:
    			this.move_R();
    			break;
    		
    		case 9:
    			this.move_Rp();
    			break;
    			
    		case 10:
    			this.move_U();
    			break;
    			
    		case 11:
    			this.move_Up();
    			break;
    		}
    	}
    	
//    	setColorDistances();
    }
    
    private void setCube(RubiksCube o) {
    	Cubelet[][] original = o.getCube();
    	for(int i = 0; i < 6; i++) {
    		for(int j = 0; j < 9; j++) {
    			cube[i][j] = original[i][j];
    		}
    	}
    	
    }
    
    public RubiksCube copy() {
    	RubiksCube c = new RubiksCube();
    	c.setCube(this);
    	return c;
    }
    
    /**
     * Accepts characters: F, B, D, L, R, U
     * 
     * @param moveType
     * @return
     */
    public RubiksCube move_copy(char moveType, int clockwise) {
    	
    	RubiksCube toReturn = this.copy();
    	
    	if (clockwise == 0) {
	    	switch(moveType) {
			
			case 'F':
				toReturn.move_F();
				break;
				
			case 'B':
				toReturn.move_B();
				break;
				
			case 'D':
				toReturn.move_D();
				break;
				
			case 'L':
				toReturn.move_L();
				break;
				
			case 'R':
				toReturn.move_R();
				break;
					
			case 'U':
				toReturn.move_U();
				break;
			default:
				throw new IllegalArgumentException();
			}
	    }
    	else if (clockwise == 1) {
	    	switch(moveType) {
			
			case 'F':
				toReturn.move_Fp();
				break;
				
			case 'B':
				toReturn.move_Bp();
				break;
				
			case 'D':
				toReturn.move_Dp();
				break;
				
			case 'L':
				toReturn.move_Lp();
				break;
				
			case 'R':
				toReturn.move_Rp();
				break;
					
			case 'U':
				toReturn.move_Up();
				break;
			default:
				throw new IllegalArgumentException();
			}
    	}
//    	else {
//	    	switch(moveType) {
//			
//			case 'F':
//				toReturn.move_F();
//				toReturn.move_F();
//				break;
//				
//			case 'B':
//				toReturn.move_B();
//				toReturn.move_B();
//				break;
//				
//			case 'D':
//				toReturn.move_D();
//				toReturn.move_D();
//				break;
//				
//			case 'L':
//				toReturn.move_L();
//				toReturn.move_L();
//				break;
//				
//			case 'R':
//				toReturn.move_R();
//				toReturn.move_R();
//				break;
//					
//			case 'U':
//				toReturn.move_U();
//				toReturn.move_U();
//				break;
//			default:
//				throw new IllegalArgumentException();
//			}
//    	}
    	
    	return toReturn;
    }

    public Boolean equals(RubiksCube c) {
    	return this.toString().equals(c.toString());
    }
    
    public Boolean equalsString(String c) {
    	return this.toString().equals(c);
    }

    public Cubelet[][] getCube() {return cube;}
    
    public char getColorAt(int index) {
    	return cube[index / cube[0].length] [index % cube[0].length].color;
    }
    
    public char getColorAt(int side, int num) {
    	return cube[side][num].color;
    }
    
    public int heuristic() {
		
    	int thisResult = 0;
    	int max = 0;
    	
    	for (int i = 0; i < cube.length; i++) {
    		Cubelet temp = cube[i][4];	//getting center square
    		
    		for (int j = 0; j < cube[i].length; j++) {
    			if (! (cube[i][j].color == temp.color && cube[i][j].color == REFERENCE.cube[i][j].color)) {
    				if (j % 2 == 0)
    					thisResult += 1;
    				else
    					thisResult += 1;
    				
//    				if (thisResult > max)
//    					max = thisResult;
    			}
    		}
    		
    	}
    	
    	return thisResult;
    	
    }
    
}
