package com.ezen.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {
	public static void main(String[] args) {
		try {
			String resource = "com/ezen/mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession session = sqlSessionFactory.openSession(true);
			System.out.println(session);
			mapperInterface mapper = session.getMapper(mapperInterface.class);
			MemberVO mVo = mapper.selectOne(000001);
			System.out.println(mVo);	
			
//			mVo.setId(000003);
//			mVo.setName("����");
//			mVo.setPhone("111-2222-3333");
//			mVo.setAddress("����� ������");
//			int result = mapper.updateMember(mVo);
//			System.out.println("��� : " + result);
//			
			List<MemberVO> list = mapper.selectAll();
			
			for(MemberVO member : list)
				System.out.println(member);
			
			
//			int result = mapper.deleteMember(3);
//			System.out.println("���" + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}