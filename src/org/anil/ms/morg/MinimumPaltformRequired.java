package org.anil.ms.morg;
/*
 Minimum Number of Platforms Required for a Railway/Bus Station

Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

Examples:

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)

----------------------------------------------------------------------

We can solve the above problem in O(nLogn) time. The idea is to consider all evens in sorted order. Once we have all events in sorted order, 
we can trace the number of trains at any time keeping track of trains that have arrived, but not departed.

For example consider the above example.

    arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
    dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}

All events sorted by time.
Total platforms at any time can be obtained by subtracting total 
departures from total arrivals by that time.
 Time     Event Type     Total Platforms Needed at this Time                               
 9:00       Arrival                  1
 9:10       Departure                0
 9:40       Arrival                  1
 9:50       Arrival                  2
 11:00      Arrival                  3 
 11:20      Departure                2
 11:30      Departure                1
 12:00      Departure                0
 15:00      Arrival                  1
 18:00      Arrival                  2 
 19:00      Departure                1
 20:00      Departure                0

Minimum Platforms needed on railway station = Maximum platforms 
                                              needed at any time 
                                           = 3  
 * 
 * */

import java.util.Arrays;

public class MinimumPaltformRequired {

	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    
	    System.out.println(minimumPlatform(arr,dep));

	}

	private static int minimumPlatform(int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int max=0,result=0,i=0,j=0;
		
		while(i<arr.length && j<dep.length) {
			
			//If next event in sorted order is arrival, 
		    // increment count of platforms needed
			if(arr[i]<=dep[j]) {
				i++;
				max++;
				if(max>result)
					result=max;
			}
			else {
				max--;
				j++;
				
			}
			
		}
		
		
		return result;
		
	}

}
