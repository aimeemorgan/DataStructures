package structures;

import java.util.Set;

public abstract class MyAbstractHashTable<E> implements Set<E> {
    
    int size;
    int maxCapacity;
    
    Object[] array;

    public MyAbstractHashTable(int startSize) {
        array = new Object[startSize];
        maxCapacity = (int) Math.floor(startSize * .75);
        size = 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }
    
    abstract protected void resize();

}
