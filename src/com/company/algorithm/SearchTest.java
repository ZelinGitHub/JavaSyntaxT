package com.company.algorithm;

import java.util.List;

public class SearchTest {
    public static int binSearch(
            List<Integer> pList
            , Integer target
    ) {
        int leftIndex = 0;
        int rightIndex = pList.size() - 1;
        while (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (target.equals(pList.get(mid))) {
                return mid;
            } else if (target < pList.get(mid)) {
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
        return -1;
    }
}
