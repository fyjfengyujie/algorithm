package com.sort;

public class SortAlgorithm {

    public static void quickSort(int [] array,int l,int r){
        if(array == null || array.length<=0){
            return;
        }
        if(l<r){
            int mid = getKey(array,l,r);
            quickSort(array,l,mid-1);
            quickSort(array,mid+1,r);
        }

    }

    public static int getKey(int []array,int l,int r){
        int key = array[l];
        int p = l;
        while (l < r) {
            while (l<r && array[l] <= key) l++;
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            while (l<r && array[r] >= key) r--;
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
        int temp = array[p];
        array[p] = array[l-1];
        array[l-1] = temp;
        return l-1;
    }

    public static void main(String []args){
        int []array = {3,5,7,1,2,1,3};
        quickSort(array,0,array.length-1);
        for (int val: array) {
            System.out.println(val);
        }
    }

}
