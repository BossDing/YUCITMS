package com.yucitms.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import com.yucitms.test.*;

public class ComplexFormTagAction extends ActionSupport {
	//级联第一个下拉框数据
	private List<Item> itemList;
	//级联第二个下拉框数据
	private Map<Integer, List<Material>> materialMap;

	public String execute() throws Exception {
		itemList = new ArrayList<Item>();

		//循环新建10个类别
		for (int j = 0; j < 10; j++) {
			Item item = new Item();
			item.setItemId(j + 1);
			item.setItem("类别" + (j + 1));
			itemList.add(item);
		}
		
		materialMap = new HashMap<Integer, List<Material>>();
		//循环新建每个类别中的10个材料
		for (int j = 0; j < 10; j++) {
			List<Material> materialList = new ArrayList<Material>();
			for (int i = 0; i < 10; i++) {
				Material material = new Material();
				material.setMaterialId(i);
				material.setMaterial("类别" + (j + 1)+"-->"+"材料"+(i + 1));
				materialList.add(material);
			}
			materialMap.put((j + 1), materialList);
		}
		return SUCCESS;
	}

	public Map<Integer, List<Material>> getMaterialMap() {
		return materialMap;
	}

	public void setMaterialMap(Map<Integer, List<Material>> materialMap) {
		this.materialMap = materialMap;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}