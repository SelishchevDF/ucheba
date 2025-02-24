//
//  ProfileViewController.swift
//  t1
//
//  Created by selishchev on 22.02.2025.
//



import Foundation
import UIKit

final class ProfileViewController: UIViewController {
    
    private var networkService = NetworkService()
    private var profile: ProfileModel? = nil
    
    private var profileImageView: UIImageView = {
        let photo = UIImageView()
        photo.backgroundColor = .clear
        photo.layer.borderWidth = 1
        photo.layer.cornerRadius = 10
        photo.layer.masksToBounds = true
        return photo
        
    }()
    
    private var profileName: UILabel = {
        var label = UILabel()
        label.textColor = .black
        label.numberOfLines = 0
        label.textAlignment = .center
        return label
    }()
    
    private var isUserProfile: Bool
    
    init (name: String? = nil, photo: UIImage? = nil, isUserProfile: Bool) {
        self.isUserProfile = isUserProfile
        super.init (nibName: nil, bundle: nil)
        profileName.text = name
        profileName.font = UIFont(name: "Papyrus", size: 30)
        profileImageView.image = photo
             
       
    }
    
    required init?(coder: NSCoder) {
        fatalError ("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad ()
        title = "Profile"
        view.backgroundColor = .white
        setupViews()
        networkService.getProfile { [weak self] profile in
            self?.profile = profile
          
        }
            
    }
    
    func updateData(model: Profile?) {
        guard let model = model else { return }
        DispatchQueue.global().async {
            if let url = URL(string: model.photo ?? ""), let data = try? Data(contentsOf: url) {
                DispatchQueue.main.async {
                    self.profileImageView.image = UIImage(data: data)
                }
            }
        }
        DispatchQueue.main.async {
            self.profileName.text = (model.firstName ?? "") + " " + (model.lastName ?? "")
        }
    }

    
    
            
        
        
        func setupViews () {
            view.addSubview(profileImageView)
            view.addSubview(profileName)
          
            setupConstraints()
        }
        
        
        
        
        func setupConstraints() {
            profileImageView.translatesAutoresizingMaskIntoConstraints = false
            profileName.translatesAutoresizingMaskIntoConstraints = false
            
            
            NSLayoutConstraint.activate([
                profileImageView.centerYAnchor.constraint(equalTo: view.centerYAnchor, constant: -50),
                profileImageView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 30),
                profileImageView.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -30),
                profileImageView.heightAnchor.constraint(equalTo: profileImageView.widthAnchor),
                
                
                profileName.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 30),
                profileName.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: -30),
                profileName.topAnchor.constraint(equalTo: profileImageView.bottomAnchor, constant: 30),
                
               
            ])
        }
}

    
 



