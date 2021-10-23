package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Recipe;
import backend.repo.RecipeRepo;

import org.json.JSONException;
import org.json.JSONObject;

@RestController
public class RecipeController {
	
	@Autowired
	RecipeRepo recipeRepo;
	
	@GetMapping("/")
	public List<Recipe> getRecipes()
	{
		return recipeRepo.findAll();
	}
	
	@PostMapping("/")
	public void addRecipe(@RequestBody Recipe recipe)
	{
		recipeRepo.save(recipe);
	}
	
	@GetMapping("/{id}")
	public JSONObject getById(@PathVariable int id) throws JSONException
	{
		Recipe recipe = recipeRepo.findById(id).get();
		JSONObject json = new JSONObject(recipe); // Convert text to object
		System.out.println(json.toString(4)); // Print it with specified indentation
		return json;
	}
	
	@GetMapping("/{id}/show")
	public String getImage(@PathVariable int id)
	{
		return recipeRepo.getById(id).getImage();
	}
}
