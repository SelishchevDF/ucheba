//
//  Theme.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//



import UIKit

enum AllAppTheme: String {
    case white
    case blue
    case grey
}

protocol AppTheme {
    var backgroundColor: UIColor { get }
    var textColor: UIColor { get }
    var subtitleTextColor: UIColor { get }
    var type: AllAppTheme { get }
}


extension AppTheme {
    var subtitleTextColor: UIColor {
        .gray
    }
}

final class Theme {
    static var currentTheme: AppTheme = WhiteTheme ()
}

final class WhiteTheme: AppTheme {
    var backgroundColor: UIColor = .white
    var textColor: UIColor = .black
    var type: AllAppTheme = .white
}

final class BlueTheme: AppTheme {
    var backgroundColor: UIColor = UIColor(red: 228/255, green: 231/255, blue: 255, alpha: 1)
    var textColor: UIColor = .brown
    var type: AllAppTheme = .blue
}

final class GreyTheme: AppTheme {
    var backgroundColor: UIColor = UIColor(red: 229/255, green: 229/255, blue: 229/255, alpha: 1)
    var textColor: UIColor = .systemPink
    var type: AllAppTheme = .grey
}
