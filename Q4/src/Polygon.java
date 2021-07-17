import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Polygon {
    /**
     * list of points composing polygon
     */
    private ArrayList<Point2D> points;
    public Polygon(){
        points = new ArrayList<>();
    }

    /**
     * add new points to Polygon
     * @param p
     */
    public void addPoint(Point2D p){
        points.add(p);
    }

    /**
     *
     * @return area of the polygon
     */
    public double area() {
        int sum = 0;
        for (int i = 0; i < points.size() ; i++)
        {
            sum += (points.get(i).getX() * points.get(i+1).getY() )
                    - (points.get(i+1).getX()* points.get(i).getY());
        }

        return Math.abs(sum / 2);
    }
}
