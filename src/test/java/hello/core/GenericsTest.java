package hello.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
  class Fruit {

  }

  class Apple extends Fruit {

  }

  class Grape extends Fruit {

  }

  class Toy {

  }

  class FruitBox<T extends Fruit> {

  }

  @Test
  void test() {
    FruitBox<Fruit> f = new FruitBox();

//    List<? extends Fruit> list = new ArrayList<Fruit>();
//    list.add(new Fruit());
//    list.add(new Apple());
//    list.add(new Grape());
//    list.add(new Toy());
//
//    Fruit f = list.get(0);
//    Apple a = list.get(0);
//    Grape g = list.get(0);

  }

}
