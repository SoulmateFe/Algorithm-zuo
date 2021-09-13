package com.fe.class01;

import java.util.Arrays;

/**
 * @Description 选择排序
 * 下标0 ~ 下标n-1  找到最小值，在哪，放到0 位置上
 * 下标1 ~ 下标n-1  找到最小值，在哪，放到1 位置上
 * 下标2 ~ 下标n-1  找到最小值，在哪，放到2 位置上
 * 下标i ~ 下标n-1  找到最小值，在哪，放到i 位置上
 * 下标n-2 ~ 下标n-1 找到最小值，在哪，放到n-1 位置上
 * 每次循环找到一个最小值放到当前循环的第一个位置；共需要循环n-1次
 * 内层循环负责找到 下标i~下标n-1 中的最小值的下标
 *     minIndex等于第一个下标，从下标i+1开始，逐次和第一个下标对应的值比较
 * @Author sosuke :-)
 * @Date 2021/9/14 06:16
 */
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr) {
        if (null == arr || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int testTime = 500000; // 测试次数
        int maxSize = 100; // 数组数据个数
        int maxValue = 100; // 数组中最大值
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            selectionSort(arr1);
            Arrays.sort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                succeed = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * (N+1))  [0, N]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }


}
