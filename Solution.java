class Solution {
	// e.g. 123
    public int reverse(int x) {
		// rev (0) * 10 + pop == pop 
        int rev = 0;

		// x / 10, keep consuming, then end e.g. int(1/10) = 0
        while (x != 0) {
			// get last digi
            int pop = x % 10;

			// get digits without the last digit 
            x /= 10;

			// 32 bit singed in
			// max num: 2^31-1: 2147483647
            if (
				// rev is not yet has pop, >
				rev > Integer.MAX_VALUE/10 ||
				// rev == 214748364 without 7 
				(rev == Integer.MAX_VALUE / 10 && pop > 7)
			) 
				return 0;
			
			// min num: -2^31: -2147483648
            if (
				// rev not yet has pop, <
				rev < Integer.MIN_VALUE/10 || 
				(rev == Integer.MIN_VALUE / 10 && pop < -8)
			) 
				return 0;

			// push reverse num to front
            rev = rev * 10 + pop;
        }
        return rev;
    }


	// Can define stati method inside a class
	public static void main(String[] args) {
		// obj
		Solution sol = new Solution();
		// call method
		int out = sol.reverse(123);
		// print
		System.out.println("-----");
		System.out.println(out);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
