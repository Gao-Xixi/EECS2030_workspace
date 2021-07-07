package composition;

public class Line {
	private Point start;
	private Point end;
	public Line(Point start, Point end) {
		this.start = new Point(start);
		this.end = new Point(end);
	}
	public Point getStart() {
		return new Point(start);
	}
	public void setStart(Point start) {
		this.start = new Point(start);
	}
	public Point getEnd() {
		return new Point(end);
	}
	public void setEnd(Point end) {
		this.end = new Point(end);
	}
	
	public Line(Line other) {
		this(other.getStart(),other.getEnd());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {return true;}
		if(obj == null || this.getClass() != obj.getClass()){return false;}
		Line other = (Line) obj;
		return this.start.equals(other.start) && this.end.equals(other.end);
	}
}
