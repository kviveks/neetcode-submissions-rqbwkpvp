class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        // Condition 1: Tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Condition 2: No cycles
        if (!dfs(0, -1)) return false;

        // Condition 3: Must be connected
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) return false;

        visited.add(node);

        for (int nei : graph.get(node)) {
            if (nei != parent) {
                if (!dfs(nei, node)) return false;
            }
        }
        return true;
    }
}
