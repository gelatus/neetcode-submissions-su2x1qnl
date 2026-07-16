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
        List<Entry> values = map.get(key);
        if (values == null) {
            return "";
        }

        int left = 0;
        int right = values.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Entry pair = values.get(mid);
            if (pair.time <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (right >= 0) ? values.get(right).val : "";        
    }
}
