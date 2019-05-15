package com.irpea.referendum;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ReferendumLab {
    private static ReferendumLab sReferendumLab;
    private static final int NUMBER_OF_LOCATIONS = 17;
    private List<ReferendumItem> mReferendumLocationList;
    ReferendumItem[] referendumLocation = new ReferendumItem[NUMBER_OF_LOCATIONS];


    public static ReferendumLab get(Context context){
        if(sReferendumLab == null){
            sReferendumLab = new ReferendumLab(context);
        }
        return sReferendumLab;
    }

    private ReferendumLab(Context context){
        mReferendumLocationList = new ArrayList<>();
        CreateReferendumList(mReferendumLocationList);
    }

    private void CreateReferendumList(List<ReferendumItem> referendumLocationList){
        referendumLocation[0] = createLocation("Trg bana J. Jelačića, kod sata", 21,45.813194, 15.976556);
        referendumLocation[1] = createLocation("Cvjetni trg, kod cvjećarne ", 21,45.811934, 15.973929);
        referendumLocation[2] = createLocation("Trg kralja Tomislava, kod spomenika ", 21,45.805496, 15.978746);
        referendumLocation[3] = createLocation("Črnomerec, okretište tramvaja ", 21,45.814953, 15.933620);
        referendumLocation[4] = createLocation("Kvaternikov trg ", 21,45.814559, 15.996864);
        referendumLocation[5] = createLocation("Britanski trg ", 21,45.812975, 15.964819);
        referendumLocation[6] = createLocation("Park Maksimir, kod ulaza ", 21,45.819975, 16.015928);
        referendumLocation[7] = createLocation("Avenue Mall ", 21,45.777043, 15.979540);
        referendumLocation[8] = createLocation("Tržnica Jarun ", 21,45.789506, 15.929784);
        referendumLocation[9] = createLocation("Tržnica Špansko ", 21,45.802381, 15.898042);
        referendumLocation[10] = createLocation("Tržnica Gajnice ", 21,45.816727, 15.872873);
        referendumLocation[11] = createLocation("Tržnica Savica ", 21,45.794226, 15.996876);
        referendumLocation[12] = createLocation("Trešnjevački trg, ispred ulaza u Konzum ", 21,45.800085, 15.954240);
        referendumLocation[13] = createLocation("Trešnjevački trg, pred ulazom u tržnicu ", 21,45.799685, 15.953591);
        referendumLocation[14] = createLocation("Tržnica Utrine ", 21,45.776412, 15.995906);
        referendumLocation[15] = createLocation("Trg Volovčica ", 21,45.810038, 16.016648);
        referendumLocation[16] = createLocation("Tržnica Sesvete, ispred ulaza", 21,45.827158, 16.111667);

        Collections.addAll(mReferendumLocationList, referendumLocation);
    }

    private ReferendumItem createLocation(String caption, int county, double lat, double lon){
        ReferendumItem location = new ReferendumItem();
        location.setCaption(caption);
        location.setCounty(county);
        location.setLat(lat);
        location.setLon(lon);
        return location;
    }

    public List<ReferendumItem> getReferendumLocationList(){
        return mReferendumLocationList;
    }

    public ReferendumItem getReferendumLocation(UUID id){
        for(ReferendumItem referendumLocation : mReferendumLocationList){
            if(referendumLocation.getId().equals(id)){
                return referendumLocation;
            }
        }
        return null;
    }
}
