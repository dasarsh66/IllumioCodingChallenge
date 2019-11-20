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
public class Rule {
   private String direction;
    private String protocol;
    private Port port;
    private IpAddress ip;

    public Rule(String direction, String protocol, String port, String ip) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = new Port(port);
        this.ip = new IpAddress(ip);
    }

    @Override
    public String toString() {
        return "firewall.Rule{" +
                "direction='" + direction + '\'' +
                ", protocol='" + protocol + '\'' +
                ", port=" + port +
                ", ip=" + ip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        Rule inputRule = (Rule) o;

        return (
                inputRule.direction.equals(this.direction) &&
                inputRule.protocol.equals(this.protocol) &&
                inputRule.port.isValidPort(this.port) &&
                inputRule.ip.isIpInRange(this.ip)
        );


    } 
    
    
    
    
}
