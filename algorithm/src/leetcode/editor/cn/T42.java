package leetcode.editor.cn;

//[42]接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


import java.util.Stack;

public class T42 {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public int trap(int[] height) {
        // 这里用了栈的后进先出
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int pre = -1;

            while (!stack.isEmpty()) {
                int right = stack.pop();
                if (height[i] >= height[right]) {
                    if (pre != -1) {
                        ans += (i - right - 1) * (height[right] - height[pre]);
                    }
                    pre = right;
                    continue;
                } else {
                    if (pre != -1) {
                        ans += (i - right - 1) * (height[i] - height[pre]);
                    }
                    //比栈尾小，加回去
                    stack.push(right);
                    break;
                }
            }

            stack.push(i);
        }
        return ans;
    }
//leetcode submit region end(Prohibit modification and deletion)


}