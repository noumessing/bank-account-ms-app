package net.youssfi.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig {
//public record GlobalConfig(int p1,int p2) {
	private int p1;
	private int p2;
	

}
