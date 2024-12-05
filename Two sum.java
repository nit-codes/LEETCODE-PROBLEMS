class Solution {
    public int[] twoSum(int[] nums, int target) {
      int m = nums.length;
      Map <Integer,Integer> mp = new HashMap<>();
      for(int i=0 ; i<m ; i++){
        int remaining = target - nums[i];
        if(mp.containsKey(remaining)){
          return new int[]{mp.remaining , i};
        }
        mp.put(nums[i],i);
      }
      return new int[]();
}
