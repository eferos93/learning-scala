package learningscala
package chapter5

object FakadePattern extends App {
  class DonutInventoryService[T] {
    def checkStock(donut: T): Boolean = {
      println("DonutInventoryService->chekcStock")
      true
    }
  }

  class DonutPricingService[T] {
    def calculatePrice(donut: T): Double = {
      println("DonutPricingService->calculatePrice")
      2.5
    }
  }

  class DonutOrderService[T] {
    def createOrder(donut: T, quantity: Int, price: Double): Int = {
      println(s"Saving donut order to database: donut = $donut, quantity = $quantity, price = $price")
      100
    }
  }

  class DonutShoppingCartService[T] (donutInventoryService: DonutInventoryService[T],
                                     donutPricingService: DonutPricingService[T],
                                     donutOrderService: DonutOrderService[T]) {

    def bookOrder(donut: T, quantity: Int): Int = {
      println("DonutShoppingCartService->bookOrder")

      if (donutInventoryService.checkStock(donut)) {
        val price = donutPricingService.calculatePrice(donut)
        donutOrderService.createOrder(donut, quantity, price)
      } else {
        println(s"Sorry donut $donut is out of stock!")
        -100
      }
    }
  }

//  define a trait that encapsulate everything
  trait DonutStoreServices {
    val donutInventoryService = new DonutInventoryService[String]
    val donutPricingService = new DonutPricingService[String]
    val donutOrderService = new DonutOrderService[String]
    val donutShoppingCartService = new DonutShoppingCartService(donutInventoryService, donutPricingService, donutOrderService)
  }

//  now we define a facade named DonutStoreAppController
//  the this keyword permit to use self types
//  Self-types are a way to declare that a trait must be mixed into another trait,
//  even though it doesn’t directly extend it,
//  making the members of the dependency available without imports.
//  meaning, when extending DonutStoreAppController, we need to extend
//  the dependency trait
  trait DonutStoreAppController {
    this: DonutStoreServices =>
    def bookOrder(donut: String, quantity: Int): Int = {
      donutShoppingCartService.bookOrder(donut, quantity)
    }
  }

  object DonutStoreApp extends DonutStoreAppController with DonutStoreServices
}
