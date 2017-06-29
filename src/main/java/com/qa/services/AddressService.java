package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.models.Address;
import com.qa.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public Address findAddressByType(int customerId, String addressType) {
//		Iterable<Address> allAddresses = addressRepository.findAll();
//		for(Address a: allAddresses){
//			if(a.getCustomerId() == customerId && a.getAddressType().equals(addressType)){
//				return a;
//			}
//		}
//		return null;
		return addressRepository.findAddressByType(customerId, addressType);
	}

	public int updateBillingAddress(
	String addressLine1, String addressLine2,
	String city, String postcode,
	String state, String country,
	String phoneNumber, int customerId, String addressType){
//		Iterable<Address> allAddresses = addressRepository.findAll();
//		
//		for(Address a: allAddresses){
//			if(a.getCustomerId() == customerId && a.getAddressType().equals(addressType)){
//				a.setAddressLine1(addressLine1);
//				a.setAddressLine2(addressLine2);
//				a.setCity(city);
//				a.setPostcode(postcode);
//				a.setState(state);
//				a.setCountry(country);
//				a.setPhoneNumber(phoneNumber);
//				if(addressRepository.save(a) != null){
//					return 1;
//				}
//			}
//		}
//		return 0;
		return addressRepository.updateBillingAddress(addressLine1, addressLine2, 
				city, postcode, state, country, phoneNumber, customerId, addressType);
	}
	
	public Address add(Address a){
		return addressRepository.save(a);
//		return null;
	}

}