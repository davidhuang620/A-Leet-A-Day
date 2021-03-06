/*

How this approach works?

Initially we consider the area constituting the exterior most lines.
Now, to maximize the area, we need to consider the area between the lines of larger lengths. 
If we try to move the pointer at the longer line inwards, we won't gain any increase in area, 
since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial, 
as per the same argument, despite the reduction in the width. 
This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome 
the reduction in area caused by the width reduction.

Here is the proof.
Proved by contradiction:

Suppose the returned result is not the optimal solution. Then there must exist an optimal solution, 
say a container with a_ol and a_or (left and right respectively), 
such that it has a greater volume than the one we got. 
Since our algorithm stops only if the two pointers meet.
So, we must have visited one of them but not the other. WLOG, 
let's say we visited a_ol but not a_or. When a pointer stops at a_ol, it won't move until
The other pointer also points to a_ol.
In this case, iteration ends. But the other pointer must have visited a_or on its way from right end to a_ol.
Contradiction to our assumption that we didn't visit a_or.

The other pointer arrives at a value, say a_rr, that is greater than a_ol before it reaches a_or.
In this case, we does move a_ol. But notice that the volume of a_ol and a_rr is already greater than a_ol and a_or
(as it is wider and heigher), which means that a_ol and a_or is not the optimal solution -- Contradiction!

Both cases arrive at a contradiction.

*/
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right){
            int water = (right - left) * Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, water);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
