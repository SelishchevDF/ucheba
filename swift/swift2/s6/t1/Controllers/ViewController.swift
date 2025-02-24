//
//  ViewController.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//

import UIKit
import WebKit

class ViewController: UIViewController {
    
    private lazy var webView: WKWebView = {
        let webView = WKWebView(frame: view.bounds)
        webView.navigationDelegate = self
        return webView
    }()
   
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear (animated)
        view.backgroundColor = Theme.currentTheme.backgroundColor
        }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = Theme.currentTheme.backgroundColor
        ThemeSaver.getData()
        view.addSubview(webView)
        self.navigationController?.isNavigationBarHidden = true
        
        let url = URL(string: "https://oauth.vk.com/authorize?client_id=51873853&redirect_uri=https://oauth.vk.com/blank.html&scope=262150&display=mobile&response_type=token")
        webView.load(URLRequest(url: url!))
    }
        
        private func tap1() {
            let tabBarController = UITabBarController()
            let viewController1 = UINavigationController(rootViewController: FriendsViewController())
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
            

            
            guard let firstScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
                        let firstWindow = firstScene.windows.first else {
                      return
                    
            }
            
            firstWindow.rootViewController = tabBarController
        
    }
    
    
}

extension ViewController: WKNavigationDelegate {
    func webView(_ webView: WKWebView, decidePolicyFor navigationResponse: WKNavigationResponse, decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void) {
        guard let url = navigationResponse.response.url, url.path == "/blank.html",
        let fragment = url.fragment else {
            decisionHandler(.allow)
            return
        }
        let params = fragment
            .components(separatedBy: "&")
            .map { $0.components(separatedBy: "=") }
            .reduce([String: String]()) { result, param in
                var dict = result
                let key = param[0]
                let value = param[1]
                dict[key] = value
                return dict
            }
        NetworkService.token = params["access_token"]!
        NetworkService.userID = params["user_id"]!
        decisionHandler(.cancel)
        webView.removeFromSuperview()
        tap1()
    }
}
