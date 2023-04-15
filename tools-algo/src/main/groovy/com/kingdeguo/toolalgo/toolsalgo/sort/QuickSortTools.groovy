package com.kingdeguo.toolalgo.toolsalgo.sort

/**
 * 快速排序
 */
class QuickSortTools {

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left
            int j = right
            int temp = arr[left]
            while (i < j) {
                while (i < j && arr[j] >= temp) {
                    j--
                }
                if (i < j) {
                    arr[i] = arr[j]
                    i++
                }
                while (i < j && arr[i] < temp) {
                    i++
                }
                if (i < j) {
                    arr[j] = arr[i]
                    j--
                }
            }
            arr[i] = temp
            quickSort(arr, left, i - 1)
            quickSort(arr, i + 1, right)
        }
    }

}
