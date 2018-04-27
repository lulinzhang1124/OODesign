public class Amount {
    private Integer dollars;
    private Integer cents;

    public Amount(Integer dollars, Integer cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    public Integer getDollars() {
        return this.dollars;
    }

    public Integer getCents() {
        return this.cents;
    }
}
