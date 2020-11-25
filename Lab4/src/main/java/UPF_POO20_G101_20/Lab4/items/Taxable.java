package UPF_POO20_G101_20.Lab4.items;

public interface Taxable {
	static final double IVA = 0.21;
	
	public double getPrice();

	public double getPriceOnlyTax();

	public double getPricePlusTax();

	public double sumTotalTax( Taxable t );
	
}


