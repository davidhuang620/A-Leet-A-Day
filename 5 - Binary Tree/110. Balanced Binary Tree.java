/*

DIVIDE AND CONQUER
Big -> is this tree a self balance tree ?
Small -> is this tree's subtree a self balance tree ?

Then we can use recursion and solve the small problem first, then the big problem 

Follow up:
How to make it more readable ?
-1 is not a good represent of the true and false of the height of the self balance tree
we can declare a class variable
*/

private int NOT_BALANCE = -1;

/*
and use this in the code instead of the -1
also we can create a class that contains 2 information: height and balance 
*/

class ResultType{
  public int height;
  public boolean isBal;
}

/*

use this instead of the -1

*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return depth(root) != -1;
    }
    
    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        // can't add 1 here, it will mess up with our -1 function later
        int left = depth(root.left);
        int right = depth(root.right);
        
        if (left == -1 || right == -1){
            return -1;
        }
        
        if (Math.abs(left - right) > 1){
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
    
}




/*
Follow UP
*/

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    class ResultType{
        public int height;
        public boolean isBal;
        ResultType(int x, boolean isBal){
            this.height = x;
            this.isBal = isBal;
        }
    }
     
    public boolean isBalanced(TreeNode root) {
        
        ResultType result = isBal(root);
        return result.isBal;
    }
    
    private ResultType isBal(TreeNode root){
        if (root == null){
            return new ResultType(0, true);
        }
        
        ResultType left = isBal(root.left);
        ResultType right = isBal(root.right);
        
        if (!left.isBal || !right.isBal){
            return new ResultType(-1, false);
        }
        
        if (Math.abs(left.height - right.height) > 1){
            return new ResultType(-1, false);
        }
        
        ResultType result = new ResultType(Math.max(left.height, right.height) + 1, true);
        
        return result;
        
    }
    
}

