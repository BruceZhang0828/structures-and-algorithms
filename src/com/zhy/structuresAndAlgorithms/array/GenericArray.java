package com.zhy.structuresAndAlgorithms.array;

public class GenericArray<T> {
    private T [] data;
    private int size;
    /**
     * 根据传入的数量构造 数组
     */
    public GenericArray(int capacity){
        this.data = (T[])new Object[capacity];
        this.size = 0;
    }

    /**
     * 默认构造 参数为10
     */
    public GenericArray(){
        this(10);
    }

    //获取数组容量
    public int size(){
        return data.length;
    }

    //获取当前数组的元素的个数

    public int count(){
        return this.size;
    }

    //判断数组是否为空
    
}
