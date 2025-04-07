import java.util.Objects;

public class Vector {

    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double scalarProduct(Vector vector) throws IllegalArgumentException {
        Objects.requireNonNull(vector, "Polnaya JOPA");
        return x * vector.getX() + y * vector.getY() + z * vector.getZ();
    }

    public Vector crossProduct(Vector vector) throws IllegalArgumentException {
        Objects.requireNonNull(vector, "Polnaya JOPA");
        return new Vector(y * vector.getZ() - z * vector.getY(),
                    z * vector.getX() - x * vector.getZ(),
                    x * vector.getY() - y * vector.getX());
    }

    public double getCosBetween(Vector vector) throws IllegalArgumentException {
        Objects.requireNonNull(vector, "Polnaya JOPA");
        if(length() == 0 || vector.length() == 0){
            throw new ArithmeticException("Polnaya JOPA, no ti eshe i dolbaeb)))");
        }

        return scalarProduct(vector) / (length() * vector.length());
    }

    public Vector plus(Vector vector) throws IllegalArgumentException {
        Objects.requireNonNull(vector, "Polnaya JOPA");
        return new Vector(x + vector.getX(), y + vector.getY(), z + vector.getZ());
    }

    public Vector minus(Vector vector) throws IllegalArgumentException {
        Objects.requireNonNull(vector, "Polnaya JOPA");
        return new Vector(x - vector.getX(), y - vector.getY(), z - vector.getZ());
    }

    public static Vector[] generate(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(
                    Math.random() * 200 - 100,
                    Math.random() * 200 - 100,
                    Math.random() * 200 - 100
            );
        }
        return vectors;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
