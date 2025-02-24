//
//  GroupsModel.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//

import Foundation


struct GroupsModel: Codable {
    var response: GroupsResponse?
}

struct GroupsResponse: Codable {
    var count: Int
    var items: [Group]?
}

struct Group: Codable {
    var id: Int
    var name: String?
    var description: String?
    var photo: String?

    enum CodingKeys: String, CodingKey {
        case id
        case name
        case description
        case photo = "photo_50"
    }
}
