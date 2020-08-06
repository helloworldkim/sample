package menu.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;
import hotel.HotelDTO;
import reserve.reserveSystem;

public class BodyView {
	Scanner sc = new Scanner(System.in);
	HotelDTO hDTO = new HotelDTO();
	reserveSystem sys = hDTO.getSys();

	public void One() {
		String FilePath = "./";
		String title="exCSV.csv";

		BufferedWriter fw;
		
		try {
			fw = new BufferedWriter(new FileWriter(FilePath+"/"+title,true));
			 
			Customer customer = new Customer();
			System.out.print("등록하실 아이디를입력해주세요");
			customer.setCustomerId(sc.next());
			System.out.print("고객성함을 입력해주세요");
			customer.setCustomerName(sc.next());
			System.out.print("나이를 입력해주세요");
			customer.setCustomerAge(sc.nextInt());
			System.out.print("주소를 입력해주세요");
			customer.setCustomerAddress(sc.next());
			System.out.println("등록되었습니다");
			ArrayList<Customer>cList = sys.getCustomerList();
			cList.add(customer); //고객등록 후 customerList에 추가함
			System.out.println(cList);
			ArrayList<Hotel> list= hDTO.createHotel();
			hDTO.setHotelList(list);
			//CSV파일 작성부분
			String Id = customer.getCustomerId();
			String name = customer.getCustomerName();
			String age = Integer.toString(customer.getCustomerAge());
			//String cage = String.valueOf(age);
			String address = customer.getCustomerAddress();
			fw.append(Id).append(",");
			fw.append(name).append(",");
			fw.append(age).append(",");
			fw.append(address);
			//줄바꿈메서드
			fw.append(System.lineSeparator());
			//append("\n"); 해당방법으로는 줄바꿈 안됨
			
			fw.flush();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void Two(int count) {
		BufferedReader in = null;		
		String Filename = "exCSV.csv";
		try {
			ArrayList<Customer>clist = sys.getCustomerList();
			in = new BufferedReader(new FileReader(Filename));
			String line = in.readLine();
			String[] data = null;			
			while (line != null) {
				data = line.split(",");
				if(count==1) {
				Customer customer = new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3]);
				clist.add(customer);
				}
				line = in.readLine();
			}
			//모든 회원 출력부분
			for(Customer c:clist) {
				System.out.println(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("메서드 끝났습니다");
	}
		
	public void Three() {
		System.out.println("등록된 회원이신지 확인 후 이용가능하십니다");
		System.out.println("예약 진행하시는분의 성함을 입력해주세요");
		String customerName = sc.next();
		System.out.println("나이을 입력해주세요");
		int customerAge = sc.nextInt();
		System.out.println("주소를 입력해주세요");
		String customerAddress = sc.next();
		Customer tempCust=sys.checkCustomer(customerName, customerAge, customerAddress);
		System.out.println("호텔이름를 선택해주세요");
		hDTO.showHotels();
		String choosedHotel="";
		choosedHotel = sc.next();
		ArrayList<Hotel>hList = hDTO.getHotelList();
		for(int i=0; i<hList.size();i++) {
		//가져온 호텔이름과 고객이 선택한 호텔이름이 같을경우
		if(hList.get(i).getHotelName().equals(choosedHotel)) {
			Hotel hotel = hList.get(i); //현재호텔
			int reservedNumber =sys.getReserveHotel(tempCust, hotel);
			//예약번호 생성해줌
			System.out.println(hList.get(i).getHotelName()+"에 정상적으로 예약되셨습니다");
			System.out.printf("고객님의 예약번호는 %d 입니다", reservedNumber);
		}
	}
	}
	public void Four() {
		System.out.println("예약하신 호텔이름을 입력해주세요");
		String choosedHotel="";
		choosedHotel = sc.next();
		System.out.println("예약번호를 입력해주세요");
		int reservedNumber = sc.nextInt();
		ArrayList<Hotel>hList = hDTO.getHotelList();
		for(int i=0; i<hList.size();i++) {
			if(hList.get(i).getHotelName().equals(choosedHotel)) {
				Hotel hotel = hList.get(i);
				System.out.println(hotel.getHotelName());
				hotel.getCustomer(reservedNumber);
			}
	}
}
	public void Five() {
		System.out.println("등록하신 이름을 입력해주세요");
		String customerName = sc.next();
		System.out.println("등록하신 나이을 입력해주세요");
		int customerAge = sc.nextInt();
		System.out.println("등록하신 주소을 입력해주세요");
		String customerAddress = sc.next();
		hDTO.getMyHotels(customerName, customerAge, customerAddress);
	}

}
