/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int index_left = 0;
        int index_right = numbers.length-1;
        
        int[] original_numbers;
        original_numbers =  new int[numbers.length];

        for(int i=0;i<numbers.length;++i){
            original_numbers[i] = numbers[i];
        }
        
        int[] result = {index_left, index_right};
        
        Arrays.sort(numbers);
        
        while(numbers[index_left]+numbers[index_right]!=target){
            int tmp = numbers[index_left]+numbers[index_right];
            if(tmp < target) index_left++;
            else index_right--;
        }
        
        int first_index = 0;
        int second_index = 0;
        
        for(int i=0;i<original_numbers.length;++i){
            if(original_numbers[i]==numbers[index_left]){
                first_index = i;
                break;
            }
        }
        
        for(int i=0;i<original_numbers.length;++i){
            if(numbers[index_left]==numbers[index_right]&&i==first_index) continue;
            if(original_numbers[i]==numbers[index_right]){
                second_index = i;
                break;
            }
        }
        
        result[0]=Math.min(first_index, second_index)+1;
        result[1]=Math.max(first_index, second_index)+1;
        
        return result;
    }
}