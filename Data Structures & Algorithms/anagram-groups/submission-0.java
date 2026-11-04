class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        // loop through each string in 'strs'
        for (String word : strs) {
            int[] alphabet = new int[26];

            for (Character character : word.toCharArray()) {
                // build a hashmap with array as key - strings as value
                int charPosition = character - 'a';
                if (alphabet[charPosition] == 0) {
                    alphabet[charPosition] = 1;
                } else {
                    alphabet[charPosition] = alphabet[charPosition] + 1;
                }
            }

            String key = Arrays.toString(alphabet);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>(List.of(word)));
            } else {
                List<String> mapValue = map.get(key);
                mapValue.add(word);
                map.put(key, mapValue);
            }
        }

        return new ArrayList<>(map.values());
    }
}
