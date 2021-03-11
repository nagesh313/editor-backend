package com.app.editorbackend.pdf;

import com.app.editorbackend.pdf.service.PDFGenerator;
import com.app.editorbackend.pdf.service.Preview;
import com.app.editorbackend.pdf.service.Template;
import com.app.editorbackend.pdf.service.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/template")
public class TemplateController {
    @Autowired
    public TemplateRepository templateRepository;

    @GetMapping("/all")
    public List<Template> getAll() {
        return templateRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Template template) {
        templateRepository.save(template);
    }

    @PostMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestBody Preview preview) throws Exception {
        String fileName = "download-" + System.currentTimeMillis();
        PDFGenerator.generateFromPreview(preview, fileName);
        System.out.println("Calling Download:- " + fileName);
        File pdfFile = new File("./" + fileName + ".pdf");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + pdfFile.getName() + "\"");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        headers.setContentLength(pdfFile.getTotalSpace());
        InputStream targetStream = new FileInputStream(pdfFile);
        ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
                new InputStreamResource(targetStream), headers, HttpStatus.OK);
        Path path = Paths.get(pdfFile.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(pdfFile.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @DeleteMapping("/{id}")
    public void preview(@PathVariable Long id) throws Exception {
        Template template = templateRepository.getOne(id);
        templateRepository.delete(template);
    }
}
