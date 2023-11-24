package WorldSpace;

import Objects.LineSegment;

public class World {
    
    LineSegment[] lines;

    public World(LineSegment[] lines){
        this.lines = lines;
    }

    public LineSegment[] getLines() {
        return lines;
    }
}
