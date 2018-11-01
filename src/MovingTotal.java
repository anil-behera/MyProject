import java.util.*;
public class MovingTotal {
    LinkedList<Integer> al=new LinkedList<Integer>();
    ArrayList<Integer> sum=new ArrayList<Integer>();
    public void append(int[] list) {
    	
    	for(int i=0;i<list.length;i++) {
    		al.add(list[i]);
    	}
    	
    	Integer a=al.get(al.size()-list.length-2);
    	Integer b=al.get(al.size()-list.length-1);
    	sum.add((a+b+list[0]));
    	if(list.length>1)
    	sum.add((b+list[0]+list[1]));
    	for(int i=0;i<list.length-2;i++) {
    		sum.add((list[i]+list[i+1]+list[i+2]));
    	}
    	
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        return sum.contains(total);
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[] { 4 });

        System.out.println(movingTotal.contains(9));
    }
}