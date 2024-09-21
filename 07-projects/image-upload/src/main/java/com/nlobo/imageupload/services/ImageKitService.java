package com.nlobo.imageupload.services;

import com.nlobo.imageupload.ImageUploadApplication;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.utils.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImageKitService {
    private final ImageKit imageKit;
    private final Configuration configuration;

    public ImageKitService(
            @Value("${public.key}") String publicKey,
            @Value("${private.key}") String privateKey,
            @Value("${url.endpoint}") String endpoint
    ) throws IOException {
        imageKit = ImageKit.getInstance();
        configuration = new Configuration(publicKey, privateKey, endpoint);
        imageKit.setConfig(configuration);
    }

    public ImageKit getImageKit() {
        return imageKit;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
