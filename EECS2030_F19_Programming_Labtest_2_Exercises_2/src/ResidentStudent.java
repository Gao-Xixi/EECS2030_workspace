
public class ResidentStudent extends Student {
	private double premiumRate;
	public ResidentStudent(String name) {
		super(name);	
	}
	public double getPremiumRate() {
		return premiumRate;
	}
	public void setPremiumRate(double premiumRate) {
		this.premiumRate = premiumRate;
	}

	public double getTuition() {
		double tution = super.getTuition();
		return tution * premiumRate;
	}
}
