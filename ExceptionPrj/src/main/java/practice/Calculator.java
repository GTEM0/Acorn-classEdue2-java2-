package practice;

public class Calculator {

	public static int add(int x, int y) {
		return x + y;
	}

	public static int subtract(int x, int y) {
		return x - y;
	}

	public static int multiply(int x, int y) {
		return x * y;
	}

	public static int divide(int x, int y) {
		if (y == 0) {
			throw new ArithmeticException("0으로 나눌 수 없음~");
		}
		return x / y;
	}

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;

		int resultAdd = add(num1, num2);
		System.out.println("덧셈 : " + resultAdd);

		int resultSubtract = subtract(num1, num2);
		System.out.println("뺄셈 : " + resultSubtract);

		int resultMultiply = multiply(num1, num2);
		System.out.println("곱셈 : " + resultMultiply);

		int resultDivide = divide(num1, num2);
		System.out.println("나눗셈 : " + resultDivide);
	}
}
