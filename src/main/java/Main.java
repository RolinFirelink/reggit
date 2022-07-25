class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int all = 0;
        for (int i:distance) {
            all+=i;
        }
        if(destination<start){
            int temp = start;
            start = destination;
            destination = temp;
        }
        int ans = 0;
        for (int i = start; i < destination; i++) {
            ans+=distance[i];
        }
        return Math.min(ans,all-ans);
    }
}