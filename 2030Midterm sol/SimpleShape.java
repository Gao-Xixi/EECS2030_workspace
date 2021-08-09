import java.awt.*;
import java.util.UUID;

public abstract class SimpleShape extends Polygon implements JordanCurve {
    private UUID id = UUID.randomUUID();

    public abstract double area();

    public abstract double perimeter();

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}
