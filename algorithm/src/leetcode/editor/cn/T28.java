
package leetcode.editor.cn;

//[28]实现 strStr()
//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串


public class T28 {

    public static void main(String[] args) {
        System.out.println(new T28().strStr("mississippi", "mississippi"));
    }

    /**
     * 方法1：朴素匹配，以第i的为起点，逐个比较字符，不同时则继续以i+1为起点
     * 当haystack长度不足时（heystack.length-i<needle.length）退出，减少不必要的运算
     * 时间复杂度：(n-m+1)*m
     *
     */
//    public int strStr(String haystack, String needle) {
//
//        if (needle == null || needle.length() == 0) {
//            return 0;
//        }
//        char[] T = haystack.toCharArray();
//        char[] p = needle.toCharArray();
//        int ans = -1;
//        for (int i = 0; i <= T.length - p.length; i++) {
//            boolean exit = false;
//            //以i为起点
//            for (int j = 0; j < p.length; j++) {
//                if (T[i + j] != p[j]) {
//                    exit = true;
//                }
//            }
//            if (exit) {
//                continue;
//            } else {
//                ans = i;
//                break;
//            }
//        }
//        return ans;
//
//    }

    /**
     * 方法2：KMP算法，构建模式串的失配数组
     * 有                a   b   c   a   b   d   a 这么个字符串
     * 对应的失配数组为  -1  -1  -1   0   1  -1   0
     * 数值的意义为，当前字符匹配不上的情况下跳转到哪一个位置（当前部分与从头开始的连续的第几个一样），避免又从头开始
     * 假如被匹配的字符串为a  b   c   a   b   c   a   b   d   a   b   c
     * 根据朴素匹配首先    a  b   c   a   b
     * 在c 对 d时不匹配，于是跳到第二个b的下标 1 处，匹配关系变成
     * a  b   c   a   b   c   a   b   d   a   b   c
     * a   b
     * 这一步看出了相对朴素匹配的优化，被比较的字符串不需要从头开始扫描，且之前匹配上的串也不浪费，
     * 使算法负责度优化为O（n+m）
     * 0    1   2   3   4   5   6
     * a    a   b   a   a   a   c
     * -1   0   -1  0   1   1   -1
     * 5的位置与4的next（1）+1的位置不符，故以4的next（1）的next（0）+1比相同，所以5的next为next（0）+1
     */
    public int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }
        char[] T = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = findNext(p);
        int ans = -1;
        int i = 0;

        for (int j = 0; i < T.length && j < p.length; j++) {
            if (T[i] == p[j]) {
                i++;
                if (j == p.length - 1) {
                    ans = i - p.length;
                    break;
                }
            } else {
                if (j == 0) {
                    j = -1;
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }

        return ans;
    }

    // 寻找next下标，注意-1的越界
    private int[] findNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        for (int i = 1; i < p.length; i++) {
            next[i] = -1;
            int t = next[i - 1];
            while (true) {
                if (p[i] == p[t + 1]) {
                    next[i] = t + 1;
                    break;
                } else {
                    if (t == -1) {
                        break;
                    }
                    t = next[t];
                }
            }

        }
        return next;
    }


}