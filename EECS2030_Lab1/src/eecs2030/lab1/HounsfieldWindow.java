package eecs2030.lab1;

/**
 * A class that represents a windowed view of Hounsfield units. A Hounsfield
 * window is defined by two values: (1) the window level, and (2) the window
 * width. The window level is the Hounsfield unit value that the window is
 * centered on. The window width is the range of Hounsfield unit values that the
 * window is focused on.
 * 
 * <p>
 * A window has a lower and upper bound. The lower bound is defined as the
 * window level minus half the window width:
 * 
 * <p>
 * lo = level - (width / 2)
 * 
 * <p>
 * The upper bound is defined as the window level plus half the window width:
 * 
 * <p>
 * hi = level + (width / 2)
 * 
 * <p>
 * Hounsfield units are mapped by the window to a real number in the range of
 * {@code 0} to {@code 1}. A Hounsfield unit with a value less than lo is mapped
 * to the value {@code 0}. A Hounsfield unit with a value greater than hi is
 * mapped to the value {@code 1}. A Hounsfield unit with a value v between lo
 * and hi is mapped to the value:
 * 
 * <p>
 * (v - lo) / width
 * 
 *
 */
public class HounsfieldWindow {

	private int level;
	private int width;
	private double lo;
	private double hi;
	
	public HounsfieldWindow() {
		this(0,400);
		
	}
	public HounsfieldWindow(int l, int w) {
		this.setLevel(l);
		this.setWidth(w);
		
	}
	private void setBounds() {
		
		this.lo = this.level - 0.5 * this.width;
		this.hi = this.level + 0.5 * this.width;
	}
	
	
	public int getWidth() {
		return width;
	}

	public int setLevel(int level) {
		if (level < Hounsfield.MIN_VALUE) {
			throw new IllegalArgumentException("level is less than Hounsfield.MIN_VALUE");
		}
		if (level > Hounsfield.MAX_VALUE) {
			throw new IllegalArgumentException("level is greater than Hounsfield.MAX_VALUE");
		}
		int oldLevel = this.level;
		this.level = level;
		this.setBounds();
		return oldLevel;
	}
	
	

	public int setWidth(int width) {
		if (width < 1) {
			throw new IllegalArgumentException("width is less than 1");
		}
		int oldWidth = this.width;
		this.width = width;
		this.setBounds();
		return oldWidth;
	
	}

	
	
	public int getLevel() {
		return this.level;
	}
	
	public double map(Hounsfield h) {
		double result = 0.0;
		int val = h.get();
		if (val < this.lo) {
			result = 0.0;
		} else if (val > this.hi) {
			result = 1.0;
		} else {
			result = (val - this.lo) / this.width;
		}
		return result;
	}
	
}
