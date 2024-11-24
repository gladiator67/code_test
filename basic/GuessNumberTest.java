package com.aaa.basic;

import java.util.Scanner;

public class GuessNumberTest {

    private static boolean loop = true;
	
	private static boolean getExactNumber(int min, int max, int d) {
		System.out.println("선택한 숫자가 " + d + "입니까? (Y 또는 N)");
		
		Scanner scan = new Scanner(System.in);
		String answer = scan.next();
		
		if (answer.equalsIgnoreCase("Y")) {
			System.out.println("정답은 " + d + "입니다. 수고하셨습니다. ^^");
			scan.close();
			
			return false;
		} else if (answer.equalsIgnoreCase("N")) {
			System.out.print("그럼, " + d + "보다 큽니까? (Y 또는 N)");
			answer = scan.next();
			
			if(answer.equalsIgnoreCase("Y")) {
				min = d;
			} else if (answer.equalsIgnoreCase("N")){
				max = d;
			} else {
				System.out.println("값이 틀립니다.");
			}
			
			d = (min + max) / 2;
			
		} else {
			System.out.println("값이 틀립니다.");
		}
		
		getExactNumber(min, max, d);
		
		scan.close();
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0과 100사이의 숫자를 선택하세요");

		do {
			loop = getExactNumber(0, 100, 50);
		} while(loop);
	}
}
