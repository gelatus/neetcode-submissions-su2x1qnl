class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count frequencies and build a frequency map
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int num: nums) {
            Integer count = freqMap.putIfAbsent(num,1);
            if (count != null) {
                freqMap.put(num, ++count);
            } else {
                count = 1;
            }
        }

        // Add frequencies to a priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer,Integer> entry: freqMap.entrySet()) {
            pq.add(entry);
        }

        // Get the k largest elements from the queue
        int[] result = new int[k];
        for (int i=0; i<k; ++i) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}
