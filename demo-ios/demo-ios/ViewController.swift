//
//  ViewController.swift
//  demo-ios
//
//  Created by Radhika Yusuf on 29/04/21.
//

import UIKit
import shared_auth

class ViewController: UIViewController, LoginPresenter {
    

    @IBOutlet weak var fieldUserKey: UITextField!
    @IBOutlet weak var buttonLogin: UIButton!
        
    lazy private var userData: UserDefaults = UserDefaults.standard
    lazy private var loginRepository = LoginRepositoryImpl(service: AuthServices(), preferences: UserPreferences())
    lazy private var loginUseCase = LoginUseCase(loginRepository: loginRepository, loginPresenter: self)
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    @IBAction func buttonLoginClickEvent(_ sender: Any) {
        loginUseCase.doLoginByKey(key: (fieldUserKey.text ?? ""))
    }

    func onLoginSuccess() {
        let userName = (userData.object(forKey: "user_name") ?? "") as! String
        print("Success Login " + userName)
    }
        
    func showMessage(message: String) {
        print("Gagal " + message)
    }
}

