// The Swift Programming Language
// https://docs.swift.org/swift-book
enum Post: String {
    case cashier
    case cook
}

struct Worker {
    var name: String
    var salary : Double
    var post: Post
}

class Table {
    var name : String
    var capacity : Int
    var pizzeriaName : String

    init(name: String, capacity: Int, pizzeriaName: String) {
        self.name = name
        self.capacity = capacity
        self.pizzeriaName = pizzeriaName
    }

    func checkCapacity(visitors : Int) -> Bool {
        self.capacity >= visitors
    }
}

class Pizzeria{
    var workers : [Worker] = []
    var tables : [Table] = []
    var name : String 

    init(workers : [Worker], tables: [Table], name: String) {
        self.workers = workers
        self.tables = tables
        self.name = name
    }

    convenience init(name: String){
        var w1 = Worker(name: "W1", salary: 111, post: Post.cook)
        var w2 = Worker(name: "W2", salary: 2222, post: Post.cashier)
        var w3 = Worker(name: "W3" , salary: 3333, post: Post.cook)
        var t1 = Table(name: "t1", capacity: 1, pizzeriaName: name)
        var t2 = Table(name: "t2", capacity: 2, pizzeriaName: name)
        var t3 = Table(name: "t3", capacity: 3, pizzeriaName: name)
        self.init(workers:[w1,w2,w3], tables:[t1,t2,t3], name: name)
    }

}

var pizzeria = Pizzeria(name: "pizzeria")

print(pizzeria.tables[1].checkCapacity(visitors: 2)) 
print (pizzeria.name)