package com.swuorange.service;

import java.util.List;

import com.swuorange.dto.PageBean;
import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;
import com.swuorange.po.Variety;

public interface SupplyService {

	public List<SupplyInfoDTO> getSupplyList(SupplySearchDTO search, PageBean<SupplyInfoDTO> page);

	public List<Variety> getVariety(Integer productId);

}
