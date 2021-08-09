public class Main
{
    public static void main(String[] args) throws IllegalShapeArguments {
        var si = Singleton.getInstance();
        Triangle t1 = new Triangle(0,0, 0,3, 4,0); //golden 3,4,5
        Rectangle t2 = new Rectangle(0,0, 5,10);
        Square t3 = new Square(0,0, 5);
        Rectangle t4 = new Rectangle(0,0, 20,1);

        si.shapeStoragePut(t1.getId(), t1);
        si.shapeStoragePut(t2.getId(), t2);
        si.shapeStoragePut(t3.getId(), t3);
        si.shapeStoragePut(t4.getId(), t4);

        si.setSortSchemaField(Singleton.SortSchema.SortField.AREA);
        for (SimpleShape p: si.shapeStorageSort())
            System.out.println(p);
        System.out.println("=================");
        si.setSortSchemaField(Singleton.SortSchema.SortField.PERIMETER);
        for (SimpleShape p: si.shapeStorageSort())
            System.out.println(p);
        System.out.println("=================");
        si.setSortSchemaField(Singleton.SortSchema.SortField.UUID);
        for (SimpleShape p: si.shapeStorageSort())
            System.out.println(p);

        /*
Triangle{, xpoints=[0, 0, 4, 0], ypoints=[0, 3, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=4,height=3], area=6.0, perimeter=12.0, uuid=4233d0e5-c7b3-4341-975a-4350d67d0856}
Rectangle{, xpoints=[0, 0, 20, 20, 0, 0, 0, 0], ypoints=[0, 1, 1, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=20,height=1], area=20.0, perimeter=42.0, uuid=cd6eaad1-07d2-4a4b-8500-a74af143c88b}
Square{, xpoints=[0, 0, 5, 5, 0, 0, 0, 0], ypoints=[0, 5, 5, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=5,height=5], area=25.0, perimeter=20.0, uuid=bb02689a-f839-47d2-8195-2d342679bdaf}
Rectangle{, xpoints=[0, 0, 5, 5, 0, 0, 0, 0], ypoints=[0, 10, 10, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=5,height=10], area=50.0, perimeter=30.0, uuid=f36919f9-951c-4122-8d6b-c7b0ce13a3cc}
=================
Triangle{, xpoints=[0, 0, 4, 0], ypoints=[0, 3, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=4,height=3], area=6.0, perimeter=12.0, uuid=4233d0e5-c7b3-4341-975a-4350d67d0856}
Square{, xpoints=[0, 0, 5, 5, 0, 0, 0, 0], ypoints=[0, 5, 5, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=5,height=5], area=25.0, perimeter=20.0, uuid=bb02689a-f839-47d2-8195-2d342679bdaf}
Rectangle{, xpoints=[0, 0, 5, 5, 0, 0, 0, 0], ypoints=[0, 10, 10, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=5,height=10], area=50.0, perimeter=30.0, uuid=f36919f9-951c-4122-8d6b-c7b0ce13a3cc}
Rectangle{, xpoints=[0, 0, 20, 20, 0, 0, 0, 0], ypoints=[0, 1, 1, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=20,height=1], area=20.0, perimeter=42.0, uuid=cd6eaad1-07d2-4a4b-8500-a74af143c88b}
=================
Square{, xpoints=[0, 0, 5, 5, 0, 0, 0, 0], ypoints=[0, 5, 5, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=5,height=5], area=25.0, perimeter=20.0, uuid=bb02689a-f839-47d2-8195-2d342679bdaf}
Rectangle{, xpoints=[0, 0, 20, 20, 0, 0, 0, 0], ypoints=[0, 1, 1, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=20,height=1], area=20.0, perimeter=42.0, uuid=cd6eaad1-07d2-4a4b-8500-a74af143c88b}
Rectangle{, xpoints=[0, 0, 5, 5, 0, 0, 0, 0], ypoints=[0, 10, 10, 0, 0, 0, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=5,height=10], area=50.0, perimeter=30.0, uuid=f36919f9-951c-4122-8d6b-c7b0ce13a3cc}
Triangle{, xpoints=[0, 0, 4, 0], ypoints=[0, 3, 0, 0], bounds=java.awt.Rectangle[x=0,y=0,width=4,height=3], area=6.0, perimeter=12.0, uuid=4233d0e5-c7b3-4341-975a-4350d67d0856}
         */
    }
}

