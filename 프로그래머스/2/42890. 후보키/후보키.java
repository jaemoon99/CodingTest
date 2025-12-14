import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int solution(String[][] relation) {
        int cols = relation[0].length;

        List<Set<Integer>> candidateKeys = new ArrayList<>();
        boolean[] v = new boolean[cols];

        subSet(relation, v, 0, candidateKeys);

        return candidateKeys.size();
    }

    private void subSet(String[][] relation, boolean[] v, int idx, List<Set<Integer>> candidateKeys) {
        int cols = relation[0].length;

        if (idx == cols) {
            Set<Integer> selectedCols = new HashSet<>();
            for (int c = 0; c < cols; c++) {
                if (v[c]) {
					selectedCols.add(c);
				}
            }

            if (selectedCols.isEmpty()) {
				return;
			}

            for (Set<Integer> key : candidateKeys) {
                if (selectedCols.containsAll(key)) {
                    return;
                }
            }

            if (isUnique(relation, selectedCols)) {
                candidateKeys.add(selectedCols);
            }

            return;
        }

        v[idx] = false;
        subSet(relation, v, idx + 1, candidateKeys);

        v[idx] = true;
        subSet(relation, v, idx + 1, candidateKeys);
    }

    private boolean isUnique(String[][] relation, Set<Integer> selectedCols) {
        int rows = relation.length;
        Set<String> set = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c : selectedCols) {
				sb.append(c).append('=').append(relation[r][c]).append('|');
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}