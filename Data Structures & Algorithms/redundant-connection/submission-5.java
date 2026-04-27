class Solution {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        for (int i = 1; i <= n; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            Set<Integer> visited = new HashSet<>();
            // Check if u and v are already connected
            if (dfs(u, v, visited)) {
                return edge;
            }

            // Add edge AFTER check
            adjMap.get(u).add(v);
            adjMap.get(v).add(u);
        }

        return new int[]{-1, -1};
    }

    public boolean dfs(int src, int target, Set<Integer> visited) {
        if (src == target) return true;

        visited.add(src);

        for (int nei : adjMap.get(src)) {
            if (!visited.contains(nei)) {
                if (dfs(nei, target, visited)) return true;
            }
        }

        return false;
    }
}