package com.example.program2feb12;

public class BinaryTree
{
    private BTreeNode root;

   // public BinaryTree()
    {
     //   this.root = Airport.get(0);
    }

    public void visitInOrder()
    {
        if(this.root != null)
        {
            System.out.println("*** In Order:" + this.root.visitInOrder());
        }
    }


    public void visitPostOrder()
    {
        if(this.root != null)
        {
            System.out.println("*** Post Order:" + this.root.visitPostOrder());
        }
    }


    public void visitPreOrder()
    {
        if(this.root != null)
        {
            System.out.println("*** Pre Order:" + this.root.visitPreOrder());
        }
    }


    public void addValue(int payload)
    {
        BTreeNode n = new BTreeNode(payload);

        if(this.root == null)
        {
            this.root = n;
        }
        else
        {
            //My tree has stuff in it
            //this.root.addNode(n);
            if(n.getPayload() <= this.root.getPayload())
            {
                //add to the left
                if(this.root.getLeftChild() == null)
                {
                    this.root.setLeftChild(n);
                }
            }
            else
            {
                //add to the right
                if(this.root.getRightChild() == null)
                {
                    this.root.setRightChild(n);
                }
            }

        }
    }

}
