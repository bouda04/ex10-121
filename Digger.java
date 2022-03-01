import java.util.Random;

public class Digger {
	
	int diamonds;
	int ticket;
	Random rnd;

	public Digger(int ticket) {
		this.diamonds = 10;
		this.ticket = ticket;
		rnd = new Random();
	}

	public int getDiamonds() {
		return diamonds;
	}

	public void add() {
		this.diamonds++;
	}
	
	public void lose() {
		this.diamonds--;
	}
	
	public void eat(Digger other) {
		this.diamonds += other.diamonds;
		other.diamonds = 0;
	}
	
	public int draw() {
		return rnd.nextInt(6) + 1;
	}

	@Override
	public String toString() {
		return "Digger #" + ticket + ", has " + diamonds + " diamonds";
	}

	
	
}
