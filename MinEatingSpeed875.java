class Solution {
    
    private static boolean canEat(int piles[],int hour,int speed){
        int totalHours =0;
        for(int pile : piles){
            totalHours += pile / speed;
            if(pile % speed != 0){
                totalHours++;
            }
        }
        return totalHours <= hour;
    }
    public int minEatingSpeed(int[] piles, int H) {
        
        int high = Integer.MIN_VALUE;
        for(int pile : piles){
            high = Math.max(high,pile);
        }
       
        int low = 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            boolean flag = canEat(piles,H,mid);
            if(!flag){
                low = mid + 1;
            }
            else {
                high = mid - 1 ;
            }
        }
        return low;   
    }
}
