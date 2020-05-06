
package leetcode.editor.cn;

//[621]任务调度器
//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
//都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。 
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的最短时间。 
//
// 
//
// 示例 ： 
//
// 输入：tasks = ['A','A','A','B','B','B'], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
// 
//
// 
//
// 提示： 
//
// 
// 任务的总个数为 [1, 10000]。 
// n 的取值范围为 [0, 100]。 
// 
// Related Topics 贪心算法 队列 数组

import java.util.*;

//拿到题之后可以看出这是一道最优解的问题，简单点的话用贪心就能解决不行的话用动态规划解。
//首先贪心的思想思考下，用数字最多的字母优先按间隔排开，第二多的次之。根据测试用例似乎没什么毛病。
//尝试一下，
public class T621 {

    public static void main(String[] args) {
        new T621().leastInterval(new char[]{'A','A','A','B','B','B'}, 0);
    }


    public int leastInterval(char[] tasks, int n) {
        //若10000个数都为同一个字母，间隔为100，需要开10000 * 100 这么大的数组 稍微多给点
        // （可以算一下内存，但不影响实现初步思路

        Map<Character, Integer> map = new HashMap<>();

        // 统计每个字符的个数
        for (char c : tasks) {
            Integer k = 0;
            if ((k = map.get(c)) != null) {
                map.put(c, ++k);
            } else {
                map.put(c, 1);
            }
        }

        // Map转成List用来按数量排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            list.add((Map.Entry<Character, Integer>) iterator.next());
        }

        // i 代表第几个入队列,也就是最后的结果
        int i = 0;
        while (true) {
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            // 因为要删掉用光了的字母，就用迭代器的方式
            Iterator iterator1 = list.iterator();
            for (int j = 0; j <= n; i++, j++) {

                if (iterator1.hasNext()) {
                    Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) iterator1.next();
                    int t = entry.getValue() - 1;
                    if (t == 0) {
                        iterator1.remove();
                    } else {
                        entry.setValue(t);
                    }
                }
                if (list.size() == 0) {
                    break;
                }
            }

            if (list.size() == 0) {
                break;
            }
        }
        // 因为从0开始计的 所以结果+1
        return i + 1;

    }

}