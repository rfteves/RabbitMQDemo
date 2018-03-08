package rabbitmqdemo

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ShowInterceptorSpec extends Specification implements InterceptorUnitTest<ShowInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test show interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"show")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
