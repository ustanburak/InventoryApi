package inventoryapi.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping
    @ApiOperation(value = "View Home Page")
    public String viewHomePage() {
        return "index";
    }
}
