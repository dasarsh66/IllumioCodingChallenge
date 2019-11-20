/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firewall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author Dash
 */
public class Firewall {

    /**
     * @param args the command line arguments
     */
   
    Set<Rule> rulesSet;
    
    public Firewall(String filepath) throws IOException {
        rulesSet = new HashSet<>();
        fileRead(filepath);
    }
    
     private void fileRead(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] attributes = line.split(",");
            rulesSet.add(new Rule(
                                attributes[0],
                                attributes[1],
                                attributes[2],
                                attributes[3]
                            ));
        }
    }
     
     
   
    public boolean accept_packet(String direction, String protocol, int port, String ip_address) {
        Rule rule = new Rule(direction, protocol, String.valueOf(port), ip_address);
        Iterator<Rule> itr = rulesSet.iterator();
        while (itr.hasNext()) {
            if (rule.equals(itr.next())) {
                return true;
            }
        }
        return false;
    }  
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
