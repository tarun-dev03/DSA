
import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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

            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);

            find(candidates, target - candidates[i], i + 1, current);

            current.remove(current.size() - 1);
        }
    }
}
