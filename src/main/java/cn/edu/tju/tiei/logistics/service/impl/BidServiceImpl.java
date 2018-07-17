package cn.edu.tju.tiei.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.logistics.dao.BidMapper;
import cn.edu.tju.tiei.logistics.model.Bid;
import cn.edu.tju.tiei.logistics.service.IBidService;

@Service("bidService")
public class BidServiceImpl implements IBidService {

	@Resource
	private BidMapper bidMapper;

	public BidMapper getBidMapper() {
		return bidMapper;
	}

	@Autowired
	public void setBidMapper(BidMapper bidMapper) {
		this.bidMapper = bidMapper;
	}

	public List<Bid> findAll() {
		return bidMapper.selectByExample(null);
	}

	public Bid findById(Integer id) {
		return bidMapper.selectByPrimaryKey(id);
	}

	public void create(Bid bid) {
		bidMapper.insert(bid);
	}

	public boolean isExist(Bid bid) {
		return bidMapper.selectByPrimaryKey(bid.getId()) != null;
	}

	public void update(Bid bid) {
		bidMapper.updateByPrimaryKey(bid);
	}

	public void deleteById(Integer id) {
		bidMapper.deleteByPrimaryKey(id);
	}
	public void deleteAll() {
		bidMapper.deleteByExample(null);
	}

}
