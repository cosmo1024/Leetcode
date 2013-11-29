/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

class Solution {
public:
    vector<int> getRow(int rowIndex);
};

vector<int> Solution::getRow(int rowIndex){
	vector<int> result(rowIndex+1,1);
	if(rowIndex==0 || rowIndex == 1) return result;
	
	for(int i=2;i<=rowIndex;i++){
		for(int j=i-1;j>0;j--){
			result[j]=result[j-1]+result[j];
		}
	}	
	return result;	
}