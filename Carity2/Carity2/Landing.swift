//
//  Landing.swift
//  Carity2
//
//  Created by Sandeep shahi on 10/6/18.
//  Copyright © 2018 Sandeep shahi. All rights reserved.
//

import UIKit

class Landing: UIViewController
{

    @IBAction func loginPressed(_ sender: Any) {
    }
    @IBOutlet weak var loginButton: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        loginButton.layer.cornerRadius = 15
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
