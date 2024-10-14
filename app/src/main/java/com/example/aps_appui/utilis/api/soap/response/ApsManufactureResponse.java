package com.example.aps_appui.utilis.api.soap.response;

import java.util.List;

public class ApsManufactureResponse {
    public String mo_id;
    public String item_id;      //母件編號
    public String item_name;    //母件品名
    public String qty;          //數量
    public String online_date;  //上線日
    public String complete_date;//結關日
    public related_tech_route related_tech_route;
    public class related_tech_route{
        public String tech_routing_name; //一群-沖床
        public String unit_id;//PCS
    }
    public related_parent_part related_parent_part;
    public class related_parent_part{
        public String material_id;//材料編號
    }

    //FUNCTION
    public String getMo_id() {
        return mo_id;
    }
    public String getItem_id() {return item_id;}
    public String getItem_name() {
        return item_name;
        }
    public String getQty() {
        return qty;
    }
    public String getOnline_date() {
        return online_date;
    }
    public String getComplete_date() {
        return complete_date;
    }
    public String getTech_routing_name() {
        return related_tech_route.tech_routing_name;
    }
    public String getUnit_id() {
        return related_tech_route.unit_id;
    }
    public String getMaterial_id() {
        return related_parent_part.material_id;
    }

//    @Override
//    public String toString() {
//        return "ApsManufactureResponse{" +
//                "mo_id='" + mo_id + '\'' +
//                ", item_id='" + item_id + '\'' +
//                ", item_name='" + item_name + '\'' +
//                ", qty='" + qty + '\'' +
//                ", online_date='" + online_date + '\'' +
//                ", complete_date='" + complete_date + '\'' +
//                ", related_tech_route=" + related_tech_route +
//                ", related_parent_part=" + related_parent_part +
//                '}';
//    }
}
