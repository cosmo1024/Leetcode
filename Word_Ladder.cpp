//Hint: a. the use of buffer_q; b. the use of dict.erase(); c.http://blog.csdn.net/zxzxy1988/article/details/8591890
// 这种方法可以推广到分层打印BST

/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

class Solution {
public:
    int ladderLength(string start, string end, unordered_set<string> &dict);
};

int Solution::ladderLength(string start, string end, unordered_set<string> &dict){
    if(start.length()==0 && end.length()==0 || start == end) return 1;
    else if(dict.size() == 0 && start!=end) return 0;
    else if(start.length() != end.length()) return 0;
    
    queue<string> my_q, buffer_q;
    int distance = 1; //!!! 
    my_q.push(start);
    int word_len = start.length();
    
    while(!my_q.empty() && dict.size()>0){
        while(!my_q.empty()){
            string str = my_q.front();
            my_q.pop();
        

            for(int i=0;i<word_len;++i){
                for(char j='a';j<='z';++j){
                    if(j==str[i]) continue;
                    
                    char tmp = str[i];
                    str[i]=j;
                    if(str == end) return distance+1;
                    else if(dict.count(str)>0){
                        buffer_q.push(str);
                        dict.erase(str); //delete corresponding element in dict in case of loop
                    }                    
                    str[i] = tmp;                    
                }
            }            
        }
        distance++;
        swap(my_q, buffer_q); //!!! how to use swap  
    }
    
    return 0;//we do not find dest word 
}