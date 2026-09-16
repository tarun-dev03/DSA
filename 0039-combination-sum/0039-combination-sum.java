class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        find(candidates, target, 0, new ArrayList<>());

        return ans;
    }

    private void find(int[] candidates, int target, int index,
        List<Integer> current) {


        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            current.add(candidates[i]);


            find(candidates, target - candidates[i], i, current);

            current.remove(current.size() - 1);
        }
    }
}