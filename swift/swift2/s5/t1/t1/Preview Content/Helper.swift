//
//  Helper.swift
//  t1
//
//  Created by selishchev on 22.02.2025.
//

import Foundation

final class Helper {
    static func getDate (date: Double) -> String {
        
        let currentDate = Date(timeIntervalSince1970: date)
        
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "dd MM YYYY"
        dateFormatter.locale = Locale(identifier: "ru_RU")
        
        return dateFormatter.string(from: currentDate)
    }
}
