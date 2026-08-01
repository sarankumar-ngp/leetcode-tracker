// Last updated: 01/08/2026, 20:21:49
1class Solution {
2    public int countValidPrefixes(String s) {
3        int zero = 0 , one  = 0 ;
4        int ans = 0 ;
5
6        for(int i = 0 ;i<s.length();i++){
7            if(s.charAt(i) == '0'){
8                zero++;
9            }else{
10                one++;
11            }
12            if(Math.abs(zero - one) <= 1){
13                ans++;
14            }
15        }
16        return ans;
17        
18    }
19}