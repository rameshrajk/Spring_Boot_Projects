package com.raj.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

//need to figure out JUnit testing with cache implementation later***
@Configuration
public class ProductCacheConfig {

	@Bean
	public Config cacheConfig() {
		return new Config()
				.setInstanceName("hazel-instance")
				.addMapConfig(new MapConfig()
						.setName("product-cache")
						.setTimeToLiveSeconds(3000)
						.setMaxSizeConfig(new MaxSizeConfig(200,MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU));
	}

}
