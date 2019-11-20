/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firewall;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author Dash
 */
public class IpAddress {
    private List<Integer> startIp;
    private List<Integer> endIp;

    public IpAddress(String ipString) {
        if (ipString.indexOf('-') != -1) {
            String[] ranges = ipString.split("-");

            this.startIp = Arrays
                            .stream(ranges[0].split("\\."))
                            .map(e -> Integer.parseInt(e))
                            .collect(Collectors.toList());

            this.endIp = Arrays
                            .stream(ranges[1].split("\\."))
                            .map(e -> Integer.parseInt(e))
                            .collect(Collectors.toList());
        }
        else {
            this.startIp = this.endIp = Arrays
                                                    .stream(ipString.split("\\."))
                                                    .map(e -> Integer.parseInt(e))
                                                    .collect(Collectors.toList());
        }
    }

    public boolean isIpInRange(IpAddress ip) {
        for (int i=0; i<4; i++) {
            if (ip.startIp.get(i) < this.startIp.get(i) || ip.endIp.get(i) > this.endIp.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "firewall.IpAddress{" +
                "startIpRange=" + startIp +
                ", endIpRange=" + endIp +
                '}';
    }
}
