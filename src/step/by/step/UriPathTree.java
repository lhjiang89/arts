package step.by.step;

import java.util.HashMap;
import java.util.Map;

public class UriPathTree {

  private Map<Integer, PathNode> nodes = new HashMap<>();

  public Map<Integer, PathNode> getNodes() {
    return nodes;
  }

  public void setNodes(Map<Integer, PathNode> nodes) {
    this.nodes = nodes;
  }
}
