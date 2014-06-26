import java.util.ArrayList;

public class Row {
	
	private int length;
	private ArrayList<Boolean> seats;

	
	public Row(int length) {
		this.length = length;
		seats = new ArrayList<Boolean>();
		for(int i=0; i<length; i++) {
			seats.add(false);
		}
	}

	public ArrayList<Boolean> getSeats() {
		return seats;
	}
	
	public boolean bookSeat(int position) {
		if(seats.get(position)) {
			return false;
		} else {
			seats.set(position, true);
			return true;
		}
	}
	
	public boolean seatAvailable(int position) {
		return !seats.get(position);
	}
	
	public int countNeighboringSeats(int seat) {
		int count = 0;
		
		for (int i = seat-1; i >= 0; i--) {
			if (!seats.get(i)) count++;
			else break;
		}
		for (int i = seat+1; i < seats.size(); i++) {
			if (!seats.get(i)) count++;
			else break;
		}

		return count;
	}
}
