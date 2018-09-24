/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-7aed471 modeling language!*/


import java.util.*;

// line 13 "model.ump"
// line 52 "model.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private String timePlaced;
  private float totalPrice;
  private String creditCardCharged;
  private String expiryDate;
  private String agreedReadyTime;

  //Order Associations
  private List<ItemToBeCleaned> itemToBeCleaneds;
  private Account account;
  private Delivery delivery;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aTimePlaced, float aTotalPrice, String aCreditCardCharged, String aExpiryDate, String aAgreedReadyTime, Account aAccount)
  {
    timePlaced = aTimePlaced;
    totalPrice = aTotalPrice;
    creditCardCharged = aCreditCardCharged;
    expiryDate = aExpiryDate;
    agreedReadyTime = aAgreedReadyTime;
    itemToBeCleaneds = new ArrayList<ItemToBeCleaned>();
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create order due to account");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimePlaced(String aTimePlaced)
  {
    boolean wasSet = false;
    timePlaced = aTimePlaced;
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

  public boolean setCreditCardCharged(String aCreditCardCharged)
  {
    boolean wasSet = false;
    creditCardCharged = aCreditCardCharged;
    wasSet = true;
    return wasSet;
  }

  public boolean setExpiryDate(String aExpiryDate)
  {
    boolean wasSet = false;
    expiryDate = aExpiryDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setAgreedReadyTime(String aAgreedReadyTime)
  {
    boolean wasSet = false;
    agreedReadyTime = aAgreedReadyTime;
    wasSet = true;
    return wasSet;
  }

  public String getTimePlaced()
  {
    return timePlaced;
  }

  public float getTotalPrice()
  {
    return totalPrice;
  }

  public String getCreditCardCharged()
  {
    return creditCardCharged;
  }

  public String getExpiryDate()
  {
    return expiryDate;
  }

  public String getAgreedReadyTime()
  {
    return agreedReadyTime;
  }

  public ItemToBeCleaned getItemToBeCleaned(int index)
  {
    ItemToBeCleaned aItemToBeCleaned = itemToBeCleaneds.get(index);
    return aItemToBeCleaned;
  }

  public List<ItemToBeCleaned> getItemToBeCleaneds()
  {
    List<ItemToBeCleaned> newItemToBeCleaneds = Collections.unmodifiableList(itemToBeCleaneds);
    return newItemToBeCleaneds;
  }

  public int numberOfItemToBeCleaneds()
  {
    int number = itemToBeCleaneds.size();
    return number;
  }

  public boolean hasItemToBeCleaneds()
  {
    boolean has = itemToBeCleaneds.size() > 0;
    return has;
  }

  public int indexOfItemToBeCleaned(ItemToBeCleaned aItemToBeCleaned)
  {
    int index = itemToBeCleaneds.indexOf(aItemToBeCleaned);
    return index;
  }

  public Account getAccount()
  {
    return account;
  }

  public Delivery getDelivery()
  {
    return delivery;
  }

  public boolean hasDelivery()
  {
    boolean has = delivery != null;
    return has;
  }

  public static int minimumNumberOfItemToBeCleaneds()
  {
    return 0;
  }

  public ItemToBeCleaned addItemToBeCleaned(int aNumber, float aTotalPrice, String aDescription)
  {
    return new ItemToBeCleaned(aNumber, aTotalPrice, aDescription, this);
  }

  public boolean addItemToBeCleaned(ItemToBeCleaned aItemToBeCleaned)
  {
    boolean wasAdded = false;
    if (itemToBeCleaneds.contains(aItemToBeCleaned)) { return false; }
    Order existingOrder = aItemToBeCleaned.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aItemToBeCleaned.setOrder(this);
    }
    else
    {
      itemToBeCleaneds.add(aItemToBeCleaned);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItemToBeCleaned(ItemToBeCleaned aItemToBeCleaned)
  {
    boolean wasRemoved = false;
    //Unable to remove aItemToBeCleaned, as it must always have a order
    if (!this.equals(aItemToBeCleaned.getOrder()))
    {
      itemToBeCleaneds.remove(aItemToBeCleaned);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addItemToBeCleanedAt(ItemToBeCleaned aItemToBeCleaned, int index)
  {  
    boolean wasAdded = false;
    if(addItemToBeCleaned(aItemToBeCleaned))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemToBeCleaneds()) { index = numberOfItemToBeCleaneds() - 1; }
      itemToBeCleaneds.remove(aItemToBeCleaned);
      itemToBeCleaneds.add(index, aItemToBeCleaned);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemToBeCleanedAt(ItemToBeCleaned aItemToBeCleaned, int index)
  {
    boolean wasAdded = false;
    if(itemToBeCleaneds.contains(aItemToBeCleaned))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemToBeCleaneds()) { index = numberOfItemToBeCleaneds() - 1; }
      itemToBeCleaneds.remove(aItemToBeCleaned);
      itemToBeCleaneds.add(index, aItemToBeCleaned);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemToBeCleanedAt(aItemToBeCleaned, index);
    }
    return wasAdded;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    if (aAccount == null)
    {
      return wasSet;
    }

    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    account.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setDelivery(Delivery aDelivery)
  {
    //
    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet
    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because 
    // it's not required (No upper bound)
    //   
    boolean wasSet = false;
    Delivery existingDelivery = delivery;

    if (existingDelivery == null)
    {
      if (aDelivery != null)
      {
        if (aDelivery.addOrder(this))
        {
          existingDelivery = aDelivery;
          wasSet = true;
        }
      }
    } 
    else if (existingDelivery != null)
    {
      if (aDelivery == null)
      {
        if (existingDelivery.minimumNumberOfOrders() < existingDelivery.numberOfOrders())
        {
          existingDelivery.removeOrder(this);
          existingDelivery = aDelivery;  // aDelivery == null
          wasSet = true;
        }
      } 
      else
      {
        if (existingDelivery.minimumNumberOfOrders() < existingDelivery.numberOfOrders())
        {
          existingDelivery.removeOrder(this);
          aDelivery.addOrder(this);
          existingDelivery = aDelivery;
          wasSet = true;
        }
      }
    }
    if (wasSet)
    {
      delivery = existingDelivery;
    }
    return wasSet;
  }
  
  public void delete()
  {
    for(int i=itemToBeCleaneds.size(); i > 0; i--)
    {
      ItemToBeCleaned aItemToBeCleaned = itemToBeCleaneds.get(i - 1);
      aItemToBeCleaned.delete();
    }
    Account placeholderAccount = account;
    this.account = null;
    placeholderAccount.removeOrder(this);
    if (delivery != null)
    {
      if (delivery.numberOfOrders() <= 1)
      {
        delivery.delete();
      }
      else
      {
        Delivery placeholderDelivery = delivery;
        this.delivery = null;
        placeholderDelivery.removeOrder(this);
      }
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "timePlaced" + ":" + getTimePlaced()+ "," +
            "totalPrice" + ":" + getTotalPrice()+ "," +
            "creditCardCharged" + ":" + getCreditCardCharged()+ "," +
            "expiryDate" + ":" + getExpiryDate()+ "," +
            "agreedReadyTime" + ":" + getAgreedReadyTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "delivery = "+(getDelivery()!=null?Integer.toHexString(System.identityHashCode(getDelivery())):"null")
     + outputString;
  }
}