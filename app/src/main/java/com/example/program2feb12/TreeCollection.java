package com.example.program2feb12;

import android.os.Build;

import java.util.LinkedList;

public class TreeCollection
{
    private LinkedList<TreeValue> theMappings;

    public TreeCollection()
    {
        this.theMappings = new LinkedList<TreeValue>();
    }

    public void addTree(String airportCode, BinaryTree2 tree)
    {
        this.theMappings.add(new TreeValue(airportCode, tree));
    }

    public BinaryTree2 getTreeWithSuperSecretCode(String airportCode)
    {
        for(TreeValue tv : this.theMappings)
        {
            if(tv.airportCode.equals(airportCode))
            {
                return tv.tree;
            }
        }
        return null;
    }

}
