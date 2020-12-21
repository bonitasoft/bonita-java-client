package org.bonitasoft.web.client.feign;

import feign.Feign;
import org.bonitasoft.web.client.BonitaClientBuilder;

public interface BonitaFeignClientBuilder extends BonitaClientBuilder<BonitaFeignClientBuilder> {

	BonitaFeignClientBuilder feignBuilder(Feign.Builder feignBuilder);

}
