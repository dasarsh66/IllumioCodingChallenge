
# IllumioCodingChallenge

- Coding Assignment : firewall system

Code Explanation :
Firewall.java
I created a class Firewall.java which takes in a input file and reads, parses and stores all of the rules in the input file.
I used a HashSet to store rules read from input file. This class uses Rule.java
Rule.java 
This class creates rule objects read from the data provided by Firewall.java(direction,protocol,iPAddress and Port). This class uses ipAddress.java and Port.java to create new ipAddress and port objects.
IpAddress.java
This creates ipAddress objects used by rule.java
Port.java
This creates Port objects used by rule.java
FirewallTest.java
For testing

Testing : 
FirewallTest.java class was created to test the code. This leverages junit framework for testing. Both true and false assertions have been tested in this class. There's a input.csv file included which has some input test data to test the code


Time complexity to accept 1 packet : 
O(n), where n is the units of times required to itereate through n number of rules read from the input file


Optimizations suggested  : 
To improve further on time complexity, I would create a data structure which would genereate a unique value for every rule so that time complecity for accepting a packet would be O(1). I would probaly implement a custom HashTable to make this change

Team Interested in the order of preference : 
1) Data team
2) Platform team
