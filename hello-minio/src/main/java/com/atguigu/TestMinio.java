package com.atguigu;

import io.minio.*;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TestMinio {
    public static void main(String[] args) {
        String endpoint = "http://192.168.186.100:9000";
        String accesskey = "minioadmin";
        String seccretkey = "minioadmin";
        String bucketName = "hello-minio";

        MinioClient minioClient = MinioClient.builder().endpoint(endpoint).credentials(accesskey, seccretkey).build();

        try {
            boolean bucketExistsucket = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if(!bucketExistsucket){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());

                String policy = """
                        {
                          "Statement" : [ {
                            "Action" : "s3:GetObject",
                            "Effect" : "Allow",
                            "Principal" : "*",
                            "Resource" : "arn:aws:s3:::%s/*"
                          } ],
                          "Version" : "2012-10-17"
                        }""".formatted(bucketName);
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(policy).build());
            }
            minioClient.uploadObject(UploadObjectArgs.builder().filename("C:\\Users\\32245\\Pictures\\Screenshots\\歪嘴小猫.jpg").bucket(bucketName).object("歪嘴小猫.jpg").build());
            System.out.println("上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
