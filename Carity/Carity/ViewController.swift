//
//  ViewController.swift
//  Carity
//
//  Created by Chennasri Kaveti on 10/6/18.
//  Copyright © 2018 Chennasri Kaveti. All rights reserved.
//

import UIKit
//import Braintree
//import AlamoFire


class ViewController: UIViewController {
    @IBOutlet weak var sbutton: UIButton!
    @IBOutlet weak var viewSelected: UIView!
    @IBAction func signupPressed(_ sender: Any)
    {
        self.performSegue(withIdentifier: "goSign", sender: self)
    }
    @IBAction func loginPressed(_ sender: Any)
    {
        //auth using fb:
        self.performSegue(withIdentifier: "goHome", sender: self)
    }
@IBOutlet weak var loginButton: UIButton!
    override func viewDidLoad()
    {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        loginButton.layer.cornerRadius = 15
        sbutton.layer.cornerRadius = 15
        


    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func payPressed(sender: AnyObject){
        
    }
    
    

}

