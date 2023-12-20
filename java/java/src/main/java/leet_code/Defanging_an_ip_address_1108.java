package leet_code;

public class Defanging_an_ip_address_1108 {
    public String defangIPaddr(String address) {
        if (address == null) {
            return address;
        }
        return address.replaceAll("\\.","[.]");
    }
}
