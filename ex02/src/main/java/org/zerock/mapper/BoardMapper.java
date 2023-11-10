package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
// ��ü ����Ÿ ��ȸ
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	//insert�� bno�� �� �ʿ� ���� ��
	public void insert(BoardVO vo);
	//insert�� bon�� �ʿ� �� ��
	public void insertSelectKey(BoardVO vo);
	
	//bno�� ����Ÿ ��ȸ
	public BoardVO read(Long bno);
	
	//bno���� ����Ÿ ����
	public int delete(Long bno);
	
	public int update(BoardVO vo);
}
