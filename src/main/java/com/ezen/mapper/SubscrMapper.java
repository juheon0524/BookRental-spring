package com.ezen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.domain.Criterial;
import com.ezen.domain.SubscrVO;

public interface SubscrMapper {

	public SubscrVO read(String subscrid);
	public int insertSubscr(SubscrVO subscr);
	public int deleteSubscr(String subscrid);
	public int updateSubscr(SubscrVO subscr);
	
	public List<SubscrVO> getListWithPaging(@Param("cri")Criterial cri);
	public int getTotalCount();
}
