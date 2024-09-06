// The Swift Programming Language
// https://docs.swift.org/swift-book

class Food {
    var name:String
    var cost:Double
    var description:String

    init(name:String, cost:Double, description:String){
        self.name = name
        self.cost = cost
        self.description = description
    }
}
class Pizza:Food{}
class Potato:Food{}

protocol OpenCloseProtocol{
    func open()
    func close()
}
extension OpenCloseProtocol{
    func open(){
        print("open")
    }
    func close(){
        print("close")
        
    }
}

class Cafe:OpenCloseProtocol {
    var menu: [Food] = []

    init(menu: [Food]) {
        self.menu = menu
    }

    func addInMenu(item:Food) { 
        self.menu.append(item) 
    }

    convenience init(){
        var pizza1 = Pizza(name: "pizza1", cost: 111, description: "ololo")
        var pizza2 = Pizza(name: "pizza2", cost: 222, description: "ololo")
        var pizza3 = Pizza(name: "pizza3", cost: 333, description: "ololo")
        var potato1 = Potato(name: "potato4", cost: 444, description: "ololo")
        var potato2 = Potato(name: "potato5", cost: 555, description: "ololo")
        var potato3 = Potato(name: "potato6", cost: 666, description: "ololo")
        self.init(menu:[pizza1, pizza2, pizza3, potato1, potato2, potato3])
    }
}

func minus<T:Numeric>(a:T, b:T) -> T {
    a-b
}