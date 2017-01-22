package gui;

import java.awt.GridBagConstraints;

import core.InformationManager;
import gui.display.DisplayContainer;
import gui.listeners.LocationAvailability;
import gui.listeners.WeatherListener;
import gui.search.SearchContainer;
import gui.utilities.GridBagContainer;

@SuppressWarnings("serial")
public class ContentPane extends GridBagContainer {
	private final static int CENTER = GridBagConstraints.CENTER;
	private final static int HORIZONTAL = GridBagConstraints.HORIZONTAL;
	private final static int BOTH = GridBagConstraints.BOTH;
	private final static int NORTH = GridBagConstraints.NORTH;

	@Override
	public void addComponents() {
		addSearch();
		addDisplay();
	//	addLocationChoiceListener();
		addLocationAvailability();
		addWeatherListener("todayMeteo", InformationManager.OGGI);
		addWeatherListener("tomorrowMeteo", InformationManager.DOMANI);
	}

	private void addSearch() {
		SearchContainer searchC = new SearchContainer();
		lim.setPosition(0, 0);
		lim.setFillAndAnchor(HORIZONTAL, NORTH);
		lim.setGridCellDimension(1, 1);
		getChildActiveComponents(searchC.getActiveComponents());
		this.add(searchC, lim);
	}

	private void addDisplay() {
		DisplayContainer displayC = new DisplayContainer();
		lim.setPosition(1, 0);
		lim.setInsets(10, 10, 10, 10);
		lim.setFillAndAnchor(BOTH, CENTER);
		lim.setGridCellDimension(1, 1);
		getChildActiveComponents(displayC.getActiveComponents());
		this.add(displayC, lim);
	}
	
//	private void addLocationChoiceListener(){
//		LocationChoiceListener sl = new LocationChoiceListener(activeComponents.getButton("search"),
//								activeComponents.getTextField("searchBox"),
//								activeComponents.getTextArea("display"));
//
//		activeComponents.getButton("search").addActionListener(sl);
//	}
	
	private void addLocationAvailability(){
		LocationAvailability la = new LocationAvailability(activeComponents);
		activeComponents.getTextField("searchBox").addCaretListener(la);
	}
	
	private void addWeatherListener(String buttonName, int dayID){
		WeatherListener twl = new WeatherListener(activeComponents, dayID);
		activeComponents.getRadioButton(buttonName).addActionListener(twl);
	}
	

}
