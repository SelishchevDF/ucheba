// The Swift Programming Language
// https://docs.swift.org/swift-book

var teas = ["tea1":"100", "tea2":"200", "tea3":"300"]
var customers = ["tea3", "tea2", "tea1"]
for (index, value) in customers.enumerated() {
    for (key, prise) in teas {
        if (value == key) {
        print("\(index + 1) + \(value) + \(prise)")
        }
    } 
}

var array:[Int?] = [-4, 5, 10, nil, 4, nil, 25, 0, nil, 16, 75, -20, -7, 15, 0, nil]
var arrayNew = [Int]()
for item in array {
    if (item != 4 && item != 0 && item != nil){
        arrayNew.append(item!)
    }
}
arrayNew.sort()
print(arrayNew)

func createArray(num:Int) -> [Int] {
    var array:[Int] = []
    var count = 1
    for i in 0...num-1{
        array.append(count)
        count *= 2
    }
    return array
}
print(createArray(num: 4))