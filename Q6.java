/*You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 
Note: The answer should be returned in an increasing format.
Examples:
Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.
Input: arr[] = [1, 2, 3, 4, 5]
Output: []
Explanation: o candidate occur more than n/3 times.*/
import java.util.*;
class Q6 {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Enter the number of elements in the array:");
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }
            
            int[] nums = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            // Now the method is part of the Q6 class
            List<Integer> result = findMajority(nums);
            System.out.println("Majority elements (appearing more than n/3 times): " + result);
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            sc.close();
        }
    }

    // Function to find the majority elements in the array
    public static List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        // First pass: find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify the candidates' counts
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int n = nums.length;
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        // Sort the result list before returning
        Collections.sort(result);
        return result;
    }
}
