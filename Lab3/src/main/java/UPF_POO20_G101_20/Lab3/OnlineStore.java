package UPF_POO20_G101_20.Lab3;

import java.util.ArrayList;
import java.util.List;

import UPF_POO20_G101_20.Lab3.items.AuctionItem;
import UPF_POO20_G101_20.Lab3.items.UnitItem;
import UPF_POO20_G101_20.Lab3.items.WeightedItem;
import UPF_POO20_G101_20.Lab3.packages.Box;
import UPF_POO20_G101_20.Lab3.packages.Envelope;
import UPF_POO20_G101_20.Lab3.users.Admin;
import UPF_POO20_G101_20.Lab3.users.Buyer;
import UPF_POO20_G101_20.Lab3.users.Seller;

public class OnlineStore{
	private List<User> users = new ArrayList<User>();
	private List<Item> itemsStock = new ArrayList<Item>();
	private List<Package> packages = new ArrayList<Package>();
	private double benefits = 0; // totalCost
	private double costs = 0;  // totalPrice
	
	public static void main( String[] args )
    {
		OnlineStore store = new OnlineStore();
        
        Buyer u = new Buyer("Jason", "8", "vier13", "477558456");
        Buyer u1 = new Buyer("Ramon", "9", "vfhs3", "47821369");
        Seller s = new Seller("John", "7", "Wick", "444572455");
        Admin a = new Admin("Admin", "0", "afhgfh");
        
        
		double size[] = {1, 1};
        WeightedItem i = new WeightedItem("Rice", "Food", size, 2, s, 5, 20);
        store.costs += i.getCost();
        System.out.println(i.getName() + " " + Double.toString(i.getCost()) + " " + i.getType() + " " + Double.toString(i.getPrice()) + " " + i.getStock());
        System.out.println(i.computeProfit() + " " + i.getSize()[0] + " " + i.getSize()[1] + " " + i.getSize()[2]);
        
        double size1[] = {1, 1, 1};
        UnitItem i1 = new UnitItem("Sofa", "Furniture", size1, 2, s, 5, 20);
        store.costs += i1.getCost();
        System.out.println(i1.getName() + " " + Double.toString(i1.getCost()) + " " + i1.getType() + " " + Double.toString(i1.getPrice()) + " " + i1.getStock());
        System.out.println(i1.computeProfit() + " " +  " " + i1.getSize()[0] + " " + i1.getSize()[1] + " " + i1.getSize()[2]);
        
        double size2[] = {10, 10, 10};
        AuctionItem i2 = new AuctionItem("Volvo", "Car", size2, 11960, s, 13000, "20171010");
        store.costs += i2.getCost();
        System.out.println(i2.computeProfit() + " " + i2.getDeadline() + " " + i2.getName() + " " + i2.getPrice() + " " + i2.getBuyer());
        
        List<AuctionItem> auction = new ArrayList<AuctionItem>();
        auction.add(i2);
        
        Box b = new Box(1, 1, 1);
        Box b1 = new Box(2, 2, 1);
        Box b2 = new Box(10, 10, 10);
        
        Envelope e = new Envelope(1, 1, "A");
        Envelope e1 = new Envelope(2, 2, "B");
        
        s.addAvailableItem(i);
        u.buy(i, 10);
        s.sell(i);
        
        a.expel(u);
        a.manageAuction(i2, "20171009");
        a.printStock(auction);
        
        store.packages.add(b);
        store.packages.add(b1);
        store.packages.add(b2);
        store.packages.add(e);
        store.packages.add(e1);
        
        i.assignBestPackage(store.packages);
        i1.assignBestPackage(store.packages);
        i2.assignBestPackage(store.packages);

        store.itemsStock.add(i);
        store.itemsStock.add(i1);
        store.itemsStock.add(i2);
        
        store.users.add(u);
        store.users.add(u1);
        store.users.add(s);
        store.users.add(a);
        
        u.buy(i2, 1);
        i2.makeBid(u, 11025, "20170110");
        i2.makeBid(u1, 114450, "20170312");
        i2.makeBid(u, 114455, "20171010");
        
        store.benefits += i.computeProfit() + i1.computeProfit() + i2.computeProfit();
        
        System.out.println(store.costs + " " + store.benefits);
    }
}