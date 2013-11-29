/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        //To deal with the situation when any of the array is null
        if(n==0) return;
        else if(m==0){
            for(int i=0;i<n;++i) A[i]=B[i];
            return;
        }
        
        int index_a = m-1;
        int index_b = n-1;
        int index_merged = m+n-1;
        
        // the while condition should be index_b>=0 instead of (index_a>=0 && index_b>=0)
        while(index_b >= 0){
            if(index_a < 0){
                A[index_merged] = B[index_b];
                --index_b;
            }
            else if(A[index_a] > B[index_b]){
                A[index_merged] = A[index_a];
                --index_a;
            }
            else{
                A[index_merged] = B[index_b];
                --index_b;
            }
            --index_merged;
        }
    }
}