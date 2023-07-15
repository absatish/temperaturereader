package com.raheem.temperaturereader.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

@Service
public class S3Service {

    private final AmazonS3 amazonS3Client;
    private final ObjectMapper objectMapper;

    @Autowired
    public S3Service(final AmazonS3 amazonS3Client1) {
        this.amazonS3Client = amazonS3Client1;
        this.objectMapper = new ObjectMapper();
    }

    public void upload(final String bucketName, final String keyName, final String data) {
        final InputStream inputStream = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        final ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("text/html");
        amazonS3Client.putObject(bucketName, keyName, inputStream, objectMetadata);
    }
}
