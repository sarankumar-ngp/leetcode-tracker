// Last updated: 09/07/2026, 10:14:10
class Solution {
    public int climbStairs(int n) {
        int a = 0; int b = 1;
        int c = 0;
        for(int i = 1;i<=n;i++){
            c = a+ b ;
            a = b ; 
            b = c ;
        }
        return c ;
        
    }
}