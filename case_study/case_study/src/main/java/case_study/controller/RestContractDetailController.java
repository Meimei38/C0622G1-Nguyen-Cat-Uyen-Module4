package case_study.controller;

import case_study.dto.contract.IAttachContractDetailDto;
import case_study.model.contract.AttachFacility;
import case_study.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/contract/v1")
public class RestContractDetailController {

    @Autowired
    IContractDetailService contractDetailService;

    /**Don't need to use Dto and join tables. Find all contract detail only. It will return a list of contract detail, including attach facility entity inside.*/
    @GetMapping("/{id}")
    public ResponseEntity<List<IAttachContractDetailDto>> getAttachFacilityContractDetail(@PathVariable Integer id) {
        List<IAttachContractDetailDto> attachContractDetailDtoList = contractDetailService.findAttachContractDetail(id);
        if (attachContractDetailDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attachContractDetailDtoList, HttpStatus.OK);
    }
}
