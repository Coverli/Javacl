package com.basic.Array.DoubleEncapsulatingArray;

public class Array {
    private int[] data;
    private int size;

    // 构造函数，传入数组的容量 capacity 构造 Array
    public Array (int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量 capacity=10
    public Array () {
        this( 10 );
    }

    // 获取数组中的元素个数
    public int getSize () {
        return size;
    }

    // 获取数组的容量
    public int getCapacity () {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty () {
        return size == 0;
    }

    // 向所有元素后添加一个元素
    public void addLast ( int e ) {
		/*
		if ( size == data.length) {
			throw new IllegalArgumentException ("AddLast failed! Array is full!");
		} else {
			data[size] = e;
			size ++;
		}
		*/

        add(size, e);
    }

    // 向所有元素前添加一个元素
    public void addFirst ( int e ) {
        add ( 0, e );
    }

    // 在第 index 个位置插入一个新元素e
    public void add ( int index, int e ) {

        if ( size == data.length) {
            throw new IllegalArgumentException ("AddLast failed! Array is full!");
        }

        if ( index < 0 || index > size) {
            throw new IllegalArgumentException ("AddLast failed! Require index >= 0 and index < size!");
        }

        for ( int i = size - 1 ; i >= index ; i-- ) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    // 获取 index 索引位置的元素
    public int get ( int index ) {

        if ( index < 0 || index >= size ) {
            throw new IllegalArgumentException ("Get failed. Index is Illegal");
        }

        return data[index];
    }

    // 修改 index 索引位置的元素为e
    public void set ( int index, int e ) {

        if ( index < 0 || index >= size ) {
            throw new IllegalArgumentException ("Get failed. Index is Illegal");
        }

        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains ( int e ) {

        for ( int i = 0 ; i < size ; i++ ) {
            if ( data[i] == e ) {
                return true;
            }
        }

        return false;
    }

    // 查找数组中元素 e 所在的索引，如果不存在元素e，则返回-1
    public int find ( int e ) {

        for ( int i = 0 ; i < size ; i++ ) {
            if ( data[i] == e ) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString () {

        StringBuilder res = new StringBuilder();
        res.append ( String.format ("Array: size = %d, capacity = %d\n", size, data));
        res.append ( '[' );

        for ( int i = 1 ; i < size ; i++ ) {
            res.append ( data[i] );
            if ( i != size - 1 ) {
                res.append ( ", " );
            }
        }

        res.append ( ']' );
        return res.toString ();
    }
}