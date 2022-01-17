package org.bonitasoft.web.client.feign;

import org.bonitasoft.web.client.BonitaClientBuilder;

import feign.Feign;

public interface BonitaFeignClientBuilder extends BonitaClientBuilder<BonitaFeignClientBuilder> {

    BonitaFeignClientBuilder feignBuilder(Feign.Builder feignBuilder);
}
