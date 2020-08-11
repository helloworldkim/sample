package hotel;

import java.util.ArrayList;

import customer.Customer;
import model.customer.HotelCSVInOut;
import reserve.reserveSystem;

public class HotelDTO {
			Hotel hotel;
			reserveSystem sys = reserveSystem.getInstance();
			HotelCSVInOut hotelCSV = HotelCSVInOut.getInstance();
			ArrayList<Hotel> hotelList= hotelCSV.UseHotelCSV();
			ArrayList<Customer> customerList = sys.getCustomerList();
		public void showHotels() {
			for(int i=0; i<hotelList.size(); i++) {
				System.out.println(hotelList.get(i));
			}
		}

		public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

		public ArrayList<Hotel> getHotelList() {
			return hotelList;
		}

		public void setHotelList(ArrayList<Hotel> hotelList) {
			this.hotelList = hotelList;
		}

		public ArrayList<Customer> getCustomerList() {
			return customerList;
		}

		public void setCustomerList(ArrayList<Customer> customerList) {
			this.customerList = customerList;
		}
		
		
}
