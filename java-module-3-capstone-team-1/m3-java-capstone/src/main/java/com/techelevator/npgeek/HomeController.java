package com.techelevator.npgeek;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;
import com.techelevator.model.Weather;
import com.techelevator.model.WeatherDAO;

@SessionAttributes({ "parkCode", "tempChoice" })
@Controller
public class HomeController {

	@Autowired
	ParkDAO parkDAO;
	@Autowired
	WeatherDAO weatherDAO;

	@RequestMapping(path = { "/", "/homePage" })
	public String displayParksPage(ModelMap map) {
		List<Park> parks = parkDAO.getAllParks();
		map.addAttribute("tempChoice", true);

		map.put("parks", parks);
		return "homePage";
	}

	@RequestMapping(path = "/parkDetail", method = RequestMethod.GET)
	public String displayParkDetail(@RequestParam String parkCode, ModelMap modelHolder) {
		Park parkDetail = parkDAO.getAPark(parkCode);
		List<Weather> weather = weatherDAO.getAllWeather(parkCode);
		boolean tempChoice = (boolean)modelHolder.get("tempChoice");
		if(tempChoice == false) { //must be celsius
			for(Weather w :weather) {
				w.setHigh(Weather.convertToCelsius(w.getHigh()));
			}
		}
		modelHolder.put("details", parkDetail);
		modelHolder.put("allWeather", weather);
		modelHolder.addAttribute("parkCode", parkCode);
		return "/parkDetail";
	}

	@RequestMapping(path = "/parkDetail", method = RequestMethod.POST)
	public String processPersonalInformationInput(ModelMap modelHolder, @RequestParam boolean degrees) {
		modelHolder.addAttribute("tempChoice", degrees);

		return "redirect:/parkDetail";
	}

}
