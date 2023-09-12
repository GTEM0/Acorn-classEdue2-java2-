package practice;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class DivisorCalculator2 {
	
	public static List<Integer> findDivisor(int d) {
		List<Integer> divisor = new ArrayList<>();

		for (int i = 1; i <= d; i++) {
			if (d % i == 0) {
				divisor.add(i);
			}
		}
		return divisor;
	}

	public static void main(String[] args) {
		int number = 56;
		List<Integer> divisor = findDivisor(number);

		System.out.println(number + "의 약수는:");
		for (int divisor0 : divisor) {
			System.out.print(divisor0 + " ");
		}
	}
}
