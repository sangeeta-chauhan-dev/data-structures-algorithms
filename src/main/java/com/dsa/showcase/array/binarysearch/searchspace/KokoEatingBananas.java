package com.dsa.showcase.array.binarysearch.searchspace;
/*875. Koko Eating Bananas
        Solved
Medium
        Topics
premium lock icon
        Companies
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


Constraints:

        1 <= piles.length <= 104
piles.length <= h <= 109
        1 <= piles[i] <= 109*/
class KokoEatingBananas {
        public static void main(String[] args) {
            int[] piles = {3, 6, 7, 11};
            int h = 8;
            KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
            System.out.println(kokoEatingBananas.minEatingSpeed(piles, h));
        }
    //time complexity O(n log m) where n is the number of piles and m is the maximum number of bananas in a pile
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int ans=0;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(getHour(piles,mid)<=h){
                ans=mid;
                high = mid-1;
            }else{
               low = mid+1;
            }
        }
        return ans;
    }
    public int getMax(int[]piles){
        int max =0;
        for(int pile : piles){
            max = Math.max(max,pile);
        }
        return max;
    }
    public long  getHour(int []piles, int speed){
        long  h=0;
        for(int pile : piles){
          h += (pile + speed - 1) / speed;  // integer ceil
        }
        return h;
    }
}