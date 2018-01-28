package com.yucitms.orm.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 试题分类
 * @author qiangzi
 *
 */
public class Classify implements java.io.Serializable{
	private Integer id;
	private String classify;
	private Date createDate;
	private boolean state;
	private Set<Questions_DanXuan> danXuans= new HashSet<Questions_DanXuan>();
	private Set<Questions_DuoXuan> duoXuans= new HashSet<Questions_DuoXuan>();
	private Set<Questions_JianDa> jianDas= new HashSet<Questions_JianDa>();
	private Set<Questions_PanDuan> panDuans= new HashSet<Questions_PanDuan>();
	private Set<Questions_TianKong> tianKongs= new HashSet<Questions_TianKong>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public Set<Questions_DanXuan> getDanXuans() {
		return danXuans;
	}
	public void setDanXuans(Set<Questions_DanXuan> danXuans) {
		this.danXuans = danXuans;
	}
	public Set<Questions_DuoXuan> getDuoXuans() {
		return duoXuans;
	}
	public void setDuoXuans(Set<Questions_DuoXuan> duoXuans) {
		this.duoXuans = duoXuans;
	}
	public Set<Questions_JianDa> getJianDas() {
		return jianDas;
	}
	public void setJianDas(Set<Questions_JianDa> jianDas) {
		this.jianDas = jianDas;
	}
	public Set<Questions_PanDuan> getPanDuans() {
		return panDuans;
	}
	public void setPanDuans(Set<Questions_PanDuan> panDuans) {
		this.panDuans = panDuans;
	}
	public Set<Questions_TianKong> getTianKongs() {
		return tianKongs;
	}
	public void setTianKongs(Set<Questions_TianKong> tianKongs) {
		this.tianKongs = tianKongs;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
}
