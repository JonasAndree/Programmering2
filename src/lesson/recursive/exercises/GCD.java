/**
 * 
 */
package lesson.recursive.exercises;

/**
 * 
 * Euclid's algorithm. The greatest common divisor (gcd) of two positive integers 
 * is the largest integer that divides evenly into both of them. 
 * 
 * For example, the gcd(102, 68) = 34.
 * 	gcd(102, 68) 
 * 		gcd(68, 34)
 * 			gcd(34, 0)
 * 			return 34
 * 		return 34
 * 	return 34
 * 
 * We can efficiently compute the gcd using the following property, 
 * which holds for positive integers p and q:
 * 		If p > q, 
 * 			the gcd of p and q is the same as the gcd of q and p % q.
 * 	
 * gcd(1440, 408) 
 *  	gcd(408, 216) 
 *     		gcd(216, 192) 
 *        		gcd(192, 24)
 *           		gcd(24, 0)
 *             		return 24
 *           	return 24 
 *        	return 24 
 *     	return 24 
 *  return 24 
 *  
 *  *Given four positive integers a, b, c, and d, explain what value is 
 *  *	computed by gcd(gcd(a, b), gcd(c, d)).
 *
 * @author jonas.andree
 *
 */
public class GCD {

}
