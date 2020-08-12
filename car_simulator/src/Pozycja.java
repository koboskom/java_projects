import static java.lang.Math.sqrt;
import static java.lang.Math.abs;

public class Pozycja {

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double dist() {
        return (sqrt((dx - x) * (dx - x) + (dy - y) * (dy - y)));

    }

    public void jedzdo(double v, double t) {
        double deltax = v * t * (dx - x) / dist();
        double deltay = v * t * (dy - y) / dist();
        if (abs(dx - x) < deltax) {
            x = x + abs(dx - x);
        } else
            x = x + deltax;
        if (abs(dy - y) < deltay) {
            y = y + abs(dy - y);
        } else
            y = y + deltay;

    }

    private double x;
    private double y;
    private double dx;
    private double dy;
}