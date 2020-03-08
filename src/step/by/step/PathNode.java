package step.by.step;

import java.util.Objects;
import java.util.TreeMap;

public class PathNode {

  private String path;
  private PathNode parent;
  private TreeMap<String, PathNode> children = new TreeMap<>();

  public PathNode(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public TreeMap<String, PathNode> getChildren() {
    return children;
  }

  public void setChildren(TreeMap<String, PathNode> children) {
    this.children = children;
  }

  public PathNode getParent() {
    return parent;
  }

  public void setParent(PathNode parent) {
    this.parent = parent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PathNode pathNode = (PathNode) o;
    return Objects.equals(path, pathNode.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path);
  }
}
