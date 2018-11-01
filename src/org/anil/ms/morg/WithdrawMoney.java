package org.anil.ms.morg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WithdrawMoney {
	private final static int[] currencies = { 2000, 500, 200, 100 };
	private static Map<Integer, Integer> cntCurrencies = new HashMap<>();
	private static Map<Integer, Integer> withdrawCurrencies = new HashMap<>();
	private static int availableBalance = 0;

	static {
		int a2000 = 10;
		int a500 = 40;
		int a200 = 100;
		int a100 = 200;
		cntCurrencies.put(2000, a2000);
		cntCurrencies.put(500, a500);
		cntCurrencies.put(200, a200);
		cntCurrencies.put(100, a100);

		availableBalance = a2000 * 2000 + a500 * 500 + a200 * 200 + a100 * 100;
	}

	public static void main(String[] args) {
		System.out.println("Begin Trasaction...");
		System.out.println("Available Balance:" + availableBalance);
		System.out.println("Available Currencies:" + cntCurrencies);
		System.out.println("======================================");
		int amount = 0;
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter Amount to withdraw");
			amount = sc.nextInt();
		}
		withdraw(amount);

		System.out.println("======================================");
		System.out.println("End of Trasaction...");
		System.out.println("Available Balance:" + availableBalance);
		System.out.println("Available Currencies:" + cntCurrencies);

	}

	private static void withdraw(int amount) {
		if (amount % currencies[currencies.length - 1] != 0) {
			System.out.println("Invalid Input. Input should be multiple of" + currencies[currencies.length - 1]);
		} else if (amount > availableBalance) {
			System.out.println("Insufficient Balance in ATM");
		} else {
			process(amount);
			System.out.println(withdrawCurrencies);
		}
	}

	private static void process(int amount) {
		availableBalance = availableBalance - amount;
		while (amount != 0) {
			if (amount > 2000) {
				amount = processVal(amount, 0);
			} else if (amount > 500) {
				amount = processVal(amount, 1);
			} else if (amount > 200) {
				amount = processVal(amount, 2);
			} else {
				amount = processVal(amount, 3);
			}
		}

	}

	private static int processVal(int amount, int pos) {

		if (pos >= currencies.length)
			return 0;

		int val = currencies[pos];

		/* Block to process the amount for lower currency start */

		/*
		 * int rem=amount%val; if(rem==0){ if (pos < currencies.length-1) { int
		 * canBe = processVal(val, pos + 1); if (canBe == 0) { amount = amount -
		 * val; } } }
		 */
		/* Block to process the amount for lower currency End */

		int res = amount / val;
		int avail = cntCurrencies.get(val);
		int cnt = 0;
		int deduct = cntCurrencies.get(val);

		// get the existing value
		if (withdrawCurrencies.get(val) != null)
			cnt = withdrawCurrencies.get(val);

		if (res != 0 && res < avail) {
			withdrawCurrencies.put(val, cnt + res);
			amount = amount - (res * val);
			cntCurrencies.put(val, deduct - res);
		} else {
			withdrawCurrencies.put(val, cnt + avail);
			amount = amount - (avail * val);
			cntCurrencies.put(val, deduct - avail);
			// process with Next Currency for remaining amount
			if (pos < currencies.length)
				processVal(amount, pos + 1);

		}
		return amount;
	}

}
