package org.anil.ms.morg;

//Kadane’s Algorithm

public class MaxSubArraySum {
	
	static int maximumSubArray(int[] ar) {
		
		int finalSum=ar[0],sum=ar[0];
		
		int start=0,s=0,end=0;
		
		for(int i=1;i<ar.length;i++) {
			/*
			sum=Math.max(ar[i], sum+ar[i]);//3 //0 //-4  //2  //9  //7
			finalSum=Math.max(sum, finalSum);//3 //3 //3 //3  //9  //9
*/		
			sum+=ar[i];
			if(finalSum<sum) {
				finalSum=sum;
				start=s;
				end=i;
			}
			if(sum<0) {
				sum=0;
				s=i+1;
			}
			
			/*Start :4End :7
			10
			Start :2End :6
			7
			Start :0End :0
			-2*/
		}
		System.out.println("Start :"+ start + " ,End :"+end);
		
		return finalSum;
	}

	public static void main(String[] args) {
		int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
		
		System.out.println(maximumSubArray(arrA));
		
		int arrC[] ={-2, -3, 4, -1, -2, 1, 5, -3};
		
		System.out.println(maximumSubArray(arrC));
		
		int arrB[] = { -2, -3, -4, -1, -7, -2, -3,-11 };
		System.out.println(maximumSubArray(arrB));

	}

}
