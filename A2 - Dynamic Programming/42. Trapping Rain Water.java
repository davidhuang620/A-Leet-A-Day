/*

niubi

// Credit https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.

For instance, at the very beginning, if leftMax = 2, rightMax = 5, 
then we move left pointer from index 0 to index 1 since left bar is smaller. 
For index 1, left bar is 2, we can conclude that the area in position 1 is 2. 

Let us analysis two possible conditions:

Condition 1: there exists another bar with height h, as 2 < h < 5, 
then position 1 can fill water with 2 units, even though water will be blocked by the middle bar.

Condition 2: there exists another bar with height h, as 2 > h, 
then position 1 still can fill water with 2 units (in other words,
if there does not exist any bars greater than 2, 
then water will fill out every position until reach the right most bar with height 5)
So anything in the middle of leftMax bar and rightMax bar will not influence how much water can current position trap

Overall, similar to problem 11, we only need to track whether leftMax is smaller than rightMax or not 
(shorter bar will determine volume of water 木桶原理)

If leftMax is smaller, use left bar as current container rim
If rightMax is smaller, use right bar as current container rim
DO NOT FORGET to deduct the height of current position while doing calculation 
(try to imagine that height of current position is the height of base）

*/


class Solution {
    public int trap(int[] height) {
        
        if (height == null || height.length == 0) return 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int count = 0;
        
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            if (leftMax <= rightMax){
                count += leftMax - height[left];
                left++;
            } else {
                count += rightMax - height[right];
                right--;
            }
        }
        
        return count;
    }
}
