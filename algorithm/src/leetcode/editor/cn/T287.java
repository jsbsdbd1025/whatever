
package leetcode.editor.cn;

//[287]寻找重复数
//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class T287 {

    public static void main(String[] args) {
        System.out.println(new T287().findDuplicate(new int[]{1,3,4,2,1}));
    }

    /**
     * 时间复杂度  排序 nlog(n) + 遍历n
     * 空间复杂度  不需要额外空间
     */
//    public int findDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//           if(nums[i] == nums[i-1]){
//               return nums[i];
//           }
//        }
//        return -1;
//    }

    /**
     * 时间复杂度  遍历n
     * 空间复杂度  因为数字就1-n 额外开一个n的数组作为映射
     *
     * @param nums
     * @return
     */
//    public int findDuplicate(int[] nums) {
//        int[] map = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (map[nums[i]-1]>0){
//                return nums[i];
//            }
//            map[nums[i]-1]++;
//        }
//        return -1;
//    }


//    public int findDuplicate(int[] nums) {
//        // 用HashSet和HashMap没差
//        Set set = new HashSet();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                return nums[i];
//            }
//            set.add(nums[i]);
//        }
//        return -1;
//    }

    /**
     * 剑指offerP40
     * 与数组映射方法类似，节省了额外的内存开销
     */
//    public int findDuplicate(int[] nums) {
////        int i = 0;
////        while (i < nums.length) {
////
////            if (nums[i] != i + 1) {
////                if (nums[i] == nums[nums[i] - 1]) {
////                    return nums[i];
////                } else {
////                    int t = nums[i];
////                    nums[i] = nums[nums[i] - 1];
////                    nums[t - 1] = t;
////                }
////                continue;
////            }
////            i++;
////        }
////        return i;
////    }

    /**
     * 剑指OfferP43
     * 时间复杂度 二分 log(n) * 遍历 n
     * 不需要对原数组进行操作，需要几个变量的空间
     */
    public int findDuplicate(int[] nums) {

        int l = 1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int c = 0;// 在 l - r 范围内的总数
            int v = 0;// 在 l - mid 范围内的数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= l && nums[i] <= r) {
                    c++;
                    if (nums[i] <= mid) {
                        v++;
                    }
                }
            }
            if (v * 2 > c) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}