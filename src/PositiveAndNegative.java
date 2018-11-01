import java.util.Arrays;

public class PositiveAndNegative {
	public static void main(String[] args) {
		int ar[] = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10}; //{1, -3, 5, -3, 6, 6, 7, -4, 9, 10}
		int even=0,odd=1,temp;
		for(int i=0;i<ar.length && odd<ar.length && even<ar.length;i++) {
			if(ar[i]<0) {
				temp=ar[odd];
				ar[odd]=ar[i];
				ar[i]=temp;
				odd+=2;
			}
		}
		System.out.println(Arrays.toString(ar));
	}
}
