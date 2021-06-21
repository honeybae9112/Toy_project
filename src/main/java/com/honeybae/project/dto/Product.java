package com.honeybae.project.dto;

public class Product {
	
	private String productId;
	private String brand;
	private boolean collaborationYn;
	private String collaborationBrand;
	private String type;
	private String model;
	private String name;
	private String color;
	private int price;
	private int size;
	private int quantity;
	private String description;
	private String inMaterial;
	private String outMaterial;
	private float realSizeLength;
	private float realSizeWidth;
	private float weight;
	private boolean usedYn;
	private String releaseDate;
	private boolean retroYn;
	private String writer;
	private String writeTime;
	private String updateTime;
	private boolean soldoutYn;
	private boolean deleteYn;
	private int readCount;
	
	public Product() {
	}
	public Product(String productId, String brand, boolean collaborationYn, String collaborationBrand, String type,
			String model, String name, String color, int price, int size, int quantity, String description,
			String inMaterial, String outMaterial, float realSizeLength, float realSizeWidth, float weight,
			boolean usedYn, String releaseDate, boolean retroYn, String writer, String writeTime, String updateTime,
			boolean soldoutYn, boolean deleteYn, int readCount) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.collaborationYn = collaborationYn;
		this.collaborationBrand = collaborationBrand;
		this.type = type;
		this.model = model;
		this.name = name;
		this.color = color;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
		this.description = description;
		this.inMaterial = inMaterial;
		this.outMaterial = outMaterial;
		this.realSizeLength = realSizeLength;
		this.realSizeWidth = realSizeWidth;
		this.weight = weight;
		this.usedYn = usedYn;
		this.releaseDate = releaseDate;
		this.retroYn = retroYn;
		this.writer = writer;
		this.writeTime = writeTime;
		this.updateTime = updateTime;
		this.soldoutYn = soldoutYn;
		this.deleteYn = deleteYn;
		this.readCount = readCount;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isCollaborationYn() {
		return collaborationYn;
	}
	public void setCollaborationYn(boolean collaborationYn) {
		this.collaborationYn = collaborationYn;
	}
	public String getCollaborationBrand() {
		return collaborationBrand;
	}
	public void setCollaborationBrand(String collaborationBrand) {
		this.collaborationBrand = collaborationBrand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInMaterial() {
		return inMaterial;
	}
	public void setInMaterial(String inMaterial) {
		this.inMaterial = inMaterial;
	}
	public String getOutMaterial() {
		return outMaterial;
	}
	public void setOutMaterial(String outMaterial) {
		this.outMaterial = outMaterial;
	}
	public float getRealSizeLength() {
		return realSizeLength;
	}
	public void setRealSizeLength(float realSizeLength) {
		this.realSizeLength = realSizeLength;
	}
	public float getRealSizeWidth() {
		return realSizeWidth;
	}
	public void setRealSizeWidth(float realSizeWidth) {
		this.realSizeWidth = realSizeWidth;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public boolean isUsedYn() {
		return usedYn;
	}
	public void setUsedYn(boolean usedYn) {
		this.usedYn = usedYn;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isRetroYn() {
		return retroYn;
	}
	public void setRetroYn(boolean retroYn) {
		this.retroYn = retroYn;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isSoldoutYn() {
		return soldoutYn;
	}
	public void setSoldoutYn(boolean soldoutYn) {
		this.soldoutYn = soldoutYn;
	}
	public boolean isDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(boolean deleteYn) {
		this.deleteYn = deleteYn;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", brand=" + brand + ", collaborationYn=" + collaborationYn
				+ ", collaborationBrand=" + collaborationBrand + ", type=" + type + ", model=" + model + ", name="
				+ name + ", color=" + color + ", price=" + price + ", size=" + size + ", quantity=" + quantity
				+ ", description=" + description + ", inMaterial=" + inMaterial + ", outMaterial=" + outMaterial
				+ ", realSizeLength=" + realSizeLength + ", realSizeWidth=" + realSizeWidth + ", weight=" + weight
				+ ", usedYn=" + usedYn + ", releaseDate=" + releaseDate + ", retroYn=" + retroYn + ", writer=" + writer
				+ ", writeTime=" + writeTime + ", updateTime=" + updateTime + ", soldoutYn=" + soldoutYn + ", deleteYn="
				+ deleteYn + ", readCount=" + readCount + "]";
	}

	
	
}
