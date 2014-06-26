
public class Show {
	
	private Theater theater;
	private Double price;
	private String name;
	
	public Show(Double price, Theater theater, String name) {
		this.price = price;
		this.theater = theater;
		this.name = name;
	}
	
	public Theater getTheater() {
		return theater;
	}

	public Double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
		
}
