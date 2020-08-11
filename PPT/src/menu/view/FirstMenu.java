package menu.view;

import java.util.Scanner;

public class FirstMenu {
		Scanner sc = new Scanner(System.in);
		public int FirstView() {
		System.out.println("원하시는 메뉴를 선택해주세요");
		System.out.println("1.회원가입");
		System.out.println("2.관리자메뉴");
		System.out.println("3.호텔현황");
		System.out.println("4.호텔예약");
		System.out.println("5.예약확인");
		System.out.println("6.나가기");
		return sc.nextInt();
	}
	
}
