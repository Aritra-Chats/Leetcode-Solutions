class StockSpanner {
    private class Pair {
        int val, span;
        Pair(int val, int span) {
            this.val = val;
            this.span = span;
        }
    }
    Stack<Pair> s;
    public StockSpanner() {
        this.s = new Stack<>();
    }
    
    public int next(int price) {
        int next = 1;
        while(!s.isEmpty() && s.peek().val <= price)
            next += s.pop().span;
        s.push(new Pair(price, next));
        return next;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
