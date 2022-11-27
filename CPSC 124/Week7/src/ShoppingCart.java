import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Product> cart = new ArrayList<Product>(); 
	//Same as Product[] cart = new Product[100], 
	//but arraylist allows variable size instead of fixed size like array
	
	public void addToCart(Product p) {
		cart.add(p);
	}
	
	public void checkOut() {
		double total = 0;
		//How to add all product's price in the cart?
		for (int i = 0 ; i < cart.size(); i++) { //ArrayList .size() is the equivalent of array's .length
			 
			total = cart.get(i).getPrice() + total;   //ArrayList .get(i) gets the element at index i, similar to array's nums[i]
			
			
		}
		
		
		System.out.println("Your total is + "+total);
	}
}
