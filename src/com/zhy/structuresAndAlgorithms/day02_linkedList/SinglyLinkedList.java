package com.zhy.structuresAndAlgorithms.day02_linkedList;

import java.util.SortedSet;

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


    //判断 true or false
    public boolean TFResult(Node left,Node right){
        Node l = left;
        Node r = right;

        System.out.println("left_"+l.data);
        System.out.println("right_"+r.data);

        while(l!=null&&r!=null){
            if(l.data==r.data){
                l = l.next;
                r = r.next;
                continue;
            }else {
                break;
            }
        }
        System.out.println("什么结果");
        if(l==null&&r==null){
            System.out.println("什么结果");
            return true;
        }else{
            return false;
        }
    }

    //判断是否回文

    public boolean palindrome(){

        if(head==null){//如果为null 直接返回false;
            return false;
        }else{
            //详细的判断
            //先找中间节点
            Node p  = head;
            Node q = head;
            if (p.next==null){
                System.out.println("只有一个元素");
                return true;
            }

            while(q.next!=null&&q.next.next!=null){
                p = p.next;
                q = q.next.next;
            }

            System.out.println("中间节点"+p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if (q.next ==null){
                //p 一定为整个链表中的中点,且节点数目为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("");
                System.out.println("");
            }else{
                //p q均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);

            }

            return TFResult(leftLink,rightLink);

        }
    }


    //带结点的链表翻转
    public Node inverseLinkList_head(Node p) {
        //Head 为新建一个头结点
        Node Head = new Node(9999,null);
        //p为原来链表中的头结点,现在Head指向 整个链表
        Head.next = p;
        /**
         * 带头结点的链表翻转等价于
         * 从第二个元素开始重新头插法建立链表
         */
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while(Cur != null){
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first"+Head.data);
            Cur = next;
        }

        //返回左半部分的中点之前的那个结点
        //从此处开始 同步向两边比较
        return Head;
    }

    //无头结点 的表链翻转
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;
        System.out.println("z----"+r.data);
        Node next = null;
        while (r!=p){
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;

        return r;
    }


    public static Node createNode(int value){
        return new Node(value,null);
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
