package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.po.Product;

@Mapper
public interface DemandMapper {

	public List<Product> getProductType();

	public Integer queryTotalCount(DemandSearchDTO search);

	public List<DemandDTO> queryDemandBy(DemandSearchDTO search);

}
