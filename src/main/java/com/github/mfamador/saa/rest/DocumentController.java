package com.github.mfamador.saa.rest;

import com.github.mfamador.saa.model.Document;
import com.github.mfamador.saa.service.DocumentService;
import com.github.mfamador.saa.service.impl.DocumentServiceImpl;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/saa/")
public class DocumentController {

    private DocumentService service;

    @Autowired
    public void setDocumentServiceImpl(DocumentServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Document>> findAll() {

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
