/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-7aed471 modeling language!*/


import java.util.*;
import java.sql.Time;

// line 39 "model.ump"
// line 66 "model.ump"
public class Driver
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Driver Attributes
  private String name;

  //Driver Associations
  private List<Delivery> deliveries;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Driver(String aName)
  {
    name = aName;
    deliveries = new ArrayList<Delivery>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Delivery getDelivery(int index)
  {
    Delivery aDelivery = deliveries.get(index);
    return aDelivery;
  }

  public List<Delivery> getDeliveries()
  {
    List<Delivery> newDeliveries = Collections.unmodifiableList(deliveries);
    return newDeliveries;
  }

  public int numberOfDeliveries()
  {
    int number = deliveries.size();
    return number;
  }

  public boolean hasDeliveries()
  {
    boolean has = deliveries.size() > 0;
    return has;
  }

  public int indexOfDelivery(Delivery aDelivery)
  {
    int index = deliveries.indexOf(aDelivery);
    return index;
  }

  public static int minimumNumberOfDeliveries()
  {
    return 0;
  }

  public Delivery addDelivery(Time aTimePickedUp, Time aTimeDelivered, Order... allOrders)
  {
    return new Delivery(aTimePickedUp, aTimeDelivered, this, allOrders);
  }

  public boolean addDelivery(Delivery aDelivery)
  {
    boolean wasAdded = false;
    if (deliveries.contains(aDelivery)) { return false; }
    Driver existingDriver = aDelivery.getDriver();
    boolean isNewDriver = existingDriver != null && !this.equals(existingDriver);
    if (isNewDriver)
    {
      aDelivery.setDriver(this);
    }
    else
    {
      deliveries.add(aDelivery);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDelivery(Delivery aDelivery)
  {
    boolean wasRemoved = false;
    //Unable to remove aDelivery, as it must always have a driver
    if (!this.equals(aDelivery.getDriver()))
    {
      deliveries.remove(aDelivery);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDeliveryAt(Delivery aDelivery, int index)
  {  
    boolean wasAdded = false;
    if(addDelivery(aDelivery))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDeliveries()) { index = numberOfDeliveries() - 1; }
      deliveries.remove(aDelivery);
      deliveries.add(index, aDelivery);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDeliveryAt(Delivery aDelivery, int index)
  {
    boolean wasAdded = false;
    if(deliveries.contains(aDelivery))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDeliveries()) { index = numberOfDeliveries() - 1; }
      deliveries.remove(aDelivery);
      deliveries.add(index, aDelivery);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDeliveryAt(aDelivery, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=deliveries.size(); i > 0; i--)
    {
      Delivery aDelivery = deliveries.get(i - 1);
      aDelivery.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}