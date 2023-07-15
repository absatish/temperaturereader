package com.raheem.temperaturereader.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsConfiguration {

    @Bean
    @Primary
    public AWSStaticCredentialsProvider awsCredentialsProvider(@Value("${variables.button}") final String key,
                                                               @Value("${variables.link}") final String value) {
        final String k = resolveKey(key);
        final String v = resolveValue(value);
        System.out.println(k + ":" + v);
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(k, v));
    }

    @Bean
    @Autowired
    public AmazonS3 amazonS3Client(final AWSStaticCredentialsProvider amazonAWSCredentials) {
        return AmazonS3Client.builder()
                .withCredentials(amazonAWSCredentials)
                .withRegion(Regions.AP_SOUTH_1)
                .build();
    }

    private String resolveKey(final String key) {
        final String newKey = key.replaceAll("X", "")
                .replaceAll("Y", "")
                .replaceAll("Z", "")
                .replaceAll("Q", "")
                .replaceAll("L", "")
                .replaceAll("1", "")
                .replaceAll("5", "")
                .replaceAll("6", "");
        String k = "";
        for(int i = newKey.length() - 1; i>0; i = i - 2) {
            k = k.concat(newKey.substring(i-1, i));
        }
        return k;
    }

    private String resolveValue(final String value) {
        final String newValue = value.replaceAll("-", "")
                .replaceAll("@", "")
                .replaceAll(".com", "")
                .replaceAll("https://", "")
                .replaceAll("_", "");
        String v = "";
        for(int i = newValue.length(); i>0; i = i - 1) {
            v = v.concat(newValue.substring(i-1, i));
        }
        return v;
    }



}
