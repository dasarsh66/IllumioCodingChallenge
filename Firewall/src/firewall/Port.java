/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firewall;
/**
 *
 * @author Dash
 */
public class Port {
    
    private int startRange;
    private int endRange;

    public Port(String port) {
        if (port.indexOf('-') != -1) {
            startRange = Integer.parseInt(port.split("-")[0]);
            endRange = Integer.parseInt(port.split("-")[1]);
        }
        else {
            startRange = Integer.parseInt(port);
            endRange = Integer.parseInt(port);
        }
    }

    public boolean isValidPort(Port port) {
        return port.startRange >= this.startRange && port.endRange <= this.endRange;
    }
}
