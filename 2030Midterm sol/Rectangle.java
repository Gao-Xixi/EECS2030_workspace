/**
 * Rectangle is a special SimplePolygon with only four vertices
 */
public class Rectangle extends SimplePolygon {

    /**
     * Constructs a Rectangle using top-left corner coordinate and given none-zero positive width and height
     * @param x coordinate of the origin of the rectangle (top-left corner)
     * @param y coordinate of the origin of the rectangle (top-left corner)
     * @param w width of the Rectangle (non-zero)
     * @param h height of the Rectangle (non-zero)
     * @throws IllegalShapeArguments when width or height are zero or negative numbers
     */
    public Rectangle(int x, int y, int w, int h) throws IllegalShapeArguments
    {
        super();
        if (w < 1 || h < 1) throw new IllegalShapeArguments("Width and height should be greater than zero!");
        addPoint(x,y);
        addPoint(x,y+h);
        addPoint(x+w,y+h);
        addPoint(x+w,y);
        addPoint(x,y);
    }
}
