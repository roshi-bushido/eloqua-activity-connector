package org.mule.modules.eloqua;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.modules.eloqua.config.ConnectorConfig;

@Connector(name="eloqua", friendlyName="Eloqua", minMuleVersion = "3.7")
public class EloquaConnector {

    @Config
    ConnectorConfig config;

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}