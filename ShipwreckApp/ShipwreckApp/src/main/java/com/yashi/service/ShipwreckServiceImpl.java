package com.yashi.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashi.bean.Shipwreck;
import com.yashi.repo.IShipwreckRepo;

@Transactional
@Service("service")
public class ShipwreckServiceImpl implements IShipwreckService {
	@Autowired
	IShipwreckRepo repo;

	public IShipwreckRepo getRepo() {
		return repo;
	}

	public void setRepo(IShipwreckRepo repo) {
		this.repo = repo;
	}

	@Override
	public Shipwreck create(Shipwreck wreck) {

		return repo.create(wreck);
	}

	@Override
	public Shipwreck get(Long id) {

		return repo.get(id);
	}

	@Override
	public Shipwreck update(Long id, Shipwreck wreck) {

		return repo.update(id, wreck);
	}

	@Override
	public Shipwreck delete(Long id) {

		return repo.delete(id);
	}

	@Override
	public List<Shipwreck> findAll() {

		return repo.findAll();
	}

	@Override
	public Map<Long, Shipwreck> getList() {
		
		return repo.getList();
	}

}
