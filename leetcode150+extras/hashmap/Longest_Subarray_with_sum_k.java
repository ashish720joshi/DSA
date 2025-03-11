   // code here
        Map<Integer, Integer>presum = new HashMap<>();
        int n = arr.length;
        int maxlen = 0;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += arr[i];
            if(sum == k){
                maxlen = Math.max(maxlen, i+1);
            }
        
            int rem = sum -k;
            if(presum.containsKey(rem)){
               int len = i-presum.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            if(!presum.containsKey(sum)){
                presum.put(sum,i);
            }
        }
        return maxlen;
    }