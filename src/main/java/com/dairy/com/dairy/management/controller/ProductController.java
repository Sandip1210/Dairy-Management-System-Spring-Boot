package com.dairy.com.dairy.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dairy.com.dairy.management.Request.Milkrecord;
import com.dairy.com.dairy.management.entity.DailyMilkRecord;
import com.dairy.com.dairy.management.entity.OrderDetials;
import com.dairy.com.dairy.management.entity.Products;
import com.dairy.com.dairy.management.service.ProductService;

@Controller

public class ProductController {
	@Autowired
	ProductService ps;
	@PostMapping("/addProducts")        
 public String addProduct(@RequestParam("name") String name,
	                                 @RequestParam("qty") int qty,
	                                 @RequestParam("price") int price,
	                                 @RequestParam("description") String description,
	                                 @RequestParam("imgfilename") MultipartFile imgFile,
	                                 RedirectAttributes redirectAttributes) {
	            
	           
	            // Get the original filename of the uploaded image
	            String imageName = imgFile.getOriginalFilename();

	           

	            // Create a Product object and set its fields
	            Products product = new Products();
	            product.setName(name);
	            product.setQty(qty);
	            product.setPrice(price);
	            product.setDescription(description);
	            product.setImgfilename(imageName);  // Store only the image file name

	            // Save the product to the database using the ProductService
	           String message= ps.addProducts(product);
	        
            redirectAttributes.addFlashAttribute("message", message);
	        return "redirect:/allProducts";
	
	}
	
	
	@GetMapping("/allProducts")
	public String getAllProducts(Model model)
	{
			List<Products> li=ps.getAllProducts();
			model.addAttribute("getproduct",li);
			//return "dailyMilkHistory";
			return "viewproduct";
		}
	

@GetMapping("/productPage/{id}")
public String getProductsPage(Model model,@PathVariable int id)
{
		List<Products> li=ps.getAllProducts();
		model.addAttribute("products",li);
		model.addAttribute("uid",id);
		//return "dailyMilkHistory";
		System.out.println(id);
		return "allProducts";
	}

@GetMapping("/orderDetails/{id}/{uid}")
public String orderInfo(@PathVariable int id, @PathVariable int uid) {
    System.out.println("Product ID: " + id);
    System.out.println("User ID: " + uid);
    return "OrderDetails";
}


@GetMapping("/products/order")
public String getProPage() {
	return "OrderDetails";
}
@PostMapping("/products/order")
public String placeOrder(@ModelAttribute OrderDetials od,Model model,RedirectAttributes redirectAttributes)
{  
	
	
	try{
		System.out.println(od);
	String mess=ps.placeOrder(od);
	redirectAttributes.addFlashAttribute(mess);
	
	return "redirect:/products/order?success";
}catch(Exception e) {
	redirectAttributes.addFlashAttribute("message", e.getMessage());
	return "redirect:/products/order?error";
}
}

@GetMapping("/orderHistory")
String viewOrderHistory(@ModelAttribute OrderDetials od,Model model) {
	List<OrderDetials> li=ps.OrderHistory();
	model.addAttribute("orderhistory",li);
return "orderHistory";
}
	
	@GetMapping("/orderHistory1")
	String viewOrderHistory1(@ModelAttribute OrderDetials od,Model model) {
		List<OrderDetials> li=ps.OrderHistory();
		model.addAttribute("orderhistory",li);
		return "UserOrderHistory";
}
@GetMapping("/acceptOrder/{oid}")
String acceptwOrder(@PathVariable int oid) {
	ps.accpetOrder( oid);	
	return"redirect:/orderHistory";

}

}
	
	

