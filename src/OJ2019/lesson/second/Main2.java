package OJ2019.lesson.second;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main (String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            //是否构成多边形
            if(t < 3) {
                for(int j = 0; j < t; j++) {
                    sc.nextInt();
                    sc.nextInt();
                }
                continue;
            }
            Point[] pts = new Point[t];
            for(int j = 0; j < t; j++) {
                pts[j] = new Point(sc.nextInt(), sc.nextInt());
            }
            List<Point> hull = findHull(pts);
            Collections.sort(hull);
            if(hull.size() > 2) {
                for (int j = 0; j < hull.size(); j++) {
                    System.out.print(hull.get(j) + (j == hull.size() - 1 ? "" : ", "));
                }
            }
            System.out.println();
        }
    }

    //构造point
    static class Point implements Comparable {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Object o) {
            Point pN = ((Point)o);
            if(pN.x == x) {
                return y - pN.y;
            } else {
                return x - pN.x;
            }
        }
        public String toString() {
            return x + " " + y;
        }
        public boolean equals(Object o) {
            return ((Point)o).x == x && ((Point)o).y == y;
        }

        @Override
        public int hashCode() {
            return (10000*x) + y;
        }
    }

    public static List<Point> findHull(Point[] points) {
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < start.x) {
                start = points[i];
            }
        }
        Point current = start;
        //use set because this algorithm might try to insert duplicate point.
        Set<Point> result = new HashSet<>();
        result.add(start);
        List<Point> collinearPoints = new ArrayList<>();
        while (true) {
            Point nextTarget = points[0];
            for (int i = 1; i < points.length; i++) {
                if (points[i] == current) {
                    continue;
                }
                int val = cross(current, nextTarget, points[i]);
                //if val > 0 it means points[i] is on left of current -> nextTarget. Make him the nextTarget.
                if (val > 0) {
                    nextTarget = points[i];
                    //reset collinear points because we now have a new nextTarget.
                    collinearPoints = new ArrayList<>();
                } else if (val == 0) { //if val is 0 then collinear current, nextTarget and points[i] are collinear.
                    //if its collinear point then pick the further one but add closer one to list of collinear points.
                    if (distance(current, nextTarget, points[i]) < 0) {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else { //just add points[i] to collinearPoints list. If nextTarget indeed is the next point on
                        //convex then all points in collinear points will be also on boundary.
                        collinearPoints.add(points[i]);
                    }
                }
                //else if val < 0 then nothing to do since points[i] is on right side of current -> nextTarget.
            }

            //add all points in collinearPoints to result.
            for (Point p : collinearPoints) {
                result.add(p);
            }
            //if nextTarget is same as start it means we have formed an envelope and its done.
            if (nextTarget == start) {
                break;
            }
            //add nextTarget to result and set current to nextTarget.
            result.add(nextTarget);
            current = nextTarget;
        }
        return new ArrayList<>(result);

    }


    public static int cross(Point a, Point b, Point c) {
        int abx = b.x - a.x;
        int aby = b.y - a.y;
        int acx = c.x - a.x;
        int acy = c.y - a.y;
        return Integer.compare((abx*acy - aby*acx), 0);
    }

    public static int distance(Point a, Point b, Point c) {
        int abx = b.x - a.x;
        int aby = b.y - a.y;
        int acx = c.x - a.x;
        int acy = c.y - a.y;
        return Integer.compare(abx*abx + aby*aby - acx*acx - acy*acy, 0);

    }


}
