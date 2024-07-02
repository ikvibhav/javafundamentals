import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numPoints);
        System.out.println("average length = " + avgLength);
        System.out.println("largest Side = " + largestSide);
        System.out.println("largest X = " + largestX);
    }

    public int getNumPoints (Shape s) {
        int numPoints = 0;
        for (Point p : s.getPoints()) {
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength (Shape s) {
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        return length / numPoints;
    }

    public double getLargestSide (Shape s){
        double largestDistance = 0.0;

        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if (currDist > largestDistance){
                largestDistance = currDist;
            }
            prevPt = currPt; 
        }

        return largestDistance;
    }

    public double getLargestX (Shape s){
        double largestX = s.getLastPoint().getX();
        for (Point currPt : s.getPoints()){
            double currPtX = (double)currPt.getX();
            if (currPtX > largestX){
                largestX = currPtX;
            }
        }
        return largestX;
    }
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner()
        pr.testPerimeter();
    }
}
