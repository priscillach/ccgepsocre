package org.wzq.bioplat.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@ConfigurationProperties(prefix = "elasticsearch")
@Configuration
@Data
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    private String host;
    private Integer port;
    private String username;
    private String password;
//    @Autowired
//    ElasticsearchRestTemplate elasticsearchRestTemplate;
//    @PostConstruct
//    void init() {
//        elasticsearchRestTemplate.putMapping(PertByID.class);
//    }
    @Bean
    public RestHighLevelClient elasticsearchClient(){
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
        RestClientBuilder builder=RestClient.builder(new HttpHost(host,port));
        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
        });
        RestHighLevelClient restHighLevelClient=new RestHighLevelClient(builder);
        return restHighLevelClient;

    }
}
