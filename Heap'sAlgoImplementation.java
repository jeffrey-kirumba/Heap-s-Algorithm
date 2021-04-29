import java.util.*;

 
class Solution {
    List<List<Integer>> permutatedArrays = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        permuted(n,nums);
        return permutatedArrays;
    }
    public void permuted(int n, int[] nums) {
        if(n == 1){
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList()); //Turned Array into List 
            permutatedArrays.add(list);
            return;
        }
        permuted(n-1, nums);
        for(int i=0; i<n-1; i++) {
            if (n%2 == 0){//if even
                int temp = nums[i];
                nums[i] = nums[n-1];
                nums[n-1] = temp;}
            else{ //if odd
                int temp = nums[0];
                nums[0] = nums[n-1];
                nums[n-1]= temp;}			   
		    permuted(n-1, nums);// Call after alterations (n-1 times)
   
        }

    }
}// https://leetcode.com/jeffreykirumba/ My code was accepted on leetcode
