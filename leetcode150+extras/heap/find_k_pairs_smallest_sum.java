class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>>ansList=new ArrayList<>();
        for(int i=0;i<Integer.min(k,nums1.length);i++){
            queue.offer(new int[]{nums1[i]+nums2[0],i,0});
        }

        while(k!=0 && !queue.isEmpty()){
            int []a=queue.poll();
            int sum=a[0];
            int i=a[1];
            int j=a[2];
            ansList.add(Arrays.asList(nums1[i],nums2[j]));
            if(j+1<nums2.length){
                queue.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
            k--;
        }

        return ansList;
    }
}