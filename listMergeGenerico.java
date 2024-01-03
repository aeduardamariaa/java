import java.util.Comparator;

public class ArrayList<T>
{
  private int count;
  private Object[] arr;

  public ArrayList()
  {
    count = 0;
    arr = new Object[10];
  }

  // O(1)
  public void add(T value)
  {
    if (count == arr.length)
    {
      Object[] newArr = new Object[2 * arr.length];
      for (int i = 0; i < arr.length; i++)
        newArr[i] = arr[i];
      arr = newArr;
    }

    arr[count] = value;
    count++;
  }

  // O(1)
  public int size()
  {
    return count;
  }

  // O(1)
  public T get(int index)
  {
    if (index >= 0 && index < count)
      return (T)arr[index];
    
    throw new IndexOutOfBoundsException();
  }

  // O(1)
  public void set(int index, T value)
  {
    if (index < 0 || index >= count)
      throw new IndexOutOfBoundsException();
    
    arr[index] = value;
  }

  // O(1)
  public void clear()
  {
    count = 0;
    arr = new Object[10];
  }

  // O(1)
  public Boolean isEmpty()
  {
    return count == 0;
  }

  // O(n)
  public Boolean contains(T value)
  {
    for (int i = 0; i < count; i++)
    {
      if (arr[i].equals(value))
        return true;
    }

    return false;
  }

  // O(n)
  public int indexOf(T value)
  {
    for (int i = 0; i < count; i++)
    {
      if (arr[i].equals(value))
        return i;
    }

    return -1;
  }

  // O(n)
  public ArrayList<T> clone()
  {
    ArrayList<T> copy = new ArrayList<T>();
    
    copy.count = this.count;
    copy.arr = new Object[this.arr.length];
    for (int i = 0; i < count; i++)
      copy.arr[i] = this.arr[i];
    
    return copy;
  }

  // O(n)
  public T remove(int index)
  {
    if (index < 0 || index >= count)
      throw new IndexOutOfBoundsException();
    var removedValue = arr[index];

    for (int i = index + 1; i < count; i++)
    {
      arr[i - 1] = arr[i];  
    }
    count--;

    return (T)removedValue;
  }

  // O(n)
  public void remove(T value)
  {
    int index = indexOf(value);
    if (index == -1)
      return;
    remove(index);
  }

  // O(n lg(n))
  public void sort(Comparator<T> cmp)
  {
    Object[] temp = new Object[count];
    mergeSort(cmp, arr, temp, 0, count);
  }

  private void mergeSort(
    Comparator<T> cmp,
    Object[] arr,
    Object[] temp,
    int start,
    int end
  )
  {
    if (end - start < 2)
      return;
    
    int middle = (start + end) / 2;
    mergeSort(cmp, arr, temp, start, middle);
    mergeSort(cmp, arr, temp, middle, end);
    merge(cmp, arr, temp, start, middle, end);
  }

  private void merge(
    Comparator<T> cmp,
    Object[] arr,
    Object[] temp,
    int start,
    int middle,
    int end
  )
  {
    int i = start, j = middle, k = start;
    while (i < middle && j < end)
    {
      var result = cmp.compare((T)arr[i], (T)arr[j]);
      if (result < 0)
      {
        temp[k] = arr[i];
        i++;
      }
      else
      {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }

    while (i < middle)
    {
      temp[k] = arr[i];
      i++;
      k++;
    }
    
    while (j < end)
    {
      temp[k] = arr[j];
      j++;
      k++;
    }

    for (int m = start; m < end; m++)
      arr[m] = temp[m];
  }
}
