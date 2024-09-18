//
//  ViewController.swift
//  t2
//
//  Created by selishchev on 18/09/2024.
//  Copyright © 2024 selishchev. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    private var image: UIImage = {
        let image = UIImage()
        return image
    }()
    
    private var label: UILabel = {
        let label = UILabel()
        label.text = "OH NOOOOOO!!!"
        label.textAlignment = .center
        label.textColor = .red
        return label
    }()
    
    private var txtF1:UITextField = {
        let txtF1 = UITextField()
        txtF1.text = "login"
        return txtF1
    }()
    
    private var txtF2:UITextField = {
        let txtF2 = UITextField()
        txtF2.text = "pass"
        return txtF2
    }()
    
    private var btn:UIButton = {
        let btn = UIButton()
        btn.setTitle("submit", for: .normal)
        return btn
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        setupViews()
    }
    
    private func setupViews(){
        //view.addSubview(image)
        view.addSubview(label)
        view.addSubview(txtF1)
        view.addSubview(txtF2)
        view.addSubview(btn)
        setupConstraints()
    }
    
    private func setupConstraints(){
       label.translatesAutoresizingMaskIntoConstraints = false
        txtF1.translatesAutoresizingMaskIntoConstraints = false
        txtF2.translatesAutoresizingMaskIntoConstraints = false
        btn.translatesAutoresizingMaskIntoConstraints = false

    }

}

