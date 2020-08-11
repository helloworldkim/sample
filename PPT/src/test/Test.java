package test;

import menu.view.BodyMenu;
import menu.view.FirstMenu;
import menu.view.LastMenu;



public class Test {
	
	
	
	public static void main(String[] args) {
		FirstMenu firstMenu = new FirstMenu();
		BodyMenu bodyMenu = new BodyMenu();
		LastMenu LastMenu = new LastMenu();
		//실행부분 
		boolean loop= true;
		while(loop) {
			int answer = firstMenu.FirstView();
			switch (answer) {
			//회원가입
			case 1://처음에는 무조건 회원등록을 해야만 사용가능  db를 이용하는게 아니라서
				//csv파일에 저장하도록 변경함 덮어씌우기 방식
				bodyMenu.One();
				break;
			//관리자메뉴
			case 2: bodyMenu.Two();				
				break;
			//모든호텔현황
			case 3: bodyMenu.Three();
				break;
			//호텔예약
			case 4:bodyMenu.Four();
				break;
			//예약확인
			case 5:	bodyMenu.Five();
				break;
				//기본값 나가기
			default:loop = LastMenu.LastView();
			break;
			}		
		}//반복문 종료
		
	}
}
