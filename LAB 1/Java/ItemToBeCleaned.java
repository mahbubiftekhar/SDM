/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-7aed471 modeling language!*/



// line 23 "model.ump"
// line 71 "model.ump"
public class ItemToBeCleaned
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ItemToBeCleaned Attributes
  private int number;
  private float totalPrice;
  private String description;

  //ItemToBeCleaned Associations
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ItemToBeCleaned(int aNumber, float aTotalPrice, String aDescription, Order aOrder)
  {
    number = aNumber;
    totalPrice = aTotalPrice;
    description = aDescription;
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create itemToBeCleaned due to order");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalPrice(float aTotalPrice)
  {
    boolean wasSet = false;
    totalPrice = aTotalPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public float getTotalPrice()
  {
    return totalPrice;
  }

  public String getDescription()
  {
    return description;
  }

  public Order getOrder()
  {
    return order;
  }

  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    if (aOrder == null)
    {
      return wasSet;
    }

    Order existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removeItemToBeCleaned(this);
    }
    order.addItemToBeCleaned(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Order placeholderOrder = order;
    this.order = null;
    placeholderOrder.removeItemToBeCleaned(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "totalPrice" + ":" + getTotalPrice()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null")
     + outputString;
  }
}