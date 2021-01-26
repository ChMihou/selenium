package com.web.selenium.untils;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.*;

public class changeAwsIp {
    //绑定弹性地址到特定实例

    /**
     * @return 返回弹性IP的分配Id
     */
    public static String bindIp2Instance() {
        //实例的Id
        String instance_id = "";

        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

        AllocateAddressRequest allocate_request = new AllocateAddressRequest()
                .withDomain(DomainType.Vpc);

        AllocateAddressResult allocate_response =
                ec2.allocateAddress(allocate_request);

        String allocation_id = allocate_response.getAllocationId();

        AssociateAddressRequest associate_request =
                new AssociateAddressRequest()
                        .withInstanceId(instance_id)
                        .withAllocationId(allocation_id);

        AssociateAddressResult associate_response =
                ec2.associateAddress(associate_request);

        System.out.printf(
                "Successfully associated Elastic IP address %s " +
                        "with instance %s",
                associate_response.getAssociationId(),
                instance_id);
        return allocation_id;
    }

    /**
     * 打印弹性IP的描述信息
     */
    public static void DescribeAddresses() {
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

        DescribeAddressesResult response = ec2.describeAddresses();

        for (Address address : response.getAddresses()) {
            System.out.printf(
                    "Found address with public IP %s, " +
                            "domain %s, " +
                            "allocation id %s " +
                            "and NIC id %s",
                    address.getPublicIp(),
                    address.getDomain(),
                    address.getAllocationId(),
                    address.getNetworkInterfaceId());
        }
    }

    /**
     * @param alloc_id 弹性Ip的分配Id
     */
    public static void freedIp(String alloc_id) {

        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

        ReleaseAddressRequest request = new ReleaseAddressRequest()
                .withAllocationId(alloc_id);

        ReleaseAddressResult response = ec2.releaseAddress(request);

        System.out.printf(
                "Successfully released elastic IP address %s", alloc_id);
    }
}
