class TimeMap {
private:
    unordered_map<string, vector<pair<int, string>>> map;

public:
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        // Implementation for setting the value with the given key and timestamp
        map[key].push_back({timestamp, value});        
    }
    
    string get(string key, int timestamp) {
        // Implementation for getting the value with the given key and timestamp
        if (map.find(key) == map.end()) {
            return "";
        }

        const auto& values = map[key];
        int left = 0;
        int right = static_cast<int>(values.size()) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values[mid].first <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (right >= 0) ? values[right].second : "";        
    }
};
