package cn.boxfish.config;

import cn.boxfish.handler.MyHandler;
import cn.boxfish.handshake.MyHandshakeInterceptor;

/**
 * Created by TIM on 2015/8/17.
 * websocket����  Ҳ����ʹ��xml��������
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
     * ����websocket ����, Ҳ���Էŵ�xml������
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
