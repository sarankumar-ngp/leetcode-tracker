// Last updated: 09/10/2026, 09:20:47
class Solution {
    public int fib(int n) {
        int a = 0 ;
        int b = 1 ;
        int c = 0 ;
        if(n==1) return 1;
        for(int i = 2 ; i<=n ;i++){
            c = a+ b ;
            a = b ;
            b = c ;
        }
        return c ;
        
    }
}