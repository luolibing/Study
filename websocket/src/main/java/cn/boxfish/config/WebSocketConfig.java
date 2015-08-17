package cn.boxfish.config;

import cn.boxfish.handler.MyHandler;
import cn.boxfish.handshake.MyHandshakeInterceptor;

/**
 * Created by TIM on 2015/8/17.
 * websocket配置  也可以使用xml进行配置
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler");
        registry.addInterceptors(new MyHandshakeInterceptor());
        registry.withSockJS();
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }

    /**
     * 配置websocket 配置, 也可以放到xml中配置
     * @return
     */
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
}
