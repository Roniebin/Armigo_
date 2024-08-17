package org.example.virtualfittingshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.FileInputStream;
import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ImageTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testImageProcessing() throws Exception {
        // Prepare a mock multipart file for the request
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/image/1.jpg");
        byte[] imageBytes = fileInputStream.readAllBytes();
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "image1",
                "test.jpg",
                "image/jpeg",
                imageBytes
        );
        String expectedBytes = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
        // Send POST request to /test endpoint
        mockMvc.perform(MockMvcRequestBuilders.multipart("/test")
                        .file(mockMultipartFile)
                )
                .andExpect(status().isOk()) // Expect HTTP 200 OK status
                .andExpect(model().attributeExists("imageData")) // Expect "imageData" in the model
                .andExpect(view().name("test")) // Expect the view name to be "test"
                .andExpect(model().attribute("imageData",expectedBytes));
    }

}
