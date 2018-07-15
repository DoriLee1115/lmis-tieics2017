package cn.edu.tju.tiei.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.logistics.dao.WaybillMapper;
import cn.edu.tju.tiei.logistics.model.Waybill;
import cn.edu.tju.tiei.logistics.service.IWaybillService;

@Service("waybillService")
public class WaybillServiceImpl implements IWaybillService {

	@Resource
	private WaybillMapper waybillMapper;

	public WaybillMapper getWaybillMapper() {
		return waybillMapper;
	}

	@Autowired
	public void setWaybillMapper(WaybillMapper waybillMapper) {
		this.waybillMapper = waybillMapper;
	}

	public List<Waybill> findAll() {
		return waybillMapper.selectByExample(null);
	}

	public Waybill findById(String id) {
		return waybillMapper.selectByPrimaryKey(id);
	}

	public void create(Waybill waybill) {
		waybillMapper.insert(waybill);
	}

	public boolean isExist(Waybill waybill) {
		return waybillMapper.selectByPrimaryKey(waybill.getId()) != null;
	}

	public void update(Waybill waybill) {
		waybillMapper.updateByPrimaryKey(waybill);
	}

	public void deleteById(String id) {
		waybillMapper.deleteByPrimaryKey(id);
	}

	public void deleteAll() {
		waybillMapper.deleteByExample(null);
	}

}
