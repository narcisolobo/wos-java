package com.nlobo.uploadtos3.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {
    private final S3Client s3;
    public S3Service(
            @Value("${aws.access.key}") String accessKey,
            @Value("${aws.secret.key}") String secretKey) {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
        this.s3 = S3Client
                .builder()
                .region(Region.US_WEST_1)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    public String uploadAvatar(MultipartFile file, String bucketName) {
        String fileUrl = "";
        try {
            String prefix = generateRandomFileName();
            String key = "avatars/" + prefix + "-" + file.getOriginalFilename();

            PutObjectRequest request = PutObjectRequest
                    .builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();

            s3.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

            fileUrl = "https://" + bucketName + ".s3.amazonaws.com/" + key;

        } catch (S3Exception e) {
            System.err.println("Error uploading to S3: " + e.awsErrorDetails().errorMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return fileUrl;
    }

    public static String generateRandomFileName() {
        return UUID.randomUUID().toString();
    }
}
