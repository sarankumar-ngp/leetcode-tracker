// Last updated: 09/07/2026, 10:14:18
class Solution {
    public boolean isPalindrome(int x) {
        int a = 0 ;
        int b = 0 ;
        int original=x;
            while(x> 0 ){
                b = x % 10 ;
                a = a*10+b;
                x = x / 10 ; 
            }
            if (a == original ){
                return true ;
            }else{
                return false ;
            }
        
    }
}