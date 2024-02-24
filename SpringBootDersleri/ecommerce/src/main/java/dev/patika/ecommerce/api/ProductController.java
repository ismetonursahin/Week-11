package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.business.abstracts.IProductService;
import dev.patika.ecommerce.business.abstracts.ISupplierService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.product.ProductSaveRequest;
import dev.patika.ecommerce.dto.response.Product.ProductResponse;
import dev.patika.ecommerce.dto.response.Supplier.SupplierResponse;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Product;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final IProductService productService;
    private final IModelMapperService modelMapper;
    private final ISupplierService supplierService;
    private final ICategoryService categoryService;

    public ProductController(
            IProductService productService,
            IModelMapperService modelMapper,
            ISupplierService supplierService,
            ICategoryService categoryService)
    {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
        this.categoryService = categoryService;
    }

    @PostMapping()  // veri eklemek
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        Product saveProducts = this.modelMapper.forRequest().map(productSaveRequest, Product.class);

        Category category = this.categoryService.get(productSaveRequest.getCategoryId());
        saveProducts.setCategory(category);

        Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());
        saveProducts.setSupplier(supplier);

        this.productService.save(saveProducts);
        return  ResultHelper.created(this.modelMapper.forResponse().map(saveProducts,ProductResponse.class));
    }

    @GetMapping("/{id}")  // get
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> get(@PathVariable("id") int id) {
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(product, ProductResponse.class));
    }

    @GetMapping("/{id}/supplier")  // get
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> getSupplier(@PathVariable("id") int id) {
        Product product = this.productService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(product.getSupplier(), SupplierResponse.class));
    }


}
