//
//  UserModel.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//

import Foundation

struct UserModel: Decodable {
    var responce: [User]
}

struct User: Decodable {
    var firstName: String?
    var lastName: String?
    var photo: String?

    enum CodingKeys: String, CodingKey {
        case firstName = "first_name"
        case lastName = "last_name"
        case photo = "photo_400_orig"
    }
}
