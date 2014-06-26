import java.util.ArrayList;

public class Customer {
	
	private String name;
	private String firstname;
	private String phone;
	private ArrayList<Ticket> tickets; 
	
	public Customer(String name, String firstname, String phone) {
		this.name = name;
		this.firstname = firstname;
		this.phone = phone;
		tickets = new ArrayList<Ticket>();
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String number) {
		this.phone = number;
	}
	
	public boolean hasPhoneNumber(String number) {
		return this.phone.equals(phone);
	}

	public double totalTicketPrice() {
		double total = 0;
		for (Ticket ticket : tickets) {
			total += ticket.getShow().getPrice();
		}
		return total;
	}

	public void listTickets() {
		for (int i = 0; i < tickets.size(); i++) {
			Ticket ticket = tickets.get(i);
			System.out.println( i+". "+ticket.getShow().getName()+", Seat "+ticket.getRow()+"-"+ticket.getSeat()+", "+ticket.getShow().getPrice()+" Euro" );
		}
	}
	
	public void deleteTicket(int i) {
		Ticket ticket = tickets.get(i);
		ticket.getShow().getTheater().getRows().get(ticket.getRow()).bookSeat(ticket.getSeat());
		tickets.remove(i);
	}
	
}
