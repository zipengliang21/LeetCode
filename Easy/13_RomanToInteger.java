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