import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer nextElement = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        if (this.iter.hasNext()) {
            this.nextElement = this.iter.next();
        }
    }

    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {
        Integer result = nextElement;
        if (iter.hasNext()) {
            nextElement = iter.next();
        } else {
            nextElement = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}
