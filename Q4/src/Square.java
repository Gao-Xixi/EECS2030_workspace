import java.awt.geom.Point2D;

public class Square extends Rectangle {


    /**
     * constructor
     * if the lengths are not equal, throw an Exception
     * @param p1 is the left-bottom point
     * @param p2 is the left-top point
     * @param p3 is the right-top point
     * @param p4 is the right-bottom point
     */
    public Square(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3, Point2D.Double p4) {
        super(p1, p2, p3, p4);
        if(p2.getY()-p1.getY() != p3.getX() - p2.getX()){
            throw new IllegalArgumentException(" it is not a square!");
        }

    }
}
