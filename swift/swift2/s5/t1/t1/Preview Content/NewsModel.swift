//
//  NewsModel.swift
//  t1
//
//  Created by selishchev on 22.02.2025.
//

import Foundation

struct NewsModel: Decodable {
    var results: [News]
}



struct News: Decodable, Identifiable {
    var id: Int
    var date: Double
    var title: String
    
    
    enum CodingKeys: String, CodingKey {
        case id
        case date = "publication_date"
        case title
    }
}
