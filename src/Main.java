import java.util.Scanner;


class Main  {
Scanner scanner = new Scanner(System.in);


public int Menu (){

    System.out.println("1. Add Menu Item\n" +
            "2. Remove Menu Item\n" +
            "3. Display Menu\n" +
            "4. Search Menu Item\n" +
            "5. Create Order\n" +
            "6. Add Item to Order\n" +
            "7. Remove Item from Order\n" +
            "8. Display Order\n" +
            "9. Add Order to Kitchen Queue\n" +
            "10. Process Next Order\n" +
            "11. Search Order\n" +
            "12. Check Order Status\n" +
            "13. Display Completed Orders\n" +
            "0. Exit");


        System.out.println("Select an option :");
        int option = scanner.nextInt();

        return option;



}



    public  void main(String[] args) {
    Restraunt restraunt = new Restraunt();

    while(true){
        int choice = Menu();

        switch (choice){
            case 1 -> restraunt.addMenuItem();
            case 2 -> restraunt.removeMenuItem();
            case 3 -> restraunt.displayMenu();
            case 4 ->restraunt.searchMenuItem();
            case 5 -> restraunt.createOrder();
            case 6 -> restraunt.addItemToOrder();
            case 7 -> restraunt.removeItemFromOrder();
            case 8 -> restraunt.displayOrder();
            case 9 -> restraunt.addOrderToKitchen();
            case 10 -> restraunt.processOrder();
            case 11 -> restraunt.searchOrder();
            case 12 -> restraunt.checkoutOrderStatus();
            case 13 -> restraunt.displayCompletedOrders();
            case 0-> {
                System.out.println("thank you for using our System");
                break;
            }


        }
    }


    }


}