package com.leetcode2022;

import java.util.Map;

public class NewArrayList {

    static class Entry<K,V> implements Map.Entry<K,V>{
        public K key;
        public V value;
        public Entry next;
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
            this.value = value;
            return value;
        }
        public Entry getNext(){
            return next;
        }

        public void setNext(Entry next){
            this.next = next;
        }
    }

    public Entry[] map;
    public int size;

    NewArrayList(){
        map = new Entry[12];
        int size = 0;
    }

    public void put(Object key,Object value){
        int local = key.hashCode()%map.length;
        if (map[local] == null){
            map[local] = new Entry();
            map[local].key = key;
            map[local].value = value;
            size++;
            return;
        }
        Entry entry = map[local];
        while(entry.next!=null){
            Object temp = entry.getKey();
            if(key.equals(temp)){
                entry.setValue(value);
                return;
            }
            entry = entry.next;
        }
        Object temp = entry.getKey();
        if(key.equals(temp)){
            entry.setValue(value);
            return;
        }
        size++;
        Entry nextEntry = new Entry();
        nextEntry.key = key;
        nextEntry.setValue(value);
        entry.setNext(nextEntry);
    }

    public Object get(Object key){
        int local = key.hashCode()%map.length;
        Entry temp = map[local];
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }


}
