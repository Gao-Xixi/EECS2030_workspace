public class Triangle extends SimplePolygon{
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) throws IllegalShapeArguments {
        super();
        if (!isValid(x1, y1, x2, y2, x3, y3)) {
            throw new IllegalShapeArguments();}
            addPoint(x1, y1);
            addPoint(x2, y2);
            addPoint(x3, y3);
            addPoint(x1, y1);


    }
    public static boolean isValid ( int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2) == 0 ? false : true;
    }

}
