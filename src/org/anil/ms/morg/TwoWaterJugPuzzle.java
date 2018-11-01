package org.anil.ms.morg;

/*
The Two Water Jug Puzzle:
You are at the side of a river. You are given a m litre jug and a n litre jug where 0 < m < n. Both the jugs are initially empty. The jugs don’t have markings to allow measuring smaller quantities. You have to use the jugs to measure d litres of water where d < n. Determine the minimum no of operations to be performed to obtain d litres of water in one of jug.
The operations you can perform are:

Empty a Jug
Fill a Jug
Pour water from one jug to the other until one of the jugs is either empty or full.
===================================================================================
There are several ways of solving this problem including BFS and DP. In this article an arithmetic approach to solve the problem is discussed. 
The problem can be modeled by means of Diophantine equation of the form mx + ny = d which is solvable if and only if gcd(m, n) divides d. Also, 
the solution x,y for which equation is satisfied can be given using the Extended Euclid algorithm for GCD.
For example, if we have a jug J1 of 5 litre (n = 5) and another jug J2 of 3 litre (m = 3) and we have to measure 1 litre of water using them. 
The associated equation will be 5n + 3m = 1. First of all this problem can be solved since gcd(3,5) = 1 which divides 1 (See this for detailed explanation).
Using the Extended Euclid algorithm, we get values of n and m for which the equation is satisfied which are n = 2 and m = -3.
These values of n, m also have some meaning like here n = 2 and m = -3 means that we have to fill J1 twice and empty J2 thrice.
Now to find the minimum no of operations to be performed we have to decide which jug should be filled first. 
Depending upon which jug is chosen to be filled and which to be emptied we have two different solutions and the minimum among them would be our answer
Solution 1 (Always pour from m litre jug into n litre jug)
---------------------------------------------------------

Fill the m litre jug and empty it into n litre jug.
Whenever the m litre jug becomes empty fill it.
Whenever the n litre jug becomes full empty it.
Repeat steps 1,2,3 till either n litre jug or the m litre jug contains d litres of water.
Each of steps 1, 2 and 3 are counted as one operation that we perform. Let us say algorithm 1 achieves the task in C1 no of operations.

Solution 2 (Always pour from n litre jug into m litre jug)
----------------------------------------------------------

Fill the n litre jug and empty it into m litre jug.
Whenever the n litre jug becomes empty fill it.
Whenever the m litre jug becomes full empty it.
Repeat steps 1, 2 and 3 till either n litre jug or the m litre jug contains d litres of water.
Let us say solution 2 achieves the task in C2 no of operations.

Now our final solution will be minimum of C1 and C2.

Now we illustrate how both of the solutions work. Suppose there are a 3 litre jug and a 5 litre jug to measure 4 litres water so m = 3,n = 5 and d = 4. The associated Diophantine equation will be 3m + 5n = 4. We us pair (x, y) to represent amounts of water inside 3 litre jug and 5 litre jug respectively in each pouring step.

Using Solution 1, successive pouring steps are:

(0,0)->(3,0)->(0,3)->(3,3)->(1,5)->(1,0)->(0,1)->(3,1)->(0,4)
Hence the no of operations you need to perform are 8.

Using Solution 2, successive pouring steps are:

(0,0)->(0,5)->(3,2)->(0,2)->(2,0)->(2,5)->(3,4)
Hence the no of operations you need to perform are 6.
 * */
public class TwoWaterJugPuzzle {
	public static void main(String[] args) {
		int steps = findMinSteps(3, 5, 4);
		System.out.println(steps);
	}

	private static int findMinSteps(int m, int n, int d) {
		int jog1, jog2;
		if (m > n) {
			jog1 = m;
			jog2 = n;
		} else {
			jog1 = n;
			jog2 = m;
		}
		if ((d > jog1))
			return -1;
		else {
			if (d % gcd(jog1, jog2) != 0) {
				return -1;
			} else {
				int s1 = pour(jog1, jog2, d);
				int s2 = pour(jog2, jog1, d);
				if (s1 > s2) {
					return s2;
				}
				return s1;
			}
		}
	}

	private static int pour(int jog1, int jog2, int d) {
		int from = jog1,to = 0,steps = 1,min = 0;
		while (from != d || to != d) {
			min = Math.min(from, jog2 - to);
			to = to + min;
			from = from - min;
			steps++;
			if (to == d || from == d) {
				break;
			}
			if (to == jog2) {
				to = 0;
				steps++;
			}
			if (from == 0) {
				from = jog1;
				steps++;
			}
		}
		return steps;
	}

	private static int gcd(int jog1, int jog2) {
		if (jog2 == 0) {
			return jog1;
		}
		return gcd(jog2, jog1 % jog2);
	}

}
