package com.honeybae.project.dto;

public class Product {
	
	private String productId;
	private String brand;
	private boolean collaboration;
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
	private boolean retro;
	private String writer;
	private String writeTime;
	private String updateTime;
	private boolean soldout;
	private boolean delete;
	private int readCount;
	
	public Product() {
	}

	public Product(String productId, String brand, boolean collaboration, String collaborationBrand, String type,
			String model, String name, String color, int price, int size, int quantity, String description,
			String inMaterial, String outMaterial, float realSizeLength, float realSizeWidth, float weight,
			boolean usedYn, String releaseDate, boolean retro, String writer, String writeTime, String updateTime,
			boolean soldout, boolean delete, int readCount) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.collaboration = collaboration;
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
		this.retro = retro;
		this.writer = writer;
		this.writeTime = writeTime;
		this.updateTime = updateTime;
		this.soldout = soldout;
		this.delete = delete;
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

	public boolean isCollaboration() {
		return collaboration;
	}

	public void setCollaboration(boolean collaboration) {
		this.collaboration = collaboration;
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

	public boolean isRetro() {
		return retro;
	}

	public void setRetro(boolean retro) {
		this.retro = retro;
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

	public boolean isSoldout() {
		return soldout;
	}

	public void setSoldout(boolean soldout) {
		this.soldout = soldout;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", brand=" + brand + ", collaboration=" + collaboration
				+ ", collaborationBrand=" + collaborationBrand + ", type=" + type + ", model=" + model + ", name="
				+ name + ", color=" + color + ", price=" + price + ", size=" + size + ", quantity=" + quantity
				+ ", description=" + description + ", inMaterial=" + inMaterial + ", outMaterial=" + outMaterial
				+ ", realSizeLength=" + realSizeLength + ", realSizeWidth=" + realSizeWidth + ", weight=" + weight
				+ ", usedYn=" + usedYn + ", releaseDate=" + releaseDate + ", retro=" + retro + ", writer=" + writer
				+ ", writeTime=" + writeTime + ", updateTime=" + updateTime + ", soldout=" + soldout + ", delete="
				+ delete + ", readCount=" + readCount + "]";
	}
	
	
	
}
