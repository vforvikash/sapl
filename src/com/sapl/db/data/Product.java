package com.sapl.db.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Product implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 15456L;

	private int id;

	@NotEmpty
	@Size(min = 3, max = 10, message="Product Name must between 3 to 10 Characters.")
	private String name;
	
	private Boolean isIndentHouse;
	private Double length;        
	private Double width;         
	private Double p_rate;        
	private Double s_rate; 
	private String description;
	private char productStyle;
	private int openingStock;  
	private int closingStock;  
	private int keepStock;     
	private int unit;          
	private Double salesPrice;    
	private Double purchasePrice;
	
	private Type type;          
	private GroupSize groupSize;     
	private ProductType productType;   
	private Group group;         
	private Ground ground;        
	private Loom loom;          
	private Colour colour;        
	private Texture texture;
	private String productSubType="Woven";
	private String unitType;
	private Set<Colour> colours = new HashSet<Colour>();
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the isIndentHouse
	 */
	public Boolean getIsIndentHouse() {
		return isIndentHouse;
	}
	/**
	 * @param isIndentHouse the isIndentHouse to set
	 */
	public void setIsIndentHouse(Boolean isIndentHouse) {
		this.isIndentHouse = isIndentHouse;
	}
	/**
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(Double length) {
		this.length = length;
	}
	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}
	/**
	 * @return the p_rate
	 */
	public Double getP_rate() {
		return p_rate;
	}
	/**
	 * @param p_rate the p_rate to set
	 */
	public void setP_rate(Double p_rate) {
		this.p_rate = p_rate;
	}
	/**
	 * @return the s_rate
	 */
	public Double getS_rate() {
		return s_rate;
	}
	/**
	 * @param s_rate the s_rate to set
	 */
	public void setS_rate(Double s_rate) {
		this.s_rate = s_rate;
	}
	/**
	 * @return the openingStock
	 */
	public int getOpeningStock() {
		return openingStock;
	}
	/**
	 * @param openingStock the openingStock to set
	 */
	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}
	/**
	 * @return the closingStock
	 */
	public int getClosingStock() {
		return closingStock;
	}
	/**
	 * @param closingStock the closingStock to set
	 */
	public void setClosingStock(int closingStock) {
		this.closingStock = closingStock;
	}
	/**
	 * @return the keepStock
	 */
	public int getKeepStock() {
		return keepStock;
	}
	/**
	 * @param keepStock the keepStock to set
	 */
	public void setKeepStock(int keepStock) {
		this.keepStock = keepStock;
	}
	/**
	 * @return the unit
	 */
	public int getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(int unit) {
		this.unit = unit;
	}
	/**
	 * @return the salesPrice
	 */
	public Double getSalesPrice() {
		return salesPrice;
	}
	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}
	/**
	 * @return the purchasePrice
	 */
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @return the groupSize
	 */
	public GroupSize getGroupSize() {
		return groupSize;
	}
	/**
	 * @param groupSize the groupSize to set
	 */
	public void setGroupSize(GroupSize groupSize) {
		this.groupSize = groupSize;
	}
	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}
	/**
	 * @return the ground
	 */
	public Ground getGround() {
		return ground;
	}
	/**
	 * @param ground the ground to set
	 */
	public void setGround(Ground ground) {
		this.ground = ground;
	}
	/**
	 * @return the loom
	 */
	public Loom getLoom() {
		return loom;
	}
	/**
	 * @param loom the loom to set
	 */
	public void setLoom(Loom loom) {
		this.loom = loom;
	}
	/**
	 * @return the colour
	 */
	public Colour getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
	}
	/**
	 * @return the texture
	 */
	public Texture getTexture() {
		return texture;
	}
	/**
	 * @param texture the texture to set
	 */
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	/**
	 * @return the colours
	 */
	public Set<Colour> getColours() {
		return colours;
	}
	/**
	 * @param colours the colours to set
	 */
	public void setColours(Set<Colour> colours) {
		this.colours = colours;
	}
	
	/**
	 * @return the productStyle
	 */
	public char getProductStyle() {
		return productStyle;
	}
	/**
	 * @param productStyle the productStyle to set
	 */
	public void setProductStyle(char productStyle) {
		this.productStyle = productStyle;
	}
	/**
	 * @return the productSubType
	 */
	public String getProductSubType() {
		return productSubType;
	}
	/**
	 * @param productSubType the productSubType to set
	 */
	public void setProductSubType(String productSubType) {
		this.productSubType = productSubType;
	}
	/**
	 * @return the unitType
	 */
	public String getUnitType() {
		return unitType;
	}
	/**
	 * @param unitType the unitType to set
	 */
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
