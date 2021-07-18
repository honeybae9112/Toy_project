package com.honeybae.project.dto;

import java.util.Objects;

public class Product {

	private int id;
	private String brand;
	private Boolean collaboration;
	private String collaborationBrand;
	private String category;
	private String model;
	private String color;
	private Integer price;
	private int size;
	private int quantity;
	private String description;
	private String inMaterial;
	private String outMaterial;
	private float realSizeLength;
	private float realSizeWidth;
	private float weight;
	private Boolean used;
	private String releaseDate;
	private Boolean retro;
	private int writerId;
	private String writedDate;
	private int modifierId;
	private String modifiedDate;
	private int sellStatus;
	private int viewCount;

	public Product() {
	}

	public Product(int id, String brand, Boolean collaboration, String collaborationBrand, String category,
			String model, String color, Integer price, int size, int quantity, String description, String inMaterial,
			String outMaterial, float realSizeLength, float realSizeWidth, float weight, Boolean used,
			String releaseDate, Boolean retro, int writerId, String writedDate, int modifierId, String modifiedDate,
			int sellStatus, int viewCount) {
		super();
		this.id = id;
		this.brand = brand;
		this.collaboration = collaboration;
		this.collaborationBrand = collaborationBrand;
		this.category = category;
		this.model = model;
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
		this.writerId = writerId;
		this.writedDate = writedDate;
		this.modifierId = modifierId;
		this.modifiedDate = modifiedDate;
		this.sellStatus = sellStatus;
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

	public Boolean getCollaboration() {
		return collaboration;
	}

	public void setCollaboration(Boolean collaboration) {
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
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

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Boolean getRetro() {
		return retro;
	}

	public void setRetro(Boolean retro) {
		this.retro = retro;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getWritedDate() {
		return writedDate;
	}

	public void setWritedDate(String writedDate) {
		this.writedDate = writedDate;
	}

	public int getModifierId() {
		return modifierId;
	}

	public void setModifierId(int modifierId) {
		this.modifierId = modifierId;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(int sellStatus) {
		this.sellStatus = sellStatus;
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
				+ collaborationBrand + ", category=" + category + ", model=" + model + ", color=" + color + ", price="
				+ price + ", size=" + size + ", quantity=" + quantity + ", description=" + description + ", inMaterial="
				+ inMaterial + ", outMaterial=" + outMaterial + ", realSizeLength=" + realSizeLength
				+ ", realSizeWidth=" + realSizeWidth + ", weight=" + weight + ", used=" + used + ", releaseDate="
				+ releaseDate + ", retro=" + retro + ", writerId=" + writerId + ", writedDate=" + writedDate
				+ ", modifierId=" + modifierId + ", modifiedDate=" + modifiedDate + ", sellStatus=" + sellStatus
				+ ", viewCount=" + viewCount + "]";
	}


}
