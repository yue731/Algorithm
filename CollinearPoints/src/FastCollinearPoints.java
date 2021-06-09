import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private List<LineSegment> segmentsList;

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("Input points is null");
        checkNullPoint(points);
        Point[] pointsCopy = points.clone();
        Arrays.sort(pointsCopy);
        checkDuplicatedPoint(pointsCopy);

        this.segmentsList = new ArrayList<>();

        Point[] others = pointsCopy.clone();
        for (int i = 0; i < pointsCopy.length - 3; i++) {
            Point p = pointsCopy[i];

            Arrays.sort(others, p.slopeOrder());
            double slope = p.slopeTo(others[1]);
            int start = 1;

            for (int j = 2; j < others.length; j++) {
                if (Double.compare(slope, p.slopeTo(others[j])) != 0) {
                    if (j - start + 1 >= 4) {
                        Point[] pair = generateSegment(others, p, start, j);
                        if (pair[0].compareTo(p) == 0) {
                            segmentsList.add(new LineSegment(pair[0], pair[1]));
                        }

                    }
                    start = j;
                    slope = p.slopeTo(others[j]);
                }
            }

            if (others.length - 1 - start + 1 + 1 >= 4) {
                Point[] pair = generateSegment(others, p, start, others.length);
                if (pair[0].compareTo(p) == 0) {
                    segmentsList.add(new LineSegment(pair[0], pair[1]));
                }

            }

        }


    }

    public int numberOfSegments() {
        return segmentsList.size();
    }

    public LineSegment[] segments() {
        LineSegment[] res = new LineSegment[numberOfSegments()];
        for (int i = 0; i < res.length; i++) {
            res[i] = segmentsList.get(i);
        }
        return res;
    }

    private void checkNullPoint(Point[] points) {
        for (Point point : points) {
            if (point == null) throw new IllegalArgumentException("Point in points is null");
        }
    }

    private void checkDuplicatedPoint(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) throw new IllegalArgumentException("Duplicated points");
        }
    }

    private Point[] generateSegment(Point[] points, Point p, int start, int end) {
        List<Point> temp = new ArrayList<>();
        temp.add(p);
        int j = 1;
        for (int i = start; i < end; i++) {
            temp.add(points[i]);
        }
        temp.sort(null);
        return new Point[]{temp.get(0), temp.get(temp.size() - 1)};
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
