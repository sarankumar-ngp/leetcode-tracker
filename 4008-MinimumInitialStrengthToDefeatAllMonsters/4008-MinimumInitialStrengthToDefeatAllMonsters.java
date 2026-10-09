// Last updated: 09/10/2026, 09:20:28

class Solution{
    public long minInitialStrength(int[] monsters, int[][] boosts){
        int n = monsters.length;
        long[] diff = new long[n+1];
        for(int[] b : boosts){
            int l = b[0];
            int r = b[1];
            int val = b[2];

            diff[l] += val;
            if(r+1 < diff.length){
                diff[r+1] -= val;
            }
        }
        long[] bonus = new long[n];
        long cur = 0 ;
        for(int i = 0 ; i<n;i++){
            cur += diff[i];
            bonus[i] = cur;
        }
        long low = 0 ;
        long high = 0 ;
        for(int x : monsters){
            high += x;
        }
        while(low < high){
            long mid = low + (high - low) / 2;
            if(canDefeat(mid,monsters,bonus)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }return low;
    }private boolean canDefeat(long strength, int[] monsters, long[] bonus){
        long curr = strength;
        for(int i = 0 ; i<monsters.length;i++){
            if(curr + bonus[i] < monsters[i]){
                return false;
            }
            curr -= monsters[i];
            if(curr<0){
                curr = 0 ;
            }
        }
        return true;
    }
}