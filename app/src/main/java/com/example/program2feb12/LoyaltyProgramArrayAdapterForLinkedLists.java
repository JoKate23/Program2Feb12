package com.example.program2feb12;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LoyaltyProgramArrayAdapterForLinkedLists extends ArrayAdapter
{
    //private Context mContext;
    private LinkedListOfLoyaltyPrograms loyaltyProgramList;
    private int textViewResourceId;

    public LoyaltyProgramArrayAdapterForLinkedLists(Context context, int textViewResourceId,
                                                LinkedListOfLoyaltyPrograms list)
    {
        super(context, textViewResourceId);
        //this.mContext = context;
        this.loyaltyProgramList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public int getCount()
    {
        return this.loyaltyProgramList.length();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(super.getContext()).
                    inflate(this.textViewResourceId, parent, false);
        }

        TextView lpLoyaltyName = (TextView) listItem.findViewById(R.id.lpLoyaltyNameTV);
        TextView lpBankAffiliation = (TextView) listItem.findViewById(R.id.lpBankAffiliationTV);
        TextView lpCurrentBalance = (TextView) listItem.findViewById(R.id.lpCurrentBalanceTV);
        NewLoyalty lp = this.loyaltyProgramList.getAtIndex(position);

        lpLoyaltyName.setText(lp.getLoyaltyName());
        lpBankAffiliation.setText(lp.getBankAffiliation());
        lpCurrentBalance.setText("" + lp.getCurrentBalance());
        //return the View after we have set all of the values
        return listItem;

    }
}
