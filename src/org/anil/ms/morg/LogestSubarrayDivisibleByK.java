package org.anil.ms.morg;

import java.util.Arrays;
import java.util.HashMap;
/*
 * Longest subarray with sum divisible by k
 * 
 *  Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
	Output : 4
	The subarray is {7, 6, 1, 4} with sum 18,
	which is divisible by 3.
	
	Input : arr[] = {-2, 2, -5, 12, -11, -1, 7}
	Output : 5
 * */

public class LogestSubarrayDivisibleByK {
	
	public static void main(String[] args) {
		int[] ar= {1,2,3,4,1};
				//{-2, 2, -5, 12, -11, -1, 7};
			//{2, 7, 6, 1, 4, 5};
			//{1,2,3,4,1};
		
		System.out.println(subarray(3,ar));
	}

	private static int subarray(int k, int[] ar) {
		int[] modar=new int[ar.length];
		int sum=0,r=0,max=0,start=0,end=0;
		HashMap<Integer,Integer> h=new HashMap<>();
		for(int i=0;i<ar.length;i++) {
			sum+=ar[i];
			r=sum%k;
			modar[i]=r;
		}
		
		System.out.println(Arrays.toString(modar));
		
		for(int i=0;i<modar.length;i++) {
			if(modar[i]==0) {
				max=i+1;
				start=0;
				end=i+1;
			}
			else if(!h.containsKey(modar[i])) {
				h.put(modar[i], i);
			}
			else {
				//The idea is to traverse the array and record the result of cumulative sum modulo K and its corresponding index. 
				//If for index i,j, the remainder is the same, then the subarray between i,j must be a valid subarray (i.e., its sum is divisible by K).
				if(max<(i-h.get(modar[i]))) {
					max=(i-h.get(modar[i])+1);
					start=h.get(modar[i]);
					end=i+1;
				}
			}
		}
		
		System.out.println("Start :"+start+" End: "+end);
		return max;
	}
	
}
