class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        // unique solution
        List<String> list = new ArrayList<>();

        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        helper(result, list, s, 0);

        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int pos) {
        // when should we terminate the recursion

        // 1. When should we add list into result && 2. pruning
        if (list.size() == 4) {
            // pruning check
            if (pos != s.length()) {
                return;
            }

            StringBuffer sb = new StringBuffer();
            String ip = sb.append(list.get(0))
                    .append(".")
                    .append(list.get(1))
                    .append(".")
                    .append(list.get(2))
                    .append(".")
                    .append(list.get(3))
                    .toString();
            result.add(ip);
        }
        // recursion go to next level
        for (int i = pos; i < s.length() && i < pos + 3; i++) {
            String ipPartNum = s.substring(pos, i + 1); // 0 - 255, len at most is 3, pruning
            if (isValid(ipPartNum)) {
                list.add(ipPartNum);
                helper(result, list, s, i + 1);
                // backtracking
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String ipPartNum) {
        if (ipPartNum.charAt(0) == '0') {
            return ipPartNum.equals("0"); // 01 - false; 0 - true
        }
        int num = Integer.valueOf(ipPartNum);
        return num >= 0 && num <= 255;
    }
}