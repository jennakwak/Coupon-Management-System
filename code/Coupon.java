package Project_LL;

//create constructor for class Coupon 
public class Coupon {
	String couponProvider;
	String productName;
	public int price;
	public int discountRate;
	public int expPeriod;
	String couponStatus;
	double finalPrice;
	
	public Coupon(String couponProvider, String productName, int price, int discountRate, int expPeriod, String couponStatus) {
		this.couponProvider = couponProvider;
		this.productName = productName;
		this.price = price;
		this.discountRate = discountRate;
		this.expPeriod = expPeriod;
		this.couponStatus = couponStatus;
		this.finalPrice = calculateFinalPrice(price, discountRate);
		}
	
	//create method for final price with discount rate
	private double calculateFinalPrice(int price, int discountRate) {
		return (double)price - ((double)price * (double)discountRate) / 100;
		}
	//if use input 'key'(keyField)' on the menu, compare each
	public int compare(Coupon other, String key) {
		if(other == null) {
			return 1;
			}
		switch (key) {
	      case "couponProvider":
	        return couponProvider.toLowerCase().compareTo(other.couponProvider.toLowerCase());
	      case "productName":
	        return productName.toLowerCase().compareTo(other.productName.toLowerCase());
	      case "price":
	        return Integer.valueOf(price).compareTo(other.price);
	      case "discountRate":
	        return Integer.valueOf(discountRate).compareTo(other.discountRate);
	      case "expPeriod":
	        return Integer.valueOf(expPeriod).compareTo(other.expPeriod);
	      case "finalPrice":
	        return Double.valueOf(finalPrice).compareTo(other.finalPrice);
	      case "couponStatus":
	        return couponStatus.compareTo(other.couponStatus);
	      default:
	        return 0;
	    }
	  }
	//toString method to print the output 
	public String toString() {
		return "Coupon provider: "+couponProvider+", " + "Product name: "+productName+", " + "Original price: $"+price+", " + "Discount rate: "+discountRate+"%, " +"Final price: $"+finalPrice+", "+ "Expiration period: "+expPeriod+"days, " + "Coupon status: "+couponStatus;
		}
	}
