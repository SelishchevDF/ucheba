//
//  NetworkService.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//

import Foundation

protocol NetworkServiceDelegate: AnyObject {
    func updateTable (models: [Friend])
}


final class NetworkService {
    enum NetworkError: Error {
        case dataError
    }
    private let session = URLSession.shared
    
    static var token = ""
    static var userID = ""
    
    
    func getFriends(getData: @escaping (Result<FriendsModel, Error>) -> Void) {
        guard let url = URL(string:
                                "https://api.vk.com/method/friends.get?access_token=\(NetworkService.token)&v=5.131&fields=online,photo_50")
        else {
            return
        }
        session.dataTask(with: url) { data, _, error in
            guard let data = data else {
                getData(.failure(NetworkError.dataError))
                return
            }
            do {
                let friends = try JSONDecoder().decode(FriendsModel.self, from: data)
                getData(.success(friends))
            } catch {
                getData(.failure(error))
            }
        }.resume()
    }
    
    
    func getGroups(getData: @escaping (Result<GroupsModel, Error>) -> Void) {
        guard let url = URL(string:
                                "https://api.vk.com/method/groups.get?access_token=\(NetworkService.token)&v=5.131&extended=1&fields=description")
        else {
            return
        }
        session.dataTask(with: url) { data, _, error in
            guard let data = data else {
                getData(.failure(NetworkError.dataError))
                return
            }
            do {
                let groups = try JSONDecoder().decode(GroupsModel.self, from: data)
                getData(.success(groups))
            } catch {
                getData(.failure(error))
            }
        }.resume()
    }
    
    
    func getPhotos(completion: @escaping([Photo]) -> Void) {
        guard let url = URL(string: "https://api.vk.com/method/photos.get?fields=bdate&access_token=\(NetworkService.token)&v=5.131&album_id=profile") else {
            return
        }
        
        session.dataTask(with: url) { (data, _, error) in
            guard let data = data else {
                return
            }
            do {
                let photos = try JSONDecoder().decode(PhotosModel.self, from: data)
                completion(photos.response.items)
                print(photos)
            } catch {
                print(error)
            }
        }.resume()
    }
    
    
    
    func getProfile(getData: @escaping (ProfileModel) -> Void) {
        guard let url = URL(string:
                                "https://api.vk.com/method/account.getProfileInfo?access_token=\(NetworkService.token)&album_id=wall&v=5.131")
        else {
            return
        }
        session.dataTask(with: url) { data, _, error in
            guard let data = data else {
                return
            }
            do {
                let profile = try JSONDecoder().decode(ProfileModel.self, from: data)
                getData(profile)
            } catch {
                print(error)
            }
        }.resume()
    }
    
    func getProfilePhoto(photoURL: String?, getData: @escaping (Data) -> Void) {
        DispatchQueue.global().async {
            if let url = URL(string: photoURL ?? ""), let data = try? Data(contentsOf: url) {
                getData(data)
            }
        }
    }
    
    
}
