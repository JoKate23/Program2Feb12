package com.example.program2feb12;

import java.io.Serializable;

public class BinaryTree2 implements Serializable
{
    public int payload;
    public BinaryTree2 left;
    public BinaryTree2 right;


    public BinaryTree2(int payload)
    {
        this.payload = payload;
        this.left = null;
        this.right = null;
    }

    public BinaryTree2()
    {
        //exists so it can be rebuilt
        //needed for serializable?
    }

    public void visitInOrder()
    {
        if(this.left != null)
        {
            this.left.visitInOrder(); //blocks
        }
        System.out.println("*** " + this.payload);
        if(this.right != null)
        {
            this.right.visitInOrder();
        }

    }



    public void add(int payloadToAdd)
    {
        if(payloadToAdd <= this.payload)
        {
            //add to the left
            if(this.left == null)
            {
                this.left = new BinaryTree2(payloadToAdd);
            }
            else
            {
                this.left.add(payloadToAdd);
            }
        }
        else
        {
            //add to the right
            if(this.right == null)
            {
                this.right = new BinaryTree2(payloadToAdd);
            }
            else
            {
                this.right.add(payloadToAdd);
            }
        }
    }


}
