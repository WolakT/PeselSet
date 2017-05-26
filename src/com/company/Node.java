package com.company;

/**
 * Created by RENT on 2017-05-26.
 */
public class Node {
    private Node[] node = new Node[10];
    private boolean hasValue;

    public Node[] getNode() {
        return node;
    }

    public void setNode(Node[] node) {
        this.node = node;
    }

    public Node(int level){
        if(level <3) {

            for (int i = 0; i < 10; i++) {
                this.node[i] = new Node(level +1);
            }
        }
    }
    public void setHasValue(boolean b){
        this.hasValue = b;
    }
    public boolean getHasValue()
    {return this.hasValue;}
}
