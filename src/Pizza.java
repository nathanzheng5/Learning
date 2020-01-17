public class Pizza {


    private final int cheese;
    private final int pepperoni;
    private final int pepper;
    private final int ham;
    private final int pineapple;

    public Pizza(int cheese, int pepperoni, int pepper, int ham, int pineapple) {
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.pepper = pepper;
        this.ham = ham;
        this.pineapple = pineapple;
    }

    public Pizza(int cheese, int pepperoni) {
        this(cheese, pepperoni, 0,0,0);
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza(1, 0, 2, 3, 4);
        Pizza pizza1 = new Pizza(1, 2);
    }

}
