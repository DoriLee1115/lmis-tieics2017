package cn.edu.tju.tiei.logistics.main;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.edu.tju.tiei.logistics.dao.UsrMapper;
import cn.edu.tju.tiei.logistics.model.Usr;
import cn.edu.tju.tiei.logistics.dao.ShipperMapper;
import cn.edu.tju.tiei.logistics.model.Shipper;

public class Main {

	public static void main(String[] args) {
		
		String resource = "MapperConfig.xml";
		
		try {
			Reader inputStream = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UsrMapper mapper = sqlSession.getMapper(UsrMapper.class);
			List<Usr> usrs = mapper.selectByExample(null);
			
			for (Usr usr : usrs) {
				System.out.println(usr);
			}
			ShipperMapper mapper1 = sqlSession.getMapper(ShipperMapper.class);
			List<Shipper> shippers = mapper1.selectByExample(null);
			
			for (Shipper shipper : shippers) {
				System.out.println(shipper);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
