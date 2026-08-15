// Last updated: 15/08/2026, 21:17:04
1class Solution {
2    public int kthDigit(long k) {
3        if(k<=9){
4            return(int) k;
5        }
6        k -=9;
7        long digits = 2;
8        long count = 90;
9        while(k> digits * count){
10            k-=digits * count;
11            digits++;
12            count *= 10;
13        }
14        long startBlock = 1;
15        for(int i = 1;i<digits-1;i++){
16            startBlock *= 10;
17        }
18        long blockDigits = 10 * digits;
19        long blockOffset = (k-1)/blockDigits;
20        long posInBlock = (k-1) % blockDigits;
21
22        long currentBlock = startBlock + blockOffset;
23
24        long numIndex = posInBlock / digits;
25        long digitIndex = posInBlock % digits;
26
27        long targetNumber;
28        if(currentBlock % 2 == 0){
29            targetNumber = currentBlock * 10 + numIndex;
30        }else{
31            targetNumber = currentBlock * 10 +(9 - numIndex);
32        }
33        return Long.toString(targetNumber).charAt((int) digitIndex)
34 - '0';        
35    }
36}