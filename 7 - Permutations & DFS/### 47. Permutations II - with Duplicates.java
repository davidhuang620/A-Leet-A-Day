/*

Similiar problem with Permutation problem, but this time we have duplciates

The Key is to check if the current nums[i] is a duplicate number of the previous number, 
(so we need to sort the array first)

If it is, we only allow one kind of combination 
which is when the first one is use => visited[i - 1]

All other cases (where the first one is not use)
would be another duplicate permutation and should be denied.

In other words =>  
if the previouse number is not used and we are duplicates, we want to pass 
(Because the duplicate permuations are already been taken of one and only one time when the first one is used)

the previous one is not visited && we are duplicates 
(i > 0 && !visited[i-1] && nums[i] == nums[i-1]){
  continue;
}



*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null){
            return ans;
        }
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void helper(int[] nums, boolean[] visited, List<Integer> perm, List<List<Integer>> ans){
        
        if (perm.size() == nums.length ){
            ans.add(new ArrayList<Integer>(perm));
            return;
        }        
        for (int i = 0; i < nums.length; i++){
            if (visited[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            perm.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, perm, ans);
            visited[i] = false;
            perm.remove(perm.size() - 1);
        }

    }
    
}
