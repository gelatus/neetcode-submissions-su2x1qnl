class TimeMap {

    private record Entry(int time, String val) {}
    private Map<String, List<Entry>> map;    

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));        
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list = map.get(key);
        if (list == null) {
            return "";
        }

        String res = "";
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Entry pair = list.get(mid);
            if (pair.time <= timestamp) {
                res = pair.val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;        
    }
}
