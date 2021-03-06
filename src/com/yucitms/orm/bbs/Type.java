package com.yucitms.orm.bbs;

import java.util.HashSet;
import java.util.Set;
/**
 * 帖子类型
 * @author qiangzi
 *
 */
public class Type implements java.io.Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String name;
    private Set<Post> posts = new HashSet<Post>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

}
