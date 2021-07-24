package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.LanguageTypeEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/language-type")
public interface LanguageTypeRestController {

    @GetMapping("/getall")
    DataResult<List<LanguageTypeEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<LanguageTypeEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<LanguageTypeEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<LanguageTypeEntity> save(@Valid @NotNull @RequestBody LanguageTypeEntity languageTypeEntity);

    @PutMapping("/update")
    DataResult<LanguageTypeEntity> update(@Valid @NotNull @RequestBody LanguageTypeEntity languageTypeEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
