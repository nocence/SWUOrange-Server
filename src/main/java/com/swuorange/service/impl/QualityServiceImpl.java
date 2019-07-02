package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.dao.QualityMapper;
import com.swuorange.dto.QualityDTO;
import com.swuorange.dto.QualityInfo;
import com.swuorange.po.Subbase;
import com.swuorange.service.QualityService;
import com.swuorange.util.PagerHelper;

@Service
public class QualityServiceImpl implements QualityService  {

	@Autowired
	public QualityMapper qualityMapper;
	
	//查询出总条数
	@Override
	public Integer countQuality(QualityDTO qualityDTO) {
		
		return qualityMapper.countQuality(qualityDTO);
	}

	@Override
	public List<QualityInfo> queryQualityList(PagerHelper pageHelper) {
		
		return qualityMapper.queryQualityList(pageHelper);
	}

	@Override
	public List<QualityInfo> queryQualityByName(QualityDTO qualityDTO) {
		
		return qualityMapper.queryQualityByName(qualityDTO);
	}

	@Override
	public Subbase querySubbaseById(Subbase subbase) {
		
		return qualityMapper.querySubbaseById(subbase);
	}

	@Override
	public QualityInfo showQuality(QualityDTO qualityDTO) {
		
		return qualityMapper.showQuality(qualityDTO);
	}

	@Override
	public Integer addQuality(QualityDTO qualityDTO) {
		
		return qualityMapper.addQuality(qualityDTO);
	}

}
