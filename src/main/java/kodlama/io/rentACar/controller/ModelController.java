package kodlama.io.rentACar.controller;

import jakarta.validation.Valid;
import kodlama.io.rentACar.bussiness.abstracts.ModelService;
import kodlama.io.rentACar.bussiness.request.ModelRequests.CreateModelRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelController")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest){
        this.modelService.getAll();
    }


}
