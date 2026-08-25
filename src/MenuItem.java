public class MenuItem {

  final private Integer ID  ;
   private String name;
   private double price;
   private String category ;
   static int ItemsCount = 0;


    public MenuItem(int ID, String name, double price, String category) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.category = category;
        ItemsCount++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
        else {
            this.price = 100;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "#"+ ID +"-"+ name + " - " + price + " - " + category ;
    }
}
