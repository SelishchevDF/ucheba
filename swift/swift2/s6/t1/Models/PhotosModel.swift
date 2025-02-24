//
//  PhotosModel.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//

import Foundation

struct PhotosModel: Decodable {
    var response: Photos
}

struct Photos: Decodable {
    var items: [Photo]
}

struct Photo: Decodable {
    var id: Int
    var text: String?
    var sizes: [Sizes]
}

struct Sizes: Codable {
    var url: String
}
