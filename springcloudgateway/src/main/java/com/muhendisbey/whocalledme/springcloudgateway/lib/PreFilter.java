package com.muhendisbey.whocalledme.springcloudgateway.lib;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.function.BiConsumer;

public class PreFilter extends AbstractGatewayFilterFactory<PreFilter.Config>
{
    private final Logger _logger = LoggerFactory.getLogger(PreFilter.class);
    private final BiConsumer<ServerWebExchange, GatewayFilterChain> _preFilterConsumer;

    public PreFilter(BiConsumer<ServerWebExchange, GatewayFilterChain> _preFilterRunnable)
    {
        super(Config.class);
        this._preFilterConsumer = _preFilterRunnable;
    }

    @Override
    public GatewayFilter apply(Config config)
    {
        _logger.info("LogFilter(" + config.getName() + ") was called!");

        return ((exchange, chain) -> {
            _preFilterConsumer.accept(exchange, chain);
            return chain.filter(exchange);
        });
    }

    @Override
    public List<String> shortcutFieldOrder()
    {
        return List.of("name");
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Config
    {
        private String name;
    }
}
