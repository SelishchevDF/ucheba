//
//  CustomTableViewCellName.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//

import Foundation
import UIKit

final class FriendsCell: UITableViewCell {
    
    var tap: ((String?, UIImage?) -> Void)?
    
    private var friendImageView = UIImageView(image: UIImage(systemName: "person"))
    
      
    private var text: UILabel = {
        let label = UILabel()
        label.text = "Name"
        label.textColor = .black
        return label
    }()
    
    private var onlineCircle: UIView = {
        let circle = UIView()
        circle.backgroundColor = .gray
        circle.layer.cornerRadius = 10
        return circle
    }()
    

    
    func updateCell (friend:Friend) {
        text.text = (friend.firstName ?? "") + " " + (friend.lastName ?? "")
        if friend.online == 0 {
            onlineCircle.backgroundColor = .red
        } else {
            onlineCircle.backgroundColor = .green
        }
        


    
    DispatchQueue.global ().async {
        if let url = URL(string: friend.photo ?? ""), let data = try?
            Data (contentsOf: url)
        {
            DispatchQueue.main.async {
                self.friendImageView.image = UIImage (data: data)
            }
        }
    }
}
    
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        backgroundColor = .clear
        let recognizer = UITapGestureRecognizer(target: self, action: #selector(cellClick))
        addGestureRecognizer(recognizer)
        setupViews()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupViews() {
        contentView.addSubview(friendImageView)
        contentView.addSubview(text)
        friendImageView.addSubview(onlineCircle)
        setupConstraints()
    }
    
    private func setupConstraints() {
        friendImageView.translatesAutoresizingMaskIntoConstraints = false
        text.translatesAutoresizingMaskIntoConstraints = false
        onlineCircle.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            friendImageView.centerYAnchor.constraint(equalTo: contentView.centerYAnchor),
            friendImageView.leadingAnchor.constraint(equalTo: contentView.leadingAnchor, constant: 10),
            friendImageView.heightAnchor.constraint(equalToConstant: 50),
            friendImageView.widthAnchor.constraint(equalTo: friendImageView.heightAnchor),
                      
            onlineCircle.widthAnchor.constraint(equalToConstant: 20),
            onlineCircle.heightAnchor.constraint(equalTo: onlineCircle.widthAnchor),
            onlineCircle.bottomAnchor.constraint(equalTo: friendImageView.bottomAnchor),
            onlineCircle.trailingAnchor.constraint(equalTo: friendImageView.trailingAnchor, constant: 10),
                      
            text.topAnchor.constraint(equalTo: contentView.topAnchor, constant: 30),
            text.leadingAnchor.constraint(equalTo: friendImageView.trailingAnchor, constant: 30),
            text.trailingAnchor.constraint(equalTo: contentView.trailingAnchor, constant: 10),
            text.bottomAnchor.constraint(equalTo: contentView.bottomAnchor, constant: -30)
        ])
    }
    
    @objc private func cellClick() {
        tap?(text.text,friendImageView.image)
    }
    
}
