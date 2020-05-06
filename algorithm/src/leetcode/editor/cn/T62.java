
package leetcode.editor.cn;

//[62]不同路径
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划


public class T62 {

    private static int count;

    public static void main(String[] args) {
        count = 0;

        dfs(0, 0, 3, 7);

        System.out.println(count);
    }

    /**
     * @param x 当前所在行
     * @param y 当前所在列
     * @param m 总行数
     * @param n 总列数
     */
    public static void dfs(int x, int y, int m, int n) {
        //在地图外不能走直接返回
        if (x >= m || y >= n) {
            return;
        }

        //到达终点，记一条路径
        if (x == m - 1 && y == n - 1) {
            count++;
            System.out.println("到达终点累计:"+count);
            return;
        }
        //向右走
        System.out.println("(" + x + "," + y + ")向右走到" + "(" + x + "," + (y + 1) + ")");
        dfs(x, y + 1, m, n);
        System.out.println("(" + x + "," + (y + 1) + ")退回" + "(" + x + "," + y + ")");


        //向下走
        System.out.println("(" + x + "," + y + ")-向下走到" + "(" + (x + 1) + "," + y + ")");
        dfs(x + 1, y, m, n);
        System.out.println("(" + (x + 1) + "," + y + ")退回" + "(" + x + 1 + "," + y + ")");

    }

    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}