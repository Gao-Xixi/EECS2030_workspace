
public class NonResidentStudent extends Student {
	private double discountRate;
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public NonResidentStudent(String name) {
		super(name);
		
	}
	public double getTuition() {
		double tution = super.getTuition();
		return tution * discountRate;
	}
}
