// 1. Solution 

//Time= O(n)
//Space=O(1)


import java.util.ArrayList;
import java.util.List;

public class CommonElements {
    public static List<Integer> commonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};

        List<Integer> result = commonElements(arr1, arr2, arr3);
        System.out.println(result); // Output: [1, 5]
    }
}



// 2. Solution 

//Time= O(n+m)
//Space=O(n+m)


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctIntegers {
    public static List<List<Integer>> findDistinctIntegers(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> distinctNums1 = new ArrayList<>();
        List<Integer> distinctNums2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                distinctNums1.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                distinctNums2.add(num);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(distinctNums1);
        result.add(distinctNums2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        List<List<Integer>> result = findDistinctIntegers(nums1, nums2);
        System.out.println(result); // Output: [[1, 3], [4, 6]]
    }
}



// 3. Solution 

//Time= O(m*n)
//Space=O(m*n)


public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposed = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposed = transpose(matrix);

        for (int[] row : transposed) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        // Output:
        // 1 4 7
        // 2 5 8
        // 3 6 9
    }
}



// 4. Solution 

//Time= O(n log n)
//Space=O(1)


import java.util.Arrays;

public class ArrayPairSum {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        int maxSum = arrayPairSum(nums);
        System.out.println(maxSum); // Output: 4
    }
}



// 5. Solution 

//Time=O(sqrt(n))
//Space=O(1)


public class CompleteStaircase {
    public static int arrangeCoins(int n) {
        int count = 0;
        int coinsNeeded = 1;

        while (n >= coinsNeeded) {
            n -= coinsNeeded;
            coinsNeeded++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int completeRows = arrangeCoins(n);
        System.out.println(completeRows); // Output: 2
    }
}



// 6. Solution 

//Time=O(n)
//Space=O(n)


import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int squareLeft = nums[left] * nums[left];
            int squareRight = nums[right] * nums[right];

            if (squareLeft > squareRight) {
                result[index] = squareLeft;
                left++;
            } else {
                result[index] = squareRight;
                right--;
            }

            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] squares = sortedSquares(nums);
        System.out.println(Arrays.toString(squares)); // Output: [0, 1, 9, 16, 100]
    }
}



// 7. Solution 

//Time=O(k)
//Space=O(1)


public class MaxCount {
    public static int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;

        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        int maxIntegers = maxCount(m, n, ops);
        System.out.println(maxIntegers); // Output: 4
    }
}



// 8. Solution 

//Time=O(n)
//Space=O(n)


public class ShuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[n + i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] shuffledArray = shuffle(nums, n);
        
        for (int num : shuffledArray) {
            System.out.print(num + " "); // Output: 2 3 5 4 1 7
        }
    }
}








