package com.muhendisbey.whocalledme.springcloudgateway.lib;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.util.BiConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

public class PostFilter extends AbstractGatewayFilterFactory<PostFilter.Config>
{
    private final Logger _logger = LoggerFactory.getLogger(PostFilter.class);
    private final BiConsumer<ServerWebExchange, GatewayFilterChain> _postFilterConsumer;

    public PostFilter(BiConsumer<ServerWebExchange, GatewayFilterChain> _postFilterConsumer)
    {
        super(Config.class);
        this._postFilterConsumer = _postFilterConsumer;
    }

    @Override
    public GatewayFilter apply(Config config)
    {
        _logger.info("LogFilter(" + config.getName() + ") was called!");

        return ((exchange, chain) -> chain.filter(exchange)
                .then(Mono.fromRunnable( () -> _postFilterConsumer.accept(exchange, chain))
                ));
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
