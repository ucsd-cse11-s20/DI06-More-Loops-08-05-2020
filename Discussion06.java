import tester.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
	    this.x = x;
	    this.y = y;
    }

    double distance(Point p) {
    	return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
}

interface Region {
    boolean contains(Point p);
    String visualize(int xMin, int xMax, int yMin, int yMax);
}

abstract class ARegion {
    String visualize(int xMin, int xMax, int yMin, int yMax) {
        // Fill out the body of this method.
        return "";
    }
}

class CircRegion extends ARegion {
    Point center;
    int radius;

    CircRegion(Point center, int radius) {
	    this.center = center;
	    this.radius = radius;
    }

    boolean contains(Point p) {
	    return this.center.distance(p) < this.radius;
    }
}

class Discussion06 {
    public static void main(String[] args) {
	    CircRegion c1 = new CircRegion(new Point(10, 10), 6);
        System.out.println(c1.visualize(0, 20, 0, 20));
    }

    void testVisualize(Tester t) {
        String expected = "________________________________________\n" +
            "________________________________________\n" +
            "________________________________________\n" +
            "________________________________________\n" +
            "________________________________________\n" +
            "______________##############____________\n" +
            "____________##################__________\n" +
            "__________######################________\n" +
            "__________######################________\n" +
            "__________######################________\n" +
            "__________######################________\n" +
            "__________######################________\n" +
            "__________######################________\n" +
            "__________######################________\n" +
            "____________##################__________\n" +
            "______________##############____________\n" +
            "________________________________________\n" +
            "________________________________________\n" +
            "________________________________________\n" +
            "________________________________________\n";
        String actual = new CircRegion(new Point(10, 10), 6).visualize(0, 20, 0, 20);
        t.checkExpect(actual, expected);
    }
}
