package step.by.step;

import java.net.URI;
import java.util.*;

public class PatternMatcher {

  private static UriPathTree tree = new UriPathTree();

  private static final int MAX_NUM_OF_PATTERN_CHILDREN = 2;

  private static final double MAX_WILDCARD_PERCENT = 0.4F;

  private static String findPattern(String str) {
    URI uri = URI.create(str);
    String path = uri.getPath().substring(1);
    String[] parts = path.split("\\/");
    int numOfSections = parts.length;

    PathNode root = tree.getNodes().get(numOfSections);
    if (root == null) {
      root = new PathNode(null);
      tree.getNodes().put(numOfSections, root);
    }
    PathNode parent = root;
    PathNode target = root;
    for (int i = 0; i < parts.length; i++) {
      String section = parts[i];
      target = parent.getChildren().get(section);
      if (target != null) {
        parent = target;
        continue;
      } else {
        target = new PathNode(section);
        target.setParent(parent);
        parent.getChildren().put(section, target);
        parent = target;
      }
    }

    // TODO
    mergeNode(root);

    StringBuilder pattern = new StringBuilder();
    while (target.getPath() != null) {
      pattern.insert(0, "/" + target.getPath());
      target = target.getParent();
    }
    return pattern.toString();
  }

  /**
   * @param p
   * @param q
   * @param matchPath if true, means to find same tree. Otherwise, to find same sub-tree
   * @return
   */
  public static boolean isSameTree(PathNode p, PathNode q, boolean matchPath, int numOfWildcard) {
    TreeMap<String, PathNode> lChildren = new TreeMap<>(p.getChildren());
    TreeMap<String, PathNode> rChildren = new TreeMap<>(q.getChildren());

    if (matchPath && !p.getPath().equals(q.getPath()) && !p.getPath().equals("*") && !q.getPath().equals("*")) {
      return false;
    }

    if (lChildren.size() == 0 && rChildren.size() == 0 &&
        calcWildcardPercent(numOfWildcard, p) > MAX_WILDCARD_PERCENT) {
      return false;
    }

    Set<String> lMatched = new HashSet<>();
    Set<String> rMatched = new HashSet<>();
    for (String lkey : lChildren.keySet()) {
      for (String rkey : rChildren.keySet()) {
        if (rMatched.contains(rkey)) {
          continue;
        }
        if (isSameTree(lChildren.get(lkey), rChildren.get(rkey), true, numOfWildcard)) {
          lMatched.add(lkey);
          rMatched.add(rkey);
          break;
        }
        if (isSameTree(lChildren.get(lkey), rChildren.get(rkey), false, numOfWildcard + 1)) {
          lMatched.add(lkey);
          rMatched.add(rkey);
          p.getChildren().remove(lkey);
          q.getChildren().remove(rkey);
          lChildren.get(lkey).setPath("*");
          rChildren.get(rkey).setPath("*");
          p.getChildren().put("*", lChildren.get(lkey));
          q.getChildren().put("*", rChildren.get(rkey));
          break;
        }
      }
    }

    // smaller tree nodes are all matched, then we regard them as same
    if (lChildren.size() > rChildren.size() ?
        rMatched.size() == rChildren.size() :
        lMatched.size() == lChildren.size()) {
      return true;
    }
    return false;
  }

  private static double calcWildcardPercent(int numOfWildcard, PathNode node) {
    int i = 1;
    while (node.getParent() != null) {
      i++;
      node = node.getParent();
    }
    return numOfWildcard * 1.0F / i;
  }

  private static void mergeNode(PathNode root) {

    if (root.getChildren().size() > MAX_NUM_OF_PATTERN_CHILDREN) {

      Queue<PathNode> children = new LinkedList<>(root.getChildren().values());
      int total = children.size();
      Set<PathNode> visited = new HashSet<>();
      while (visited.size() < total) {
        PathNode node = children.poll();
        visited.add(node);
        int i = 0;
        while (i++ < children.size()) {
          PathNode target = children.poll();
          if (isSameTree(node, target, false, 0)) {
            root.getChildren().remove(node.getPath());
            root.getChildren().remove(target.getPath());
            node.setPath("*");
            root.getChildren().put("*", node);
            visited.add(target);
          } else {
            children.offer(target);
          }

        }
        children.offer(node);
      }
    }

    for (PathNode node : root.getChildren().values()) {
      mergeNode(node);
    }
  }

  public static void main(String[] args) {

    Set<String> set = new HashSet<>();

    set.add("https://wwww.ebay.com/abc/" + 1 + "/bad/v1");
    set.add("https://wwww.ebay.com/cde/" + 1 + "/good/v1");
    set.add("https://wwww.ebay.com/abc/" + 1 + "/neutral/v1");
    set.add("https://wwww.ebay.com/xyz/" + 1 + "/good/v1");
//    set.add("https://wwww.ebay.com/sch/" + 2 + "/itm/adkajl");
//    set.add("https://wwww.ebay.com/sch/" + 3 + "/itm/dddd");
//    set.add("https://wwww.ebay.com/sch/" + 4 + "/itm/dddd");

    for (String s : set) {
      System.out.println(s + " : " + findPattern(s));
    }

    System.out.println();
  }

}
