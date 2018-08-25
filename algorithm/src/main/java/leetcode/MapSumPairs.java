package leetcode;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by linhjiang on 8/11/18.
 */
public class MapSumPairs {

  class Node {
    char c;
    int sum = 0;
    Integer val = null;
    Node parent;
    Map<Character, Node> children = new HashMap<Character, Node>();

    public Node(char c) {
      this.c = c;
    }
    public Node(Node p, char c) {
      this.parent = p;
      this.c = c;
    }
    public Node(Node p, char c, int val) {
      this.parent = p;
      this.c = c;
      this.val = val;
    }
  }

  private Node root = new Node('$');

  /** Initialize your data structure here. */
  public MapSumPairs() {

  }

  public void insert(String key, int val) {
    Node s = root;
    s.sum += val;
    int i = 0;
    for(; i < key.length() - 1; i ++) {
      char c = key.charAt(i);
      Node n = s.children.get(c);
      if(n == null) {
        n = new Node(s, c);
        s.children.put(c, n);
      }
      n.sum += val;
      s = n;
    }
    // last char
    char c = key.charAt(i);
    Node n = s.children.get(c);
    if(n == null) {
      n = new Node(s, c, val);
      s.children.put(c, n);
      n.sum += val;
    } else {
      if(n.val != null) {
        int lastVal = n.val;
        n.sum += val - n.val;
        n.val = val;
        while(n.parent != null) {
          n.parent.sum -= lastVal;
          n = n.parent;
        }
      } else {
        n.sum += val;
      }
    }
  }

  public int sum(String prefix) {
    if("".equals(prefix)){
      return root.sum;
    }
    Node s = root;
    for(int i = 0; i < prefix.length(); i ++) {
      char c = prefix.charAt(i);
      s = s.children.get(c);
      if(s == null) {
        return 0;
      }
    }
    return s.sum;
  }

  public static void main(String[] args) {
    MapSumPairs p = new MapSumPairs();
    p.insert("aa", 3);
    p.insert("aa", 2);

    System.out.println(p.sum("a"));
  }


}
