import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        find(k, n, 1, new ArrayList<>());
        return ans;
    }

    private void find(int k, int target, int index, List<Integer> current) {

        if (current.size() == k && target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (current.size() >= k || target < 0) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            current.add(i);

            find(k, target - i, i + 1, current);

            current.remove(current.size() - 1);
        }
    }
}