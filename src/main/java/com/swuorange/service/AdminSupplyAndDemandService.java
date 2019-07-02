package com.swuorange.service;

import java.util.List;

import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Remarks;
import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;

public interface AdminSupplyAndDemandService {

	List<DemandDTO> getBuyList(DemandSearchDTO search, PageBean<DemandDTO> page);

	void checkBuy(Remarks remarks);


	List<SupplyInfoDTO> getSupplyInfoList(SupplySearchDTO search, PageBean<SupplyInfoDTO> page);

	void checkSupply(Remarks remarks);

}
