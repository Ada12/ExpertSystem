package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BasicService;
import service.OptimalService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangchen on 2018/4/3.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OptimalController {

    @Autowired
    private OptimalService optimalService;

    @Autowired
    private BasicService basicService;

    public ResponseEntity<Map<String, Object>> getResponseBody(Object object) {
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", object);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "library/all", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getLibrary(
            @RequestParam("type") String type
    ) {
        return getResponseBody(optimalService.getLibrary(type));
    }

}
