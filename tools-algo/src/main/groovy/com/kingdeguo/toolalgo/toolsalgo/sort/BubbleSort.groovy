package com.kingdeguo.toolalgo.toolsalgo.sort

/**
 * 冒泡排序
 */
class BubbleSort {

    /**
     * 冒泡排序
     * @param arr
     */
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
    }

}
