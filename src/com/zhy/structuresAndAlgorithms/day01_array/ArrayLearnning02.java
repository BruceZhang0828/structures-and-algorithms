package com.zhy.structuresAndAlgorithms.day01_array;

public class ArrayLearnning02 {
    //定义一个数组 进行保存数据
    private int[] data;
    //定义数组长度
    private int size;
    //定义数组中实际的个数：
    private int count;

    //构造方法 需要定义数组的大小
    public ArrayLearnning02(int size) {
        this.data = new int[size];
        this.size = size;
        this.count = 0;//刚开始数组的大小为0
    }

    /**
     * 根据数组索引进行查询
     * @return
     */
    public int find(int index){
        if(index<0||index>size)return -1;
        return data[index];
    }

    /**
     * 插入元素:头部插入 尾部插入
     * @return
     */
    public boolean insert(int index,int value){
        //数组已经满了
        if(count==size){
            System.out.println("数组已经满了...");
            return false;
        }

        //index的校验

        if(index<0||index>size){
            System.out.println("位置不合适");
            return false;
        }

        //位置合法 进行插入
        //index之后的数据 向后移一个位
        for (int i = count;i>index;i--){
            data[i] = data[i-1];
        }
        //插入数据
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 根据下标进行删除
     * @param index
     * @return
     */
    public boolean delete(int index){
        if (index<0||index>count){
            System.out.println("索引错误");
            return false;
        }

        //从删除位置之后的数据 向前移动一个位置
        for (int i =index+1;i<count;i++){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }


    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayLearnning02 array = new ArrayLearnning02(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //day01_array.insert(3, 11);
        array.printAll();
    }
}
