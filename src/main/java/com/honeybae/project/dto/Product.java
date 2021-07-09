package com.honeybae.project.dto;

import java.util.Objects;

public class Product {
	
	private int id;
	private String brand;
	private boolean collaboration;
	private String collaborationBrand;
	private String category;
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
	private boolean used;
	private String releaseDate;
	private boolean retro;
	private int member_id;
	private String writeDate;
	private String updateDate;
	private boolean soldout;
	private int viewCount;
	
	public Product() {
	}

	public Product(int id, String brand, boolean collaboration, String collaborationBrand, String category,
			String model, String name, String color, int price, int size, int quantity, String description,
			String inMaterial, String outMaterial, float realSizeLength, float realSizeWidth, float weight,
			boolean used, String releaseDate, boolean retro, int member_id, String writeDate, String updateDate,
			boolean soldout, int viewCount) {
		super();
		this.id = id;
		this.brand = brand;
		this.collaboration = collaboration;
		this.collaborationBrand = collaborationBrand;
		this.category = category;
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
		this.used = used;
		this.releaseDate = releaseDate;
		this.retro = retro;
		this.member_id = member_id;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
		this.soldout = soldout;
		this.viewCount = viewCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
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

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isSoldout() {
		return soldout;
	}

	public void setSoldout(boolean soldout) {
		this.soldout = soldout;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", collaboration=" + collaboration + ", collaborationBrand="
				+ collaborationBrand + ", category=" + category + ", model=" + model + ", name=" + name + ", color="
				+ color + ", price=" + price + ", size=" + size + ", quantity=" + quantity + ", description="
				+ description + ", inMaterial=" + inMaterial + ", outMaterial=" + outMaterial + ", realSizeLength="
				+ realSizeLength + ", realSizeWidth=" + realSizeWidth + ", weight=" + weight + ", used=" + used
				+ ", releaseDate=" + releaseDate + ", retro=" + retro + ", member_id=" + member_id + ", writeDate="
				+ writeDate + ", updateDate=" + updateDate + ", soldout=" + soldout + ", viewCount=" + viewCount + "]";
	}

	

}
