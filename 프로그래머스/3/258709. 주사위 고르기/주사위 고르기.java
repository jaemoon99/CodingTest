import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[][] dice) {
        int len = dice.length;
        int selCnt = len / 2;

        List<int[]> combs = new ArrayList<>();
        makeComb(0, 0, selCnt, new int[selCnt], combs, len);

        long maxWin = -1;
        int[] best = null;

        for (int[] aDice : combs) {
            boolean[] selected = new boolean[len];
            for (int idx : aDice) selected[idx] = true;

            int[] bDice = new int[selCnt];
            int bi = 0;
            for (int i = 0; i < len; i++) {
                if (!selected[i]) bDice[bi++] = i;
            }

            List<Integer> sumA = new ArrayList<>();
            List<Integer> sumB = new ArrayList<>();

            makeSum(0, 0, aDice, dice, sumA);
            makeSum(0, 0, bDice, dice, sumB);

            Collections.sort(sumB);

            long win = 0;
            for (int a : sumA) {
                win += lowerBound(sumB, a);
            }

            if (win > maxWin) {
                maxWin = win;
                best = aDice;
            }
        }

        int[] answer = new int[best.length];
        for (int i = 0; i < best.length; i++) {
            answer[i] = best[i] + 1;
        }

        return answer;
    }

    private void makeComb(int start, int depth, int selCnt, int[] comb, List<int[]> result, int len) {
        if (depth == selCnt) {
            result.add(comb.clone());
            return;
        }

        for (int i = start; i < len; i++) {
            comb[depth] = i;
            makeComb(i + 1, depth + 1, selCnt, comb, result, len);
        }
    }

    private void makeSum(int depth, int sum, int[] selectedDice, int[][] dice, List<Integer> sums) {
        if (depth == selectedDice.length) {
            sums.add(sum);
            return;
        }

        int diceIdx = selectedDice[depth];
        for (int face = 0; face < 6; face++) {
            makeSum(depth + 1, sum + dice[diceIdx][face], selectedDice, dice, sums);
        }
    }

    private int lowerBound(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
