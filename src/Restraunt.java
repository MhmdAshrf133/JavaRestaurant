
import java.util.*;

public class Restraunt {
    List <MenuItem> MenuItems =   new ArrayList<>();
    List <order> kitchenOrders =   new LinkedList<>();
    Map<Integer, order> orders =   new HashMap<>();
    Map<Integer, order> completedOrders =   new LinkedHashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addMenuItem() {
        System.out.println("Adding a menu item");
        Integer menuItemID ;
        while(true){
            boolean isExist = false;
            System.out.println("Menu item ID: ");
             menuItemID = scanner.nextInt();
             scanner.nextLine();
            for(MenuItem item : MenuItems){
                if(item.getID() == menuItemID){
                   isExist = true;
                }
            }
            if(isExist){
                System.out.println("ID already exists");
            }
            else{
                break;
            }
        }
        System.out.println("Enter the item Name :");
        String itemName = scanner.nextLine();
        System.out.println("Enter the item price :");
           double itemPrice = scanner.nextDouble();
           scanner.nextLine();
           System.out.println("Enter the item category :");
           String category = scanner.nextLine();


        MenuItems.add(new MenuItem(menuItemID,itemName,itemPrice,category));
        System.out.println("Menu item added ");



    }


    void removeMenuItem() {
        System.out.println("Removing a menu item");
        System.out.println("Enter the item ID to remove :");
        Integer menuItemID = scanner.nextInt();
        for(MenuItem item : MenuItems){
            boolean isRemoved = false;
            if(item.getID() == menuItemID){
              isRemoved =  MenuItems.remove(item);
                System.out.println("Menu item removed");
                break ;
            }
        }
    }

    void displayMenu(){
        System.out.println("Menu items :");
        for(int i = 0 ; i < MenuItems.size(); i++){
            MenuItem item = MenuItems.get(i);
            System.out.println((i+1)+" - "+item);
        }
    }

    void searchMenuItem(){
        System.out.println("Searching for menu items :");
        System.out.println("Enter the item ID to search for:");
        Integer menuItemID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Searching for ID " + menuItemID);
        for(MenuItem item : MenuItems){
            if(item.getID() == menuItemID){
                System.out.println(item);
                return;
            }
            System.out.println("Menu item doesnt exist");
        }
    }

    void createOrder(){
        System.out.println("Creating a new order");
        System.out.println("Enter the order ID:");
        Integer orderID ;
        while(true){
            boolean isExist = false;
            System.out.println("Order ID: ");
             orderID = scanner.nextInt();
            scanner.nextLine();
            if(orders.containsKey(orderID)){
                System.out.println("Order ID already exists");
                continue ;
            }
            else{
                break;
            }
        }
        System.out.println("Enter the Customer Name :");
        String CustomerName = scanner.nextLine();


    orders.put(orderID, new order(orderID,CustomerName));
    System.out.println("Order has been created");


    }

    void addItemToOrder(){
        System.out.println("Adding a new item to the order");
        System.out.println("Enter the order ID:");
        Integer orderID = scanner.nextInt();
        scanner.nextLine();
        order order ;
        if(orders.containsKey(orderID)){
             order = orders.get(orderID);
        }
        else {
            System.out.println("Order does not exist");
            return;
        }
        if(order.getOrderStatus().equals(OrderStatus.CANCELLED) || order.getOrderStatus().equals(OrderStatus.COMPLETED)){
            System.out.println("Order is " + order.getOrderStatus() + "you cant add items");
            return;
        }
        System.out.println("Enter the item ID:");
        Integer itemID = scanner.nextInt();
        scanner.nextLine();
        if(order.searchItem(itemID)!=null){
            System.out.println("item already exists");
            return;
        }
        MenuItem menuItem = null;
        boolean isfound = false ;
        for(MenuItem item : MenuItems){
            if(item.getID().equals(itemID) ){
                menuItem = item;
                isfound = true;
                System.out.println("item has been found");
                break;
            }
        }
        if(!isfound){
            System.out.println("Item does not exist");
            return;
        }
        
        System.out.println("Enter the item quantity: :");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        if(quantity <= 0){
            System.out.println("Quantity must be greater than 0");
            return;
        }
        
        order.addItem(new OrderItem( menuItem , quantity));
        System.out.println("Order has been added");

    }

    void removeItemFromOrder(){
        System.out.println("Removing a item from the order");
        System.out.println("Enter the order ID:");
        Integer orderID = scanner.nextInt();
        scanner.nextLine();
        order order ;
        if(orders.containsKey(orderID)){
            order = orders.get(orderID);
        }
        else {
            System.out.println("Order does not exist");
            return;
        }
        if(order.getOrderStatus().equals(OrderStatus.CANCELLED) || order.getOrderStatus().equals(OrderStatus.COMPLETED)){
            System.out.println("Order is " + order.getOrderStatus() + "you cant remove items");
            return;
        }
        System.out.println("Enter the item ID:");
        Integer itemID = scanner.nextInt();
        scanner.nextLine();
        OrderItem orderItem = order.searchItem(itemID);
        if(orderItem != null){
            order.removeItem(orderItem);
        }
        else {
            System.out.println("Item does not exist");
        }
    }


    void displayOrder (){
        System.out.println("enter ID that's you want to display:");
        Integer itemID = scanner.nextInt();
        scanner.nextLine();
        if(orders.containsKey(itemID)){
             orders.get(itemID).displayOrder();
        }
        else {
            System.out.println("Order does not exist");
        }
    }


    void addOrderToKitchen(){
        System.out.println("Adding a new order to the kitchen");
        System.out.println("Enter the order ID:");
        Integer orderID = scanner.nextInt();
        scanner.nextLine();
        order order ;
        if(orders.containsKey(orderID)){
            order = orders.get(orderID);
        }
        else {
            System.out.println("Order does not exist");
            return;
        }
        if(order.getOrderStatus().equals(OrderStatus.PENDING)){
            kitchenOrders.add(order);
            order.setOrderStatus(OrderStatus.IN_KITCHEN);
        }
        else{
            System.out.println("Order is " + order.getOrderStatus() + "you cant add it");
            return;
        }
    }

    void processOrder(){
       order order = kitchenOrders.removeFirst() ;
       order.setOrderStatus(OrderStatus.COMPLETED);
       completedOrders.put(order.getOrderID(), order);
       System.out.println("Order has been completed");

    }

    void searchOrder(){
        System.out.println("Enter the order ID:");
        Integer orderID = scanner.nextInt();
        scanner.nextLine();
        order order ;
        if(orders.containsKey(orderID)){
            System.out.println("Order is found ");
            orders.get(orderID).displayOrder();
        }
        else {
            System.out.println("Order does not exist");
        }

    }

    void checkoutOrderStatus(){
        System.out.println("Enter the order ID:");
        Integer orderID = scanner.nextInt();
        scanner.nextLine();
        if(orders.containsKey(orderID)){
            System.out.println("the order is "+orders.get(orderID).getOrderStatus());
        }
        else{
            System.out.println("Order does not exist");
        }
    }

    void displayCompletedOrders(){
        for(order order : completedOrders.values()){
            displayOrder();
        }
    }

}
