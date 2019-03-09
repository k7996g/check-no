package com.yashi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yashi.bean.Shipwreck;
import com.yashi.service.IShipwreckService;

@RestController
public class WreckController {
	@Autowired
	static IShipwreckService service;

	public IShipwreckService getService() {
		return service;
	}

	public void setService(IShipwreckService service) {
		this.service = service;
	}

	@RequestMapping(value = "/createWreck", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public Shipwreck createWreck(@RequestBody Shipwreck wreck) {
		wreck = service.create(wreck);
		return wreck;

	}

	@RequestMapping(value = "/getWreck/{wreckid}", produces = "application/json", method = RequestMethod.POST)
	public Shipwreck getWreck(@PathVariable long wreckid) {
		Shipwreck wreck = service.get(wreckid);
		return wreck;
	}

	@RequestMapping(value = "/updateWreck/{wreckid}", produces = "application/json", method = RequestMethod.POST)
	public Shipwreck updateWreck(@PathVariable long wreckid, Shipwreck wreck) {
		wreck = service.update(wreckid, wreck);
		return wreck;
	}

	@RequestMapping(value = "/deleteWreck/{wreckid}", produces = "application/json", method = RequestMethod.POST)
	public Shipwreck deleteWreck(@PathVariable long wreckid) {
		Shipwreck wreck = service.delete(wreckid);
		return wreck;
	}

	@RequestMapping(value = "/getWreckList", produces = "application/json", method = RequestMethod.GET)
	public List<Shipwreck> getWreckList() {

		return service.findAll();

	}

	@RequestMapping(value = "/getMap", produces = "application/json", method = RequestMethod.GET)
	public Map<Long, Shipwreck> getMap() {
		System.out.println(service.getList());
		return service.getList();
	}
	@RequestMapping(value = "/getWreckLis", produces = "application/json", method = RequestMethod.GET)
	public String getWreckLis() {

		return "Yashi";

	}
}
