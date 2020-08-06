package menu.view;

import java.util.Scanner;

public class FirstMenu {
		Scanner sc = new Scanner(System.in);
		public int FirstView() {
		System.out.println("원하시는 메뉴를 선택해주세요");
		System.out.println("1.회원가입 2.모든회원확인3.호텔예약4.예약확인5.내 호텔확인하기6.나가기");
		return sc.nextInt();
	}
	
}
