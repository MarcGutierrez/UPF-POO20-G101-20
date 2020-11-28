package UPF_POO20_G101_20.Lab4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import UPF_POO20_G101_20.Lab4.items.AuctionItem;
import UPF_POO20_G101_20.Lab4.items.UnitItem;
import UPF_POO20_G101_20.Lab4.items.WeightedItem;
import UPF_POO20_G101_20.Lab4.packages.Box;
import UPF_POO20_G101_20.Lab4.packages.Envelope;
import UPF_POO20_G101_20.Lab4.users.Admin;
import UPF_POO20_G101_20.Lab4.users.Buyer;
import UPF_POO20_G101_20.Lab4.users.Seller;

public class FullOnlineStore{
	static private List<User> users = new ArrayList<User>();
	static private List<Item> itemsStock = new ArrayList<Item>();
	static private List<Package> packages = new ArrayList<Package>();
	static private List<Sale> sales = new ArrayList<Sale>();
	static private Calendar date;
	static private double benefits = 0; // totalCost
	static private double costs = 0;  // totalPrice
	
	public static void addSale(Item item, Buyer buyer) {
		Sale sale = new Sale(item, buyer, date);
		sales.add(sale);
	}
	
	public static void sell (Item item, Buyer buyer, int number) {
		costs += item.getCost();
		benefits += item.computeProfit();
		buyer.buy(item, number);  // The buy of buyer already calls the sell of seller
		addSale(item, buyer);
	}
	
	public static void updateDate() {
		date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), date.get(Calendar.HOUR_OF_DAY)+1, date.get(Calendar.MINUTE));
		for(int i = 0; i < itemsStock.size(); i++) {
			Item item = itemsStock.get(i);
			if (item instanceof AuctionItem && ((AuctionItem)item).frozen(date)) {
		        sell(item, ((AuctionItem)item).getBuyer(), 1);
		        itemsStock.remove(item);
			}
		}
	}
	
	public static void main( String[] args )
    {
		date = Calendar.getInstance();
		date.set(Calendar.YEAR, 1999);
		date.set(Calendar.MONTH, 7);
		date.set(Calendar.DAY_OF_MONTH, 26);
        
        Buyer u = new Buyer("Jason", "8", "vier13", "477558456");
        Buyer u1 = new Buyer("Ramon", "9", "vfhs3", "47821369");
        Seller s = new Seller("John", "7", "Wick", "444572455");
        Admin a = new Admin("Admin", "0", "afhgfh");
        
		double size[] = {1, 1};
        WeightedItem i = new WeightedItem("Rice", "Food", size, 2, s, 5, 20);
        costs += i.getCost();
        System.out.println(i.getName() + " " + Double.toString(i.getCost()) + " " + i.getType() + " " + Double.toString(i.getPrice()) + " " + i.getStock());
        System.out.println(i.computeProfit() + " " + i.getSize()[0] + " " + i.getSize()[1] + " " + i.getSize()[2]);
        
        double size1[] = {1, 1, 1};
        UnitItem i1 = new UnitItem("Sofa", "Furniture", size1, 2, s, 5, 20);
        costs += i1.getCost();
        System.out.println(i1.getName() + " " + Double.toString(i1.getCost()) + " " + i1.getType() + " " + Double.toString(i1.getPrice()) + " " + i1.getStock());
        System.out.println(i1.computeProfit() + " " +  " " + i1.getSize()[0] + " " + i1.getSize()[1] + " " + i1.getSize()[2]);
        
        double size2[] = {10, 10, 10};
        Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 1999);
		date.set(Calendar.MONTH, 7);
		date.set(Calendar.DAY_OF_MONTH, 27);
        AuctionItem i2 = new AuctionItem("Volvo", "Car", size2, 11960, s, 13000, date);
        costs += i2.getCost();
        System.out.println(i2.computeProfit() + " " + i2.getDeadline() + " " + i2.getName() + " " + i2.getPrice() + " " + i2.getBuyer());
        
        List<AuctionItem> auction = new ArrayList<AuctionItem>();
        auction.add(i2);
        
        Box b = new Box(1, 1, 1);
        Box b1 = new Box(2, 2, 1);
        Box b2 = new Box(10, 10, 10);
        
        Envelope e = new Envelope(1, 1, "A");
        Envelope e1 = new Envelope(2, 2, "B");
        
        s.addAvailableItem(i);
        sell(i, u, 10);
        
        a.expel(u);
        a.manageAuction(i2, Calendar.getInstance());
        a.printStock(auction);
        
        packages.add(b);
        packages.add(b1);
        packages.add(b2);
        packages.add(e);
        packages.add(e1);
        
        i.assignBestPackage(packages);
        i1.assignBestPackage(packages);
        i2.assignBestPackage(packages);

        itemsStock.add(i);
        itemsStock.add(i1);
        itemsStock.add(i2);
        
        users.add(u);
        users.add(u1);
        users.add(s);
        users.add(a);
        
        for (int idx = 0; idx < 30; idx++) {
        	updateDate();
        }
        
        benefits += i.computeProfit() + i1.computeProfit() + i2.computeProfit();
        
        System.out.println(costs + " " + benefits);
    }
}