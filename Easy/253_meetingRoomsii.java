class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval: intervals) {
            list.add(new int[] {interval[0], 1});
            list.add(new int[] {interval[1], -1});
        }

        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int count = 0;
        int result = 0;
        for (int[] point: list) {
            count += point[1];
            result = Math.max(count, result);
        }

        return result;
    }
}