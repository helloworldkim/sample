package menu.view;

import java.util.Scanner;

public class AdminMenu {
		Scanner sc = new Scanner(System.in);
		public int AdminView() {
		System.out.println("원하시는 메뉴를 선택해주세요");
		System.out.println("1.모든회원확인2.호텔추가3.나가기");
		return sc.nextInt();
	}
	
}
