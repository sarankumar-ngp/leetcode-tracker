// Last updated: 09/07/2026, 10:13:45
class Solution {
    public int addDigits(int num) {
        while(num>=10){
            int sum = 0 ;

            while(num>0){
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}