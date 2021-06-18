package com.honeybae.project.dto;

public class Product {
	
	private String productNo;
	private String brand;
	private String collaborationYn;
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
	private String usedYn;
	private String releaseDate;
	private String retroYn;
	private String writer;
	private String writeTime;
	private String updateTime;
	private String soldoutYn;
	private String deleteYn;
	private int readCount;
	
	
	public Product() {
		super();
	}
	



	public Product(String productNo, String brand, String collaborationYn, String collaborationBrand, String type,
			String model, String name, String color, int price, int size, int quantity, String description,
			String inMaterial, String outMaterial, float realSizeLength, float realSizeWidth, float weight,
			String usedYn, String releaseDate, String retroYn, String writer, String writeTime, String updateTime,
			String soldoutYn, String deleteYn, int readCount) {
		super();
		this.productNo = productNo;
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




	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getSoldoutYn() {
		return soldoutYn;
	}

	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCollaborationYn() {
		return collaborationYn;
	}
	public void setCollaborationYn(String collaborationYn) {
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
	public void setInMaterial(String in_material) {
		this.inMaterial = in_material;
	}
	public String getOutMaterial() {
		return outMaterial;
	}
	public void setOutMaterial(String out_material) {
		this.outMaterial = out_material;
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
	public String getUsedYn() {
		return usedYn;
	}
	public void setUsedYn(String usedYn) {
		this.usedYn = usedYn;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRetroYn() {
		return retroYn;
	}
	public void setRetroYn(String retroYn) {
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
	public String getSoleoutYn() {
		return soldoutYn;
	}
	public void setSoldoutYn(String soleoutYn) {
		this.soldoutYn = soleoutYn;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", brand=" + brand + ", collaborationYn=" + collaborationYn
				+ ", collaborationBrand=" + collaborationBrand + ", type=" + type + ", model=" + model + ", name="
				+ name + ", color=" + color + ", price=" + price + ", size=" + size + ", quantity=" + quantity
				+ ", description=" + description + ", inMaterial=" + inMaterial + ", outMaterial=" + outMaterial
				+ ", realSizeLength=" + realSizeLength + ", realSizeWidth=" + realSizeWidth + ", weight=" + weight
				+ ", usedYn=" + usedYn + ", releaseDate=" + releaseDate + ", retroYn=" + retroYn + ", writer=" + writer
				+ ", writeTime=" + writeTime + ", updateTime=" + updateTime + ", soldoutYn=" + soldoutYn + ", deleteYn="
				+ deleteYn + ", readCount=" + readCount + "]";
	}

}
