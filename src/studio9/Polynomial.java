package studio9;

import java.util.LinkedList;

public class Polynomial {
	private LinkedList<Double> list;// List to store polynomial coefficients
	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//FIXME
		list=new LinkedList<Double>(); // Initialize the coefficients list as an empty LinkedList
	}
	/**
	 * 
	 * Adds a term to the end of the polynomial.
	 * @param coeff
	 * @return polynomial with added term
	 */
	public void addTerm(double coeff) {
		//FIXME
		list.add(coeff); // Add the coefficient to the end of the list
		return; //return new list 
	}
	/*
	 * Returns a String of the polynomial with the proper form:
	 *For example, the list [1, 0, 4] would output "x^2 + 4".
	 *
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 * Finished and added annotations! 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(); // StringBuilder to build the polynomial string
		int degree = list.size() - 1;  // Start with the highest degree (based on list size)
		for (int i = 0; i < list.size(); i++) { // Iterate over all coefficients
			double coeff = list.get(i); // Get the current coefficient
			if (coeff != 0) { // Skip terms with a coefficient of 0
				if (sb.length() > 0) sb.append(" + "); // Add " + " if this is not the first term
				if (degree > 1) { // If the degree is greater than 1 (e.g., x^N)
					sb.append(coeff).append("x^").append(degree); // Append the coefficient, x, and the degree
				} else if (degree == 1) { // If the degree is 1 (e.g., x)
					sb.append(coeff).append("x"); // Append the coefficient and x
				} else { // If the degree is 0 (constant term)
					sb.append(coeff); // Append just the coefficient
				}
			}
			degree--; // Decrease the degree for the next term
		}
		return sb.toString(); // Return the final polynomial string
	}
	/**
	 * 
	 * @param x
	 * @return value of polynomial at that x
	 */
	public double evaluate(double x) {
		double result=0; //initalize result as starting point
		int degree=list.size()-1; //start using highest degree
		for (Double coeff:list) {//iterate through each 
			result +=coeff*Math.pow(x,degree);// Add coeff * x^degree to result
			degree--; //decrease degree for next term 
		}
		return result; //return final result  
	}


	public Polynomial derivative() {
		Polynomial result=new Polynomial(); //intialize new Polynomial for derivative 
		int degree=list.size()-1; //start using highest degree
		for (int i=0; i<list.size(); i++) {//iterate through each coefficient
			Double coeff=list.get(i);//get the current coefficient 
			if (degree>0) {//only include terms where degree is greater than zero
				result.addTerm(coeff*degree);//apply the power rule: n*a
			}
			degree--;// Decrease the degree for the next term
		} 
		return result; // Return the new Polynomial representing the derivative
	}


	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}
	public static void main(String[] args) {
		Polynomial poly = new Polynomial(); // Create a new Polynomial object
		poly.addTerm(1);  // Adding x^2 coefficient
		poly.addTerm(0);  // Adding x^1 coefficient
		poly.addTerm(4);  // Adding constant coefficient
		//testing to String
		System.out.println(poly); // Expected: "x^2 + 4"
		//testing eval
		System.out.println("P(3)= "+poly.evaluate(3));
		 // Testing the derivative method
        Polynomial derivative = poly.derivative();
        System.out.println("Derivative: " + derivative); // Expected: "2x"
	}
}