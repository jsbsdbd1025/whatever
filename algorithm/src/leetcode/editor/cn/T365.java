
package leetcode.editor.cn;

//[365]水壶问题
//有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？ 
//
// 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。 
//
// 你允许： 
//
// 
// 装满任意一个水壶 
// 清空任意一个水壶 
// 从一个水壶向另外一个水壶倒水，直到装满或者倒空 
// 
//
// 示例 1: (From the famous "Die Hard" example) 
//
// 输入: x = 3, y = 5, z = 4
//输出: True
// 
//
// 示例 2: 
//
// 输入: x = 2, y = 6, z = 5
//输出: False
// 
// Related Topics 数学


import java.util.*;

public class T365 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println(new T365().canMeasureWater(104693,
                104701,
                324244));
        System.out.println(System.currentTimeMillis() - startTime);

    }


    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    private Set<String> flag;
    private Stack<Node> nodes;

    public boolean canMeasureWater(int x, int y, int z) {

        flag = new HashSet<>();
        nodes = new Stack<>();
        nodes.add(new Node(0, 0));
        while (!nodes.isEmpty()) {
            Node top = nodes.pop();
            StringBuilder builder = new StringBuilder();
            builder.append(getString(top.i, 9))
                    .append(getString(top.j, 9));
            String hash = builder.toString();
            if (flag.contains(hash)) {
                continue;
            }
            //标位已走
            flag.add(hash);

            if (top.i == z || top.j == z || (top.i + top.j == z)) {
                return true;
            }
            // 1.给x水壶中倒水
            if (top.i == 0) {
                nodes.push(new Node(x, top.j));
            }

            // 2.给y水壶中倒水
            if (top.j == 0) {
                nodes.push(new Node(top.i, y));
            }
            // y水壶满了不能倒
            if (top.j != y) {
                //x水壶没水也不倒
                if (top.i != 0) {
                    //3.将x水壶中的水倒到y水壶,这里分倒不满和倒不下的情况
                    if (top.j + top.i <= y) {
                        //倒不满y水壶(刚好)
                        nodes.push(new Node(0, top.j + top.i));
                    } else {
                        //倒满y水壶剩下的水保留在x水壶中
                        nodes.push(new Node(top.j + top.i - y, y));
                    }
                }
            }

            // x水壶满了不能倒
            if (top.i != x) {
                //y水壶没水也不倒
                if (top.j != 0) {
                    //4.将y水壶中的水倒到x水壶,同样分倒不满和倒不下的情况
                    if (top.j + top.i <= x) {
                        nodes.push(new Node(top.j + top.i, 0));
                    } else {
                        nodes.push(new Node(x, top.j + top.i - x));
                    }
                }
            }

            //5.将x水壶中的水倒掉
            if (top.i == x) {
                nodes.push(new Node(0, top.j));
            }
            //6.将y水壶中的水倒掉
            if (top.j == y) {
                nodes.push(new Node(top.i, 0));
            }
        }
        return false;
    }

    public static StringBuilder getString(int src, int len) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(src);
        while (stringBuilder.length() < len) {
            stringBuilder.insert(0, "0")
                    .append(stringBuilder.toString());
        }
        return stringBuilder;
    }

}