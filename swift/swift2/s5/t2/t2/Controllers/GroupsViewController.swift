//
//  GroupsViewController.swift
//  t1
//
//  Created by selishchev on 22.02.2025.
//



import Foundation
import UIKit


class GroupsViewController: UITableViewController {
    private var networkService = NetworkService()
    private var models: [Group] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Groups"
        view.backgroundColor = UIColor.white
        tableView.register(GroupsCell.self, forCellReuseIdentifier: "GroupsCell")
              
        networkService.getGroups() { [ weak self ] groups in
            self?.models = groups
            DispatchQueue.main.async {
                      self?.tableView.reloadData()
                  }
            }
      }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        models.count
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        models.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
           let cell = tableView.dequeueReusableCell(withIdentifier: "GroupsCell", for: indexPath)
           let model = models[indexPath.row]
           guard let cell = cell as? GroupsCell else {
               return UITableViewCell()
           }
           
           cell.setupTextGroups(group: model)
           return cell
       }
}
