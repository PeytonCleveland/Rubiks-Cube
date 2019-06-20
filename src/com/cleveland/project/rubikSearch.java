package com.cleveland.project;
import java.util.Stack;

public class rubikSearch {
	
	public rubiksCube Goal;
	public rubiksCube searchCube;
	private boolean solved = false;
	
	public rubikSearch(rubiksCube r){
		searchCube = r;
		Goal = new rubiksCube();
		int index = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++){
					Goal.faces[i][j][k] = index;
					index++;
				}
			}
		}
		Goal.printCube();
	}
	
	public void search(){
		
		Stack<rubiksCube> stack= new Stack<rubiksCube>();
		stack.push(searchCube);
		rubiksCube currentCube;
		int depth = 1;
		
		while(!stack.isEmpty() && solved == false){
			currentCube = stack.pop();
			depth--;
			if(checkGoal(currentCube)) solved = true;
			else{
				if(depth < 22){
					currentCube.visit();
					depth++;
					while(!currentCube.children.isEmpty()){
						stack.push(currentCube.children.get(0));
						currentCube.children.remove(0);
					}
				}else{
					System.out.println("Depth reached");
				}
			}
		}
	}

	private boolean checkGoal(rubiksCube currentCube) {
		if(currentCube.faces == Goal.faces){
			System.out.println("Goal Found!");
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		rubiksCube r = new rubiksCube();
		r.randomizeCube();
		r.printCube();
		rubikSearch search = new rubikSearch(r);
		search.search();
	}
}
