//
//  ThemeSaver.swift
//  t2
//
//  Created by selishchev on 22.02.2025.
//

//
//import Foundation
//
//final class ThemeSaver {
//    
//    static func putData () {
//        let theme = Theme.currentTheme.type
//        UserDefaults.standard.set (theme.rawValue, forKey: "theme")
//    }
//    
//    static func getData () {
//        let theme = UserDefaults.standard.string (forKey: "theme" )
//        let themeType = AllAppTheme (rawValue: theme ?? "white")
//        switch themeType {
//        case .white: Theme.currentTheme = WhiteTheme ()
//        case .blue: Theme.currentTheme = BlueTheme ()
//        case .grey: Theme.currentTheme = GreyTheme ( )
//        default: Theme.currentTheme = WhiteTheme ()
//        }
//    }
//}
