package com.company.algorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortTest {

    void bubbleSort(List<Integer> pList) {

        for (int j = 0; j < pList.size(); j++) {
            for (int i = 0; i < pList.size() - j - 1; i++) {
                if (pList.get(i + 1) > pList.get(i)) {
                    Integer temp = pList.get(i);
                    pList.set(i, pList.get(i + 1));
                    pList.set(i + 1, temp);
                }
            }
        }

    }

    void selectSort(List<Integer> pList) {

        for (int j = 0; j < pList.size(); j++) {
            int index = j;
            for (int i = j+1; i < pList.size(); i++) {
                if (pList.get(i) < pList.get(index)) {
                    index = i;
                }
            }
            if (index != j) {
                Integer temp = pList.get(j);
                pList.set(j, pList.get(index));
                pList.set(index, temp);
            }
        }

    }
}
