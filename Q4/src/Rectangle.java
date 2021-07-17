import java.awt.geom.Point2D;
/**
 * superclass of Square Class
 */
public class Rectangle extends Shape {
    /** import Point2D, p1,p2,p3,p4 type are double */
    private Point2D.Double p1, p2, p3, p4;

    /**
     * constructor
     * if it is not a rectangle, throw an Exception
     * @param p1 is the left-bottom point
     * @param p2 is the left-top point
     * @param p3 is the right-top point
     * @param p4 is the right-bottom point
     */
    public Rectangle(Point2D.Double p1,Point2D.Double p2, Point2D.Double p3,Point2D.Double p4){
        if(p1.getX() != p2.getX()|| p3.getX() != p4.getX()
                || p2.getY() != p3.getY() || p1.getY() != p4.getY()){
            throw new IllegalArgumentException(" not a rectangle!");
        }
        else{
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        }
    }
    public double area(){
        return (p2.getY() - p1.getY()) * (p3.getX() - p2.getX());
    }
    /**
     * overriding the method
     * @return perimeter
     */

    @Override
        public double perimeter() {
            return 2 * (p2.getY() - p1.getY() + p3.getX() - p2.getX());
    }

    /**
     * Array sorted by area, ascending order
     * @param o other object
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        Rectangle other = (Rectangle) o;
        if (this.area() < other.area() ){
            return -1;
        }
        else if (this.area() < other.area()) {
            return 1;
        } else {
            return 0;
        }
    }
}
