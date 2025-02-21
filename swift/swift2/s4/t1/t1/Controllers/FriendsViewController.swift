//
//  FriendsViewController.swift
//  t1
//
//  Created by selishchev on 21.02.2025.
//

import Foundation
import UIKit

class FriendsViewController: UITableViewController {
    
    private var networkService = NetworkService()
    private var models: [Friend] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Friends"
        view.backgroundColor = .white
        tableView.backgroundColor = .white
        tableView.register(FriendsCell.self, forCellReuseIdentifier: "FriendsCell")
        networkService.getFriends { [weak self] friends in self?.models = friends
            DispatchQueue.main.async {self?.tableView.reloadData()
            
              }
          }
      }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear (animated)
        view.backgroundColor = .white
        tableView.backgroundColor = .white
        tableView.reloadData()
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        models.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "FriendsCell", for: indexPath) as? FriendsCell else {
            return UITableViewCell()
        }
        let model = models[indexPath.row]
        cell.updateCell(model: model)
        return cell
    }
}

    
    
