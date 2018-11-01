package org.anil.ms.morg;
/*
 0-1 Knapsack Problem | DP-10
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. 
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */

import java.util.Arrays;

public class KnapSackProblem {

	public static void main(String[] args) {
		
		/*int[] val = new int[]{60, 100, 120};
	    int[] wt = new int[]{10, 20, 30};
	    int  W = 50;*/
		
		int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;
        
        System.out.println(Arrays.toString(val));
        System.out.println(Arrays.toString(wt));
	    System.out.println(knapsack(val, wt, W));
		 	
	}

	private static int knapsack(int[] val, int[] weight, int sackWeight) {
		
		int[][] matrix=new int[val.length+1][sackWeight+1];
		
		for(int v=0;v<=val.length;v++) {
			for(int w=0;w<=sackWeight;w++) {
				if(v==0 || w==0) {
					matrix[v][w]=0;
				}
				else if(weight[v-1]<=w) {
					
					matrix[v][w]=Math.max(val[v-1]+matrix[v-1][w-weight[v-1]],matrix[v-1][w]);
					
				}
				else {					
					matrix[v][w]=matrix[v-1][w];
				}
			}
		}		
		 for (int[] rows : matrix) {
	            for (int col : rows) {
	                System.out.format("%5d", col);
	            }
	            System.out.println();
	        }
		 
		 int item=val.length,w=0;
		 
		 //We cannot consider that the sack is full,i.e. w=sackWeight
		 for(int i=sackWeight;i>1;i--) {
			 if(matrix[item][i]!=matrix[item][i-1]) {
				 w=i;
				 break;
			 }
		 }
		 
		 System.out.println(w);
		 
		 System.out.print("Items Taken : ");
		 while(item>0 && w>0) {
			 if(matrix[item][w] !=matrix[item-1][w]) {
				 System.out.print(val[item-1] +"\t");		 //Why item-1 as Matrix starts from Zero
				 w-=weight[item-1];
			 }
			 item-=1;
		 }
		System.out.println();
		return matrix[val.length][sackWeight];
	}
}
