package assesmentsolutions;
import java.util.ArrayList;
import java.util.List;
public class IntervalTree {

	    private static class Interval {
	        int start, end;

	        public Interval(int start, int end) {
	            this.start = start;
	            this.end = end;
	        }
	    }

	    private static class IntervalTreeNode {
	        Interval interval;
	        int max;
	        IntervalTreeNode left, right;

	        public IntervalTreeNode(Interval interval) {
	            this.interval = interval;
	            this.max = interval.end;
	            this.left = this.right = null;
	        }
	    }

	    private IntervalTreeNode root;

	    public IntervalTree() {
	        this.root = null;
	    }

	    public void insertInterval(int start, int end) {
	        root = insert(root, new Interval(start, end));
	    }

	    private IntervalTreeNode insert(IntervalTreeNode node, Interval interval) {
	        if (node == null) {
	            return new IntervalTreeNode(interval);
	        }

	        int l = node.interval.start;
	        if (interval.start < l) {
	            node.left = insert(node.left, interval);
	        } else {
	            node.right = insert(node.right, interval);
	        }

	        if (node.max < interval.end) {
	            node.max = interval.end;
	        }

	        return node;
	    }

	    public void deleteInterval(int start, int end) {
	        root = delete(root, new Interval(start, end));
	    }

	    private IntervalTreeNode delete(IntervalTreeNode node, Interval interval) {
	        if (node == null) {
	            return null;
	        }

	        if (interval.start < node.interval.start) {
	            node.left = delete(node.left, interval);
	        } else if (interval.start > node.interval.start) {
	            node.right = delete(node.right, interval);
	        } else if (node.interval.start == interval.start && node.interval.end == interval.end) {
	            if (node.left == null) {
	                return node.right;
	            } else if (node.right == null) {
	                return node.left;
	            }

	            IntervalTreeNode minNode = getMin(node.right);
	            node.interval.start = minNode.interval.start;
	            node.interval.end = minNode.interval.end;
	            node.right = delete(node.right, minNode.interval);
	        }

	        if (node != null) {
	            node.max = Math.max(node.interval.end, Math.max(maxEndpoint(node.left), maxEndpoint(node.right)));
	        }

	        return node;
	    }

	    private IntervalTreeNode getMin(IntervalTreeNode node) {
	        while (node.left != null) {
	            node = node.left;
	        }
	        return node;
	    }

	    private int maxEndpoint(IntervalTreeNode node) {
	        return node == null ? Integer.MIN_VALUE : node.max;
	    }

	    public List<Interval> findOverlappingIntervals(int start, int end) {
	        List<Interval> result = new ArrayList<>();
	        findOverlappingIntervals(root, start, end, result);
	        return result;
	    }

	    private void findOverlappingIntervals(IntervalTreeNode node, int start, int end, List<Interval> result) {
	        if (node == null) {
	            return;
	        }

	        if (isOverlap(node.interval, start, end)) {
	            result.add(node.interval);
	        }

	        if (node.left != null && node.left.max >= start) {
	            findOverlappingIntervals(node.left, start, end, result);
	        }

	        findOverlappingIntervals(node.right, start, end, result);
	    }

	    private boolean isOverlap(Interval interval, int start, int end) {
	        return interval.start <= end && start <= interval.end;
	    }

	    public static void main(String[] args) {
	        IntervalTree tree = new IntervalTree();
	        tree.insertInterval(1, 3);
	        tree.insertInterval(5, 8);
	        tree.insertInterval(4, 7);
	        tree.insertInterval(6, 10);
	        
	        System.out.println("Overlapping intervals with [4, 9]:");
	        List<Interval> overlaps = tree.findOverlappingIntervals(4, 9);
	        for (Interval interval : overlaps) {
	            System.out.println("[" + interval.start + ", " + interval.end + "]");
	        }

	        tree.deleteInterval(5, 8);

	        System.out.println("Overlapping intervals with [4, 9] after deleting [5, 8]:");
	        overlaps = tree.findOverlappingIntervals(4, 9);
	        for (Interval interval : overlaps) {
	            System.out.println("[" + interval.start + ", " + interval.end + "]");
	        }
	    }
	}


