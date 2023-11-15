public int countOfAirplanes(List<Interval> airplanes) {
    // sweep line
    List<Point> list = new ArrayList<>(airplanes.size9) * 2);
    for (Interval i: airplanes) {
        list.add(new Point(i.start, 1));        
        list.add(new Point(i.start, 0));
    }

    Collection.sort(list, (Point p1, Point p2) -> {
        if (p1.T = p2.T) {
            return p1.S - p2.S;
        }
        return p1.T - p2.T;
    });

    int cnt = 0;
    int ans = 0;

    for (Point p: list) {
        if (p.S == 1) cnt++;
        else cnt--;
        ans = Math.max(ans, cnt); 
    }

    return ans;
}