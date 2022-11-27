
public class Week7Main {

	public static void main(String[] args) {
		Product p1 = new Product();
		p1.title = "Shirt";
		p1.setPrice(16.99);
		
		System.out.println(p1.title + ": $" + p1.getPrice());
		
		Product p2 = new Product();
		p2.title = "Jeans";
		p2.setPrice(36.99);
		
		ShoppingCart sc = new ShoppingCart();
		sc.addToCart(p1);
		sc.addToCart(p2);
		
		sc.checkOut();
	}
	
}
