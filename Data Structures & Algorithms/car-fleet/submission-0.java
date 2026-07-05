class Solution {
    private static record Car(int position, double timeToTarget) {};

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        // Populate the (position,timeToTarget) records
        for (int i=0; i<n; i++) {
            double timeToTarget = (double)(target -position[i])/speed[i];
            cars[i] = new Car(position[i], timeToTarget);
        }

        // Sort cars by position in descending order, i.e., 
        // the ones closerto the target first
        Arrays.sort(cars, Comparator.comparingInt(Car::position).reversed());

        // Now check how many fleets by starting with the first car in the list
        int fleets = 0;
        double prevTime = 0;
        for (Car car: cars) {
            if (car.timeToTarget() > prevTime) {
                // This car doesn't catch up to the previous one
                // so it forms its own fleet
                fleets++;
                prevTime = car.timeToTarget();
            }
        }

        return fleets;
    }
}
