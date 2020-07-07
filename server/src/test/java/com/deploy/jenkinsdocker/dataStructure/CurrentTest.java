package com.deploy.jenkinsdocker.dataStructure;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class CurrentTest {

    private Node head;

    private int size;

    private static class Node{
        public String data;

        public Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(String data) {
            this(data, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    public int getSize(){
        return size;
    }

    public void addFirst(String e){
        Node node = new Node(e);
        node.next = head;
        head = node;
        size ++;
    }

    public Node remove(int index){
        Node prev = head;
        for(int i = 0; i < index -1; i++)
            prev = prev.next;
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Node node = head; node != null; node = node.next){
            buffer.append(node.data).append("--->");
        }
        buffer.append("NULL");
        return buffer.toString();
    }
}
