package kodlama.io.rentACar.bussiness.concretes;

import kodlama.io.rentACar.bussiness.abstracts.BrandService;
import kodlama.io.rentACar.bussiness.request.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.request.UpdateBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandResponse;
import kodlama.io.rentACar.bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.bussiness.rules.BrandBussinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.BrandRepository;
import kodlama.io.rentACar.entity.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository;
    ModelMapperService modelMapperService;
    BrandBussinessRules brandBussinessRules;


    @Override
    public List<GetAllBrandResponse> getAll() {
     /*   List<Brand> brands= brandRepository.findAll();
        List<GetAllBrandResponse> response=new ArrayList<GetAllBrandResponse>();

        for(Brand brand : brands){
            GetAllBrandResponse item= new GetAllBrandResponse();
            item.setId(brand.getId());
            item.setName(brand.getName());

            response.add(item);

        }

        return response; */

        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponse> brandResponse = brands.stream()
                .map(brand -> modelMapperService.forRequest()
                        .map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
    return brandResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
      Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = new GetByIdBrandResponse();

        response.setName(brand.getName());

        return response;
    }

    @Override
    public void add(CreateBrandRequest create) {
        this.brandBussinessRules.checkIfBrandNameExists(create.getName());
     //   Brand brand = new Brand();
     //   brand.setName(create.getName());
     //  this.brandRepository.save(brand);

     Brand brand = modelMapperService.forRequest().map(create,Brand.class);
     this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest update) {
    Brand brand = new Brand();
    brand.setId(update.getId());
    brand.setName(update.getName());
    brandRepository.save(brand);
    }

    @Override
    public void delet(int id) {
        brandRepository.deleteById(id);

    }
}
