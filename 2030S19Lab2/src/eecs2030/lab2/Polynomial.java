/**
 * 
 */
package eecs2030.lab2;

import java.util.Arrays;

/**
 * The {@code Polynomial} class represents a polynomial of a single
 * indeterminate with double coefficients. A polynomial is an an expression
 * consisting of variables with non-negative integer exponents and real
 * coefficients. The set of operations supported by the {@code Polynomial} class
 * includes: addition, subtraction, multiplication, function composition,
 * polynomial derivative, and evaluation.
 * 
 * <p>
 * Examples of polynomials with a single indeterminate, x, are:
 * 
 * <pre>
 * p(x) = x^2 - 5.0x + 1.0
 * p(x) = x^6 + 4.1x^4 + 0.5x - 7.2
 * p(x) = 1.0
 * </pre>
 * 
 * @author EECS2030 Summer 2019
 *
 */
public class Polynomial implements Comparable<Polynomial> {

	/**
	 * Array of the polynomial coefficients.
	 * 
	 * <pre>
	 * p(x) = cf[0] * x^0 + ... + cf[n-1] * x^(n-1)
	 * </pre>
	 */
	private double[] cf;

	/**
	 * The degree of the polynomial. That is the largest exponent with non zero
	 * coefficient. If all the coefficients are zero, the degree is zero. To set the
	 * value of {@code degree}, implement and call {@code findDegree()} method every
	 * time the polynomial is created or an operation is performed
	 */
	private int degree;

	/**
	 * Creates a new polynomial {@code a * x^i}
	 * 
	 * @param a
	 *            the leading coefficient
	 * @param i
	 *            the exponent
	 * @throws IllegalArgumentException
	 *             if {@code i} is negative
	 */
	public Polynomial(double a, int i) {
		if(i < 0) {
			throw new IllegalArgumentException();
		}
		else {
			this.cf = new double[i + 1];
			cf[i] = a;
			this.degree = i;
		}

	}
	
	/**
	 * A helper function for testing. Do not remove or change.
	 */
	protected int test_getDegree() {
		return degree;
	}
	/**
	 * A helper function for testing. Do not remove or change.
	 */
	protected void test_setDegree(int d) {
		degree = d;
	}	
	/**
	 * A helper function for testing. Do not remove or change.
	 */
	protected double[] test_getCf() {
		return cf;
	}

	/**
	 * Creates a new polynomial from array of coefficients. The new polynomial has
	 * the form
	 * 
	 * <pre>
	 * cf[0] * x^0 + ... + cf[n-1] * x^(n-1)
	 * </pre>
	 * 
	 * where {@code n} is the length of the coefficients array.
	 * 
	 * @param cf
	 *            the coefficients array
	 * @throws IllegalArgumentException
	 *             if {@code cf} is empty
	 *             
	 */
	public Polynomial(double[] cf) {
		if(cf.length == 0) {
			throw new IllegalArgumentException();
		}
		else {
			this.cf = new double[cf.length];
			for(int i =0;i < cf.length;i++) {
				this.cf[i] = cf[i];
		
			}
			this.degree = cf.length - 1;
			
		}
	}
	 // pre-compute the degree of the polynomial, in case of leading zero coefficients
    // (that is, the length of the array need not relate to the degree of the polynomial)
	/**
	 *  find online
	 */
    private void reduce() {
        degree = -1;
        for (int i = cf.length - 1; i >= 0; i--) {
            if (cf[i] != 0) {
                degree = i;
                return;
            }
        }
    }
	/**
	 * Creates a polynomial with zero degree and one zero coefficient.
	 * 
	 * <pre>
	 * p(x) = 0
	 * </pre>
	 */
	public Polynomial() {
		cf = new double[1];
		cf[0] = 0;
		degree = 0;
		
	}

	/**
	 * Finds the polynomial {@code degree}, which is the largest exponent with non
	 * zero coefficient. If all the coefficients are zero, the degree is zero.
	 */
	private void findDegree() {

	}

	/**
	 * Returns the degree of the polynomial. A polynomial with zero coefficients has
	 * a zero degree.
	 * 
	 * @return the degree of the polynomial
	 */
	public int getDegree() {
		return this.degree;
	}

	/**
	 * Returns the sum of this polynomial {@code p}} and the other polynomial
	 * {@code q} the argument.
	 *
	 * @param q
	 *            the other polynomial
	 * @return the polynomial whose value is {@code (p(x) + q(x))}
	 */
	public Polynomial plus(Polynomial q) {
		Polynomial result = new Polynomial(0 , this.cf.length -1);
		for(int i =0; i < this.cf.length; i++) {
			result.cf[i] = this.cf[i] + q.cf[i];
		}
		return result;
	}

	/**
	 * Returns the result of subtracting the specified polynomial {@code q} from
	 * this polynomial {@code p}.
	 *
	 * @param q
	 *            the other polynomial
	 * @return the polynomial whose value is {@code (p(x) - q(x))}
	 */
	public Polynomial minus(Polynomial q) {
		Polynomial result = new Polynomial(0 , this.cf.length -1);
		for(int i =0; i < this.cf.length; i++) {
			result.cf[i] = this.cf[i] - q.cf[i];
		}
		return result;
	}

	/**
	 * Returns the product of this polynomial {@code p} and the specified polynomial
	 * {@code q}.
	 *
	 * @param q
	 *            the other polynomial
	 * @return the polynomial whose value is {@code (p(x) * q(x))}
	 */
	public Polynomial times(Polynomial q) {
		Polynomial result = new Polynomial(0 , this.cf.length + q.cf.length - 2);
		for(int i =0; i < this.cf.length; i++) {
			for(int j = 0; j < q.cf.length; j++)
				result.cf[i + j] += this.cf[i] * q.cf[j];
		}
		result.reduce();
		return result;
	}

	/**
	 * Returns the composition of this polynomial {@code p} and the specified
	 * polynomial {@code q}.
	 *
	 * @param q
	 *            the other polynomial
	 * @return the polynomial whose value is {@code (p(q(x)))}
	 */
	public Polynomial compose(Polynomial q) {
		Polynomial poly = new Polynomial(0, 0);
        for (int i = this.degree; i >= 0; i--) {
            Polynomial term = new Polynomial(this.cf[i], 0);
            poly = term.plus(q.times(poly));
        }
        return poly;
	}

	/**
	 * Returns the result of deriving this polynomial {@code p}.
	 *
	 * @return the polynomial whose value is {@code p'(x)}
	 */
	public Polynomial derive() {
		if (degree == 0) return new Polynomial(0, 0);
		Polynomial poly = new Polynomial(0, this.degree -1);
		poly.degree = degree - 1;
		for(int i = 0; i < degree; i++) {
        	poly.cf[i] = (i+1) * this.cf[i+1];
		}
		return poly;
	}

	/**
	 * Returns the result of evaluating this polynomial {@code p} at the value x.
	 *
	 * @param x
	 *            the value at which to evaluate the polynomial
	 * @return the value of evaluating {@code (p(x))}
	 */
	public double evaluate(double x) {
		double result = 0;
		for(int i =0; i < this.cf.length; i++) {
			result = result + this.cf[i] * Math.pow(x, i);
		}
		
		return result;
	}

	/**
	 * Returns a hash code for this polynomial. The hash code value is equal to the
	 * degree of the polynomial multiplied with 31 plus the hashcode of the
	 * coefficients array.
	 * 
	 * @return 31 * degree + Arrays.hashCode(cf)
	 */
	@Override
	public int hashCode() {
		return 31 * degree + Arrays.hashCode(cf);
	}

	/**
	 * Compares this polynomial to the other object {@code obj}. The result is true
	 * if and only if the argument is a polynomial object having the same degree and
	 * coefficients as this polynomial.
	 * 
	 * @param obj
	 *            an object to compare
	 * @return {@code true} if this polynomial equals to the specified object; and
	 *         {@code false} otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {return true;}
		if(obj == null) {return false;}
		if(this.getClass() != obj.getClass()) {return false;}
		Polynomial other = (Polynomial) obj;
		if(this.degree != other.degree) {
			return false;
		}
		else {
			boolean result = true;
			for(int i =0; i < this.cf.length; i++) {
				result = result && this.cf[i] == other.cf[i];
			}
			return result;
		}
		
	}

	/**
	 * Compares this polynomial {@code p} and the other polynomial {@code q} by
	 * their degree. If the degrees are equal, the polynomial coefficients are
	 * compared, and so on.
	 *
	 * @param q
	 *            the other polynomial
	 * @return the value {@code -1 } if this polynomial is less than the argument
	 *         polynomial; {@code +1} if this polynomial is greater than the
	 *         argument polynomial; and {@code 0} if this polynomial is equal to the
	 *         argument polynomial.
	 */
	@Override
	public int compareTo(Polynomial q) {
		if(this.degree == q.degree ) {
			for(int i =0; i < this.cf.length; i++) {
				if(this.cf[i] > q.cf[i]) {
					return 1;
				}
				else if (this.cf[i] < q.cf[i]) {
					return -1;
				}
			}
			return 0;
			
		}
		else if(this.degree > q.degree) {
			return 1;
			
		}
		else {
			return -1;
		}
	}

	/**
	 * Return a string representation of this polynomial in the standard form. The
	 * standard form of a polynomial is to put the terms with the highest degree
	 * first. The following are examples of the returned string for different
	 * polynomials.
	 * 
	 * <pre>
	new Polynomial();                              //0.0
	new Polynomial(1,0)                            //1.0
	new Polynomial(1,1);                           //1.0x
	new Polynomial(new double[] {1,1});            //1.0x + 1.0
	new Polynomial(new double[] {0,0,2});          //2.0x^2
	new Polynomial(new double[] {0,1,2});          //2.0x^2 + 1.0x
	new Polynomial(new double[] {1,0,2});          //2.0x^2 + 1.0
	new Polynomial(new double[] {0.0001213,1,2});  //2.0x^2 + 1.0x + 1.213E-4
	 * </pre>
	 * 
	 * @return a string representation of this polynomial
	 */
	@Override
	public String toString() {
		if      (degree == -1) return "0";
        else if (degree ==  0) return "" + cf[0];
        else if (degree ==  1 ) {
        	if      (cf[0] == 0) return cf[1] + "x";
            else if (cf[0]  > 0) return cf[1] + "x" + " + " + (cf[0]);
            else if (cf[0]  < 0) return cf[1] + "x" + " - " + (-cf[0]);
        	
        }
        else if (degree ==  1 && cf[0] != 0) return cf[1] + " x " + cf[0];
        String s = cf[degree] + "x^" + degree;
        for (int i = degree - 1; i >= 0; i--) {
            if      (cf[i] == 0) continue;
            else if (cf[i]  > 0) s = s + " + " + (cf[i]);
            else if (cf[i]  < 0) s = s + " - " + (-cf[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    
		
	}
}
