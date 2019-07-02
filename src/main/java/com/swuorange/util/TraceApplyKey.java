package com.swuorange.util;

public class TraceApplyKey {
	
    public static String getTraceApplyCode(String equipmentType, String equipmentNo){
        String newEquipmentNo = "0000001";
 
        if(equipmentNo != null && !equipmentNo.isEmpty()){
            int newEquipment = Integer.parseInt(equipmentNo) + 1;
            newEquipmentNo = String.format(equipmentType + "%05d", newEquipment);
        }
 
        return newEquipmentNo;
    }
 

}
