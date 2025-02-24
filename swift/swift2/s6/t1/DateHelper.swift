//
//  DateHelper.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//

import Foundation


final class DateHelper {
    static func getDateString(date: Date?) -> String {
        if date == nil { return "" }
        let dateFormatter = DateFormatter()
        dateFormatter.timeStyle = .medium
        dateFormatter.dateStyle = .short
        dateFormatter.locale = Locale(identifier: "ru_RU")
        return dateFormatter.string(from: date!)
    }
}
