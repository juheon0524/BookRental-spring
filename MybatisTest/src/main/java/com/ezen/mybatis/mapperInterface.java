package com.ezen.mybatis;

import java.util.List;

public interface mapperInterface {
	public MemberVO selectOne(int id);
	public int insertMember(MemberVO mVo);
	public int deleteMember(int id);
	public int updateMember(MemberVO mVo);
	
	public List<MemberVO> selectAll();
}
