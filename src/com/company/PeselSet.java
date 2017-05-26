package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-05-25.
 */
public class PeselSet {
    private Node nodePesel;
    public PeselSet(){
        nodePesel = new Node(0);
    }
    public HashSet<String> set = new HashSet<>();

    public boolean add (String p){
        if(p.length() != 11) {
            throw new IllegalArgumentException("Pesel Length is not valid");
        }
        else if( !isPeselValid(p)){
            throw new IllegalArgumentException("Invalid Pesel");}
        else if (checkIfInSet(p)){
            throw new IllegalArgumentException("Already in database");
        }
        else {
            set.add(p);

            int[] ints = new int[10];
            for (int i = 0; i <10 ; i++) {
                ints[i] = Integer.parseInt(Character.toString(p.charAt(i)));


            }
            setNodes(nodePesel, ints, 0);

            return true;

        }

    }

    private void setNodes(Node nodeTemp, int[] vals, int counter){

            Node[] children = nodeTemp.getNode();
            children[counter].setHasValue(true);
            setNodes(children[counter],vals,counter++);





    }

    public boolean isPeselValid(String p){

        int result =0;
        int[] ints = new int[10];
        for (int i = 0; i <10 ; i++) {
            ints[i] = Integer.parseInt(Character.toString(p.charAt(i)));
        }
        int control = Integer.parseInt(Character.toString(p.charAt(10)));
        int[] vals = {9,7,3,1,9,7,3,1,9,7};
        for (int i = 0; i < ints.length; i++) {
            result = result + (vals[i]*ints[i]);
        }

        if (result%10 == control)
            return true;
        else return false;
    }
    public boolean checkIfInSet(String p){
        if(set!=null){
        return set.contains(p);}
        else {return false  ;}
    }
}
