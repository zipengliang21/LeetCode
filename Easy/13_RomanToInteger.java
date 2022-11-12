class Solution {
    public int romanToInt(String s) {
        // key: Roman numeral, value: integer
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i < s.length() - 1 && map.get(ch) < map.get(s.charAt(i + 1))) {
                result -= map.get(ch);
            } else {
                result += map.get(ch);
            }
        }

        return result;
    }

}

public int romanToInt(String s) {
    int[] map = new int[26];
    map['I' - 'A'] = 1;
    map['V' - 'A'] = 5;
    map['X' - 'A'] = 10;
    map['L' - 'A'] = 50;
    map['C' - 'A'] = 100;
    map['D' - 'A'] = 500;
    map['M' - 'A'] = 1000;

    int result = 0;
    int preValue = 1000;

    char[] arr = s.toCharArray(); 

    for(int i=0; i < arr.length; i++) {
        int currentValue = map[arr[i] - 'A'];
        if(preValue < currentValue) {
            result += currentValue - 2 * preValue;
        } else {
            result += currentValue;
        }
        preValue = currentValue;
    }
    return result;
}