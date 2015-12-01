package org.mule.modules.eloqua.config;

import org.mule.api.annotations.ws.WsdlTransportRetriever;
import org.mule.devkit.api.ws.transport.WsdlTransport;
import org.mule.devkit.api.ws.transport.HttpBasicWsdlTransport;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.components.WsdlProvider;
import org.mule.api.annotations.ws.WsdlServiceEndpoint;
import org.mule.api.annotations.ws.WsdlServiceRetriever;
import org.mule.devkit.api.ws.definition.DefaultServiceDefinition;
import org.mule.devkit.api.ws.definition.ServiceDefinition;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

@WsdlProvider(friendlyName = "Configuration")
public class ConnectorConfig {

    @Configurable
    @Placement(order = 1)
    private String username;

    @Configurable
    @Placement(order = 2)
    @Password
    @Optional
    private String password;

    @Configurable
    @Default("https://secure.p01.eloqua.com/API/1.2/service.svc")
    @Placement(order = 3)
    private String endpoint;

    @WsdlServiceRetriever
    public ServiceDefinition getServiceDefinition() {
           return new DefaultServiceDefinition(
                "Eloqua_EloquaService",
                "Service.svc",
                "https://secure.eloqua.com/API/1.2/Service.svc?wsdl",
                "Eloqua",
                "EloquaService");
    }

    @WsdlServiceEndpoint
    public String getServiceEndpoint(ServiceDefinition definition) {
         return endpoint;
    }

    @WsdlTransportRetriever
    public WsdlTransport resolveTransport(ServiceDefinition serviceDefinition) {
        return new HttpBasicWsdlTransport(getUsername(), getPassword());
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}