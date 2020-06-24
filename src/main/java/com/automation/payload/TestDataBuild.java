package com.automation.payload;

import java.util.ArrayList;
import java.util.List;

import com.automation.pojo.AddPlace;
import com.automation.pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name) {
		AddPlace addPlace = new AddPlace();
		Location location = new Location();
		addPlace.setAccuracy(50);
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setLanguage("French-IN");
		addPlace.setName(name);
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setWebsite("http://google.com");
		List<String> addType = new ArrayList();
		addType.add("shoe park");
		addType.add("shop");
		addPlace.setTypes(addType);
		location.setLat(-38.383494);
		location.setLng(33.427361);
		addPlace.setLocation(location);
		return addPlace;
	}
}
