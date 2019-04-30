package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BinaryTreeActivity extends AppCompatActivity
{

    private TextView payloadTV;
    private Button leftButton, rightButton;
    private BinaryTree2 myTree;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_tree);

        this.payloadTV = this.findViewById(R.id.payloadTV);
        this.leftButton = this.findViewById(R.id.leftButton);
        this.rightButton = this.findViewById(R.id.rightButton);

        //get tree owned by this activity???
        if(this.getIntent().hasExtra("myTreeCode"))
        {
            String myTreeCode = this.getIntent().getStringExtra("myTreeCode");
            this.myTree = Core.theVault.getTreeWithSuperSecretCode(myTreeCode); //(BinaryTree2)this.getIntent().getSerializableExtra("myTree");

        }
        else
        {
            //this must be screen 1
            this.myTree = new BinaryTree2(5);
            this.myTree.add(2);
            this.myTree.add(1);
            this.myTree.add(7);
            this.myTree.add(8);
            this.myTree.add(3);
        }

        this.payloadTV.setText("" + this.myTree.payload);
        this.hideButtonsIfNeeded();

    }

    private void hideButtonsIfNeeded()
    {
        if(this.myTree.left == null)
        {
            this.leftButton.setVisibility(View.INVISIBLE);
        }

        if(this.myTree.right == null)
        {
            this.rightButton.setVisibility(View.INVISIBLE);
        }
    }

    public void onLeftButtonClicked(View vy)
    {
        Intent i = new Intent(this, BinaryTreeActivity.class);
        i.putExtra("myTreeCode", "" + Core.currentCode); //passing the secret code
        Core.theVault.addTree("" + Core.currentCode, this.myTree.left);
        Core.currentCode++;
        this.startActivity(i);
    }

    public void onRightButtonClicked(View vy)
    {
        Intent i = new Intent(this, BinaryTreeActivity.class);
        i.putExtra("myTreeCode", "" + Core.currentCode);
        Core.theVault.addTree("" + Core.currentCode, this.myTree.right);
        Core.currentCode++;
        this.startActivity(i);
    }

}
