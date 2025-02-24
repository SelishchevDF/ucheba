//
//  FriendsViewController.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//


import UIKit

final class FriendsViewController: UITableViewController {
    private var friendsModel: FriendsModel?
    private var fileCache = FileCache()

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .systemBackground
        title = "Friends"
        tableView.register(FriendsCell.self, forCellReuseIdentifier: "FriendsCell")
        navigationItem.rightBarButtonItem = UIBarButtonItem(image: UIImage(systemName: "person"), style: .plain, target: self, action: #selector(showPersonalInfo))

        refreshControl = UIRefreshControl()
        refreshControl?.addTarget(self, action: #selector(updateFriends), for: .valueChanged)

        NetworkService().getFriends { [weak self] result in
            switch result {
            case .failure: do {
                    self?.friendsModel = self?.fileCache.getFriends()

                    if self?.friendsModel?.response?.count == 0 {
                        DispatchQueue.main.async {
                            self?.title = "Друзей нет"
                        }
                    }
                    DispatchQueue.main.async {
                        self?.showAlert()
                    }
                }
            case let .success(friendsModel):
                do {
                    self?.friendsModel = friendsModel

                    self?.fileCache.putFriends(friends: self?.friendsModel?.response?.items ?? [])

                    if friendsModel.response?.count == 0 {
                    
                        DispatchQueue.main.async {
                            self?.title = "Друзей нет"
                        }
                    } else {
                        self?.friendsModel = friendsModel

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

    private func showAlert() {
        let alert = UIAlertController(title: "Не удалось получить данные о друзьях",
                                      message: "Данные прочитаны локально за дату \(DateHelper.getDateString(date: fileCache.getFriendDate()))",
                                      preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Закрыть", style: .default, handler: nil))
        present(alert, animated: true, completion: nil)
    }

    @objc private func showPersonalInfo() {
        let animation = CATransition()
        animation.type = .fade
        animation.duration = 1
        navigationController?.view.layer.add(animation, forKey: nil)
        navigationController?.pushViewController(ProfileViewController(isUserProfile: true), animated: false)
    }

    override func tableView(_: UITableView, numberOfRowsInSection _: Int) -> Int {
        return friendsModel?.response?.count ?? 0
    }

    @objc private func updateFriends() {
        NetworkService().getFriends { [weak self] result in
            switch result {
            case .failure: do {
                    self?.friendsModel = self?.fileCache.getFriends()

                    if self?.friendsModel?.response?.count == 0 {
                        DispatchQueue.main.async {
                            self?.title = "Друзей нет"
                        }
                    }
                    DispatchQueue.main.async {
                        self?.showAlert()
                    }
                }
            case let .success(friendsModel):
                do {
                    self?.friendsModel = friendsModel

                    self?.fileCache.putFriends(friends: self?.friendsModel?.response?.items ?? [])

                    if friendsModel.response?.count == 0 {
                        
                        DispatchQueue.main.async {
                            self?.title = "Друзей нет"
                        }
                    } else {
                        self?.friendsModel = friendsModel

                        DispatchQueue.main.async {
                            self?.tableView.reloadData()
                        }
                    }
                }
            }
            DispatchQueue.main.async {
                self?.refreshControl?.endRefreshing()
            }
        }
    }

    override func tableView(_: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell =
            tableView.dequeueReusableCell(withIdentifier: "FriendsCell", for: indexPath) as? FriendsCell
        else {
            return UITableViewCell()
        }
        guard let friend = friendsModel?.response?.items?[indexPath.row] else {
            return UITableViewCell()
        }

        cell.updateCell(friend: friend)
        cell.tap = { [weak self] name, photo in
            self?.navigationController?.pushViewController(ProfileViewController(name: name, photo: photo, isUserProfile: false), animated: true)
        }
        return cell
    }
}
