package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.StockClient;

@RestController
@RequestMapping("/calc")
public class StockCalculationRestController {

	@Autowired
	private StockClient client;
	
	@GetMapping("/calculate/{companyName}/{quantity}")
	public ResponseEntity<?>calculate(@PathVariable String companyName, @PathVariable Integer quantity)
	{
		ResponseEntity<?> entity=null;
		Double totalPrice=null;
		System.out.println(companyName+" 33333 "+quantity);

		
		try {
			entity=client.getStockPrice(companyName);
			System.out.println(entity);
			int statuscode=entity.getStatusCodeValue();
			if (statuscode==200) {
				Double companyStockPrice = (Double) entity.getBody(); 
				totalPrice=quantity*companyStockPrice;
				String response = "Total price of your stock is ::"+totalPrice;
				entity=new ResponseEntity<String>(response,HttpStatus.OK);
			}
		} catch (Exception e) {
			entity=new ResponseEntity<String>("Company not found",HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
