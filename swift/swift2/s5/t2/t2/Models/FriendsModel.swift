//
//  FriendsModel.swift
//  t2
//
//  Created by selishchev on 22.02.2025.
//

struct FriendsModel: Decodable {
    var response: Friends
}

struct Friends: Decodable {
    var items: [Friend]
}

struct Friend: Decodable {
    var id: Int
    var firstName: String?
    var lastName: String?
    var photo: String?
    var online: Int?
    
    enum CodingKeys: String, CodingKey {
        case id
        case firstName = "first_name"
        case lastName = "last_name"
        case photo = "photo_50"
        case online
    }
}
