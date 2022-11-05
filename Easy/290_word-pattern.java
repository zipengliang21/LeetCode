class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        // 0. split s to String array
        String[] words = s.split(" ");

        // 1. words.length == pattern.length() ?
        if (words.length != pattern.length()) {
            return false;
        }

        // 2. iterate
        for (int i = 0; i < words.length; i++) {
            // key exist in map
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!words[i].equals(map.get(key))) {
                    return false;
                }
            } else {
                // value also needs to be unique as well as key
                if (map.containsValue(words[i])) {
                    return false;
                }

                map.put(key, words[i]);
            }
        }

        return true;
    }
}