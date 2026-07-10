class MedianFinder {
    PriorityQueue<Integer> left, right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num);
        if ((left.size() > right.size() + 1) || (!right.isEmpty() && left.peek() > right.peek()))
            right.offer(left.poll());
        if (right.size() > left.size())
            left.offer(right.poll());
    }
    
    public double findMedian() {
        if(left.size() > right.size())
            return left.peek();
        else
            return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
