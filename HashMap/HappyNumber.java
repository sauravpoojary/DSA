package HashMap;

import java.util.HashSet;

public class HappyNumber {

    private static int sumOfSquaresOfDigits(int n) {
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {

        //with hash set
        // HashSet<Integer> set = new HashSet<>();
        // int temp = n;
        // while(temp != 1 && !set.contains(temp)) {
        //     System.out.println(temp);
        //     set.add(temp);
        //     temp = sumOfSquaresOfDigits(temp);
        // }
        // return temp == 1;

        //without hasset
        //using slow and fast pointers
        int slow = n;
        int fast = n;
        do {
            slow = sumOfSquaresOfDigits(slow);
            fast = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fast));
        }while(slow!=fast);

        return slow == 1;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }
}
