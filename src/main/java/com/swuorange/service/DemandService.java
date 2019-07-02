package com.swuorange.service;

import java.util.List;

import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.po.Product;

public interface DemandService {

	public List<Product> getProductType();

	public List<DemandDTO> DemandBaseList(DemandSearchDTO search, PageBean<DemandDTO> page);

}
