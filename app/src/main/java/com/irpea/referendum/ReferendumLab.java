package com.irpea.referendum;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ReferendumLab {
    private static ReferendumLab sReferendumLab;
    private static final int NUMBER_OF_LOCATIONS = 90;
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
        referendumLocation[0] = createLocation("JASTREBARSKO","Ul. Braće Kazić 7, pored Zagrebačke banke", 1,45.673011, 15.652111);
        referendumLocation[1] = createLocation("ZAPREŠIĆ","Trg Ivana Pavla II, šetnica", 1,45.860902, 15.801360);
        referendumLocation[2] = createLocation("ZAPREŠIĆ","Ul. Braće Kazić 7, pored Zagrebačke banke", 1,45.673011, 15.652111);
        referendumLocation[3] = createLocation("ZAPREŠIĆ","Ulica Ksavera Šandora Đalskog, pored Spara", 1,45.870478, 15.797815);
        referendumLocation[4] = createLocation("SAMOBOR","Glavni trg", 1,45.802787, 15.710351);
        referendumLocation[5] = createLocation("IVANIĆ-GRAD","Kolodvorska bb, pored Željezničkog kolodvora", 1,45.673011, 15.652111);
        referendumLocation[6] = createLocation("SVETI IVAN ZELINA","Trg Ante Starčevića, kod gradskog sata", 1,45.960041, 16.242969);
        referendumLocation[7] = createLocation("VELIKA GORICA","Trg kralja Tomislava, pored tržnice", 1,45.713160, 16.077496);
        referendumLocation[8] = createLocation("DUBRAVA","Trg slobode, pored Robnog centra", 1,45.837987, 16.537269);

        referendumLocation[9] = createLocation("SISAK","Školska ul. 3, Plodine", 3,45.465489, 16.381935);
        referendumLocation[10] = createLocation("SISAK","Zagrebačka ul. 49/A, Kaufland", 3,45.495823, 16.365739);
        referendumLocation[11] = createLocation("SISAK","Zagrebačka ul. 49/F, Lidl", 3,45.496894, 16.359612);
        referendumLocation[12] = createLocation("SISAK","Petrinjska ul. 11A, Konzum", 3,45.454079, 16.371492);
        referendumLocation[13] = createLocation("PETRINJA","Crkva Sv. Lovre", 3,45.437072, 16.303537);
        referendumLocation[14] = createLocation("KUTINA","Robna kuća", 3,45.481002, 16.780636);

        referendumLocation[15] = createLocation("DUGA RESA","Jozefinska ul. - Trg sv. Jurja raskrižje", 4,45.450062, 15.499703);
        referendumLocation[16] = createLocation("KARLOVAC","Trg Hrvatskih branitelja, Kaufland", 4,45.488371, 15.545980);
        referendumLocation[17] = createLocation("KARLOVAC","Radićeva ul. \"kod žabe\"", 4,45.490073, 15.555999); //Ovaj nisam nasao na mapi
        referendumLocation[18] = createLocation("SLUNJ","Trg dr. Franje Tuđmana, Gradski park", 4,45.114311, 15.584484);
        referendumLocation[19] = createLocation("OGULIN","Ivana Goran Kovačića 2 (Trg kod Golubice)", 4,45.266709, 15.225025);

        referendumLocation[20] = createLocation("VARAŽDIN","Augusta Šenoe - pored ulaza u varaždinsku tržnicu", 5,46.309966, 16.338480);
        referendumLocation[21] = createLocation("VARAŽDIN","Ruđera Boškovića 25, kod ulaza u Konzum", 5,46.315186, 16.343682);
        referendumLocation[22] = createLocation("VARAŽDIN","Koprivnička 17, skretanje za Kaufland", 5,46.315558, 16.336346);
        referendumLocation[23] = createLocation("VARAŽDIN","Franjevački trg, šetnica uz spomenik", 5,46.307874, 16.336635);
        referendumLocation[24] = createLocation("VARAŽDIN","Ul. Ivana Meštrovića 1, varaždinska bolnica", 5,46.303509, 16.328745);

        referendumLocation[25] = createLocation("KOPRIVNICA","Zrinski trg", 6,46.163158, 16.831104);
        referendumLocation[26] = createLocation("KRIŽEVCI","Trg Antuna Nemčića, pokraj Erste banke", 6,46.024665, 16.545557);
        referendumLocation[27] = createLocation("ĐURĐEVAC","Trg Sv. Juraja", 6,46.042391, 17.068061);

        referendumLocation[28] = createLocation("BJELOVAR","Trg Eugena Kvaternika, preko puta pošte", 7,45.899414, 16.841523);

        referendumLocation[29] = createLocation("KASTAV","Šporova jama 1a, kod Spara", 8,45.370609, 14.351947);
        referendumLocation[30] = createLocation("RIJEKA","Korzo 24, ispred Radio Rijeka", 8,45.327153, 14.441442);
        referendumLocation[31] = createLocation("RIJEKA","Ulica Vatroslava Lisinskog 4, tržnica", 8,45.324890, 14.443121);

        referendumLocation[32] = createLocation("SLATINA","Trg Sv. Josipa 1, fontana", 10,45.702394, 17.701195);
        referendumLocation[33] = createLocation("VIROVITICA","Trg F. Tuđmana 1, Zagrebačka banka ", 10,45.832798, 17.386910);
        referendumLocation[34] = createLocation("PITOMAČA","Ulica Vatroslava Lisinskog 4, tržnica", 10,45.949648, 17.232053);

        referendumLocation[35] = createLocation("NOVA GRADIŠKA","Trg kralja Tomislava, kod sata", 12,45.259562, 17.381389);
        referendumLocation[36] = createLocation("SLAVONSKI BROD","Trg Ivane Brlić Mažuranić, Ante Starčevića križanje", 12,45.153655, 18.012030);
        referendumLocation[37] = createLocation("SLAVONSKI BROD","Naselje Slavonija 2, Kaufland", 12,45.162304, 18.018858);

        referendumLocation[38] = createLocation("ZADAR","Narodni trg, jugo-zapadna strana trga", 13,44.114070, 15.227476);
        referendumLocation[39] = createLocation("ZADAR","Obala kneza Branimira, kod mosta", 13,44.115950, 15.230982);

        referendumLocation[40] = createLocation("BELI MANASTIR","Ul. kralja Tomislava 53, ispred Lidl parkinga", 14,45.771817, 18.606338);
        referendumLocation[41] = createLocation("BELIŠĆE","Trg Ante Starčevića, kod tržnice", 14,45.686209, 18.406093);
        referendumLocation[42] = createLocation("ĐAKOVO","Strossmayerov trg, u blizini katedrale", 14,45.307340, 18.411779);
        referendumLocation[43] = createLocation("NAŠICE","Ul. kralja Petra Krešimira IV 4b, ispred Plodina", 14,45.498526, 18.096483);
        referendumLocation[44] = createLocation("OSIJEK","Ulica J.R.Kira 40, ispred Kauflanda", 14,45.544958, 18.709731);
        referendumLocation[45] = createLocation("OSIJEK","Ulica Josipa Jurja Strossmayera - Trg A. Starčevića", 14,45.565198, 18.647737);
        referendumLocation[46] = createLocation("OSIJEK","Svilajska ulica 31a, pred ulazom PORTANOVA (trgovački centar)", 14,45.555213, 18.638041);
        referendumLocation[47] = createLocation("OSIJEK","Sv. Leopolda Bogdana Mandića, Autotržnica (ulaz)", 14,45.541697, 18.649264);
        referendumLocation[48] = createLocation("OSIJEK","Trg Josipa bana Jelačića, Donji Grad", 14,45.555593, 18.719409);
        referendumLocation[49] = createLocation("VALPOVO","Trg kralja Tomislava, pored pekare Mlinar kod Konzuma", 14,45.658878, 18.417785);
        referendumLocation[50] = createLocation("DARDA","Ul. Svetog Ivana Krstitelja 110, kod Konzuma", 14,45.624568, 18.686663);
        referendumLocation[51] = createLocation("DALJ","Ul Slavka Kolara, pijaca ", 14,45.486544, 18.982025);
        referendumLocation[52] = createLocation("ALJMAŠ","Trg Braće Radić, ispred NTLa", 14,45.528983, 18.949670);
        referendumLocation[53] = createLocation("BIJELO","Brdo Nikole Tesle, centar sela", 14,45.517408, 18.874047);

        referendumLocation[54] = createLocation("ŠIBENIK","Ul. Ante Starčevića 4, ispred jadranske banke", 15,43.733277, 15.895245);
        referendumLocation[55] = createLocation("KNIN","Trg Oluje", 15,44.041721, 15.196640);

        referendumLocation[56] = createLocation("VUKOVAR","Ul. Josipa Jurja Strossmayera 12", 16,45.352638, 19.001504);
        referendumLocation[57] = createLocation("VINKOVCI","Trg Bana Josipa Šokčevića 1", 16,45.288831, 18.805411);

        referendumLocation[58] = createLocation("SPLIT","Vukovarska 207, City centar Split", 17,43.513861, 16.502666);
        referendumLocation[59] = createLocation("SPLIT","Put brodarice 6, Trgovački centar Joker", 17,43.519239, 16.445940);
        referendumLocation[60] = createLocation("SPLIT","Ul. Josipa Jovića 93, Trgovački centar Mall of Split", 17,43.518526, 16.483206);

        referendumLocation[61] = createLocation("LABIN","Rudarska ul. 18, ulaz Tržnica Labin", 18,45.092495, 14.120377);
        referendumLocation[62] = createLocation("PAZIN","Križanje Ul. 25. rujna 1943 i Trga slobode", 18,45.240235, 13.936791);
        referendumLocation[63] = createLocation("POREČ","Tržnica Markt, kod ulaza", 18,45.227337, 13.599091);
        referendumLocation[64] = createLocation("PULA","Narodni trg 9, ulaz tržnica Pula", 18,44.866421, 13.849201);
        referendumLocation[65] = createLocation("PULA","Trg kralja Tomislava - tržnica Veruda", 18,44.857303, 13.837478);

        referendumLocation[66] = createLocation("DUBROVNIK","Vukovarska ul. 34, ispred Tommy", 19,42.652108, 18.090580);
        referendumLocation[67] = createLocation("DUBROVNIK","Ul. kralja Tomislava 5, ispred Tommy", 19,42.655086, 18.076691);

        referendumLocation[68] = createLocation("ČAKOVEC","Trg Republike", 20,46.390117, 16.435027);
        referendumLocation[69] = createLocation("ČAKOVEC","Galerija Sjever, blizu ulaza u Spar", 20,46.395848, 16.428072);
        referendumLocation[70] = createLocation("PODTUREN","Glavna ul. 16, pored trgovine Kitro ", 20,46.468171, 16.544041);
        referendumLocation[71] = createLocation("DEKANOVEC","Bajzovi dvori, Kalnička ul. 28", 20,46.446689, 16.580624);

        referendumLocation[72] = createLocation("GRAD ZAGREB", "Trg bana J. Jelačića, kod sata", 21,45.813194, 15.976556);
        referendumLocation[73] = createLocation("GRAD ZAGREB","Cvjetni trg, kod cvjećarne", 21,45.811934, 15.973929);
        referendumLocation[74] = createLocation("GRAD ZAGREB","Trg kralja Tomislava, kod spomenika", 21,45.805496, 15.978746);
        referendumLocation[75] = createLocation("GRAD ZAGREB","Črnomerec, okretište tramvaja", 21,45.814953, 15.933620);
        referendumLocation[76] = createLocation("GRAD ZAGREB","Kvaternikov trg", 21,45.814559, 15.996864);
        referendumLocation[77] = createLocation("GRAD ZAGREB","Britanski trg", 21,45.812975, 15.964819);
        referendumLocation[78] = createLocation("GRAD ZAGREB","Park Maksimir, kod ulaza", 21,45.819975, 16.015928);
        referendumLocation[79] = createLocation("GRAD ZAGREB","Avenue Mall", 21,45.777043, 15.979540);
        referendumLocation[80] = createLocation("GRAD ZAGREB","Tržnica Jarun", 21,45.789506, 15.929784);
        referendumLocation[81] = createLocation("GRAD ZAGREB","Tržnica Špansko", 21,45.802381, 15.898042);
        referendumLocation[82] = createLocation("GRAD ZAGREB","Tržnica Gajnice", 21,45.816727, 15.872873);
        referendumLocation[83] = createLocation("GRAD ZAGREB","Tržnica Savica", 21,45.794226, 15.996876);
        referendumLocation[84] = createLocation("GRAD ZAGREB","Trešnjevački trg, ispred ulaza u Konzum", 21,45.800085, 15.954240);
        referendumLocation[85] = createLocation("GRAD ZAGREB","Trešnjevački trg, pred ulazom u tržnicu", 21,45.799685, 15.953591);
        referendumLocation[86] = createLocation("GRAD ZAGREB","Tržnica Utrine ", 21,45.776412, 15.995906);
        referendumLocation[87] = createLocation("GRAD ZAGREB","Trg Volovčica", 21,45.810038, 16.016648);
        referendumLocation[88] = createLocation("GRAD ZAGREB","Tržnica Sesvete, ispred ulaza", 21,45.827158, 16.111667);
        referendumLocation[89] = createLocation("GRAD ZAGREB","Glavni kolodvor, ulazu u Importanne Centar", 21,45.803691, 15.977584);


        Collections.addAll(mReferendumLocationList, referendumLocation);
    }

    private ReferendumItem createLocation(String countyName, String caption, int county, double lat, double lon){
        ReferendumItem location = new ReferendumItem();
        location.setCountyName(countyName);
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
