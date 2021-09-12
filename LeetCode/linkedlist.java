package LeetCode;

public class linkedlist {
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
    }


    Node nodeA = new Node(4);
    Node nodeB = new Node(3);
    Node nodeC = new Node(2);
    Node nodeD = new Node(1);

    nodeA.next = nodeB;
    nodeB.next = nodeC;
    nodeC.next = nodeD;
}
