public class Solution {
public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(str.length()==0) return 0;
        
        int sign = 1;
        boolean if_sign = false;
        boolean if_num  = false;  	
    	int result = 0;
    	
    	for(int i=0;i<str.length();++i){
    		if(!if_num && str.charAt(i)==' ') continue;
    		else if(!if_num && (str.charAt(i) == '+' || str.charAt(i) == '-')){
    			if(!if_sign){
    				sign = str.charAt(i) == '-'? -1 : 1;
    				if_sign = true;
    				if_num = true;		
    			}
    			else return 0;
    		}
    		else if (str.charAt(i) > '9' || str.charAt(i) < '0'){
    			if(!if_num) return 0;
    			else{
    				break; //end of the valid number    				
    			}
    		}
    		else{
    			if_num = true;
    			if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10 < (str.charAt(i)-'0') ){
    				return sign==-1? Integer.MIN_VALUE:Integer.MAX_VALUE;
    			}
    			else result = result*10 + str.charAt(i)-'0';
    		}   			
    	}
    	
    	return sign*result;
    } 
}