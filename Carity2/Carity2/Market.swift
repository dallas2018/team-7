//
//  Market.swift
//  Carity2
//
//  Created by Sandeep shahi on 10/6/18.
//  Copyright © 2018 Sandeep shahi. All rights reserved.
//

import UIKit

class Market: UIViewController {

    @IBAction func donateButton2Pressed(_ sender: Any)
    {
        self.performSegue(withIdentifier: "goCharity", sender: self)
    }
    @IBOutlet weak var cuteImg: UIImageView!
    @IBOutlet weak var donateButton2: UIButton!
    @IBOutlet weak var donateButton: UIButton!
    @IBAction func donatePressed(_ sender: Any)
    {
        //go to donation page
    }
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        donateButton.layer.cornerRadius = 5
        donateButton2.layer.cornerRadius = 15
        cuteImg.layer.cornerRadius = 5
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
