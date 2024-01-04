import java.util.Comparator;

class LinkedList<E> {
  private int size;
  private LinkedListItem<E> first;
  private LinkedListItem<E> last;

  public LinkedList() {
    this.size = 0;
    this.first = null;
    this.last = null;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    LinkedListItem<E> current = first;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }

    return current.getData();
  }

  public LinkedListItem<E> getItem(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    LinkedListItem<E> current = first;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }

    return current;
  }

  public void add(int index, E data) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException();

    if (index == 0)
      addFirst(data);
    else if (index == size - 1)
      addLast(data);
    else {
      var newItem = new LinkedListItem<E>(data);
      var previousItem = this.getItem(index - 1);
      var currentItem = this.getItem(index);

      previousItem.setNext(newItem);
      newItem.setNext(currentItem);
      this.size++;
    }
  }

  public void remove(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    if (index == 0)
      this.removeFirst();
    else if (index == size - 1)
      this.removeLast();
    else {
      var previousItem = this.getItem(index - 1);
      var currentItem = this.getItem(index);

      previousItem.setNext(currentItem.getNext());
      currentItem.setNext(null);
      this.size--;
    }
  }

  public int getSize() {
    return this.size;
  }

  public E getFirst() {
    return this.first.getData();
  }

  public void addFirst(E data) {
    var newItem = new LinkedListItem<E>(data);

    if (this.first != null)
      newItem.setNext(this.first);

    this.first = newItem;
    this.size++;

    if (this.size == 1)
      this.last = newItem;
  }

  public E getLast() {
    return this.last.getData();
  }

  public void addLast(E data) {
    var newItem = new LinkedListItem<E>(data);

    if (this.last != null)
      this.last.setNext(newItem);

    this.last = newItem;
    this.size++;

    if (this.size == 1)
      this.first = newItem;
  }

  public E removeFirst() {
    if (this.size == 0)
      return null;

    var temp = this.first;

    if (this.first.getNext() != null)
      this.first = this.first.getNext();
    else {
      this.first = null;
      this.last = null;
    }

    this.size--;
    return temp.getData();
  }

  public E removeLast() {
    if (this.size == 0)
      return null;

    var temp = this.last;
    this.size--;

    if (this.size != 0) {
      var previous = this.getItem(this.size - 1);
      
      this.last = previous;
      this.last.setNext(null);
    } else {
      this.first = null;
      this.last = null;
    }

    return temp.getData();
  }
}
