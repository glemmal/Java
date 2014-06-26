
public class Ticket {
	
	private Integer seat;
	private Integer row;
	private Show show;
	
	public Ticket(Integer seat, Integer row, Show show) {
		this.seat = seat;
		this.row = row;
		this.show = show;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	
}
