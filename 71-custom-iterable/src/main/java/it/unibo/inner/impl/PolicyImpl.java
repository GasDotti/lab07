package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class PolicyImpl<T> implements IterableWithPolicy<T>{

    private T[] elements;
    private Predicate<T> filter;

    public PolicyImpl(final T[] array, final Predicate<T> filter){

        if(array == null || filter == null){
            throw new NullPointerException();
        }

        this.elements = array.clone();
        setIterationPolicy(filter);
    }
    public PolicyImpl(final T[] array){

        this(array, new Predicate<T>(){
            @Override
            public boolean test(T elem) {
                return true;
            }
        });
    }

    public int getLength(){
        return this.elements.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }
    
    private final class InnerIterator implements Iterator<T>{

        private int pos;

        public InnerIterator(){
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            while (this.pos < getLength() && !filter.test(elements[pos])) {
                this.pos++;
            }
            return this.pos < getLength();
        }

        @Override
        public T next() {
            return elements[this.pos++];
        }

    }

}
