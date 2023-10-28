public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    public DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int QtyOrdered;
    public void setQtyOrdered(int qty) {
        QtyOrdered = qty;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (QtyOrdered >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else {
            itemOrdered[QtyOrdered] = disc;
            QtyOrdered ++;
            System.out.println("The disc has been add");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvlist){
        if (QtyOrdered + dvlist.length > MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else {
            for (DigitalVideoDisc disc : dvlist) {
                itemOrdered[QtyOrdered] = disc;
                QtyOrdered++;
            }
            System.out.println("The dvlist has been add");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        if (QtyOrdered + 2 > MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else {
            itemOrdered[QtyOrdered] = dvd1;
            QtyOrdered++;
            itemOrdered[QtyOrdered] = dvd2;
            QtyOrdered++;
            System.out.println("Two dvd has been add");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for (int i = 0; i <= QtyOrdered; i++){
            if(itemOrdered[i] != null && itemOrdered[i].equals(disc)){
                for (int j = i; j < QtyOrdered - 1; j++){
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[QtyOrdered -1] = null;
                QtyOrdered --;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("Can't find DVD in cart");
    }
    public void showCart(Cart cart){
        for (int i =1; i <= QtyOrdered; i++){
                if (itemOrdered[i] != null) {
                System.out.println(i + " " + itemOrdered[i].getTitle() + " " + itemOrdered[i].getCost());
            }
        }
        System.out.println("Total cost : " + cart.totalCost());
    }

    public float totalCost(){
        float total = 0;
        for(int i = 0; i <= QtyOrdered; i ++){
            if (itemOrdered[i] != null) {
                total += itemOrdered[i].getCost();
            }
        }
        return total;
    }
}
