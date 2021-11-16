package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.models.GroceryItem;
import com.example.demo.repository.CustomItemRepository;
import com.example.demo.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableMongoRepositories
public class DemoApplication {

	@Autowired
	ItemRepository groceryItemRepo;

	@Autowired
	CustomItemRepository customRepo;

	List<GroceryItem> itemList = new ArrayList<GroceryItem>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/create")
	public String createItem(@RequestParam(value = "name", defaultValue = "apple") String name,
			@RequestParam(value = "quantity", defaultValue = "1") int quantity,
			@RequestParam(value = "category", defaultValue = "fruits") String category) {
		groceryItemRepo.save(new GroceryItem(String.valueOf(Math.random()), name, quantity, category));
		return String.format("Added %s %s with count %d", category, name, quantity);
	}

	@GetMapping("/get")
	public String showAllGroceryItems() {

		itemList = groceryItemRepo.findAll();
		return itemList.stream().map(item -> getItemDetails(item)).collect(Collectors.joining("\n"));
	}

	// 2. Get item by name
	public void getGroceryItemByName(String name) {
		System.out.println("Getting item by name: " + name);
		GroceryItem item = groceryItemRepo.findItemByName(name);
		System.out.println(getItemDetails(item));
	}

	// 3. Get name and items of a all items of a particular category
	public void getItemsByCategory(String category) {
		System.out.println("Getting items for the category " + category);
		List<GroceryItem> list = groceryItemRepo.findAll(category);

		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getItemQuantity()));
	}

	// 4. Get count of documents in the collection
	public void findCountOfGroceryItems() {
		long count = groceryItemRepo.count();
		System.out.println("Number of documents in the collection = " + count);
	}

	// UPDATE APPROACH 1: Using MongoRepository
	public void updateCategoryName(String category) {

		// Change to this new value
		String newCategory = "munchies";

		// Find all the items with the category
		List<GroceryItem> list = groceryItemRepo.findAll(category);

		list.forEach(item -> {
			// Update the category in each document
			item.setCategory(newCategory);
		});

		// Save all the items in database
		List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);

		if (itemsUpdated != null)
			System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
	}

	// UPDATE APPROACH 2: Using MongoTemplate
	public void updateItemQuantity(String name, float newQuantity) {
		System.out.println("Updating quantity for " + name);
		customRepo.updateItemQuantity(name, newQuantity);
	}

	// DELETE
	public void deleteGroceryItem(String id) {
		groceryItemRepo.deleteById(id);
		System.out.println("Item with id " + id + " deleted...");
	}
	// Print details in readable form

	public String getItemDetails(GroceryItem item) {

		return String.valueOf("Item Name: " + item.getName() + ", \nItem Quantity: " + item.getItemQuantity()
				+ ", \nItem Category: " + item.getCategory());
	}
}
