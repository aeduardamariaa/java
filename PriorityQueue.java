import java.util.Comparator;

class PriorityQueue<E> {
  private Comparator<E> cmp;
  private LinkedList<E> list;

  public PriorityQueue(Comparator<E> cmp) {
    this.cmp = cmp;
    this.list = new LinkedList<E>();
  }

  public void add(E data) {
    var size = list.getSize();
    
    if (size == 0) {
      list.add(0, data);
      return;
    }

    for (int i = 0; i < size; i++) {
      var current = list.get(i);
      if (cmp.compare(data, current) <= 0) {
        this.list.add(i, data);
        return;
      }
    }

    this.list.addLast(data);
  }

  public E peek() {
    return list.getFirst();
  }

  public E poll() {
    var temp = list.getFirst();
    list.removeFirst();

    return temp;
  }

  public String toString() {
    return this.list.toString();
  }
}
