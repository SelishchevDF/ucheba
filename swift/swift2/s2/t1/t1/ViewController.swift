//
//  ViewController.swift
//  t1
//
//  Created by selishchev on 19/02/2025.
//

import UIKit

class ViewController: UIViewController {
    
      
    private var imageView = UIImageView(image: UIImage(systemName: "person"))
    
    
    
    private var label: UILabel = {
        let label = UILabel()
        label.text = "Autorization"
        label.textAlignment = .center
        label.font = UIFont(name: "Papyrus", size: 30)
        label.textColor = .white
        label.backgroundColor = .systemBlue
        return label
    }()
    
    private var loginField: UITextField = {
        let  login = UITextField()
        login.borderStyle = .line
        login .layer.borderWidth = 1
        login.layer.borderColor = UIColor.black.cgColor
        login.textColor = .black
        let placeholderText = NSAttributedString(string: "Login", attributes: [NSAttributedString.Key.foregroundColor:UIColor.gray])
        login.attributedPlaceholder = placeholderText
        return login
    }()
    
    private var passwordField: UITextField = {
        let password = UITextField()
        password.borderStyle = .line
        password .layer.borderWidth = 1
        password.layer.borderColor = UIColor.black.cgColor
        password.textColor = .black
        let placeholderText = NSAttributedString(string: "Password", attributes: [NSAttributedString.Key.foregroundColor:UIColor.gray])
        password.attributedPlaceholder = placeholderText
        return password
    }()
    
    private var enterButton: UIButton = {
        let button = UIButton()
        button.setTitle("Enter", for: .normal)
        button.titleLabel?.font = UIFont.systemFont(ofSize: 40)
        button.setTitleColor(.black, for: .normal)
        button.setTitleColor(.green, for:.highlighted)
    
        return button
    }()
        
        
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        enterButton.addTarget(self, action: #selector(tap1), for: .touchUpInside)
        self.navigationController?.isNavigationBarHidden = true
        setupViews()
    }
    
    
    private func setupViews() {
        view.addSubview(imageView)
        view.addSubview(label)
        view.addSubview(loginField)
        view.addSubview(passwordField)
        view.addSubview(enterButton)
        setupConstraints()
    }
    
    private func setupConstraints() {
        imageView.translatesAutoresizingMaskIntoConstraints = false
        label.translatesAutoresizingMaskIntoConstraints = false
        loginField.translatesAutoresizingMaskIntoConstraints = false
        passwordField.translatesAutoresizingMaskIntoConstraints = false
        enterButton.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            imageView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor, constant: 10),
            imageView.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            imageView.widthAnchor.constraint(equalToConstant: view.frame.size.width/4),
            imageView.heightAnchor.constraint(equalToConstant: view.frame.size.width/3.5),
            
            
            label.topAnchor.constraint(equalTo: imageView.bottomAnchor, constant: 20),
            label.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 10),
            label.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -10),
            label.heightAnchor.constraint(equalToConstant: 100),
            
            
            loginField.topAnchor.constraint(equalTo: label.bottomAnchor, constant: 30),
            loginField.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 30),
            loginField.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -30),
            loginField.heightAnchor.constraint(equalToConstant: 50),
            
            
            passwordField.topAnchor.constraint(equalTo: loginField.bottomAnchor, constant: 10),
            passwordField.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 30),
            passwordField.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -30),
            passwordField.heightAnchor.constraint(equalToConstant: 50),
            
            
            enterButton.topAnchor.constraint(equalTo: passwordField.bottomAnchor, constant: 30),
            enterButton.centerXAnchor.constraint(equalTo: view.centerXAnchor),
            enterButton.widthAnchor.constraint(equalToConstant: view.frame.size.width/4),
            enterButton.heightAnchor.constraint(equalToConstant: view.frame.size.width/4)
        ])
                
    }
}

private extension ViewController {
    @objc func tap1() {
        let tabBarController = UITabBarController()
        let viewController1 = UINavigationController(rootViewController: FrendsViewController())
        let viewController2 = UINavigationController(rootViewController: GroupsViewController())
        let viewController3 = UINavigationController(rootViewController: PhotosViewController(collectionViewLayout:UICollectionViewFlowLayout()))
        
        viewController1.tabBarItem.title = "Friends"
        viewController2.tabBarItem.title = "Groups"
        viewController3.tabBarItem.title = "Photos"
        
        
        let controllers = [viewController1, viewController2, viewController3]
        
        for element in controllers {
            element.tabBarItem.setTitleTextAttributes([.font: UIFont.systemFont(ofSize: 25.0, weight: .regular)], for: .normal)
        }
        tabBarController.viewControllers = controllers
        
        navigationController?.pushViewController(tabBarController, animated: true)
        
    }
    
}
