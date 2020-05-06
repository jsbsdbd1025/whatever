
package leetcode.editor.cn;

//[459]重复的子字符串
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串


public class T459 {

    public static void main(String[] args) {
        System.out.println(new T459().repeatedSubstringPattern("abcabcabc"));
        // aba  abab    ababa

    }

    // 辗转相除法
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 最初的想法，开头有几个连续的-1，即为循环节，abab abcabcabc这种数据符合，
    // 死在了abacabac这种
    // 然后想到的是求最后一个next的值+1 与 总长度的公约数，即为循环节。
    // 坑在了aaaa这种单个循环的用例，打补丁后能过
    // 最后发现结合了两种想法，总长度减去最后一个next的值+1 即为循环节。
    public boolean repeatedSubstringPattern(String s) {

        int[] nexts = findNext(s.toCharArray());

        // 末尾为-1肯定不循环
        if (nexts[s.length() - 1] == -1) {
            return false;
        }

        //解决aaaa这种用例
        if (nexts[s.length() - 1] + 2 == s.length()) {
            return true;
        }

        return gcd(s.length(), nexts[s.length() - 1] + 1) > 1;

        //        return s.length() % (s.length() - nexts[s.length() - 1] - 1) == 0;
//        if (nexts[s.length() - 1] >= 0) {
//            if (nexts[s.length() - 1] + 2 == s.length()) {
//                return true;
//            }
//
//        }
//        return false;

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