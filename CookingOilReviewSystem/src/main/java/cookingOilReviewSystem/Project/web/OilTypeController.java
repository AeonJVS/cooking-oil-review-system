package cookingOilReviewSystem.Project.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cookingOilReviewSystem.Project.domain.OilType;
import cookingOilReviewSystem.Project.domain.OilTypeRepository;


@CrossOrigin
@Controller
public class OilTypeController {
	@Autowired
	private OilTypeRepository typerepository; 
	
	@RequestMapping(value = "/oiltypelist", method = RequestMethod.GET)
	public @ResponseBody List<OilType> getOiltypeRest() {
		return (List<OilType>) typerepository.findAll();
	}
	
	@RequestMapping(value = "/oiltypelist/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<OilType> findOiltypeRest(@PathVariable("id") Long typeId) {	
		return typerepository.findById(typeId);
	} 
    
	@RequestMapping(value = "/oiltypelist", method = RequestMethod.POST)
	public @ResponseBody OilType saveOiltypeRest(@RequestBody OilType oilType) {	
		return typerepository.save(oilType);
	}
}