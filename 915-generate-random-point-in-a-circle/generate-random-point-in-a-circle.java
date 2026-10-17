import java.util.Random;

class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }

    public double[] randPoint() {
        double len = Math.sqrt(random.nextDouble()) * radius;
        double deg = random.nextDouble() * 2 * Math.PI;
        
        double x = x_center + len * Math.cos(deg);
        double y = y_center + len * Math.sin(deg);
        
        return new double[]{x, y};
    }
}

