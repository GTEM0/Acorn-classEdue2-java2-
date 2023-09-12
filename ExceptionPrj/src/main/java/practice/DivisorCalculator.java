package practice;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class DivisorCalculator {
	
	public static List<Integer> findDivisors(int n) {
		List<Integer> divisors = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

	public static void main(String[] args) {
		int number = 56;
		List<Integer> divisors = findDivisors(number);

		System.out.println(number + "의 약수는:");
		for (int divisor : divisors) {
			System.out.print(divisor + " ");
		}
	}
}
