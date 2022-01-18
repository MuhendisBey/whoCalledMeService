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
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.BiConsumer;

public class PrePostFilter extends AbstractGatewayFilterFactory<PrePostFilter.Config>
{
    private final Logger _logger = LoggerFactory.getLogger(PrePostFilter.class);
    private final BiConsumer<ServerWebExchange, GatewayFilterChain> _preFilterRunnable;
    private final BiConsumer<ServerWebExchange, GatewayFilterChain> _postFilterRunnable;

    public PrePostFilter(BiConsumer<ServerWebExchange, GatewayFilterChain> _preFilterRunnable,
                         BiConsumer<ServerWebExchange, GatewayFilterChain> _postFilterRunnable)
    {
        super(Config.class);
        this._preFilterRunnable = _preFilterRunnable;
        this._postFilterRunnable = _postFilterRunnable;
    }

    @Override
    public GatewayFilter apply(Config config)
    {
        _logger.info("LogFilter(" + config.getName() + ") was called!");

        return ((exchange, chain) -> {
            _preFilterRunnable.accept(exchange, chain);
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(
                        () -> _postFilterRunnable.accept(exchange, chain))
            );
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
