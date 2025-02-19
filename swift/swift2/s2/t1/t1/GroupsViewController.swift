//
//  GroupCell.swift
//  t1
//
//  Created by selishchev on 19/02/2025.
//

// viewController2

import Foundation
import UIKit

class GroupsViewController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Groups"
        view.backgroundColor = UIColor.white
//        navigationController? .setNavigationBarHidden(true, animated: true)
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
