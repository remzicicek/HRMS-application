package com.hrms.HRMS.restControllers.abstracts;

import com.hrms.HRMS.core.results.DataResult;
import com.hrms.HRMS.core.results.Result;
import com.hrms.HRMS.entities.concretes.LanguageEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/api/language")
public interface LanguageRestController {

    @GetMapping("/getall")
    DataResult<List<LanguageEntity>> getAll();

    @GetMapping("/getallSortedDESC")
    DataResult<List<LanguageEntity>> getAllSorted();

    @GetMapping("/getAllByPage")
    DataResult<List<LanguageEntity>> getList(@Valid @NotNull @RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/add")
    DataResult<LanguageEntity> save(@Valid @NotNull @RequestBody LanguageEntity languageEntity);

    @PutMapping("/update")
    DataResult<LanguageEntity> update(@Valid @NotNull @RequestBody LanguageEntity languageEntity);

    @DeleteMapping("/delete/{id}")
    Result delete(@Valid @NotNull @PathVariable("id") Long id);
}
