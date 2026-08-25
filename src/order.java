import java.util.ArrayList;
import java.util.List;

public class order {
   final private Integer orderID;
   final private String customerName;
   private double totalPrice;
   OrderStatus orderStatus;
    List <OrderItem> items = new ArrayList<>();

    public order (int orderID, String customerName)
        {
        this.orderID = orderID;
        this.customerName = customerName;
        orderStatus = OrderStatus.PENDING;
        this.totalPrice = 0;
        }

        public void addItem (OrderItem item){
            items.add(item);
            System.out.println(item.getItem().getName() + " added to the order " + orderID);
        }

        public void removeItem (OrderItem item){
            items.remove(item);
            System.out.println(item.getItem().getName() + " removed from the order " + orderID);
        }

        public double calculateTotalPrice() {
            totalPrice = 0;
            for(OrderItem item : items){
                totalPrice += item.calculateSubTotal() ;
            }
            return totalPrice;
        }

        public OrderItem searchItem (int itemID){
            for(OrderItem item : items){
                if(item.getItem().getID() == itemID){
                    return item;
                }

            }
            return null;
        }

        public void displayOrder() {
        System.out.println("order id :"+orderID + "\n Customer Name " + customerName + "\n order status " + orderStatus);

        for (OrderItem item : items) {
            System.out.println(item);
        }

        System.out.println("Total Price : " + calculateTotalPrice());


        }


    public Integer getOrderID() {
        return orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
