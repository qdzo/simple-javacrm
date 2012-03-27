package model;

public class Product {

	private final Integer productId;
	private String nameProduct;
	private long price;
	private int summary;
	private String description;
	
	Product(Integer id){
		this.productId = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		if(validate(nameProduct))
		this.nameProduct = nameProduct;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(String price) {
		if(validateDecimalLong(price))
		this.price = Long.parseLong(price);
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String descriprion) {
		if(validate(description))
		this.description = descriprion;
	}
	

	
	public Integer getProductId() {
		return productId;
	}

	
	public int getSummary() {
		return summary;
	}

	
	public void setSummary(String summary) {
		if(validateDecimal(summary))
		this.summary = Integer.parseInt(summary);
	}
	
	
	public void provideSell(){
		this.summary=-1;
	}
	
	
	public void provideSell(String summToSell){
		if(validateDecimal(summToSell))
		this.summary =Integer.parseInt(summToSell);
	}
	
	
	protected boolean validate(String line){
		if(line.length()==0||(line.trim()).length()==0){
			System.out.println("Required an argument!");
			return false;
		}
		return true;
	}
	
	protected boolean validateDecimal(String dec){
		Integer decimal = null;
		
			try {
				decimal = Integer.parseInt(dec);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(decimal==null){
			System.out.println("Required a right decimal argument!");
			return false;
		}
		return true;
	}
	
	protected boolean validateDecimalLong(String decLong) {
		Long decimalLong = null;
		try {
			decimalLong = Long.parseLong(decLong);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(decimalLong==null){
			System.out.println("Required a right long decimal argument!");
			return false;
		}
		return true;
	}

	
}
