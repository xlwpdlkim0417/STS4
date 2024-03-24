package _sb0322_01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import _sb0322_01.dto.State;

@Configuration
public class MyConfig {

	@Bean
	public State state() {
		return new State();
	}
}
