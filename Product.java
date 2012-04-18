package model;

public class Product {

	private final Integer productId;
	private String nameProduct;
	private Long price;
	private Integer summary;
	private String description;
	private ModelStatus modelStatus;
	
	
	public Product(Integer id){
		this.productId = id;
		nameProduct=null;
		price=null;
		summary=null;
		description=null;
		modelStatus= ModelStatus.Null;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		if(validate(nameProduct))
		this.nameProduct = nameProduct;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(String price) {
		if(validateDecimalLong(price))
		this.price = Long.parseLong(price);
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(validate(description))
		this.description = description;
	}
	

	
	public Integer getProductId() {
		return productId;
	}

	
	public Integer getSummary() {
		return summary;
	}

	
	public void setSummary(String summary) {
		if(validateDecimal(summary))
		this.summary = Integer.parseInt(summary);
	}
	
	
	public void sellProduct(){
		this.summary=-1;
	}
	
	
	public void sellProducts(String summToSell){
		if(validateDecimal(summToSell))
		this.summary =Integer.parseInt(summToSell);
	}
	
	
	public static boolean validate(String line){
		if(line==null||(line.trim()).length()==0){
			System.out.println("Required an argument!");
			return false;
		}
		return true;
	}
	
	
	public static boolean validateDecimal(String dec){
		Integer decimal = null;
		
			try {
				decimal = Integer.parseInt(dec);
			} catch (NumberFormatException e) {
				System.out.println("Required a right decimal argument!");
			}
		if(decimal==null){
			return false;
		}
		return true;
	}
	
	
	public static boolean validateDecimalLong(String decLong) {
		Long decimalLong = null;
		try {
			decimalLong = Long.parseLong(decLong);
		} catch (NumberFormatException e) {
			System.out.println("Required a right long decimal argument!");
		}
		if(decimalLong==null){
			return false;
		}
		return true;
	}

	public ModelStatus getModelStatus() {
		return modelStatus;
	}

	public void setModelStatus(ModelStatus modelStatus) {
		this.modelStatus = modelStatus;
	}

	
}
