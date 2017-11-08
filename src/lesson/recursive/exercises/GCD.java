/**
 * 
 */
package lesson.recursive.exercises;

/**
 * 
 * Euclid's algorithm. The greatest common divisor (gcd) of two positive
 * integers is the largest integer that divides evenly into both of them.
 * 
 * For example, the gcd(102, 68) = 34. 102 % 68 102 - 68 = 34 gcd(102, 68) pTemp
 * = q q = p % q p = pTemp gcd(68, 34) pTemp = q q = p % q p = pTemp gcd(34, 0)
 * if ( q == 0 ) return p; return 34 return 34 return 34
 * 
 * We can efficiently compute the gcd using the following property, which holds
 * for positive integers p and q: If p > q, the gcd of p and q is the same as
 * the gcd of q and p % q.
 * 
 * gcd(1440, 408) gcd(408, 216) gcd(216, 192) gcd(192, 24) gcd(24, 0) return 24
 * return 24 return 24 return 24 return 24
 * 
 * *Given four positive integers a, b, c, and d, explain what value is *
 * computed by gcd(gcd(a, b), gcd(c, d)).
 *
 * @author jonas.andree
 *
 */
public class GCD {

	public static void main(String[] args) {
		System.out.println("gcd = " + gcd(5641561, 408));
	}

	public static int gcd(int p, int q) {
		if ( q == 0 )
			return p;
		
		int pTemp = q; 
		q = p % q; 
		p = pTemp;
		System.out.println(p + ", " +q);
		return gcd(p, q);
		
		
	}
}
