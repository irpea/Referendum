package com.irpea.referendum;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class LocationListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        updateUI();
    }

    private void updateUI(){
        ReferendumLab refLab = ReferendumLab.get(getContext());
        List<ReferendumItem> locations = refLab.getReferendumLocationList();
        mAdapter = new RecyclerViewAdapter(locations, getContext(), communication);
        mRecyclerView.setAdapter(mAdapter);
    }


    FragmentCommunication communication=new FragmentCommunication() {
        @Override
        public void respond(int posititon, double lat, double lon, int zoom) {
            Fragment newFragment = new MapFragment();
            Bundle bundle = new Bundle();
            bundle.putDouble("LAT", lat);
            bundle.putDouble("LON", lon);
            bundle.putInt("ZOOM", 13);
            newFragment.setArguments(bundle);
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, newFragment)
                    .addToBackStack(null)
                    .commit();
        }
    };




    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LocationHolder> {
        private List<ReferendumItem> mReferendumItemsList;
        private Context mContext;
        private FragmentCommunication mCommunication;

        public RecyclerViewAdapter(List<ReferendumItem> items, Context context,FragmentCommunication communication){
            mReferendumItemsList = items;
            mContext = context;
            mCommunication = communication;
        }

        @Override
        public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_location_referendum,parent,false);
            return new LocationHolder(view, mCommunication);
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




        private class LocationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private TextView mCaptionTextTitle;
            private TextView mCountyNameTextTitle;
            private TextView mCountyTextView;
            private ReferendumItem mReferendumItem;
            private FragmentCommunication mCommunication;

            public LocationHolder(@NonNull View itemView, FragmentCommunication Communicator) {
                super(itemView);
                itemView.setOnClickListener(this);

                mCaptionTextTitle = itemView.findViewById(R.id.location_title);
                mCountyNameTextTitle = itemView.findViewById(R.id.location_county_title);
                mCountyTextView = itemView.findViewById(R.id.county_title);
                mCommunication = Communicator;
            }

            public void bind(ReferendumItem referendumItem){
                mReferendumItem = referendumItem;
                mCaptionTextTitle.setText(mReferendumItem.getCaption());
                mCountyNameTextTitle.setText(mReferendumItem.getCountyName());
                mCountyTextView.setText(getCountyRoman(mReferendumItem));
            }

            @Override
            public void onClick(View v) {
                mCommunication.respond(getAdapterPosition(), mReferendumItemsList.get(getAdapterPosition()).getLat(), mReferendumItemsList.get(getAdapterPosition()).getLon(), 13);

            }
        }

        private String getCountyRoman(ReferendumItem item){
            String countyName;
            if(item.getCounty() == 1){
                countyName = "I. ZAGREBAČKA ŽUPANIJA";
                return "I.";
            }
            else if(item.getCounty() == 3){
                countyName = "III. SISAČKO-MOSLAVAČKA ŽUPANIJA";
                return "III.";

            }
            else if(item.getCounty() == 4){
                countyName = "IV. KARLOVAČKA ŽUPANIJA";
                return "IV.";
            }
            else if(item.getCounty() == 5){
                countyName = "V. VARAŽDINSKA ŽUPANIJA";
                return "V.";
            }
            else if(item.getCounty() == 6){
                countyName = "VI. KOPRIVNIČKO-KRIŽEVAČKA ŽUPANIJA";
                return "VI.";
            }
            else if(item.getCounty() == 7){
                countyName = "VII. BJELOVARSKO-BILOGORSKA ŽUPANIJA";
                return "VII.";
            }
            else if(item.getCounty() == 8){
                countyName = "VIII. PRIMORSKO-GORANSKA ŽUPANIJA";
                return "VIII.";
            }
            else if(item.getCounty() == 10){
                countyName = "X. VIROVITIČKO-PODRAVSKA ŽUPANIJA";
                return "X.";
            }
            else if(item.getCounty() == 12){
                countyName = "XII. BRODSKO-POSAVSKA ŽUPANIJA";
                return "XII.";
            }
            else if(item.getCounty() == 13){
                countyName = "XIII. ZADARSKA ŽUPANIJA";
                return "XIII.";
            }
            else if(item.getCounty() == 14){
                countyName = "XIV. OSJEČKO-BARANJSKA ŽUPANIJA";
                return "XIV.";
            }
            else if(item.getCounty() == 15){
                countyName = "XV. ŠIBENSKO-KNINSKA ŽUPANIJA";
                return "XV.";
            }
            else if(item.getCounty() == 16){
                countyName = "XVI. VUKOVARSKO-SRIJEMSKA ŽUPANIJA";
                return "XVI.";
            }
            else if(item.getCounty() == 17){
                countyName = "XVII. SPLITSKO-DALMATINSKA ŽUPANIJA";
                return "XVII.";
            }
            else if(item.getCounty() == 18){
                countyName = "XVIII. ISTARSKA ŽUPANIJA";
                return "XVIII.";
            }
            else if(item.getCounty() == 19){
                countyName = "XIX. DUBROVAČKO-NERETVANSKA ŽUPANIJA";
                return "XIX.";
            }
            else if(item.getCounty() == 20){
                countyName = "XX. MEĐIMURSKA ŽUPANIJA";
                return "XX.";
            }
            else if(item.getCounty() == 21){
                countyName = "XXI. GRAD ZAGREB";
                return "XXI.";
            } else {
                countyName = "Error";
                return "0.";
            }
        }
    }

}
