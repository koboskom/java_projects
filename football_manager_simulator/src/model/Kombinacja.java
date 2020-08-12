package model;

import java.util.ArrayList;
import java.util.List;

public class Kombinacja {
    private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    private static void helper_reverse(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            int temp = combination[0];
            combination[0] = combination[1];
            combination[1] = temp;
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper_reverse(combinations, data, start + 1, end, index + 1);
            helper_reverse(combinations, data, start + 1, end, index);
        }
    }

    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    public static List<int[]> generate_reverse(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper_reverse(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }
}

