package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.CandidateEntity;
import com.hrms.HRMS.models.CandidateModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/candidates")
public interface CandidateRestController {
    
    // if you want to see data you use data result. if not you use the Result
    
    @GetMapping("/getall")
    DataResult<List<CandidateModel>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<CandidateModel>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<CandidateModel>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<CandidateModel> save(@Valid @NotNull @RequestBody CandidateModel candidateModel);

    @PutMapping("/update")
    DataResult<CandidateModel> update(@Valid @NotNull @RequestBody CandidateModel candidateModel);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);

}
