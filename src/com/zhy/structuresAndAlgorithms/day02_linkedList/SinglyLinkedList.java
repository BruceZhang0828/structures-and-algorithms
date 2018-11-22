package com.zhy.structuresAndAlgorithms.day02_linkedList;

/**
 * 单链表的实现
 */
public class SinglyLinkedList {
    private Node head = null;

    //根据value 查询 node节点
    public Node findByValue(int value){
        Node p = head;
        while (p!=null&&p.data!=value){
            p = p.next;
        }

        return p;
    }
    //根据 index 查询
    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while(p!=null&&pos!=index){
            p = p.next;
            pos++;
        }
        return p;
    }
    //无头节点
    //表头部插入
    //这种操作 将于顺序相反,逆序
    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head==null){
            head = newNode;
        }else{
            //新节点的next指向原来的头结点
            newNode.next=head;
            //新节点变为了头节点
            head = newNode;
        }
    }
    //顺序插入在尾部插入
    //链表尾部
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        //如果是空链表 作为head节点插入
        if (head==null){
            head = newNode;
        }else {
            Node p = head;
            while (p.next!=null){
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }

    }
    //插入到某个节点之后
    public void insertAfter(Node p,int value){
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }

    public void insertAfter(Node p,Node newNode){
        if (p==null)return;
        newNode.next = p.next;
        p.next = newNode;
    }
    //在p节点之前 插入元素
    public void insertBefore(Node p,int value){
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p,Node newNode){
        if (p==null)return;

        if(head==p){
            insertToHead(newNode);
        }

        Node q = head;
        while(q!=null&&q.next!=p){
            q = q.next;
        }
        if (q==null){
            return;
        }
        newNode.next = q.next;
        q.next = newNode;
    }
    //根据 节点进行删除
    public void deleteByNode(Node p){
        if (p==null||head==null){
            return;
        }

        if(head==p){
            head = head.next;
        }

        Node q = head;
        while(q.next!=p){
            q = q.next;
        }

        q.next = q.next.next;
    }
    //根据值行删除
    public void deleteByData(int value){
        if(head==null){return;}
        Node q = head;
        Node p = null;
        while(q.next!=null&&q.data!=value){
            p =q;
            q = q.next;
        }
        //没有这个数
        if (q==null){return;}
        //这个数就是头结点
        if (p==null){
            head = head.next;
        }else{
            p.next = p.next.next;
        }

    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }



    /**
     * Node节点
     */
    public static class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return this.data;
        }
    }
}
