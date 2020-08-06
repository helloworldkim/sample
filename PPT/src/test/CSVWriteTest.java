package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import hotel.Hotel;

public class CSVWriteTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String FilePath = "./";
		String title="exCSV.csv";
		
		BufferedWriter fw;
		
		try {
			 fw = new BufferedWriter(new FileWriter(FilePath+"/"+title,true));
			
			 	Customer customer = new Customer();
				System.out.print("고객성함을 입력해주세요");
				customer.setCustomerName(sc.next());
				System.out.print("나이를 입력해주세요");
				customer.setCustomerAge(sc.nextInt());
				System.out.print("주소를 입력해주세요");
				customer.setCustomerAddress(sc.next());
				System.out.println("등록되었습니다");
				ArrayList<Customer> list = new ArrayList<Customer>();
				list.add(customer);
				String name = customer.getCustomerName();
				String age = Integer.toString(customer.getCustomerAge());
				//String cage = String.valueOf(age);
				String address = customer.getCustomerAddress();
				fw.append(name).append(",");
				fw.append(age).append(",");
				fw.append(address);
				fw.append("\n");
				
				fw.flush();
				
				fw.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

}
