import java.util.LinkedList;
import java.util.ListIterator;

class StringHashSet {
  private LinkedList<String>[] set;
  private int size;

  public StringHashSet() {
    this.set = new LinkedList[100];    
    this.size = 100;
  }

  public void add(String s) {
    int index = s.hashCode() % this.size;
    this.checkInstance(index);
    
    this.set[index].add(s);
  }

  public boolean contains(String s) {
    int index = s.hashCode() % this.size;    
    this.checkInstance(index);
    
    var it = this.set[index].iterator();

    while (it.hasNext()) {
      if (it.next().equals(s)) {
        return true;
      }
    }
    
    return false;
  }

  private void checkInstance(int index) {
    if (this.set[index] == null)
      this.set[index] = new LinkedList<String>();
  }
}
