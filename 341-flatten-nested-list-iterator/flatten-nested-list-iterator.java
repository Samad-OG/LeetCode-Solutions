import java.util.Iterator;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        pushListToStack(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> nextList = stack.pop().getList();
            pushListToStack(nextList);
        }
        return !stack.isEmpty();
    }

    private void pushListToStack(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
}
