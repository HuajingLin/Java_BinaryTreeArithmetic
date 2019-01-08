//
//  Created by huajing lin on 9/4/18.
//  Copyright © 2018 huajing lin. All rights reserved.
//
package binarytreeapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadTxtFile {

    public String Read() {
        
        String expression = "";
        File file = new File("expression.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadTxtFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (sc.hasNextLine()) {
            //System.out.println(sc.nextLine());
            expression += sc.nextLine() + " ";
        }
        return expression;
    }
}
