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
		return addressRepository.findAddressByType(customerId, addressType);
	}

	public int updateBillingAddress(String addressLine1, String addressLine2, String city, String postcode,
			String state, String country, String phoneNumber, int customerId, String addressType) {

		return addressRepository.updateBillingAddress(addressLine1, addressLine2, city, postcode, state, country,
				phoneNumber, customerId, addressType);
	}

	public Address add(Address a) {
		return addressRepository.save(a);
	}

}