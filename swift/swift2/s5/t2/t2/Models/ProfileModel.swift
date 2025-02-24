//
//  UserModel.swift
//  t1
//
//  Created by selishchev on 22.02.2025.
//

import Foundation

struct ProfileModel: Decodable {
    var responce: Profile
}


struct Profile: Decodable {
    var firstName: String?
    var lastName: String?
    var photo: String?
    
    enum CodingKeys: String, CodingKey {
        case firstName = "first_name"
        case lastName = "last name"
        case photo = "photo_50"
    }
}
