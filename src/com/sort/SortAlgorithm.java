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
        while (l < r) {
            while (l<r && array[r] >= key) r--;
            array[l] = array[r];
            while (l<r && array[l] <= key) l++;
            array[r] = array[l];
        }
        array[l] = key;
        return l;
    }

    public static void main(String []args){
        int []array = {3,5,7,1,2,1,3};
        quickSort(array,0,array.length-1);
        for (int val: array) {
            System.out.println(val);
        }
    }

}
