package kodlama.io.rentACar.bussiness.request.ModelRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
   @NotNull  // jakarta.validation.constraints list diye araştır
   @NotBlank
   @Size(min = 2 , max = 20, message = "kurallara uy")
    private String name;

}

