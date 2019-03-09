package com.yashi.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;

import com.yashi.bean.Shipwreck;


@Repository("repo")
public class ShipwreckRepoImpl implements IShipwreckRepo {
	static Map<Long, Shipwreck> wrecks = new HashMap<Long, Shipwreck>();
	long index = 3L;
	static {
		Shipwreck a = new Shipwreck(1L, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994);
		wrecks.put(1L, a);
		Shipwreck b = new Shipwreck(2L, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12,
				138.44, 1994);
		wrecks.put(2L, b);
		Shipwreck c = new Shipwreck(3L, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef",
				"FAIR", 50, 44.12, 138.44, 1994);
		wrecks.put(3L, c);
	}

	@PersistenceContext
	EntityManager entity;
	EntityTransaction trans;


	public EntityTransaction getTrans() {
		return trans;
	}

	public void setTrans(EntityTransaction trans) {
		this.trans = trans;
	}

	public EntityManager getEntity() {
		return entity;
	}

	public void setEntity(EntityManager entity) {
		this.entity = entity;
	}

	@Override
	public Shipwreck create(Shipwreck wreck) {
		index++;
		wrecks.put(index, wreck);
		trans.begin();
		entity.persist(wreck);
		entity.flush();
		trans.commit();
		return wreck;
	}

	@Override
	public Shipwreck get(Long id) {
		Shipwreck wreck = entity.find(Shipwreck.class, id);
		if (wreck == null)
			return null;
		else
			return wreck;
	}

	@Override
	public Shipwreck update(Long id, Shipwreck wreck) {
		wreck = entity.find(Shipwreck.class, id);
		trans.begin();
		entity.merge(wreck);
		entity.flush();
		trans.commit();
		return wreck;
	}

	@Override
	public Shipwreck delete(Long id) {
		Shipwreck wreck = entity.find(Shipwreck.class, id);
		if (wreck == null)
			return null;
		else {
			trans.begin();
			entity.remove(wreck);
			entity.flush();
			trans.commit();
			return wreck;
		}
	}

	@Override
	public List<Shipwreck> findAll() {
		TypedQuery<Shipwreck> query = (TypedQuery<Shipwreck>) entity.createQuery("select wreck from Shipwreck wreck");
		List<Shipwreck> list = new ArrayList<>();
		list = query.getResultList();
		return list;
	}

	@Override
	public Map<Long, Shipwreck> getList() {

		return wrecks;
	}

}
