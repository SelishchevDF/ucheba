// The Swift Programming Language
// https://docs.swift.org/swift-book

func vklad(money: Double, percent: Double, days: Double) -> Double {
    return ((money * percent * days/365)/100 + money) 
}
print(vklad(money: 10000, percent: 25, days: 365))

enum Pizza: String {
    case pizza1 = "Pizza111"
    case pizza2 = "Pizza222"
    case pizza3 = "Pizza333"
}

print(Pizza.pizza1.rawValue)

