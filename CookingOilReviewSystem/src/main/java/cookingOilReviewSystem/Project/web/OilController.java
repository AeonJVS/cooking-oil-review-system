package cookingOilReviewSystem.Project.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cookingOilReviewSystem.Project.domain.Oil;
import cookingOilReviewSystem.Project.domain.OilRepository;
import cookingOilReviewSystem.Project.domain.OilTypeRepository;

@CrossOrigin
@Controller
public class OilController {
	@Autowired
	private OilRepository oilrepository;
	@Autowired
	private OilTypeRepository typerepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
    // list cooking oils
	@RequestMapping(value = "/listoils", method = RequestMethod.GET)
	public String listOils(Model model) {
		model.addAttribute("oils", oilrepository.findAll());
		return "listoils";
	}
	
	// RESTful service to get all cooking oils
    @RequestMapping(value="/oils", method = RequestMethod.GET)
    public @ResponseBody List<Oil> oilListRest() {	
        return (List<Oil>) oilrepository.findAll();
    }    

	// RESTful service to get cooking oil by id
    @RequestMapping(value="/oils/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Oil> findOilRest(@PathVariable("id") Long oilId) {	
    	return oilrepository.findById(oilId);
    }      
    
    // RESTful service to save new cooking oil
    @RequestMapping(value="/oils", method = RequestMethod.POST)
    public @ResponseBody Oil saveOilRest(@RequestBody Oil oil) {	
    	return oilrepository.save(oil);
    }
	
    @RequestMapping(value = "/add")
    public String addOil(Model model){
    	model.addAttribute("oil", new Oil());
    	model.addAttribute("oilTypes", typerepository.findAll());
        return "addoil";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Oil oil){
    	System.out.println(oil);
    	oilrepository.save(oil);
        return "redirect:listoils";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOil(@PathVariable("id") Long oilId, Model model) {
    	oilrepository.deleteById(oilId);
        return "redirect:../listoils";
    }    
    
    @RequestMapping(value = "/edit/{id}")
    public String editOil(@PathVariable("id") Long oilId, Model model) {
    	model.addAttribute("oil", oilrepository.findById(oilId));
    	model.addAttribute("oilTypes", typerepository.findAll());
    	return "editoil";
    }
}
