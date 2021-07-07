
public class Course {
	private String title;
	private double fee;
	
	public Course(String t, double fee) {
		this.title = t;
		this.fee = fee;
	}

	public double getFee() {
		return this.fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
}
