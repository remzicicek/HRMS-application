package com.hrms.HRMS.restControllers.abstracts;


import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SocialMediaTypeEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/social-media-type")
public interface SocialMediaTypeRestController {

    @GetMapping("/getall")
    DataResult<List<SocialMediaTypeEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<SocialMediaTypeEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<SocialMediaTypeEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<SocialMediaTypeEntity> save(@Valid @NotNull @RequestBody SocialMediaTypeEntity socialMediaTypeEntity);

    @PutMapping("/update")
    DataResult<SocialMediaTypeEntity> update(@Valid @NotNull @RequestBody SocialMediaTypeEntity socialMediaTypeEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
