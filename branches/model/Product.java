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

	public void setPrice(long price) {
		if(validateDecimalLong(price))
		this.price = price;
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

	
	public void setSummary(int summary) {
		if(validateDecimal(summary))
		this.summary = summary;
	}
	
	
	public void provideSell(){
		this.summary=-1;
	}
	
	
	public void provideSell(int summToSell){
		if(validateDecimal(summToSell))
		this.summary = summToSell;
	}
	
	
	protected boolean validate(String line){
		if(line.length()==0||line==null){
			System.out.println("Required an argument!");
			return false;
		}
		return true;
	}
	
	protected boolean validateDecimal(int dec){
		if(dec==-1||dec==0){
			System.out.println("Required a right decimal argument!");
			return false;
		}
		return true;
	}
	
	private boolean validateDecimalLong(long decLong) {
		if(decLong==-1||decLong==0){
			System.out.println("Required a right long decimal argument!");
			return false;
		}
		return true;
	}

	
}
