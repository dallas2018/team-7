//
//  Marketplace.swift
//  Carity
//
//  Created by Chennasri Kaveti on 10/6/18.
//  Copyright © 2018 Chennasri Kaveti. All rights reserved.
//

import UIKit

class Marketplace: UIViewController {

    @IBAction func donatePressed(_ sender: Any)
    {
        self.performSegue(withIdentifier: "goPayment", sender: self)
    }
    @IBAction func homePressed(_ sender: Any)
    {
        self.performSegue(withIdentifier: "goHomeBro", sender: self)
    }
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
