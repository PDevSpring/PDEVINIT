package com.dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Fourniture;
import com.dari.repository.FournitureRepository;

@Service
public class FournitureServiceImpl implements FournitureService {

	@Autowired
	FournitureRepository fourrep;

	@Override
	public long AddFour(Fourniture f) {
		fourrep.save(f);
		return f.getFournitureId();
	}
	
	@Override
	public void deleteFour (long FournitureId) {
	 	fourrep.deleteById(FournitureId);}
	
	@Override
	public Fourniture findFourniture (long FournitureId) {
		Fourniture four = fourrep.findById(FournitureId).orElse(null);
		return four ;
		}
	
	public List<Fourniture> getallfourniture(){
		List<Fourniture> fours = (List<Fourniture>) fourrep.findAll();
		for(Fourniture f:fours  ) {
			System.out.println(f);
		}
		return fours;
	}
	
	//  --------- ZAYED --------- 
	/*
	public float getfourniturepricebyid(long FournitureId)
	{
		return findFourniture(FournitureId).getPrice();
	}
	
	public FType checkfourstatusbyid (long FournitureId) {
		return findFourniture(FournitureId).getType();
	}
	
	/*
	public void changefourniturestatusbyid (long FournitureId) {
		
		findFourniture(FournitureId).setType(NotDispo);
	}*/
}
