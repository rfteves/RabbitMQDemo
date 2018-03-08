package rabbitmqdemo

import com.budjb.rabbitmq.publisher.RabbitMessagePublisher


class ShowInterceptor {

    RabbitMessagePublisher rabbitMessagePublisher

    ShowInterceptor() {
        match(controller:"fordModel", action:"show")
    }

    boolean before() { true }

    boolean after() {
        /**
         * Let consumer read and save event view
         */
        FordModel fordModel = (FordModel) model.fordModelInstance
        rabbitMessagePublisher.send {
            routingKey = "carQueue"
            body = [id: fordModel.id]
        }
        true
    }

    void afterView() {
        // no-op
    }
}
