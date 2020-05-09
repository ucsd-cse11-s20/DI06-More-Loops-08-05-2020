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

abstract class ARegion implements Region {
    public String visualize(int xMin, int xMax, int yMin, int yMax) {
        // Complete this method
        String result = "";

        for (int y = yMin; y <= yMax; y += 1) {
            for (int x = xMin; x <= xMax; x += 1) {
                if (this.contains(new Point(x, y))) {
                    result += "##";
                }
                else {
                    result += "__";
                }
            }
            result += "\n";
        }

        return result;
    }
}

class CircRegion extends ARegion {
    Point center;
    int radius;

    CircRegion(Point center, int radius) {
	    this.center = center;
	    this.radius = radius;
    }

    public boolean contains(Point p) {
	    return this.center.distance(p) < this.radius;
    }
}

class Discussion06 {
    public static void main(String[] args) {
	    CircRegion c1 = new CircRegion(new Point(10, 10), 6);
        System.out.println(c1.visualize(0, 20, 0, 20));
    }
}
