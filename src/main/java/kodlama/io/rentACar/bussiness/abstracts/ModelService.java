package kodlama.io.rentACar.bussiness.abstracts;

import kodlama.io.rentACar.bussiness.request.CreateBrandRequest;
import kodlama.io.rentACar.bussiness.request.ModelRequests.CreateModelRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add (CreateModelRequest createModelRequest);
}
