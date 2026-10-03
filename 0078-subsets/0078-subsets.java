
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        subSets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void subSets(int[] arr, int index,
                        List<Integer> current,
                        List<List<Integer>> result) {

        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include the element
        current.add(arr[index]);
        subSets(arr, index + 1, current, result);
        current.remove(current.size() - 1);

        // Choice 2: Skip the element
        subSets(arr, index + 1, current, result);
    }
}
