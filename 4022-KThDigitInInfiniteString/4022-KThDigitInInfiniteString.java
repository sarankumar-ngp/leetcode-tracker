// Last updated: 09/10/2026, 09:20:26
class Solution {
    public int kthDigit(long k) {
        if(k<=9){
            return(int) k;
        }
        k -=9;
        long digits = 2;
        long count = 90;
        while(k> digits * count){
            k-=digits * count;
            digits++;
            count *= 10;
        }
        long startBlock = 1;
        for(int i = 1;i<digits-1;i++){
            startBlock *= 10;
        }
        long blockDigits = 10 * digits;
        long blockOffset = (k-1)/blockDigits;
        long posInBlock = (k-1) % blockDigits;

        long currentBlock = startBlock + blockOffset;

        long numIndex = posInBlock / digits;
        long digitIndex = posInBlock % digits;

        long targetNumber;
        if(currentBlock % 2 == 0){
            targetNumber = currentBlock * 10 + numIndex;
        }else{
            targetNumber = currentBlock * 10 +(9 - numIndex);
        }
        return Long.toString(targetNumber).charAt((int) digitIndex)
 - '0';        
    }
}