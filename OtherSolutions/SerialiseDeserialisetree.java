package assesmentsolutions;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseDeserialisetree {
	
	    public static class Node {
	        int val;
	        Node left;
	        Node right;
	        Node(int x) { 
	         val = x;
	        }
	    }

	    public String serialize(Node root) {
	        if (root == null) 
	        return "";
	        
	        StringBuilder sb = new StringBuilder();
	        Queue<Node> q = new LinkedList<>();
	        q.add(root);
	        
	        while (!q.isEmpty()) {
	            Node node = q.poll();
	            if (node == null) {
	                sb.append("#,");
	                continue;
	            }
	            sb.append(node.val).append(",");
	            q.add(node.left);
	            q.add(node.right);
	        }
	    
	        sb.setLength(sb.length() - 1);
	        return sb.toString();
	    }

	    
	    public Node deserialize(String data) {
	        if (data.isEmpty()) 
	        return null;
	        
	        String[] values = data.split(",");
	        Node root = new Node(Integer.parseInt(values[0]));
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);
	        
	        for (int i = 1; i < values.length; i++) {
	            Node parent = queue.poll();
	            if (!values[i].equals("#")) {
	                Node left = new Node(Integer.parseInt(values[i]));
	                parent.left = left;
	                queue.add(left);
	            }
	            if (++i < values.length && !values[i].equals("#")) {
	                Node right = new Node(Integer.parseInt(values[i]));
	                parent.right = right;
	                queue.add(right);
	            }
	        }
	        
	        return root;
	    }

	  
	    public static void printTree(Node root) {
	        if (root == null) {
	            System.out.println("Empty Tree");
	            return;
	        }
	        Queue<Node> q = new LinkedList<>();
	        q.add(root);
	        while (!q.isEmpty()) {
	            Node node = q.poll();
	            if (node != null) {
	                System.out.print(node.val + " ");
	                q.add(node.left);
	                q.add(node.right);
	            } else {
	                System.out.print("# ");
	            }
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	    	SerialiseDeserialisetree s=new SerialiseDeserialisetree();
	       //create tree
	        Node tree = new Node(1);
	        tree.left = new Node(2);
	        tree.right = new Node(3);
	        tree.right.left = new Node(4);
	        tree.right.right = new Node(5);
	        
	        // Serialization
	        String serialized = s.serialize(tree);
	        System.out.println("Serialized Tree: " + serialized);
	        
	        // Deserialization
	        Node deserializedTree = s.deserialize(serialized);
	        System.out.print("Deserialized Tree: ");
	        printTree(deserializedTree);
	    }
	}

