// Last updated: 09/10/2026, 09:20:31
class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int currentFloor = 0 ;
        int totalTime = 0;
        for(int floor : requests){
            totalTime += Math.abs(floor - currentFloor);
            currentFloor = floor;
        }
        return totalTime;
    }
}