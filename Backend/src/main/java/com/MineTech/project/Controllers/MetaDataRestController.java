package com.MineTech.project.Controllers;

import com.MineTech.project.Services.MetaDataServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/metaData")
public class MetaDataRestController {
    
    private MetaDataServices metaData;
    
    @GetMapping("/{cordOne}/{cordTwo}")
    public String getAIResponse(@PathVariable("cordOne") String cordOne, @PathVariable("cordTwo") String cordTwo) {
        String response = metaData.getAIResponse(cordOne, cordTwo);
        return response;
    }
}
