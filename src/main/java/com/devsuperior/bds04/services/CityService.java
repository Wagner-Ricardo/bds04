package com.devsuperior.bds04.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;


@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)
	public List<CityDTO> findAll(){
		List<City> list = cityRepository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}
 
	@Transactional(readOnly = true)
	public CityDTO insert (CityDTO dto) {
		City entity =  new City();
		entity.setName(dto.getName());
		entity.setId(dto.getId());
		entity = cityRepository.save(entity);
		return new CityDTO(entity);
		
		
	}
	
}
