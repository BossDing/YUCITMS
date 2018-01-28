package com.yucitms.test;

public class Material implements java.io.Serializable {
	// Fields
	private int materialId;
	private String material;

	public Material() {}

	public int getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}