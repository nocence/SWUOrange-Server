package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.QualityDTO;
import com.swuorange.dto.QualityInfo;
import com.swuorange.po.Subbase;
import com.swuorange.util.PagerHelper;


@Mapper
public interface QualityMapper {
	
	//查询出总条数
	public Integer countQuality(QualityDTO qualityDTO);
	
	//查询出QualityDTO对象的集合
	public List<QualityInfo> queryQualityList(PagerHelper pageHelper);

	//根据质量检测申请的名字查询
	public List<QualityInfo> queryQualityByName(QualityDTO qualityDTO);

	//根据二级基地的id,查询生产记录者
	public Subbase querySubbaseById(Subbase subbase);
	
	//根据质量检测申请的id和申请人id
	public QualityInfo showQuality(QualityDTO qualityDTO);
	
	public Integer addQuality(QualityDTO qualityDTO);
}
