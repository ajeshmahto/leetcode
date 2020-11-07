package com.cre8techlabs;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collection;

public class TestNodes {
	/*
AAA   BBB
     CC DDD
  EEEE FF GGG
  EEEE    GGG
 HHHHHHHHHH
	 */
	public static void main(String[] args) {
		Node a = createNode(0, 0, 3, 1);
		Node b = createNode(6, 0, 3, 1);
		Node c = createNode(5, 1, 2, 1);
		Node d = createNode(8, 1, 3, 1);
		Node e = createNode(2, 2, 4, 2);
		Node f = createNode(7, 2, 2, 1);
		Node g = createNode(10, 2, 3, 2);
		Node h = createNode(1, 4, 10, 1);
		
		
		linkNodes(a, b, c, d, e, f, g, h);

		assertNodeLinked(a, new Node[] {}, new Node[] {e}, new Node[] {}, new Node[] {b});
		assertNodeLinked(b, new Node[] {}, new Node[] {c, d}, new Node[] {a}, new Node[] {});
		assertNodeLinked(c, new Node[] {b}, new Node[] {}, new Node[] {}, new Node[] {d});
		assertNodeLinked(d, new Node[] {b}, new Node[] {f, g}, new Node[] {}, new Node[] {});
		assertNodeLinked(e, new Node[] {c}, new Node[] {h}, new Node[] {}, new Node[] {f});
		assertNodeLinked(f, new Node[] {d}, new Node[] {h}, new Node[] {e}, new Node[] {g});
		assertNodeLinked(g, new Node[] {d}, new Node[] {}, new Node[] {f}, new Node[] {});
		assertNodeLinked(h, new Node[] {e, g}, new Node[] {}, new Node[] {}, new Node[] {});
		
		displayRecursivelyAllNodesFromParentNode(a);
		
	}
	private static void linkNodes(Node...nodes) {
		// TODO to complete
		
	}
	private static void displayRecursivelyAllNodesFromParentNode(Node a) {
		// TODO to complete
		
	}
	private static void assertNodeLinked(Node node, Node[] up, Node[] down, Node[] left, Node[] right) {
		if (!containsAll(node.getUpNodes(), Arrays.asList(up))) {
			throw new AssertionError("The conditions are not meet");
		}
		if (!containsAll(node.getDownNodes(), Arrays.asList(down))) {
			throw new AssertionError("The conditions are not meet");
		}
		if (!containsAll(node.getLeftNodes(), Arrays.asList(left))) {
			throw new AssertionError("The conditions are not meet");
		}
		if (!containsAll(node.getRightNodes(), Arrays.asList(right))) {
			throw new AssertionError("The conditions are not meet");
		}
	}

	private static boolean containsAll(Collection<INode> nodes, Collection<INode> nodes2) {
		if (nodes.size() != nodes2.size())
			return false;
		if (nodes.isEmpty() && nodes2.isEmpty())
			return true;
		if (nodes.containsAll(nodes2) && nodes2.containsAll(nodes)) {
			return true;
		}
		return false;
	}

	private static Node createNode(int x, int y, int width, int height) {
		Node result = new Node();
		result.setRect(new Rectangle(x, y, width, height));
		
		return result;
	}
}
