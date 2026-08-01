// Last updated: 01/08/2026, 20:40:36
1
2class Solution{
3    public long minInitialStrength(int[] monsters, int[][] boosts){
4        int n = monsters.length;
5        long[] diff = new long[n+1];
6        for(int[] b : boosts){
7            int l = b[0];
8            int r = b[1];
9            int val = b[2];
10
11            diff[l] += val;
12            if(r+1 < diff.length){
13                diff[r+1] -= val;
14            }
15        }
16        long[] bonus = new long[n];
17        long cur = 0 ;
18        for(int i = 0 ; i<n;i++){
19            cur += diff[i];
20            bonus[i] = cur;
21        }
22        long low = 0 ;
23        long high = 0 ;
24        for(int x : monsters){
25            high += x;
26        }
27        while(low < high){
28            long mid = low + (high - low) / 2;
29            if(canDefeat(mid,monsters,bonus)){
30                high = mid;
31            }else{
32                low = mid + 1;
33            }
34        }return low;
35    }private boolean canDefeat(long strength, int[] monsters, long[] bonus){
36        long curr = strength;
37        for(int i = 0 ; i<monsters.length;i++){
38            if(curr + bonus[i] < monsters[i]){
39                return false;
40            }
41            curr -= monsters[i];
42            if(curr<0){
43                curr = 0 ;
44            }
45        }
46        return true;
47    }
48}