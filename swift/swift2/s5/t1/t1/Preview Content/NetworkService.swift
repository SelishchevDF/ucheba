//
//  NetworkService.swift
//  t1
//
//  Created by selishchev on 22.02.2025.
//

import Foundation
final class NetworkService {
    func getNews (completion:@escaping ([News]) -> ()) {
        guard let url = URL(string: "https://kudago.com/public-api/v1.4/news/?fields=id,title,publication_date&text_format=text&actual_only=true")
            else { return }
        URLSession.shared.dataTask(with: url) { (data, _, _) in
            guard let data = data else { return }
            do {
                let news = try
                    JSONDecoder().decode(NewsModel.self, from: data)
                completion(news.results)
            } catch {
                print(error)
            }
        }
        .resume()
    }
}
