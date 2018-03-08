package rabbitmqdemo

import com.budjb.rabbitmq.consumer.MessageContext

class PageViewConsumer {

    FordModelService fordModelService

    static rabbitConfig = [
            queue: "carQueue"
    ]

    def handleMessage(Map body, MessageContext messageContext) {
        fordModelService.increment(body.id)
    }
}
