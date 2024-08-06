package org.example.virtualfittingshop.domain.image.service;

import org.example.virtualfittingshop.domain.image.dto.RequestFusingImage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Transactional
@Service
public class FusingImageService {
    private final String FASTAPI_URL = "http://localhost:8000/data";

    public String callFusionApi(RequestFusingImage requestImageDto) throws Exception {
        HttpEntity<MultiValueMap<String, Object>> requestEntity  = createMultipartRequest(requestImageDto.getImage1(), requestImageDto.getImage2());
        ResponseEntity<String> response = sendRequestToFastAPI(requestEntity);
        return handleResponse(response);
    }

    private HttpEntity<MultiValueMap<String, Object>> createMultipartRequest(MultipartFile image1, MultipartFile image2) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image1", new MultipartFileResource(image1));
        body.add("image2", new MultipartFileResource(image2));

        return new HttpEntity<>(body, httpHeaders);
    }

    private ResponseEntity<String> sendRequestToFastAPI(HttpEntity<MultiValueMap<String, Object>> requestEntity) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                FASTAPI_URL,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }

    private String handleResponse(ResponseEntity<String> response) {
        if (response.getStatusCode() == HttpStatus.OK) {
            return "Successfully forwarded images to FastAPI: " + response.getBody();
        } else {
            return "Failed to forward images. Status code: " + response.getStatusCode();
        }
    }

    // Custom class to wrap MultipartFile as a ByteArrayResource
    public static class MultipartFileResource extends ByteArrayResource {
        private final String filename;

        public MultipartFileResource(MultipartFile multipartFile) throws Exception {
            super(multipartFile.getBytes());
            this.filename = multipartFile.getOriginalFilename();
        }

        @Override
        public String getFilename() {
            return this.filename;
        }
    }
}
