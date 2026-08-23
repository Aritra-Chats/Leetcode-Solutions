class Solution {
    private class Pair {
        String divisor;
        double quotient;
        private Pair(String divisor, double quotient) {
            this.divisor = divisor;
            this.quotient = quotient;
        }
    }
    private double dfs(String divisor, String dividend, Map<String, List<Pair>> adjMap, Set<String> vis) {
        double quotient = -1;
        for(Pair pair : adjMap.get(dividend)) {
            if(vis.contains(pair.divisor))
                continue;
            if(pair.divisor.equals(divisor))
                return pair.quotient;
            vis.add(pair.divisor);
            double nextQuotient = dfs(divisor, pair.divisor, adjMap, vis);
            if(nextQuotient != -1)
                quotient = pair.quotient * nextQuotient;
            vis.remove(pair.divisor);
        }
        return quotient;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adjMap = new HashMap<>();
        int len = values.length;
        for(int i = 0; i < len; i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            adjMap.computeIfAbsent(dividend, k -> new ArrayList<>()).add(new Pair(divisor, values[i]));
            adjMap.computeIfAbsent(divisor, k -> new ArrayList<>()).add(new Pair(dividend, 1/values[i]));
        }
        int querySize = queries.size();
        double[] results = new double[querySize];
        for(int i = 0; i < querySize; i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            if(!adjMap.containsKey(dividend) || !adjMap.containsKey(divisor)) 
                results[i] = -1;
            else 
                results[i] = dfs(divisor, dividend, adjMap, new HashSet<>());
        }
        return results;
    }
}
