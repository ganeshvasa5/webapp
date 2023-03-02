package com.webapp.cloudapp.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.webapp.cloudapp.Services.ImageService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ImageController {

	@Autowired
	ImageService imageService;

	@PostMapping(value = "/v1/product/{productId}/image", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addImage(@RequestParam("file") MultipartFile multipartFile,
			@PathVariable String productId, NativeWebRequest nativeWebRequest) {
		try {
			return imageService.createImage(multipartFile, productId, nativeWebRequest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("msg", "Please enter valid data");
			return new ResponseEntity<>(resMap, HttpStatusCode.valueOf(400));
		}
	}

	@GetMapping("/v1/product/{productId}/image/{imageId}")
	public ResponseEntity<?> getImage(@PathVariable String productId, @PathVariable String imageId,
    NativeWebRequest nativeWebRequest) {
		try {
			return imageService.getImage(imageId, productId, nativeWebRequest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("msg", "Please enter valid data");
			return new ResponseEntity<>(resMap, HttpStatusCode.valueOf(400));
		}
	}

	@GetMapping("/v1/product/{productId}/image")
	public ResponseEntity<?> getAllImages(@PathVariable String productId,NativeWebRequest nativeWebRequest) {
		try {
			return imageService.getAllImage(productId, nativeWebRequest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("msg", "Please enter valid data");
			return new ResponseEntity<>(resMap, HttpStatusCode.valueOf(400));
		}
	}

	@DeleteMapping("/v1/product/{productId}/image/{imageId}")
	public ResponseEntity<?> deleteImages(@PathVariable String productId, @PathVariable String imageId,
    NativeWebRequest nativeWebRequest) {
		try {
			return imageService.deleteImage(imageId, productId, nativeWebRequest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("msg", "Please enter valid data");
			return new ResponseEntity<>(resMap, HttpStatusCode.valueOf(400));
		}
	}

}