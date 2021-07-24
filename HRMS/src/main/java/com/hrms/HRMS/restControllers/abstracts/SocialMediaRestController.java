package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.SocialMediaEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/social-media")
public interface SocialMediaRestController {

    @GetMapping("/getall")
    DataResult<List<SocialMediaEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<SocialMediaEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<SocialMediaEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<SocialMediaEntity> save(@Valid @NotNull @RequestBody SocialMediaEntity socialMediaEntity);

    @PutMapping("/update")
    DataResult<SocialMediaEntity> update(@Valid @NotNull @RequestBody SocialMediaEntity socialMediaEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
