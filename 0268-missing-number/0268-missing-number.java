class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length;
        int output = 0;
        for(int i = start;i < end;i++){
            if(nums[i] != i){
                break;
            }
            output = i+1;

        }
        return output;
        
    }
}