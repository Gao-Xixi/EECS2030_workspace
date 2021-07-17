import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class PolygonTest {

    @Test
    public void test(){
        Point2D.Double p1 = new Point2D.Double(0, 0);
        Point2D.Double p2 = new Point2D.Double(0, 1);
        Point2D.Double p3 = new Point2D.Double(0, 2);
        Polygon p = new Polygon();
        p.addPoint(p1);
        p.addPoint(p2);
        p.addPoint(p3);
        double a = p.area();

        assertEquals(1, a,0);
    }

}