// class Solution {
//     public boolean isHappy(int n) {
//         Set<Integer> seen = new HashSet<>();

//         while (n != 1) {
//             if (seen.contains(n)) {
//                 return false; // cycle detected
//             }
//             seen.add(n);
//             n = sumOfSquares(n);
//         }

//         return true;
//     }

//     private int sumOfSquares(int n) {
//         int sum = 0;
//         while (n > 0) {
//             int digit = n % 10;
//             sum += digit * digit;
//             n /= 10;
//         }
//         return sum;
//     }
// }


class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}


