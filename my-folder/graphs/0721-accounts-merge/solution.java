class Solution {
    private class DisjointSet {
        int[] parent, rank;
        private DisjointSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        int findParent(int x) {
            if(parent[x] == x) return x;
            else {
                parent[x] = findParent(parent[x]);
                return parent[x];
            }
        }
        void union(int x, int y) {
            int px = findParent(x), py = findParent(y);
            if(px == py) return;
            if(rank[px] < rank[py]) 
                parent[px] = py;
            else if(rank[px] > rank[py])
                parent[py] = px;
            else if(rank[px] == rank[py]) {
                rank[px]++;
                parent[py] = px;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());
        Map<String, Integer> emailOwner = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            for(String email : accounts.get(i)) {
                if(email.equals(accounts.get(i).getFirst())) continue;
                if(!emailOwner.containsKey(email)) 
                    emailOwner.put(email, i);
                else
                    ds.union(emailOwner.get(email), i);
            }
        }
        Map<Integer, List<String>> mergedAccount = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            if(ds.findParent(i) == i)
                mergedAccount.put(i, new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry : emailOwner.entrySet())
            mergedAccount.get(ds.findParent(entry.getValue())).add(entry.getKey());
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> account : mergedAccount.entrySet()) {
            Collections.sort(account.getValue());
            account.getValue().add(0, accounts.get(account.getKey()).getFirst());
            result.add(account.getValue());
        }
        return result;
    }
}
