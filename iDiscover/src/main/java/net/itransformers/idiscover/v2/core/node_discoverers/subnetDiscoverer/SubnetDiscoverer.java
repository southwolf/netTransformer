package net.itransformers.idiscover.v2.core.node_discoverers.subnetDiscoverer;

import net.itransformers.idiscover.v2.core.NodeDiscoverer;
import net.itransformers.idiscover.v2.core.NodeDiscoveryResult;
import net.itransformers.idiscover.v2.core.connection_details.IPNetConnectionDetails;
import net.itransformers.idiscover.v2.core.model.ConnectionDetails;
import net.itransformers.utils.CIDRUtils;
import org.apache.commons.net.util.SubnetUtils;
import org.apache.log4j.Logger;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vasil Yordanov on 22-Jun-16.
 */
public class SubnetDiscoverer implements NodeDiscoverer {
    static Logger logger = Logger.getLogger(SubnetDiscoverer.class);

    boolean generateIPconnectionsForSubnetMembers;

    public SubnetDiscoverer(boolean generateIPconnectionsForSubnetMembers) {
        this.generateIPconnectionsForSubnetMembers = generateIPconnectionsForSubnetMembers;
    }

    @Override
    public NodeDiscoveryResult discover(ConnectionDetails connectionDetails) {


        String protocolType = connectionDetails.getParam("protocolType");
        String subnetIpAddress = connectionDetails.getParam("ipAddress");
        String subnetPrefixMask = connectionDetails.getParam("subnetPrefixMask");

        String subnetPrefix=subnetIpAddress+"/"+subnetPrefixMask;

        NodeDiscoveryResult nodeDiscoveryResult = new NodeDiscoveryResult(subnetPrefix,null);
        nodeDiscoveryResult.setDiscoveredData("subnetDetails", connectionDetails.getParams());
        if (generateIPconnectionsForSubnetMembers)
            nodeDiscoveryResult.setNeighboursConnectionDetails(getSubnetIpNeighborConnections(subnetPrefix));

        try {
            InetAddress inetAddress = InetAddress.getByName(subnetIpAddress);
            if (inetAddress instanceof Inet4Address)
                if (bogonSubnetIdentifier(subnetIpAddress)) {
                    nodeDiscoveryResult.setDiscoveredData("bogon", true);

                }
            if (privateSubnetIdentifier(subnetIpAddress)) {
                nodeDiscoveryResult.setDiscoveredData("private", true);
            }
        }

         catch (UnknownHostException e) {
            logger.error(e);
        }


        return nodeDiscoveryResult;
    }

    private Set<ConnectionDetails> getSubnetIpNeighborConnections(String subnetPrefix){
        Set<ConnectionDetails> ipConnectionDetailsSet = new HashSet<>();
        SubnetUtils utils = new SubnetUtils(subnetPrefix);
        String[] allIps = utils.getInfo().getAllAddresses();
        for (String ip : allIps) {
            IPNetConnectionDetails ipConnectionDetails = new IPNetConnectionDetails("icmp");
            ipConnectionDetails.put("ipAddress",ip);
            ipConnectionDetailsSet.add(ipConnectionDetails);
        }
        return ipConnectionDetailsSet;
    }

    private boolean bogonSubnetIdentifier(String subnetIpAddress) {

        try {

            CIDRUtils cidrUtils = null;
            cidrUtils = new CIDRUtils("0.0.0.0/8");

            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("127.0.0.0/8");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("128.0.0.0/8");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("169.254.0.0/16");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("192.0.0.0/24");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("192.0.2.0/24");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("224.0.0.0/4");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("240.0.0.0/4");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
            cidrUtils = new CIDRUtils("255.255.255.255/32");
            if (cidrUtils.isInRange(subnetIpAddress)) {
                return true;
            }
        
        } catch (UnknownHostException e) {
            logger.error(e.getMessage());
        }
        return false;

    }

    private boolean privateSubnetIdentifier(String ipv4Address) {

        CIDRUtils cidrUtils = null;
        try {


            cidrUtils = new CIDRUtils("192.168.0.0/16");
            if (cidrUtils.isInRange(ipv4Address)) {
                return true;
            }
            cidrUtils = new CIDRUtils("172.16.0.0/12");
            if (cidrUtils.isInRange(ipv4Address)) {
                return true;
            }
            cidrUtils = new CIDRUtils("10.0.0.0/8");
            if (cidrUtils.isInRange(ipv4Address)) {
                return true;
            }
        }catch (UnknownHostException ex){
             logger.error(ex.getMessage());
        }
        return false;

    }
}
