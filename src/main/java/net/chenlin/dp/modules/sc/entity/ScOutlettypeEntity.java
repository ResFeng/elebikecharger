package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScOutlettypeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String typeid;
	
	/**
	 * 
	 */
	private String typename;
	
	/**
	 * 
	 */
	private String description;
	
	/**
	 * 
	 */
	private String image;
	
    /**
     * ScOutlettypeEntity constructor
     */
	public ScOutlettypeEntity() {
		super();
	}

    /**
     * setter for typeid
     * @param typeid
     */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

    /**
     * getter for typeid
     */
	public String getTypeid() {
		return typeid;
	}

    /**
     * setter for typename
     * @param typename
     */
	public void setTypename(String typename) {
		this.typename = typename;
	}

    /**
     * getter for typename
     */
	public String getTypename() {
		return typename;
	}

    /**
     * setter for description
     * @param description
     */
	public void setDescription(String description) {
		this.description = description;
	}

    /**
     * getter for description
     */
	public String getDescription() {
		return description;
	}

    /**
     * setter for image
     * @param image
     */
	public void setImage(String image) {
		this.image = image;
	}

    /**
     * getter for image
     */
	public String getImage() {
		return image;
	}

    /**
     * ScOutlettypeEntity.toString()
     */
    @Override
    public String toString() {
        return "ScOutlettypeEntity{" +
               "typeid='" + typeid + '\'' +
               ", typename='" + typename + '\'' +
               ", description='" + description + '\'' +
               ", image='" + image + '\'' +
               '}';
    }

}
