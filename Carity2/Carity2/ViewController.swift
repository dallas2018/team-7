//
//  ViewController.swift
//  Carity2
//
//  Created by Sandeep shahi on 10/6/18.
//  Copyright © 2018 Sandeep shahi. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func launchButton(_ sender: Any)
    {
        self.performSegue(withIdentifier: "goLanding", sender: self)
    }
    override func viewDidLoad()
    {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }


}

