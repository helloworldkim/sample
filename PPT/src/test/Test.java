package test;

import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;
import menu.view.BodyView;
import menu.view.FirstMenu;
import menu.view.LastMenu;
import reserve.reserveSystem;



public class Test {
	
	
	
	public static void main(String[] args) {
		FirstMenu firstMenu = new FirstMenu();
		BodyView bodyMenu = new BodyView();
		LastMenu LastMenu = new LastMenu();
		int count=1;
		//실행부분 
		boolean loop= true;
		while(loop) {
			int answer = firstMenu.FirstView();
			if(answer==1) {//처음에는 무조건 회원등록을 해야만 사용가능  db를 이용하는게 아니라서
				//csv파일에 저장하도록 변경함 덮어씌우기 방식
				bodyMenu.One();
			}else if(answer ==2){
				bodyMenu.Two(count);
				count++;
			}else if(answer==3) {
				bodyMenu.Three();
			}else if(answer==4){
				bodyMenu.Four();
			}else if(answer==5) {
				bodyMenu.Five();			
			}else {
			loop = LastMenu.LastView();
		}
	} //반복문 종료
	
	

	}
}
