package com.irpea.referendum;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LocationHolder> {
    private List<ReferendumItem> mReferendumItemsList;
    private Context mContext;

    public RecyclerViewAdapter(List<ReferendumItem> items, Context context){
        this.mReferendumItemsList = items;
        this.mContext = context;
    }

    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_location_referendum_child,parent,false);
        return new LocationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationHolder locationHolder, int i) {
        ReferendumItem referendumItem = mReferendumItemsList.get(i);
        locationHolder.bind(referendumItem);

    }

    @Override
    public int getItemCount() {
        return mReferendumItemsList.size();
    }

    public class LocationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mCaptionTextTitle;
        private TextView mCountyNameTextTitle;
        private ReferendumItem mReferendumItem;

        public LocationHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mCaptionTextTitle = itemView.findViewById(R.id.location_title);
            mCountyNameTextTitle = itemView.findViewById(R.id.location_county_title);
        }

        public void bind(ReferendumItem referendumItem){
            mReferendumItem = referendumItem;
            mCaptionTextTitle.setText(mReferendumItem.getCaption());
            mCountyNameTextTitle.setText(mReferendumItem.getCountyName());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, mReferendumItem.getCaption(), Toast.LENGTH_SHORT).show();
        }
    }
}
