import java.awt.*;
import java.util.UUID;

public abstract class SimpleShape extends Polygon implements JordonCurve{
    private UUID uuid = UUID.randomUUID();

    public abstract double area();

    public abstract double perimeter();

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }
}
