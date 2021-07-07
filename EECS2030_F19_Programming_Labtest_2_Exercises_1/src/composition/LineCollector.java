package composition;

import java.util.ArrayList;



public class LineCollector {
	private ArrayList<Line> lines;
	
	public LineCollector() {
		lines = new ArrayList<>();
	}
	public LineCollector(LineCollector other) {
		lines = new ArrayList<>();
		for(int i = 0; i < other.lines.size(); i++) {
			lines.add(new Line(other.getLineAt(i)));
		}
//		Iterator<Line> it = other.lines.iterator();
//  
//        while (it.hasNext())
		//cast error!
//            this.lines.add((it);
   
		
		
	}
	
	public void addLine(Line l){
		lines.add(new Line(l));
	}
	public Line getLineAt( int index) {
		return lines.get(index);
	}
	public Line[] getLines(){
		Line[] result = new Line[lines.size()];
		for(int i = 0; i < lines.size(); i++) {
			result[i] = lines.get(i);
		}
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {return true;}
		if(obj == null || this.getClass() != obj.getClass()){return false;}
		LineCollector other = (LineCollector) obj;
		boolean b = true;
		for(int i = 0; i < lines.size(); i++) {
			b = b && this.lines.get(i).equals(other.lines.get(i));
		}
		return this.lines.size() == other.lines.size() && b;
				
	}

}
