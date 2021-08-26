package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link Quadruplets}<br/>
 *
 * @author dante<br />
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Dante Raphael Ricalde Delgado. (DRD)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Aug 25, 2021 (DRD) Creation class.</li>
 * </ul>
 * @version 1.0
 */
public class Quadruplets {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        final List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> prefixArray = Arrays.stream(Arrays.copyOf(array, array.length - 3)).boxed().collect(Collectors.toList());
        for (int j = 0; j < prefixArray.size(); j++) {
            List<Integer> newPreFixArray = new ArrayList<>();
            newPreFixArray.add(prefixArray.get(j));
            fourNumberSumRecursive(combinations, newPreFixArray, array, j + 1, array.length - 4 + 1, targetSum, 1);
        }
        return combinations.stream().map(l -> l.toArray(Integer[]::new)).collect(Collectors.toList());
    }

    private static void fourNumberSumRecursive(List<List<Integer>> combinations, List<Integer> prefixArray, int[] array, int positionToStart, int positionToEnd, int targetNum, int depth) {
        for (int i = positionToStart; i <= positionToEnd; i++) {
            List<Integer> newPreFixArray = new ArrayList<>();
            newPreFixArray.addAll(prefixArray);
            newPreFixArray.add(array[i]);
            if (newPreFixArray.size() == 4) {
                if (newPreFixArray.stream().mapToInt(e -> e).sum() == targetNum) {
                    combinations.add(newPreFixArray);
                }
            } else {
                positionToEnd = positionToEnd == array.length - 1 ? positionToEnd : positionToEnd + 1;
                fourNumberSumRecursive(combinations, newPreFixArray, array, ++positionToStart, positionToEnd, targetNum, ++depth);
            }
        }
    }

}