package com.muhendisbey.whocalledme.springcloudgateway.config.filter;

import com.muhendisbey.whocalledme.springcloudgateway.service.ILogService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class LogFilter extends AbstractGatewayFilterFactory<LogFilter.Config>
{
    private final Logger _logger = LoggerFactory.getLogger(LogFilter.class);
    private final ILogService _logService;

    public LogFilter(ILogService _logService)
    {
        super(Config.class);
        this._logService = _logService;
    }

    private void handlePreFilter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        _logger.info("PreFilterHandler");
    }

    private void handlePostFilter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        _logger.info("PostFilterHandler");
        var response = exchange.getResponse().bufferFactory();
        _logger.info("PostFilterResponse: " + response);
    }

    @Override
    public GatewayFilter apply(Config config)
    {
        _logger.info("LogFilter(" + config.getName() + ") was called!");
        return (exchange, chain) ->
        {
            /* NOTE: Onur: Pre-Filtering Statement */
            handlePreFilter(exchange, chain);
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(
                            /* NOTE: Onur: Post-Filtering Statement*/
                            () -> handlePostFilter(exchange, chain))
                    );
        };
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
