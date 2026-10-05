class Solution{
    public int minRotations(String s) {
        int totalRotations = 0;
        int currentPosition = 0; 

        for (int i = 0; i < s.length(); i++) {
            int targetPosition = s.charAt(i) - '0';

            int directDistance = Math.abs(currentPosition - targetPosition);

            int circularDistance = 10 - directDistance;

            totalRotations += Math.min(directDistance, circularDistance);

            currentPosition = targetPosition;
        }

        return totalRotations;
    }
}