class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        HashMap<Character, Integer> secondaryMap = new HashMap<>();
        for (Character c: t.toCharArray()) {
            if (secondaryMap.containsKey(c)) {
                secondaryMap.put(c, secondaryMap.get(c) + 1);
            } else {
                secondaryMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry:secondaryMap.entrySet()) {
            char k = entry.getKey();
            int v = entry.getValue();

            if (!map.containsKey(k)) return false;

            if (map.get(k) != v) return false;
        }

        return true;
    }
}
