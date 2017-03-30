/**
 * Represents management company object
 * @author Jonathan
 *
 */
public class ManagementCompany {
	
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties = new Property[MAX_PROPERTY];
	private String taxID;
	private int count =-1;
	private int nums = 0;
	
	
	/**
	 * Constructor Creates a Management Company object using the passed information
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFeePer - management fee
	 */
	ManagementCompany(String name, String taxID, double mgmFeePer){
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
	}
	
	/**
	 * Return the MAX_PROPERTY constant that represet the size of the "properties" array.
	 * @return the MAX_PROPERTY a constant attribute for this class that is set to 5
	 */
	public int getMAX_PROPERTY(){
		return MAX_PROPERTY;
	}
	
	
	/**
	 * Adds the property object to the "properties array".
	 * @param property - a property object
	 * @return -1 if the array is full. otherwise return the index of the array where the property was added.
	 */
	public int addProperty(Property property){
		count++;
		if (count >=0 && count < 5)
		{
			properties[count] = property;
			nums++;
			return count;
			
		}
		else return -1;
	}
	
	/**
	 * This method accesses each "Property" object within the array "Properties" and sums up the property rent and returns the total amount
	 * @return total rent
	 */
	public double totalRent(){
		double temp= 0;
		
		for(int i=0; i< nums;i++)
		{
			temp = temp + properties[i].getRentAmount();
		}
		return temp;
	}
	
	/**
	 * This method is returning the index of the property with the maximum rent amount
	 * @return int, the index of the property with the maximum rent amount
	 */
	public int maxPropertyRentIndex()
	{
		double j = 0;
		int c = 0;
		for (int i=0; i<nums; i++)
		{
			if (j < properties[i].getRentAmount())
			{
				j = properties[i].getRentAmount();
				c = i;
			}
		}
		return c;
	}
	
	/**
	 * Displays the information of the property at index i
	 * @param i - The index of the property within array "properties"
	 * @return information of the property at index i
	 */
	public String displayPropertyAtIndex(int i){
		return "Property Name : " + properties[i].getPropertyName() + "\n Located in " + 
	properties[i].getCity() + "\n Belonging to : " + properties[i].getOwner() + 
	"\n Rent Amount: " + properties[i].getRentAmount();
	}
	
	/**
	 * Displays the information of all the properties in the "properties" array
	 */
	public String toString()
	{
		String temp = "List of the properties for " + name +" ,"+  "taxID: " + taxID + "\n ___________________________________________________" ;

		for (int i = 0; i < nums; i++){
			temp = temp + "\nProperty Name : " + properties[i].getPropertyName() + "\n  Located in " + 
		properties[i].getCity() + "\n  Belonging to: " + properties[i].getOwner() + "\n "
				+ " Rent Amount: " + properties[i].getRentAmount();
			}
		
		temp = temp + "\n_______________________________________________________ \n"
				+ "total management Fee: " + (totalRent() * (mgmFeePer/100));
		return temp;
	}
	
}
