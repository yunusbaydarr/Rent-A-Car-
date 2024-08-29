package kodlama.io.rentACar.bussiness.abstracts;

import kodlama.io.rentACar.bussiness.request.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.request.UpdateBrandRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllBrandResponse;
import kodlama.io.rentACar.bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.entity.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    public GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest create);

    void update (UpdateBrandRequest update);

    void delet (int id);

}
