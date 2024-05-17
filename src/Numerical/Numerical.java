/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Numerical;

/**
 *
 * @author asus
 */
public class Numerical {
    public static double relu(double x){
        return Math.max(0, x);
    }
    
    public static void swap(double a, double b){
        a = a + b;
        b = a - b;
        a = a - b;
    }
//    8,1,4,0,9,6,5
    private static void partition(double[] array, int l, int r){
        if(l==r || r<l) return;
        if(l<0 || l>=array.length || r<0 || r>=array.length) return;
        double pivot = array[l];
        int first = l;
        int end = r;
        while(first<end){
            while(array[first] >= pivot && first<=end) first++;
            while(array[end] < pivot && first<=end) end--;
            if(first<end){
                double tmp = array[first];
                array[first] = array[end];
                array[end] = tmp; 
            }  
        }
        
        if(l!=end){
            array[l] = array[end];
            array[end] = pivot;            
        }
        
        partition(array, l, end-1);
        partition(array, end+1, r);
    }
    
    public static void sort(double[] array){
        partition(array, 0, array.length-1);
    }
    
    public static int argmax(double[][][] array){
        int pos=0;
        double max = array[0][0][0];
        for(int plane=0; plane<array.length; plane++){
            if(array[plane][0][0] > max){
                max = array[plane][0][0];
                pos = plane;
            }
        }
        return pos;
    }
    
    public static int argmax(int[] array){
        int pos=0;
        int max = array[0];
        for(int plane=0; plane<array.length; plane++){
            if(array[plane] > max){
                max = array[plane];
                pos = plane;
            }
        }
        return pos;
    }
    
    public static void main(String[] args) {;

    }
}
