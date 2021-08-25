package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
        int digits = 1;
        List<List<Integer>> subLists = new ArrayList<>();

        while (digits <= 4) {
            for (int i = 0; i < array.length - 1; i++) {
                int positionToStart = i + digits;
                while (positionToStart <= array.length - 3 + (digits - 1)) {
                    final ArrayList<Integer> subList = new ArrayList<>();
                    IntStream.range(i, i + digits).forEach(ir -> subList.add(array[ir]));
                    subLists.add(subList);
                    for (int j = positionToStart; j <= positionToStart + 3 - digits; j++) {
                        subList.add(array[j]);
                    }
                    positionToStart++;
                }
            }
            digits++;
        }
        List<Integer[]> result = new ArrayList<>();

        for (List<Integer> subList : subLists) {
            if (subList.stream().mapToInt(e -> e).sum() == targetSum) {
                final Integer[] subListArray = subList.toArray(Integer[]::new);
                boolean found = false;
                for (Integer[] arrayInResult: result) {
                    if (Arrays.equals(arrayInResult, subListArray)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result.add(subListArray);
                }
            }
        }
        return result;
    }

}