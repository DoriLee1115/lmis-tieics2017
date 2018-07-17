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
import cn.edu.tju.tiei.logistics.dao.CarrierMapper;
import cn.edu.tju.tiei.logistics.model.Carrier;
import cn.edu.tju.tiei.logistics.dao.WaybillMapper;
import cn.edu.tju.tiei.logistics.model.Waybill;
import cn.edu.tju.tiei.logistics.dao.BidMapper;
import cn.edu.tju.tiei.logistics.model.Bid;

public class Main {

	public static void main(String[] args) {
		
		String resource = "MapperConfig.xml";
		
		try {
			Reader inputStream = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UsrMapper usrmapper = sqlSession.getMapper(UsrMapper.class);
			List<Usr> usrs = usrmapper.selectByExample(null);
			
			for (Usr usr : usrs) {
				System.out.println(usr);
			}
			ShipperMapper shippermapper = sqlSession.getMapper(ShipperMapper.class);
			List<Shipper> shippers = shippermapper.selectByExample(null);
			
			for (Shipper shipper : shippers) {
				System.out.println(shipper);
			}
			CarrierMapper carriermapper = sqlSession.getMapper(CarrierMapper.class);
			List<Carrier> carriers = carriermapper.selectByExample(null);
			
			for (Carrier carrier : carriers) {
				System.out.println(carrier);
			}
			WaybillMapper waybillmapper = sqlSession.getMapper(WaybillMapper.class);
			List<Waybill> waybills = waybillmapper.selectByExample(null);
			
			for (Waybill waybill : waybills) {
				System.out.println(waybill);
			}
			BidMapper bidmapper = sqlSession.getMapper(BidMapper.class);
			List<Bid> bids = bidmapper.selectByExample(null);
			
			for (Bid bid : bids) {
				System.out.println(bid);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
