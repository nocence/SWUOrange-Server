package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.Remarks;
import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;

@Mapper
public interface AdminSupplyAndDemandMapper {

	Integer queryBuyTotalCount(DemandSearchDTO search);
	List<DemandDTO> queryBuyBy(DemandSearchDTO search);
	void updateBuy(Remarks remarks);
	
	Integer querySupplyTotalCount(SupplySearchDTO search);
	void updateSupply(Remarks remarks);
	List<SupplyInfoDTO> querySupplyBy(SupplySearchDTO search);

}
