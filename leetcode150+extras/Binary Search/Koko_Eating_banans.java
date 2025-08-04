class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int first = 1;
        int last = piles[piles.length - 1];

        while (first <= last) {
            int mid = (first + last) / 2;
            if (canFinishBananas(piles, mid, h)) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return first;
    }

    private boolean canFinishBananas(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / k);
        }
        return hours <= h;
    }
}
