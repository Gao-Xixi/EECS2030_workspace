import org.junit.Assert;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class TestShape {

    @Test
    public void testTriangle01() {
        Point2D.Double p1 = new Point2D.Double(0, 0);
        Point2D.Double p2 = new Point2D.Double(0, 1);
        Point2D.Double p3 = new Point2D.Double(0, 2);
        boolean thrown = false;

        try {
            Triangle t = new Triangle(p1, p2, p3);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testTriangle02() {
        Point2D.Double p1 = new Point2D.Double(0, 0);
        Point2D.Double p2 = new Point2D.Double(0, 1);
        Point2D.Double p3 = new Point2D.Double(1, 0);

        Triangle t = new Triangle(p1, p2, p3);
        double p = t.perimeter();
        String pp = String.format("%.2f", p);
        assertEquals("3.41", pp);
    }

    @Test
    public void testRectangle01() {
        Point2D.Double p1 = new Point2D.Double(0, 0);
        Point2D.Double p2 = new Point2D.Double(0, 1);
        Point2D.Double p3 = new Point2D.Double(2, 1);
        Point2D.Double p4 = new Point2D.Double(2, -1);
        boolean thrown = false;

        try {
            Rectangle t = new Rectangle(p1, p2, p3, p4);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testRectangle02() {
        Point2D.Double p1 = new Point2D.Double(0, 0);
        Point2D.Double p2 = new Point2D.Double(0, 1);
        Point2D.Double p3 = new Point2D.Double(2, 1);
        Point2D.Double p4 = new Point2D.Double(2, 0);

        Rectangle t = new Rectangle(p1, p2, p3, p4);
        double p = t.perimeter();

        assertEquals(6.0, p, 0);
    }
    @Test
    public void testSquare01() {
        Point2D.Double p1 = new Point2D.Double(0, 0);
        Point2D.Double p2 = new Point2D.Double(0, 1);
        Point2D.Double p3 = new Point2D.Double(2, 1);
        Point2D.Double p4 = new Point2D.Double(2, 0);
        boolean thrown = false;

        try {
            Square s = new Square(p1, p2, p3, p4);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testSquare02() {
        Point2D.Double p1 = new Point2D.Double(0, 0);
        Point2D.Double p2 = new Point2D.Double(0, 1);
        Point2D.Double p3 = new Point2D.Double(1, 1);
        Point2D.Double p4 = new Point2D.Double(1, 0);
        Square t = new Square(p1, p2, p3, p4);
        double p = t.perimeter();

        assertEquals(4.0, p, 0);
    }
}