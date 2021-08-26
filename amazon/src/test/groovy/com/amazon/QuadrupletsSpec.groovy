package com.amazon

import spock.lang.Specification


/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link QuadrupletsSpec}<br/>
 *
 * @author dante<br/>
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Dante Raphael Ricalde Delgado. (DRD)</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>Aug 25, 2021 (DRD) Creation class.</li>
 *         </ul>
 * @version 1.0
 */
class QuadrupletsSpec extends Specification {

    def '''testing quadruplets'''() {
        when:
        def fourNumberSum = Quadruplets.fourNumberSum(array as int[], targetSum)
        then:
        fourNumberSum.size() == fourNumberSumExpected.size()
        int originalSize = fourNumberSum.size()
        for (int i = 0; i < originalSize; i++) {
            for (int j = 0; j < originalSize; j++) {
                if (Arrays.equals(fourNumberSum[i] as int[], fourNumberSumExpected[j] as int[])) {
                    fourNumberSumExpected.remove(fourNumberSumExpected[j])
                }
            }
        }
        fourNumberSumExpected.size() == 0
        where:
        array                                          | targetSum || fourNumberSumExpected
        [7, 6, 4, -1, 1, 2]                            | 16        || [[7, 6, 4, -1], [7, 6, 1, 2]]
        [1, 2, 3, 4, 5, 6, 7]                          | 10        || [[1, 2, 3, 4]]
        [5, -5, -2, 2, 3, -3]                          | 0         || [[5, -5, -2, 2], [5, -5, 3, -3], [-2, 2, 3, -3]]
        [-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9]            | 4         || [[-2, -1, 1, 6], [-2, 1, 2, 3], [-2, -1, 2, 5], [-2, -1, 3, 4]]
        [-1, 22, 18, 4, 7, 11, 2, -5, -3]              | 30        || [[-1, 22, 7, 2], [22, 4, 7, -3], [-1, 18, 11, 2], [18, 4, 11, -3], [22, 11, 2, -5]]
        [-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5] | 20        || [[-5, 2, 15, 8], [-3, 2, -7, 28], [-10, -3, 28, 5], [-10, 28, -6, 8], [-7, 28, -6, 5], [-5, 2, 12, 11], [-5, 12, 8, 5]]
        [1, 2, 3, 4, 5]                                | 100       || []
        [1, 2, 3, 4, 5, -5, 6, -6]                     | 5         || [[2, 3, 5, -5], [1, 4, 5, -5], [2, 4, 5, -6], [1, 3, -5, 6], [2, 3, 6, -6], [1, 4, 6, -6]]
    }

}