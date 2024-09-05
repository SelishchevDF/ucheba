// The Swift Programming Language
// https://docs.swift.org/swift-book
enum Pizzas {
    case pizza1
    case pizza2
    case pizza3
    case pizza4
    }

struct Pizza {
    var type: Pizzas
    var prise: Int
    var dough: Dough
    var additives: Additives
    enum Dough {
        case thin
        case thick
    }
    enum Additives {
        case pepperoni
        case tomatoes
        case cheese
    }
}

class Pizzeria {
    private var pizzasList: [String]

    init(pizzasList: [String]) {
    self.pizzasList = pizzasList
    }

    func getPizzas() -> [String]{
        self.pizzasList
    }

    func addPizza(pizza: String){
        self.pizzasList.append(pizza)
    }
}

var pizzeria = Pizzeria(pizzasList: ["p1", "p2", "p3", "p4"])
print(pizzeria.getPizzas())
pizzeria.addPizza(pizza: "p111")
pizzeria.addPizza(pizza: "p222")
pizzeria.addPizza(pizza: "p333")
print(pizzeria.getPizzas())
