package qa.form.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/product")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	@RequestMapping(method=RequestMethod.POST, value="/product")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

}
