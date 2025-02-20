//
//  GroupCell.swift
//  t1
//
//  Created by selishchev on 20.02.2025.
//

// viewController2

import Foundation
import UIKit

class GroupsViewController: UITableViewController {
    private var networkService = NetworkService()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Groups"
        view.backgroundColor = UIColor.white
        networkService.getGroups()

    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        5
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        1
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        CustomTableViewCellGroups()
    }
}
