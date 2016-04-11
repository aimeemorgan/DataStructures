package structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyBST<E extends Comparable<E>> implements Set<E> {
    
    int size;
    TreeNode root;
    
    public class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(E value) {
            if (value == null) {
                throw new IllegalArgumentException("Cannot insert a null value into MyBST");
            }
            
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public MyBST() {
        this.size = 0;
        this.root = null;
    }
    
    
    public boolean isBalanced() {
        // TODO
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        if (this.root == null) {
            this.root = new TreeNode(e);
            size++;
            return true;
        }
        
        return add(e, this.root);
    }
    
    private boolean add(E e, TreeNode node) {
        if (e.compareTo(node.value) > 0) {
            if (node.right == null) {
                node.right = new TreeNode(e);
                return true;
            }
            
            add(e, node.right);
        }
        
        if (e.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new TreeNode(e);
                return true;
            } 
            
            add(e, node.left);
        }
        
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean itemAdded = false;
        
        for (E item : c) {
            boolean added = add(item);
            if (!itemAdded && added) itemAdded = true;
        }
        
        return itemAdded;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean itemRemoved = false;
        
        for (Object item : c) {
            boolean added = add((E)item);
            if (!itemRemoved && added) itemRemoved = true;
        }
        
        return itemRemoved;
    }

    @Override
    public void clear() {
        this.root = null;
    }

}
