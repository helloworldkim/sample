package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import hotel.Hotel;

public class CSVWriterHotelTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String FilePath = "./";
		String title="HotelCSV.csv";
		
		BufferedWriter fw;
		
		try {
			 fw = new BufferedWriter(new FileWriter(FilePath+"/"+title,true));
			 	Hotel hotel = new Hotel();
				System.out.print("호텔이름을 입력해주세요");
				hotel.setHotelName(sc.next());
				System.out.print("지역을 입력해주세요");
				hotel.setHotelLocation(sc.next());
				System.out.print("객실의 총 갯수를 입력해주세요");
				hotel.setRoomCount(sc.nextInt());
				System.out.println("등록되었습니다");
				ArrayList<Hotel> hList = new ArrayList<Hotel>();
				hList.add(hotel);
				String hotelName = hotel.getHotelName();
				String hotelLocaiton= hotel.getHotelLocation();
				String hotelRoomTotal = Integer.toString(hotel.getRoomCount());
				//String cage = String.valueOf(age);
				
				fw.append(hotelName).append(",");
				fw.append(hotelLocaiton).append(",");
				fw.append(hotelRoomTotal);
				fw.append("\n");
				
				fw.flush();
				
				fw.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

}
