class IntArrayList {
  private int[] data;
  private int size;
  private int maxLength;

  public IntArrayList(int maxLength) {
    this.maxLength = maxLength;
    this.data = new int[maxLength];
    this.size = 0;
  }

  public int getSize() {
    return this.size;
  }

  public int getMaxLength() {
    return this.maxLength;
  }

  public void add(Integer value) {
    if (this.size == this.maxLength) {
      int[] newData = new int[this.maxLength * 2];

      for (int i = 0; i < this.size; i++) {
        newData[i] = this.data[i];
      }
      this.data = newData;
      this.maxLength *= 2;
    }

    this.data[this.size] = value.intValue();
    this.size++;
  }

  public Integer get(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }

    return Integer.valueOf(this.data[index]);
  }

  public void set(int index, Integer value) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }

    this.data[index] = value.intValue();
  }

  public void clear() {
    for (int i = 0; i < this.size; i++)
      this.data[i] = 0;

    this.size = 0;
  }

  public boolean isEmpty() {
    return (this.size == 0);
  }

  public boolean contains(Integer value) {
    for (int i = 0; i < this.size; i++) {
      if (this.data[i] == value.intValue())
        return true;
    }

    return false;
  }

  public int indexOf(Integer value) {
    if (!this.contains(value)) {
      throw new IllegalArgumentException();
    }

    int result = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.data[i] == value.intValue())
        result = i;
    }
    return result;
  }

  public IntArrayList clone() {
    IntArrayList result = new IntArrayList(this.maxLength);

    for (int i = 0; i < this.size; i++) {
      result.add(Integer.valueOf(this.data[i]));
    }

    return result;
  }

  public Integer remove(int index) {
    if (index < 0 || index >= this.size)
      throw new IndexOutOfBoundsException();

    int result = this.data[index];

    for (int i = index; i < this.size - 1; i++) {
      this.data[i] = this.data[i+ 1];
    }
    this.data[this.size-1] = 0;
    this.size -= 1;

    return Integer.valueOf(result);
  }

  public boolean remove(Integer value) {
    if (!this.contains(value))
      return false;

    int index = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.data[i] == value.intValue()) {
        index = i;
        break;
      }
    }

    this.remove(index);
    return true;
  }

  public void sort() {
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size - i - 1; j++) {
        if (this.data[j] > this.data[j + 1]) {
          int temp = this.data[j];
          this.data[j] = this.data[j + 1];
          this.data[j + 1] = temp;
        }
      }
    }
  }

  public String toString() {
    String result = "[";
    for (int i = 0; i < this.size; i++) {
      result += this.data[i] + ((i == this.size - 1) ? "]" : ", ");
    }

    return result;
  }
}
