import java.awt.geom.Point2D;
import java.util.Arrays;

public class SimplePolygon extends SimpleShape implements Comparable<SimplePolygon> {
    public SimplePolygon() {
        super();
    }


    @Override
    public double area() {
        double sum = 0;
        for (int i = 0; i < npoints - 1; ++i)
            sum += xpoints[i] * ypoints[i + 1] - xpoints[i + 1] * ypoints[i];
        return 0.5 * Math.abs(sum);
    }

    @Override
    public double perimeter() {
        double sum = 0;
        for (int i = 0; i < npoints; i++)
            sum += Point2D.distance(xpoints[i], ypoints[i], xpoints[(i + 1) % npoints], ypoints[(i + 1) % npoints]);
        return sum;
    }

    @Override
    public int compareTo(SimplePolygon o) {
        var si = Singleton.getInstance();
        if (si.getSortSchemaField() == Singleton.SortSchema.SortField.UUID) {
            return this.getId().compareTo(o.getId());
        }
        else if (Singleton.getInstance().getSortSchemaField() == Singleton.SortSchema.SortField.AREA) {
            return Double.valueOf(area()).compareTo(Double.valueOf(o.area()));
        }
        else{
            return Double.valueOf(perimeter()).compareTo(Double.valueOf(o.perimeter()));
        }

    }

    @Override
    public String toString() {
        return "SimplePolygon{" +
                "npoints=" + npoints +
                ", xpoints=" + Arrays.toString(xpoints) +
                ", ypoints=" + Arrays.toString(ypoints) +
                ", bounds=" + bounds +
                ", area=" + area() +
                ", perimeter=" + perimeter() +
                ", uuid=" + getId() +
                '}';
    }
}
