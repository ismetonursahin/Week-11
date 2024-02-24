package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.category.CategorySaveRequest;
import dev.patika.ecommerce.dto.request.category.CategoryUpdateRequest;
import dev.patika.ecommerce.dto.response.Category.CategoryResponse;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapperService) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        // id ve name i donduren     ->
        return ResultHelper.created(this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class));
        // response yapısı oluştu.
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") int id) {
        Category category = this.categoryService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(category, CategoryResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id")  int id){
        this.categoryService.delete(id);
        return ResultHelper.ok();
    }

    @GetMapping()   // sayfalama işlemi
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursor(
            // sayfa sayısı ve veri adeti olan parametreler
            @RequestParam(name = "page", required = false, defaultValue = "0") int page, //  required=zorunda değil
            @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize
    ) {
        Page<Category> categoryPage = this.categoryService.cursor(page,pageSize);
        Page<CategoryResponse> categoryResponsePage = categoryPage.map(category -> this.modelMapper.forResponse().map(category,CategoryResponse.class));

        return ResultHelper.cursor(categoryResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        Category updateCategory = this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updateCategory);
       // create değil success olmak zorunda yaratılma işlemi yok.
        return ResultHelper.success(this.modelMapper.forResponse().map(updateCategory, CategoryResponse.class));
        // response yapısı oluştu.
    }


}

