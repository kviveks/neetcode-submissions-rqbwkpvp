class Solution {
    int[] parent;
    int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    union(i, emailToAccount.get(email));
                }
            }
        }

        Map<Integer, List<String>> rootToEmails = new HashMap<>();

        for (String email : emailToAccount.keySet()) {
            int accountIndex = emailToAccount.get(email);
            int root = find(accountIndex);

            rootToEmails
                .computeIfAbsent(root, k -> new ArrayList<>())
                .add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (int root : rootToEmails.keySet()) {
            List<String> emails = rootToEmails.get(root);
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(root).get(0));
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return;
        }

        if (rank[px] > rank[py]) {
            parent[py] = px;
            rank[px] += rank[py];
        } else {
            parent[px] = py;
            rank[py] += rank[px];
        }
    }
}