package Project_LL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_LL {
	public static void main(String[] args) throws FileNotFoundException {
		CouponLL CouponLinkedList = new CouponLL(20);
		BST bst = new BST();
		
		//file reader
		File f = new File(new File("coupon list.txt").getAbsolutePath());
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			String[] fileRow = s.nextLine().split(" ");
			String couponProvider = fileRow[0];
			String productName = fileRow[1];
			int price = Integer.parseInt(fileRow[2]);
			int discountRate = Integer.parseInt(fileRow[3]);
			int expPeriod = Integer.parseInt(fileRow[4]);
			String couponStatus = fileRow[5];

			Coupon couponList = new Coupon(couponProvider, productName, price, discountRate, expPeriod, couponStatus);  
			CouponLinkedList.add(couponList); // create unsorted list
			bst.insert(couponList); // put the list in Binary search tree
			}
		
		
		//Initial screen that user will see
		System.out.println("!!!Coupon inventory System!!!");
		System.out.println("***Available products: SkinToner, FaceCleanser, FaceOil, Lipstick, YoutubePremier, Hotdogs, HairBleach, HairDye");
		System.out.println("***Type of criteria: couponProvider, productName, price, discountRate, finalPrice, expPeriod, couponStatus");
		
		System.out.println("");
		
		//purchase coupon function
		//user input(new data) goes into linked list
		System.out.println("Add more coupon data. \n(IN ORDER: Name of Coupon provider, Product name, Original price, Discount rate, Expiration period, Coupon status)");
		Scanner data = new Scanner(System.in);	
		String moreData = data.nextLine();
		String[] fileRow = moreData.split(" ");
		
		String couponProvider = fileRow[0];
		String productName = fileRow[1];
		int price = Integer.parseInt(fileRow[2]);
		int discountRate = Integer.parseInt(fileRow[3]);
		int expPeriod = Integer.parseInt(fileRow[4]);
		String couponStatus = fileRow[5];
		
		//new linkedlist and BST after user input
		Coupon couponList = new Coupon(couponProvider, productName, price, discountRate, expPeriod, couponStatus);  
		CouponLinkedList.add(couponList);
		bst.insert(couponList);
		
		System.out.println("");
		System.out.println("[Unsorted List of Coupons]");
		System.out.println(CouponLinkedList);
			
		//create sorted list by key field that user chose
		System.out.println("Enter the key field to make sorted list of the coupons");
		Scanner n = new Scanner(System.in);
		String keyField = n.nextLine();
		CouponLinkedList.sort(keyField);
		
		
		System.out.println();
		
		//search coupon function
		System.out.println("-------Search 'Coupon of product' -------");
		System.out.println("Enter 1 available products listed above to search the coupon of the product");
		
		
		Scanner input = new Scanner(System.in);
		String enterProduct = input.nextLine();
		
		
		//search coupon by BST
		SearchNode searchedNode = bst.search(enterProduct);
	    if (searchedNode.found) {
	      System.out.println(String.format("The coupon is found in %dth by BST", searchedNode.foundIndex));
	    } else {
	      System.out.println(String.format("No coupon is found - %dth by BST", searchedNode.foundIndex));
	    }
		//search coupon by Linear Search
	    SearchNode searchedNodeLL = CouponLinkedList.search(enterProduct);
	    if (searchedNodeLL.found) {
	      System.out.println(String.format("The coupon is found in %dth by Linear Search", searchedNodeLL.foundIndex));
	    } else {
	      System.out.println(String.format("No coupon is found - %dth by Linear Search", searchedNodeLL.foundIndex));
	    }
		
	    System.out.println("Check for the Coupon details below:");
	    System.out.println(searchedNodeLL.coupon); 
	    
	    
	    System.out.println();
	    
	    //list coupon function
	    System.out.println("-------View the 'List of Coupons'-------");
	    System.out.println("By what key field do you want to view the list of coupons? Enter 1 key field from the list above:");
	    Scanner a = new Scanner(System.in);
	    String listCoupons = a.nextLine();
	    CouponLinkedList.sort(listCoupons);
	    System.out.println(CouponLinkedList);
	}
}
