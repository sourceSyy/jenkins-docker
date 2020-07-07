package com.deploy.jenkinsdocker.dataStructure;

import java.util.Arrays;

/**
 * 　　* @author YY Shen
 */
public class Array<E> {
    private E[] arr;
    private int size;

    public Array(int capacity){
        this.arr = (E[]) new Object[10];
        this.size = 0;
    }

    public Array() {
       this(10);
    }

    public Array(E[] data){
        this.arr = data;
    }

    //获取数据
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("get fail 没有当前元素");
        }
        return arr[index];
    }

    //更新元素
    public void set(int index, E data){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("get fail 没有当前元素");
        }
        arr[index] = data;
    }

    //是否包含数据
    public boolean contains(E data){
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(data)){
                return true;
            }
        }
        return false;
    }

    //查找数据的下标
    public int find(E data){
        for (int i = 0; i < size; i++) {
            if (arr[i] == data){
                return i;
            }
        }
        return -1;
    }

    //向数组中添加一个元素 在数组的末端
    public void addLast(E data){
       add(size, data);
    }

    //向数组中添加一个元素 在数组的头部
    public void addFirst(E data){
        add(0, data);
    }

    //根据数据删除
    public void removeElement(E data){
        int i = find(data);
        if(i != -1){
            remove(i);
        }
    }

    //删除元素
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("remove fail 没有当前元素");
        }
        //删除的逻辑，保证数组的下标是顺序不间断，需要将当前下标位置之后的数据全部前移，达到覆盖当前数据的效果
        E ref = arr[index];
        for(int i = index + 1; i < size; i++){
            arr[i - 1] = arr[i];
        }
        size--;
        return ref;
    }

    //删除头元素
    public E removeFirst(){
        return remove(0);
    }

    //删除尾元素
    public E removeLast(){
        return remove(size);
    }

    //向指定下标中添加元素
    public void add(int index, E data){
        if (size == arr.length){
            //TODO 其实这里是需要扩容的 暂时抛出异常
            throw new IllegalArgumentException("add fail 当前数组已满");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add fail 不能设置一个非法下标的数据");
        }
        //具体逻辑： 将该下标后面的数据整体后移，然后覆盖当前元素数据
        for (int i = size -1 ; i >= index; i--){
            arr[i + 1] = arr[i];
        }
        arr[index] = data;
        size++;
    }


    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return arr.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
