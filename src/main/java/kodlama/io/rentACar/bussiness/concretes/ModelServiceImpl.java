package kodlama.io.rentACar.bussiness.concretes;

import kodlama.io.rentACar.bussiness.abstracts.ModelService;
import kodlama.io.rentACar.bussiness.request.ModelRequests.CreateModelRequest;
import kodlama.io.rentACar.bussiness.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.ModelRepository;
import kodlama.io.rentACar.entity.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelResponse = models.stream()
                .map(model -> modelMapperService.forRequest()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}