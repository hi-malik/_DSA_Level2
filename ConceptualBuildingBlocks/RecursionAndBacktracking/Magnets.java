package ConceptualBuildingBlocks.RecursionAndBacktracking;

import java.io.*;
import java.util.*;

public class Magnets {

	public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
			int row, int col) {

				//write your code here
				if(col == arr[0].length){
				    col = 0;
				    row++;
				}
				if(row == arr.length){
				    if(isAnsValid(ans, top, left, right, bottom) == true){
				        return true;
				    }
				    return false;
				}
				if(arr[row][col] == 'L'){
				    if(isItSafe(ans, top, left, right, bottom, row, col, '+') && isItSafe(ans, top, left, right, bottom, row, col + 1, '-')){
				        ans[row][col] = '+';
				        ans[row][col + 1] = '-';
				        if(solution(arr, top, left, right, bottom, ans, row, col + 2) == true){
				            return true;
				        }
				        ans[row][col] = 'X';
				        ans[row][col + 1] = 'X';
				    }
				    
				    if(isItSafe(ans, top, left, right, bottom, row, col, '-') && isItSafe(ans, top, left, right, bottom, row, col + 1, '+')){
				        ans[row][col] = '-';
				        ans[row][col + 1] = '+';
				        if(solution(arr, top, left, right, bottom, ans, row, col + 2) == true){
				            return true;
				        }
				        ans[row][col] = 'X';
				        ans[row][col + 1] = 'X';
				    }
				}
				else if(arr[row][col] == 'T'){
				    if(isItSafe(ans, top, left, right, bottom, row, col, '+') && isItSafe(ans, top, left, right, bottom, row + 1, col, '-')){
				        ans[row][col] = '+';
				        ans[row + 1][col] = '-';
				        if(solution(arr, top, left, right, bottom, ans, row, col + 1) == true){
				            return true;
				        }
				        ans[row][col] = 'X';
				        ans[row + 1][col] = 'X';
				    }
				    
				    if(isItSafe(ans, top, left, right, bottom, row, col, '-') && isItSafe(ans, top, left, right, bottom, row + 1, col, '+')){
				        ans[row][col] = '-';
				        ans[row + 1][col] = '+';
				        if(solution(arr, top, left, right, bottom, ans, row, col + 1) == true){
				            return true;
				        }
				        ans[row][col] = 'X';
				        ans[row + 1][col] = 'X';
				    }
				}
				
				// no
				boolean f2 = solution(arr, top, left, right, bottom, ans, row, col + 1);
				if(f2 == true){
				    return true;
				}
		        return false;
	}
	public static boolean isItSafe(char ans[][], int top[], int left[], int right[], int bottom[], int row, int col, char sign){
	    if((col - 1 >= 0 && ans[row][col - 1] == sign) || (row - 1 >= 0 && ans[row - 1][col] == sign) || (col + 1 < ans[0].length && ans[row][col + 1] == sign)){
	        return false;
	    }
	    if(sign == '+'){
	        int cinr = countInRow(ans, left, sign, row);
	        int cinc = countInCol(ans, top, sign, col);
	        if(left[row] != -1 && cinr >= left[row]){
	            return false;
	        }
	        if(top[col] != -1 && cinc >= top[col]){
	            return false;
	        }
	    }
	    else{
	        int cinr = countInRow(ans, right, sign, row);
	        int cinc = countInCol(ans, bottom, sign, col);
	        if(right[row] != -1 && cinr >= right[row]){
	            return false;
	        }
	        if(bottom[col] != -1 && cinc >= bottom[col]){
	            return false;
	        }
	    }
	    return true;
	}
	public static boolean isAnsValid(char ans[][], int top[], int left[], int right[], int bottom[]){
	    for(int i = 0; i < top.length; i++){
	        int cinc = countInCol(ans, top, '+', i);
	        if(top[i] != -1 && top[i] != cinc){
	            return false;
	        }
	    }
	    for(int i = 0; i < left.length; i++){
	        int cinr = countInRow(ans, left, '+', i);
	        if(left[i] != -1 && left[i] != cinr){
	            return false;
	        }
	    }
	    for(int i = 0; i < bottom.length; i++){
	        int cinc = countInCol(ans, bottom, '-', i);
	        if(bottom[i] != -1 && bottom[i] != cinc){
	            return false;
	        }
	    }
	    for(int i = 0; i < right.length; i++){
	        int cinr = countInRow(ans, right, '-', i);
	        if(right[i] != -1 && right[i] != cinr){
	            return false;
	        }
	    }
	    return true;
	}
	public static int countInRow(char ans[][], int arr[], int sign, int rowno){
	    int counter = 0;
	    for(int col = 0; col < ans[0].length; col++){
	        if(ans[rowno][col] == sign){
	            counter++;
	        }
	    }
	    return counter;
	}
	public static int countInCol(char ans[][], int arr[], int sign, int colno){
	    int counter = 0;
	    for(int row = 0; row < ans.length; row++){
	        if(ans[row][colno] == sign){
	            counter++;
	        }
	    }
	    return counter;
	}

	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		char[][] arr = new char[m][n];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int[] top = new int[n];
		for (int i = 0; i < n; i++) {
			top[i] = scn.nextInt();
		}
		int[] left = new int[m];
		for (int i = 0; i < m; i++) {
			left[i] = scn.nextInt();
		}
		int[] right = new int[m];
		for (int i = 0; i < m; i++) {
			right[i] = scn.nextInt();
		}
		int[] bottom = new int[n];
		for (int i = 0; i < n; i++) {
			bottom[i] = scn.nextInt();
		}

		//write your code here
		char ans[][] = new char[m][n];
		for(int i = 0; i < m; i++){
		    Arrays.fill(ans[i], 'X');
		}
		if(!solution(arr, top, left, right, bottom, ans, 0, 0)){
		    System.out.println("No Solution");
		    return;
		}
		print(ans);
	}

	
}