//
//  FrendsViewController.swift
//  t1
//
//  Created by selishchev on 19/02/2025.
//

import Foundation
import UIKit

class FrendsViewController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Friends"
        view.backgroundColor = UIColor.white
    
    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        5
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        1
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        CustomTableViewCellFriends()
    }
}
