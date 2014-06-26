import java.util.ArrayList;

public class Cinema {
	
	private ArrayList<Theater> theaters;
	private ArrayList<Show> shows;
	private ArrayList<Customer> customer = new ArrayList<Customer>();
	
	public Cinema() {
		theaters = new ArrayList<Theater>();		
		shows = new ArrayList<Show>();
		
		this.addTheater(new int[]{1,2,3});
		this.addTheater(new int[]{4,2,3});
		this.addTheater(new int[]{5,8,6});
		
		this.addShow(12.00, 0, "The Great Gatsby");
		this.addShow(13.30, 1, "The Lord Of The Rings");
		this.addShow(14.30, 2, "The Matrix");
	}
		
	public String listShows() {
		String output = "";
		for(Show show : shows) {
			output += "- " + show.getName() + "\n";
		}
		return output;
	}
	
	public Show showByTitle(String title) {
		for (Show show : shows) {
			if (show.getName().equalsIgnoreCase(title)) {
				return show;
			}
		}
		return null;
	}
	
	public String showSeatingPlan(Show show) {
		String output = "";
		ArrayList<Row> rows = show.getTheater().getRows();
		for (int i = 0; i < rows.size(); i++) {
			Row row = rows.get(i);
			output += "\nRow " + i + ": ";
			ArrayList<Boolean> seats = row.getSeats();
			for (int j = 0; j < seats.size(); j++) {
				output += j + "(" + (seats.get(j) ? "x" : "0") + ")" + ",";
			}
			output = output.substring(0, output.length()-1);
		}
		return output;
	}

	public void addTheater(int[] seatsForRows) {
		ArrayList<Row> rows = new ArrayList<Row>(); 
		for (int length : seatsForRows) {
			rows.add(new Row(length));
		}
		Theater t = new Theater(rows);
		theaters.add(t);
	}

	public void addShow(double time, int theaterNumber, String title) {
		shows.add(new Show(time, theaters.get(theaterNumber), title));
	}
	
	public Customer getCustomer(String phoneNumber) {
		for(Customer customer : this.customer) {
			if(customer.hasPhoneNumber(phoneNumber)) {
				return customer;
			}
		}
		return null;
	}

	public Customer addCustomer(String name, String firstname, String phone) {
		Customer tmpCustomer = new Customer(name, firstname, phone);
		customer.add(tmpCustomer);
		return tmpCustomer;
	}
}
