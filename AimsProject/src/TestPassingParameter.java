public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc JungleDVD = new DigitalVideoDisc("jungle");
        DigitalVideoDisc CinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(JungleDVD,CinderellaDVD);
        System.out.println("jungle dvd title : " + JungleDVD.getTitle());
        System.out.println("cinderella dvd title : " + CinderellaDVD.getTitle());

        changeTitle(JungleDVD,CinderellaDVD.getTitle());
        System.out.println("jungle dvd title : " + JungleDVD.getTitle());
    }

    public static void swap(Object o1,Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

}
