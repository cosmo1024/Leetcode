public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0) return result;
        
        ArrayList<Integer> number = new ArrayList<Integer>();
        for(int i=0;i<num.length;++i)	number.add(num[i]);
        
        ArrayList<Integer> cur_permutation = new ArrayList<Integer>();
        
	get_permutation(number, cur_permutation, result);
        
        return result;
    }
    
    public void get_permutation(List<Integer> number, ArrayList<Integer> pre_permutation, ArrayList<ArrayList<Integer>> result){
    	if(number.size()==1){
    		pre_permutation.add(number.get(0));
    		result.add(pre_permutation);
    		return;
    	}
    	
    	
    	for(int i=0;i<number.size();++i){
    		Collections.swap(number, 0, i);
    		
    		ArrayList<Integer> cur_permutation = new ArrayList<Integer>(pre_permutation);
    		cur_permutation.add(number.get(0));
    		get_permutation(number.subList(1, number.size()), cur_permutation, result);
    		
    		Collections.swap(number, 0, i);
    		
    	}
    }
}
