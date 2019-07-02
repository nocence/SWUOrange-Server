package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;
import com.swuorange.po.Variety;

@Mapper
public interface SupplyInfoMapper {

	public Integer queryTotalCount(SupplySearchDTO search);

	public List<SupplyInfoDTO> querySupplyBy(SupplySearchDTO search);

	public List<Variety> getVariety(Integer productId);

}
