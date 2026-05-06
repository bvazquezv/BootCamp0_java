package Strategy;

public  class PriceCalculator {


    DiscountStrategy discont;
  public PriceCalculator( DiscountStrategy strategy)
  {
      discont=strategy;
  }

}
