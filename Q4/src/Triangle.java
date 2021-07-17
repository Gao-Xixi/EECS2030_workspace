import java.awt.geom.*;
public class Triangle extends Shape implements Comparable {
    private Point2D.Double p1, p2, p3;

    /**
     * constructor of triangle.
     * if three points are in one line, throw an Exception
     * a,b,c are Point2D.Double
     * @param a point1
     * @param b point2
     * @param c point3
     */
    public Triangle(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        if(a.getX() == b.getX() && b.getX() == c.getX()||a.getY() == b.getY() && b.getY() == c.getY()){
            throw new IllegalArgumentException("all three points for a triangle cannot be on the same line!");

        }
        else{
            this.p1 = a;
            this.p2 = b;
            this.p3 = c;
        }
    }

    /**
     * overriding the perimeter() method
     * using distance() method in Point2D
     * @return
     */
    @Override
    public double perimeter() {
        return p1.distance(p2) + p2.distance(p3) +p3.distance(p1);
    }

    /**
     * Array sorted by perimeter, ascending order
     * @param o other object
     * @return int
     */

    @Override
    public int compareTo(Object o) {
        Shape other = (Shape) o;
        if (this.perimeter() < ((Shape) o).perimeter()) {
            return -1;
        } else if (this.perimeter() > ((Shape) o).perimeter()) {
            return 1;
        } else {
            return 0;
        }

    }



}
