package kodlama.io.rentACar.controller;

import jakarta.validation.Valid;
import kodlama.io.rentACar.bussiness.abstracts.BrandService;
import kodlama.io.rentACar.bussiness.request.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.request.UpdateBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandResponse;
import kodlama.io.rentACar.bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandsController {
   private BrandService brandService;
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAll")
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
    return this.brandService.getById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping("/update")
    public void update(UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delet(@PathVariable int id){
        this.brandService.delet(id);
    }

}
