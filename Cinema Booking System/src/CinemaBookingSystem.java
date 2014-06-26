import java.io.*;

public class CinemaBookingSystem {

	private Cinema cinema;
	private String inputText;
	private BufferedReader input;

	public CinemaBookingSystem() {
		cinema = new Cinema();
		input = new BufferedReader(new InputStreamReader(System.in));

		System.out
				.println("Welcome to the ultimate Booking System, you can do the following:\n- shows: Show available shows \n- book: Book a ticket");

		while (true) {
			inputText = (String) getInput();
			if (inputText.equals("shows")) {
				shows();
			} else if (inputText.equals("book")) {
				book();
			} else if (inputText.equals("delete")) {
				deleteBooking();
			} else if (inputText.equals("checkout")) {
				checkout();
			} else if (inputText.equals("exit")) {
				System.out.println("\nThank you!");
				break;
			} else {
				System.out.println("Sorry dude, wrong parameter :(");
			}
			System.out.println("(shows | book | delete | exit | checkout)\n");
		}

	}

	public static void main(String[] args) {
		new CinemaBookingSystem();
	}

	private String getInput() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return "Error";
		}
	}

	private void shows() {
		System.out.println("\nYou can choose between the following shows:\n"
				+ cinema.listShows());
	}

	private void book() {
		System.out.println("\nFor which show do you want to book a ticket?\n"
				+ cinema.listShows());
		Show show;
		inputText = getInput();
		if ((show = cinema.showByTitle(inputText)) != null) {
			book(show);
		} else {
			System.out
					.println("Sorry, we have no show with that title right now.");
		}
	}
	
	private void book(Show show) {
		System.out.println("\nWhich seat do you want to choose?");
		while (true) {
			displayShow(show);
			Integer row = getRow();
			Integer seat = getSeat();
			Row usedRow = show.getTheater().getRows().get(row);
			boolean seatBooked = usedRow.bookSeat(seat);
			if (seatBooked) {
				System.out.println("\nThe seat is yours!\n");
				neighboringSeats(usedRow, seat);
				System.out.println("\nDo you want to book any other seats? (yes | no)");
				if (getInput().equals("no")) {
					saveBooking(show, row, seat);
					break;
				}
			} else {
				System.out.println("\nThe seat " + row + "-" + seat
						+ " is not available.\nPlease choose another one.");
			}
		}
	}
	
	private void neighboringSeats(Row row, Integer seat) {
		int count = row.countNeighboringSeats(seat);
		System.out.println("\nHow many neightboring seats do you want to book?\nThere are "+count+" seats available.\nType \"0\" if you want no additional seats:");
		int amount = Integer.parseInt(getInput());
		// TODO: here we would have to go though the seats and book the requested amount of seats.
	}

	private void saveBooking(Show show, Integer row, Integer seat) {
		System.out.println("\nPlease enter your phone number:");
		String phoneNumber = getInput();
		Customer customer = cinema.getCustomer(phoneNumber);
		if (customer != null) {
			System.out.println("\nYour number is in our system");
		} else {
			customer = createCustomer(phoneNumber);
		}
		customer.addTicket(new Ticket(seat, row, show));
		System.out.println("\nWe added your booking. Please type \"checkout\" to get your tickets.\n");
	}
	
	private Customer createCustomer(String phoneNumber) {
		System.out.println("\nYour number is not in our system.\nPlease enter your lastname:");
		String lastname = getInput();
		System.out.println("\nPlease enter your firstname:");
		String firstname = getInput();
		return cinema.addCustomer(lastname, firstname, phoneNumber);
	}
	
	private void displayShow(Show show) {
		System.out.println(cinema.showSeatingPlan(show)
				+ "\n(The price for the show is " + show.getPrice()
				+ " Euro)");		
	}

	private int getRow() {
		System.out.println("\n1. Please insert the row of your seat:");
		return Integer.parseInt(getInput());
	}
	
	private int getSeat() {
		System.out.println("\n2. - Please insert the seat you wanna book:");
		return Integer.parseInt(getInput());
	}

	
	private void deleteBooking() {
		System.out.println("\nPlease enter your phone number:");
		Customer customer = cinema.getCustomer(getInput());
		if (customer == null) {
			System.out
					.println("\nSorry, we couln't find a customer for this phone number.\n");
		} else {
			System.out.println("\nThose are your tickets:");
			customer.listTickets();
			System.out.println("Insert the number of the ticket you want to delete:");
			int number = Integer.parseInt(getInput());
			customer.deleteTicket(number);
			System.out.println("\nDeleted Ticket.\n");
		}
	}
	

	private void checkout() {
		System.out.println("\nPlease enter your phone number:");
		Customer customer = cinema.getCustomer(getInput());
		if (customer == null) {
			System.out
					.println("\nSorry, we couln't find a customer for this phone number.\n");
		} else {
			System.out.println("Those are your tickets:");
			customer.listTickets();
			System.out.println("The total price is: "
					+ customer.totalTicketPrice() + " Euro.\n");
		}
	}

}
