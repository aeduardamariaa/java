class Stack<E> {
  private Object[] stack;
  private int top;
  private int size;

  public Stack ()
  {
    this.stack = new Object[10];
    this.top = -1;
    this.size = 10;
  }

  public boolean empty()
  {
    return this.top == -1;
  }

  public E peek()
  {
    if (this.empty())
      return null;

    return (E) stack[this.top];
  }

  public E push(E item)
  {
    if (this.top == this.size - 1)
    {
      var newStack = new Object[this.size * 2];
      for (int i = 0; i < this.size; i++)
        newStack[i] = this.stack[i];

      this.stack = newStack;
      this.size = this.size * 2;
    }
    this.stack[++this.top] = item;
    
    return (E) item;
  }
  
  public E pop()
  {
    if(this.empty())
      return null;

    var aux = this.stack[this.top];
    this.stack[this.top--] = null;

    return (E) aux;
  }

  public int search(Object obj)
  {
    for (int i = this.top; i >= 0; i--)
    {
      if (this.stack[i].equals(obj))
        return this.top - i;
    }

    return -1;
  }

  public String toString()
  {
    String str = "[";
    for (int i = 0; i < this.top + 1; i++)
    {
      if (this.stack[i] != null)
        str += this.stack[i] + (i == this.top ? "]" : ", ");
    }

    return str;
  }
}
