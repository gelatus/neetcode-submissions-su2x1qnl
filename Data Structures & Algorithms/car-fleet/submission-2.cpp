class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        struct Car { int pos; double time; };
        size_t n = position.size();

        std::vector<Car> cars;
        cars.reserve(n);

        for (size_t i = 0; i < n; ++i) {
            double time = static_cast<double>(target - position[i])/speed[i];
            cars.push_back({position[i], time});
        }

        // Sort cars by starting position in descending order
        std::ranges::sort(cars, std::ranges::greater{}, &Car::pos);

        int fleets = 0;
        double curFleetTime = 0.0;

        for (const auto& car: cars) {
            if (car.time > curFleetTime) {
                fleets++;
                curFleetTime = car.time;
            }
        }

        return fleets;        
    }
};
