package Nobilis.Training.DataStructures;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyHashmap<K,V> extends AbstractMap<K,V>
        implements Map<K,V> {
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    transient Node<K,V>[] table;
    transient Set<Map.Entry<K,V>> entrySet;
    transient int size;
    int threshold;
    final float loadFactor;
    public MyHashmap(int initialCapacity, float loadFactor) {

        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);

        this.loadFactor = loadFactor;
        this.threshold = MAXIMUM_CAPACITY;//tableSizeFor(initialCapacity);
    }
    public MyHashmap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashmap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    public MyHashmap(Map<? extends K, ? extends V> m) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
    }

    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return MyHashmap.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        MyHashmap.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        MyHashmap.super.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return MyHashmap.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return MyHashmap.super.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return MyHashmap.super.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        return MyHashmap.super.replace(key, value);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return MyHashmap.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return MyHashmap.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return MyHashmap.super.compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return MyHashmap.super.merge(key, value, remappingFunction);
    }

    static class Node<K,V> implements Map.Entry<K,V>{

        final K key;
        final int hash;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
