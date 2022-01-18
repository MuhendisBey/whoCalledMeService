package com.muhendisbey.whocalledme.springcloudgateway.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/*TODO: This is incpompleted. this created new filter with new name */
@Component
public class TestPreFilterEmbedded //extends PreFilter
{
    private final Logger _logger = LoggerFactory.getLogger(TestPreFilterEmbedded.class);

    public TestPreFilterEmbedded()
    {
        super();
//        super(this::preFilter);

    }

    public void preFilter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain)
    {
        _logger.info("TestPreFilterEmbbeded preFilterHandler was called!");
    }
}
