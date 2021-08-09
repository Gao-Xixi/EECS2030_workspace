public class Rectangle extends SimplePolygon{
    public Rectangle(int x, int y, int w, int h) throws IllegalShapeArguments {
        super();
        if (w < 1 || h < 1) throw new IllegalShapeArguments();
        addPoint(x,y);
        addPoint(x,y+h);
        addPoint(x+w,y+h);
        addPoint(x+w,y);
        addPoint(x,y);

    }
}
