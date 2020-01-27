package net.store.modelView;


public class ProductModelView {

	private int productId;
	private String productName;
	private double productPrice;
	private int quantity;
	private String productDesc;
	private int catgId;
	private String  catgName;
	private String catgDesc;
	private  byte [] productPreview;
	private int nbImages;
	private int nbOrders;
	
	
	
	
	public int getNbOrders() {
		return nbOrders;
	}
	public void setNbOrders(int nbOrders) {
		this.nbOrders = nbOrders;
	}
	public int getNbImages() {
		return nbImages;
	}
	public void setNbImages(int nbImages) {
		this.nbImages = nbImages;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getCatgId() {
		return catgId;
	}
	public void setCatgId(int catgId) {
		this.catgId = catgId;
	}
	public String getCatgName() {
		return catgName;
	}
	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}
	public String getCatgDesc() {
		return catgDesc;
	}
	public void setCatgDesc(String catgDesc) {
		this.catgDesc = catgDesc;
	}
	public byte[] getProductPreview() {
		return productPreview;
	}
	public void setProductPreview(byte[] productPreview) {
		this.productPreview = productPreview;
	}
	
	
	
	
}
