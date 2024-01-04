class LinkedListItem<E> {
  private E data;
  private LinkedListItem<E> next;

  public LinkedListItem(E data) {
    this.data = data;
  }

  public E getData() {
    return (E) data;
  }

  public void setData(E data) {
    this.data = data;
  }

  public LinkedListItem<E> getNext() {
    return this.next;
  }

  public void setNext(LinkedListItem<E> next) {
    this.next = next;
  }
}
