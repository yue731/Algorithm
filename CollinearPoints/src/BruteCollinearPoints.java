import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private List<LineSegment> segmentsList; // list of LineSegment


    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points

        if (points == null) throw new IllegalArgumentException("Input points is null");
        checkNullPoint(points);

        // clone the points to avoid direct modification
        Point[] pointsCopy = points.clone();
        Arrays.sort(pointsCopy);
        checkDuplicatedPoint(pointsCopy);


        this.segmentsList = new ArrayList<>();

        for (int i = 0; i < pointsCopy.length - 3; i++) {
            Point p = pointsCopy[i];
            for (int j = i + 1; j < pointsCopy.length - 2; j++) {
                Point q = pointsCopy[j];
                for (int k = j + 1; k < pointsCopy.length - 1; k++) {
                    Point r = pointsCopy[k];
                    for (int l = k + 1; l < pointsCopy.length; l++) {
                        Point s = pointsCopy[l];
                        if (collinear(p, q, r, s)) {
                            segmentsList.add(new LineSegment(p, s));
                        }
                    }
                }
            }
        }

    }

    public int numberOfSegments() {
        // the number of line segments
        return segmentsList.size();
    }

    public LineSegment[] segments() {
        // the line segments
        LineSegment[] res = new LineSegment[numberOfSegments()];
        for (int i = 0; i < res.length; i++) {
            res[i] = segmentsList.get(i);
        }
        return res;
    }

    /*
    throw IllegalArgumentException if any point in points is null
     */
    private void checkNullPoint(Point[] points) {
        for (Point point : points) {
            if (point == null) throw new IllegalArgumentException("Point in points is null");
        }
    }

    /*
    check if any points in Point[] points are duplicated by comparing neighbor points
    given the points array is already sorted
     */
    private void checkDuplicatedPoint(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) throw new IllegalArgumentException("Duplicated points");
        }
    }

    /*
    return true if the given 4 points are collinear
     */
    private boolean collinear(Point p, Point q, Point r, Point s) {
        double slope1 = p.slopeTo(q);
        double slope2 = q.slopeTo(r);
        double slope3 = r.slopeTo(s);
        if (Double.compare(slope1, slope2) == 0.0 && Double.compare(slope2, slope3) == 0.0) return true;
        return false;
    }
}
