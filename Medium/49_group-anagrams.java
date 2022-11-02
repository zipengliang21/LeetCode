class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // sorting the str
            char[] charArrays = str.toCharArray();
            Arrays.sort(charArrays);
            String sortedStr = new String(charArrays);

            if (!map.containsKey(sortedStr)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            } else {
                List<String> list = map.get(sortedStr);
                list.add(str);
                map.put(sortedStr, list);
            }
        }

        map.forEach((k, v) -> {
            result.add(v);
        });

        return result;
    }
}