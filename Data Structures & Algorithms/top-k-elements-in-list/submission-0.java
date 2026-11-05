class Solution {
    // input - [1,2,2,3,3,3,8] k=2
    // output - [2,3]
    public int[] topKFrequent(int[] nums, int k) {
        int[] resp = new int[k];
        // number, N times (frecuency)
        Map<Integer, Integer> map = new HashMap<>();
        // loop through nums and store it in map
        // with the number of times that the number has been seen
        for (int num:nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        List<Integer>[] frequence = new List[nums.length + 1];
        for (int i = 0; i < frequence.length; i++) {
            frequence[i] = new ArrayList<>();
        }

        
        // 1 - 1
        // 2 - 2
        // 3 - 3
        // 8 - 1
        // build the frequence array from map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            frequence[value].add(key); 
        }

        // 0 - []
        // 1 - [1, 8]
        // 2 - [2]
        // 3 - [3]
        // 4 - []
        // 5 - []
        // 6 - []
        // loop the frequence until k is reached with the top k frequence
        int count = 0;
        for (int i = frequence.length - 1; i > 0 && k > count; i--) {
            for (int number : frequence[i]) {
                resp[count] = number;
                count++;

                if (count == k) {
                    return resp;
                }
            }
        }

        return resp;
    }
}
