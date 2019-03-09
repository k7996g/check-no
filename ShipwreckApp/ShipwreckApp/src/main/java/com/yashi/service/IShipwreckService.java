package com.yashi.service;

import java.util.List;
import java.util.Map;

import com.yashi.bean.Shipwreck;

public interface IShipwreckService {

	Shipwreck create(Shipwreck wreck);

	Shipwreck get(Long id);

	Shipwreck update(Long id, Shipwreck wreck);

	Shipwreck delete(Long id);

	List<Shipwreck> findAll();

	Map<Long, Shipwreck> getList();
}
