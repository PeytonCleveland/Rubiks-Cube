package com.cleveland.project;
import java.util.ArrayList;

public class rubiksCube {
	
    public int [][][] faces = new int [6][3][3];
    
	int [] random = {12,33,18,52,6,34,9,17,51,0,48,41,27,35,29,10,2,26,25,36,37,42,15,14,32,50,23,45,
						1,39,24,3,7,21,20,11,44,53,16,19,38,43,46,5,47,28,8,30};
	
	int seed = (int) (Math.random()*53);
	
	ArrayList<rubiksCube> children = new ArrayList<rubiksCube>();
	
	int lastMove = -1;
    
    int FRONT = 0,
    	TOP = 1,
    	BACK = 2,
    	BOTTOM = 3,
    	RIGHT = 4,
    	LEFT = 5;

	public void randomizeCube() {

    	for (int i = 0; i < 6; i++){
    		for (int j = 0; j < 3; j++){
    			for (int k = 0; k < 3; k++){
    				if(j==1 && k==1){
    					faces[i][j][k] = i*9+4;
    				}else{
    					faces [i][j][k] = getRandom();
    				}
    			}
    		}
    	}
    	
	}

	private int getRandom() {
    	int r = random[seed];
    	seed++;
    	if(seed > 47) seed = 0;
		return r;
	}
	
	public void rotateFront(){
		int temp1, temp2, temp3, temp4, temp5, temp6;
		temp1 = faces[2][1][2];
		temp2 = faces[2][2][2];
		faces[2][1][2] = faces[2][0][1];
		faces[2][2][2] = faces[2][0][2];
		temp3 = faces[2][2][1];
		temp4 = faces[2][2][0];
		faces[2][2][1] = temp1;
		faces[2][2][0] = temp2;
		temp5 = faces[2][1][0];
		temp6 = faces[2][0][0];
		faces[2][1][0] = temp3;
		faces[2][0][0] = temp4;
		faces[2][0][1] = temp5;
		faces[2][0][2] = temp6;
		
		temp1 = faces[3][0][0];
		temp2 = faces[3][1][0];
		temp3 = faces[3][2][0];
		faces[3][0][0] = faces[0][2][0];
		faces[3][1][0] = faces[0][2][1];
		faces[3][2][0] = faces[0][2][2];
		temp4 = faces[4][0][2];
		temp5 = faces[4][0][1];
		temp6 = faces[4][0][0];
		faces[4][0][2] = temp1;
		faces[4][0][1] = temp2;
		faces[4][0][0] = temp3;
		temp1 = faces[1][2][2];
		temp2 = faces[1][1][2];
		temp3 = faces[1][0][2];
		faces[1][2][2] = temp4;
		faces[1][1][2] = temp5;
		faces[1][0][2] = temp6;
		faces[0][2][0] = temp1;
		faces[0][2][1] = temp2;
		faces[0][2][2] = temp3;
	}
	
	public void rotateTop(){
		int temp1, temp2, temp3, temp4, temp5, temp6;
		temp1 = faces[0][1][2];
		temp2 = faces[0][2][2];
		faces[0][1][2] = faces[0][0][1];
		faces[0][2][2] = faces[0][0][2];
		temp3 = faces[0][2][1];
		temp4 = faces[0][2][0];
		faces[0][2][1] = temp1;
		faces[0][2][0] = temp2;
		temp5 = faces[0][1][0];
		temp6 = faces[0][0][0];
		faces[0][1][0] = temp3;
		faces[0][0][0] = temp4;
		faces[0][0][1] = temp5;
		faces[0][0][2] = temp6;
		
		temp1 = faces[3][0][2];
		temp2 = faces[3][0][1];
		temp3 = faces[3][0][0];
		faces[3][0][2] = faces[5][2][0];
		faces[3][0][1] = faces[5][2][1];
		faces[3][0][0] = faces[5][2][2];
		temp4 = faces[2][0][2];
		temp5 = faces[2][0][1];
		temp6 = faces[2][0][0];
		faces[2][0][2] = temp1;
		faces[2][0][1] = temp2;
		faces[2][0][0] = temp3;
		temp1 = faces[1][0][2];
		temp2 = faces[1][0][1];
		temp3 = faces[1][0][0];
		faces[1][0][2] = temp4;
		faces[1][0][1] = temp5;
		faces[1][0][0] = temp6;
		faces[5][2][0] = temp1;
		faces[5][2][1] = temp2;
		faces[5][2][2] = temp3;
	}
	
	public void rotateBack(){
		int temp1, temp2, temp3, temp4, temp5, temp6;
		temp1 = faces[5][1][2];
		temp2 = faces[5][2][2];
		faces[5][1][2] = faces[5][0][1];
		faces[5][2][2] = faces[5][0][2];
		temp3 = faces[5][2][1];
		temp4 = faces[5][2][0];
		faces[5][2][1] = temp1;
		faces[5][2][0] = temp2;
		temp5 = faces[5][1][0];
		temp6 = faces[5][0][0];
		faces[5][1][0] = temp3;
		faces[5][0][0] = temp4;
		faces[5][0][1] = temp5;
		faces[5][0][2] = temp6;
		
		temp1 = faces[3][2][2];
		temp2 = faces[3][1][2];
		temp3 = faces[3][0][2];
		faces[3][2][2] = faces[4][2][0];
		faces[3][1][2] = faces[4][2][1];
		faces[3][0][2] = faces[4][2][2];
		temp4 = faces[0][0][2];
		temp5 = faces[0][0][1];
		temp6 = faces[0][0][0];
		faces[0][0][2] = temp1;
		faces[0][0][1] = temp2;
		faces[0][0][0] = temp3;
		temp1 = faces[1][0][0];
		temp2 = faces[1][0][1];
		temp3 = faces[1][0][2];
		faces[1][0][0] = temp4;
		faces[1][0][1] = temp5;
		faces[1][0][2] = temp6;
		faces[0][2][0] = temp1;
		faces[0][2][1] = temp2;
		faces[0][2][2] = temp3;
	}
	
	public void rotateBottom(){
		int temp1, temp2, temp3, temp4, temp5, temp6;
		temp1 = faces[4][1][2];
		temp2 = faces[4][2][2];
		faces[4][1][2] = faces[4][0][1];
		faces[4][2][2] = faces[4][0][2];
		temp3 = faces[4][2][1];
		temp4 = faces[4][2][0];
		faces[4][2][1] = temp1;
		faces[4][2][0] = temp2;
		temp5 = faces[4][1][0];
		temp6 = faces[4][0][0];
		faces[4][1][0] = temp3;
		faces[4][0][0] = temp4;
		faces[4][0][1] = temp5;
		faces[4][0][2] = temp6;
		
		temp1 = faces[3][2][0];
		temp2 = faces[3][2][1];
		temp3 = faces[3][2][2];
		faces[3][2][0] = faces[2][2][0];
		faces[3][2][1] = faces[2][2][1];
		faces[3][2][2] = faces[2][2][2];
		temp4 = faces[5][0][2];
		temp5 = faces[5][0][1];
		temp6 = faces[5][0][0];
		faces[5][0][2] = temp1;
		faces[5][0][1] = temp2;
		faces[5][0][0] = temp3;
		temp1 = faces[1][2][0];
		temp2 = faces[1][2][1];
		temp3 = faces[1][2][2];
		faces[1][2][0] = temp4;
		faces[1][2][1] = temp5;
		faces[1][2][2] = temp6;
		faces[2][2][0] = temp1;
		faces[2][2][1] = temp2;
		faces[2][2][2] = temp3;
	}
	
	public void rotateRight(){
		int temp1, temp2, temp3, temp4, temp5, temp6;
		temp1 = faces[3][1][2];
		temp2 = faces[3][2][2];
		faces[3][1][2] = faces[3][0][1];
		faces[3][2][2] = faces[3][0][2];
		temp3 = faces[3][2][1];
		temp4 = faces[3][2][0];
		faces[3][2][1] = temp1;
		faces[3][2][0] = temp2;
		temp5 = faces[3][1][0];
		temp6 = faces[3][0][0];
		faces[3][1][0] = temp3;
		faces[3][0][0] = temp4;
		faces[3][0][1] = temp5;
		faces[3][0][2] = temp6;
		
		temp1 = faces[5][2][2];
		temp2 = faces[5][1][2];
		temp3 = faces[5][0][2];
		faces[5][2][2] = faces[0][2][2];
		faces[5][1][2] = faces[0][1][2];
		faces[5][0][2] = faces[0][0][2];
		temp4 = faces[4][2][2];
		temp5 = faces[4][1][2];
		temp6 = faces[4][0][2];
		faces[4][2][2] = temp1;
		faces[4][1][2] = temp2;
		faces[4][0][2] = temp3;
		temp1 = faces[2][2][2];
		temp2 = faces[2][1][2];
		temp3 = faces[2][0][2];
		faces[2][2][2] = temp4;
		faces[2][1][2] = temp5;
		faces[2][0][2] = temp6;
		faces[0][2][2] = temp1;
		faces[2][1][2] = temp2;
		faces[2][0][2] = temp3;
	}
	
	public void rotateLeft(){
		int temp1, temp2, temp3, temp4, temp5, temp6;
		temp1 = faces[1][1][2];
		temp2 = faces[1][2][2];
		faces[1][1][2] = faces[1][0][1];
		faces[1][2][2] = faces[1][0][2];
		temp3 = faces[1][2][1];
		temp4 = faces[1][2][0];
		faces[1][2][1] = temp1;
		faces[1][2][0] = temp2;
		temp5 = faces[1][1][0];
		temp6 = faces[1][0][0];
		faces[1][1][0] = temp3;
		faces[1][0][0] = temp4;
		faces[1][0][1] = temp5;
		faces[1][0][2] = temp6;
		
		temp1 = faces[2][0][0];
		temp2 = faces[2][1][0];
		temp3 = faces[2][2][0];
		faces[2][0][0] = faces[0][0][0];
		faces[2][1][0] = faces[0][1][0];
		faces[2][2][0] = faces[0][2][0];
		temp4 = faces[4][0][0];
		temp5 = faces[4][1][0];
		temp6 = faces[4][2][0];
		faces[4][0][0] = temp1;
		faces[4][1][0] = temp2;
		faces[4][2][0] = temp3;
		temp1 = faces[5][0][0];
		temp2 = faces[5][1][0];
		temp3 = faces[5][2][0];
		faces[5][0][0] = temp4;
		faces[5][1][0] = temp5;
		faces[5][2][0] = temp6;
		faces[0][0][0] = temp1;
		faces[0][1][0] = temp2;
		faces[0][2][0] = temp3;
	}
	
	public void printCube() {
		
		System.out.println("Printing cube: ");

    	for (int i = 0; i < 6; i++){
    		for (int j = 0; j < 3; j++){
    			for (int k = 0; k < 3; k++){
    				System.out.print(faces[i][j][k] + " ");
    			}
    			System.out.println();
    		}
    		System.out.println(" ");
    	}
    	
	}
	


	public void visit() {
		for(int i = 0; i < 6; i++){
			if(i == lastMove){
				//don't reverse last move
			}else{
				rubiksCube child = this;
				if(i == 0){
					child.rotateFront();
					child.lastMove = 0;
				}else if(i == 1){
					child.rotateTop();
					child.lastMove = 1;
				}else if(i == 2){
					child.rotateBack();
					child.lastMove = 2;
				}else if(i == 3){
					child.rotateBottom();
					child.lastMove = 3;
				}else if(i == 4){
					child.rotateRight();
					child.lastMove = 4;
				}else if(i == 5){
					child.rotateLeft();
					child.lastMove = 5;
				}
				children.add(child);
			}
		}
	}

}
