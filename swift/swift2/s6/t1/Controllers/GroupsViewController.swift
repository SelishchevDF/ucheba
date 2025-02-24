//
//  GroupsViewController.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//



import Foundation
import UIKit


final class GroupsViewController: UITableViewController {
    private var groupsModel: GroupsModel?
    private var fileCache = FileCache()

    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Groups"
        tableView.register(GroupsCell.self, forCellReuseIdentifier: "GroupsCell")

        NetworkService().getGroups { [weak self] result in
            switch result {
            case .failure: do {
                    self?.groupsModel = self?.fileCache.getGroups()

                    if self?.groupsModel?.response?.count == 0 {
                        DispatchQueue.main.async {
                            self?.title = "Групп нет"
                        }
                    }
                    DispatchQueue.main.async {
                        self?.showAlert()
                    }
                }
            case let .success(groupsModel): do {
                    self?.groupsModel = groupsModel

                    self?.fileCache.putGroups(groups: self?.groupsModel?.response?.items ?? [])

                    if groupsModel.response?.count == 0 {
                        
                        DispatchQueue.main.async {
                            self?.title = "Групп нет"
                        }
                    } else {
                        self?.groupsModel = groupsModel

                        DispatchQueue.main.async {
                            self?.tableView.reloadData()
                        }
                    }
                }
            }
        }
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        view.backgroundColor = Theme.currentTheme.backgroundColor
    }

    override func tableView(_: UITableView, numberOfRowsInSection _: Int) -> Int {
        return groupsModel?.response?.count ?? 0
    }

    override func tableView(_: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let groupCell =
            tableView.dequeueReusableCell(withIdentifier: "GroupsCell", for: indexPath) as? GroupsCell
        else {
            return UITableViewCell()
        }
        guard let group = groupsModel?.response?.items?[indexPath.row] else {
            return UITableViewCell()
        }
        groupCell.setupTextGroups(group: group)
        return groupCell
    }

    private func showAlert() {
        let alert = UIAlertController(title: "Не удалось получить данные о группах",
                                      message: "Данные прочитаны локально за дату \(DateHelper.getDateString(date: fileCache.getFriendDate()))",
                                      preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Закрыть", style: .default, handler: nil))
        present(alert, animated: true, completion: nil)
    }
}
