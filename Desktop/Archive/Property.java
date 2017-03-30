/**
 * Represents a Property object
 * @author Jonathan
 *
 */

public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	
	/**
	 * Constructor, Parametarized Constructor
	 * @param propertyName- property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 */
	Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it
	 * @param p- a property object
	 */
	Property(Property p){
		p.getPropertyName();
		p.getCity();
		p.getRentAmount();
		p.getOwner();
	}
	
	/**
	 * gets the city
	 * @return the city name
	 */
	public String getCity(){
		return city;
	}
	
	/**
	 * gets the owner
	 * @return the owner
	 */
	public String getOwner(){
		return owner;
	}
	
	/**
	 * gets the property name
	 * @return the property name
	 */
	public String getPropertyName(){
		return propertyName;
	}
	
	/**
	 * sets the property name
	 * @param propertyName - the propertyName to set
	 */
	public void setPropertyName(String propertyName){
		this.propertyName = propertyName;
	}
	
	/**
	 * gets the rent amount
	 * @return the rentAmount
	 */
	public double getRentAmount(){
		return rentAmount;
	}
	
	/**
	 * sets the rent amount
	 * @param rentAmount - the rentAmount to set
	 */
	public void setRentAmount(double rentAmount){
		this.rentAmount = rentAmount;
	}
	
	/**
	 * sets the city
	 * @param city - the city to set
	 */
	public void setLoc(String city){
		this.city = city;
	}
	
	/**
	 * sets the owner name
	 * @param owner - the owner to set
	 */
	public void setOwner(String owner){
		this.owner = owner;
	}

	/**
	 * @return the string representation of a property objects as the following format: Property name belonging to rent amount
	 */
	public String toString(){
		return getPropertyName() + "belonging to " + getRentAmount();
	}

}
