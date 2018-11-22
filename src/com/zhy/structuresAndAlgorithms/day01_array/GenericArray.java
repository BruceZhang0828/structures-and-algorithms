package com.zhy.structuresAndAlgorithms.day01_array;

import java.util.Arrays;

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
    public boolean isEmpty(){
        return size==0;
    }
    //修改 index位置处的元素
    public void set(int index,T t){
        checkIndex(index);
        data[index] = t;
    }
    //获取index 位置处的元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }
    //查看数组中是否包含元素e
    public boolean contain(T e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    //获取对应元素的下标 未找到返回-1
    public int find(T e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    //在index位置 插入元素e 时间复杂度为O(n+m)
    public void add(int index,T e){
        checkIndex(index);
        //如果数组容量已经满了 进行扩容 *2
        if(size==data.length){
            //扩容
            resize(2*data.length);
        }
        for (int i = size; i >index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向头插入元素
     * @param e
     */
    public void addHead(T e){
        add(0,e);
    }
    //向数组尾巴插入元素
    public void addLast(T e){
        add(size,e);
    }
    //删除index位置的元素 并返回
    public T remove(int index){
        checkIndexForRemove(index);
        T e = data[index];
        //扩容的是后下标大的在前,删除的时候 下标小的在前
        for (int i = index+1; i <size ; i++) {
                data[i-1] = data[i];
        }
        data[size]= null;
        size--;
        //缩容
        if(size==data.length/4&&size==data.length/2){
            resize(data.length/2);
        }

        return e;
    }


    //删除第一个元素
    public T removeFirst(){
        T re = remove(0);
        return re;
    }
    //删除末尾的元素
    public T removeLast(){
        T re = remove(size-1);
        return re;
    }

    //从数组中删除指定的元素
    public void removeElement(T t){
        int index = find(t);
        if(-1!=index) remove(index);
    }

    @Override
    public String toString() {
        return "GenericArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    /**
     * 进行 扩容
     * @param i
     */
    private void resize(int capacity) {
        T[] newData = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    /**
     * 检查 索引是否正确
     */
    private void checkIndex(int index) {
        if(index<0||index>size){
            throw new IllegalArgumentException("Add fail!Require index>= 0 and index<=size");
        }
    }

    private void checkIndexForRemove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }


}
